package com.everyour.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 12, nullable = false)
    private String pw;

    @Column(length = 20, nullable = false)
    private String username; //유저의 실명 또는 닉네임

    @Column(nullable = false)
    private String major; //유저의 전공

    @Column(nullable = false)
    private String studentId; //유저의 학번

}

