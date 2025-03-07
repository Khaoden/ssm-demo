package com.example.demo.vo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeResp {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;
    private Integer deptId;
    private Integer pageSize;
    private Integer pageNum;
}
