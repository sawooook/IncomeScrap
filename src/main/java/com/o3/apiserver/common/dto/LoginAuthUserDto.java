package com.o3.apiserver.common.dto;

import com.o3.apiserver.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
public class LoginAuthUserDto implements UserDetails {
    private final Long id;
    private final String userUniqueId; // 고유 유저아이디 값
    private final String password; // 비밀번호
    private final String name; // 이름
    private final String registerNumber; // 주민번호
    private String token = null;


    public LoginAuthUserDto(long id, String userUniqueId, String password, String name, String registerNumber) {
        this.id = id;
        this.userUniqueId = userUniqueId;
        this.password = password;
        this.name = name;
        this.registerNumber = registerNumber;
    }

    public static LoginAuthUserDto create(User user) {
        return new LoginAuthUserDto(user.getId(), user.getUserUniqueId(), user.getPassword(), user.getName(), user.getRegisterNumber());
    }

    @Override
    public String getUsername() {
        return this.getUserUniqueId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
