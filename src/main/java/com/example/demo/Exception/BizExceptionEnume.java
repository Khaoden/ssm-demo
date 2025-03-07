package com.example.demo.Exception;

import lombok.Getter;

public enum BizExceptionEnume {
    // 通用错误码
    PARAM_ERROR(400, "参数错误"),
    SYSTEM_ERROR(500, "系统错误"),

    // 用户相关错误码 (1xxxx)
    USER_NOT_EXIST(10001, "用户不存在"),
    USER_PASSWORD_ERROR(10002, "用户密码错误"),
    USER_NOT_LOGIN(10003, "用户未登录"),
    USER_NOT_AUTHORIZED(10004, "用户未授权"),
    USER_NOT_PERMISSION(10005, "用户无权限"),

    // 员工相关错误码 (2xxxx)
    EMPLOYEE_NOT_EXIST(20001, "员工不存在"),
    EMPLOYEE_ID_EMPTY(20002, "员工ID不能为空"),
    EMPLOYEE_NAME_INVALID(20003, "员工姓名不合法"),
    EMPLOYEE_AGE_INVALID(20004, "员工年龄不合法"),
    EMPLOYEE_GENDER_INVALID(20005, "员工性别不合法");

    @Getter
    private final Integer code;

    @Getter
    private final String message;

    BizExceptionEnume(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
