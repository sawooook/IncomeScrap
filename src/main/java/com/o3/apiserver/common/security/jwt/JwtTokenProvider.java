package com.o3.apiserver.common.security.jwt;

import com.o3.apiserver.common.dto.LoginAuthUserDto;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secretKey}")
    private String secretKey;


    public String getTokenByHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null) {
            throw new IllegalArgumentException("토큰을 찾을 수 없습니다");
        }

        return token;
    }

    public String getReplaceToken(String token) {
        return token.replace("Bearer ", "");
    }

    public boolean isValidToken(String token) {
        try {
            if (!token.startsWith("Bearer")) {
                return false;
            }
            String replaceToken = getReplaceToken(token);

            if (isValidExpiredAt(replaceToken, LocalDateTime.now())) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean isValidExpiredAt(String token, LocalDateTime now) {
        Jws<Claims> jwtToken = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
        LocalDateTime expiredDate =
                jwtToken.getBody().getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return expiredDate.isAfter(now);
    }

    public String getUniqueUserId(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    public String generateToken(String userUniqueId, LocalDateTime today) {
        try {
            Claims claims = Jwts.claims().setSubject(userUniqueId);
            return Jwts.builder()
                    .setClaims(claims)
                    .setIssuedAt(Date.from(today.atZone(ZoneId.systemDefault()).toInstant()))
                    .signWith(SignatureAlgorithm.HS256, secretKey)
                    .setExpiration(Date.from(today.plusDays(1).atZone(ZoneId.systemDefault()).toInstant())).compact();
        } catch (Exception e) {
            throw new IllegalArgumentException("토큰 생성 오류");
        }
    }
}
