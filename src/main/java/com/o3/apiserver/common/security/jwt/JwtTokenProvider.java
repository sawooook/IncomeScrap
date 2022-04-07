package com.o3.apiserver.common.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
        return request.getHeader("Authorization");
    }

    public String getReplaceToken(String token) {
        return token.replace("Bearer ", "");
    }

    public boolean isValidToken(String token) {
        try {
            if (!token.startsWith("Bearer")) {

                System.out.println("------------------1");

                return false;
            }
            String replaceToken = getReplaceToken(token);

            if (!isValidExpiredAt(replaceToken, LocalDateTime.now())) {
                System.out.println("------------------2");
                return false;
            }
        } catch (Exception e) {
            System.out.println("------------------3");
            return false;
        }
        System.out.println("------------------4");

        return true;
    }

    private boolean isValidExpiredAt(String token, LocalDateTime now) {
        Jws<Claims> jwtToken = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        LocalDateTime expiredDate =
                jwtToken.getBody().getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        return expiredDate.isAfter(now);
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
