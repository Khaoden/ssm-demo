package com.example.demo.vo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeAddReq {
    private Integer id;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 200, message = "年龄不能大于200岁")
    private Integer age;

    @NotBlank(message = "姓名不能为空")
    @Size(min = 2, max = 50, message = "名字长度不能小于2个字符或者超过50个字符")
    private String name;

    @NotBlank(message = "邮箱不能为空")
    private String email;

    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = "^[男|女]$", message = "性别只能为：男或女")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NotNull(message = "生日不能为空")  // 改为 @NotNull
    private Date birth;

    private Integer deptId = 0;
}
