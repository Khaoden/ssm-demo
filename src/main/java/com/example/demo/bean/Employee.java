package com.example.demo.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    private Date birth;
    private Integer deptId;
}
