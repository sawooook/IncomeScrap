package com.o3.apiserver.common.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class LoginUserDto implements UserDetails {
    private Long id;
    private String userUniqueId; // 고유 유저아이디 값
    private String password; // 비밀번호
    private String name; // 이름
    private String registerNumber; // 주민번호


    public LoginUserDto(Long id, String userUniqueId, String password, String name, String registerNumber) {
        this.id = id;
        this.userUniqueId = userUniqueId;
        this.password = password;
        this.name = name;
        this.registerNumber = registerNumber;
    }

    public static void create() {
        LoginUserDto()
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.g;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
