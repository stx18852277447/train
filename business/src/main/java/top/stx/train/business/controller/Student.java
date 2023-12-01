package top.stx.train.business.controller;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Getter
public class Student {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private String school;
}
