package com.example.demo.vo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EmployeeUpdateReq {
    @NotBlank(message = "ID不能为空")
    @NotNull(message = "ID不能为空")
    private Integer id;

    @Size(min = 2, max = 50, message = "名字长度不能小于2个字符或者超过50个字符")
    private String name;

    @Min(value = 0, message = "年龄不能小于0")
    @Max(value = 200, message = "年龄不能大于200岁")
    private Integer age;

    private String email;

    @Pattern(regexp = "^[男|女]$", message = "性别只能为：男或女")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birth;

    private Integer deptId;
}
