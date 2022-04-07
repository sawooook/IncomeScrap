package com.o3.apiserver.domain.user;

import com.o3.apiserver.application.user.dto.SignUpUserDto;
import com.o3.apiserver.domain.scrap.Scrap;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id = null;

    @Column(name = "user_unique_id")
    private String userUniqueId; // 고유 유저아이디 값

    @Column(name = "password")
    private String password; // 비밀번호

    @Column(name = "name")
    private String name; // 이름

    @Column(name = "register_number")
    private String registerNumber; // 주민번호


    public User(String userUniqueId, String password, String name, String registerNumber) {
        this.userUniqueId = userUniqueId;
        this.password = password;
        this.name = name;
        this.registerNumber = registerNumber;
    }

    public static User create(SignUpUserDto signUpUserDto) {
        return new User(signUpUserDto.getUserUniqueId(), signUpUserDto.getPassword(), signUpUserDto.getName(), signUpUserDto.getRegNo());
    }
}
