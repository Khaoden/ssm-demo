package com.example.demo.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {
    private Integer code;
    private String message;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(BizExceptionEnume enume) {
        super(enume.getMessage());
        this.code = enume.getCode();
        this.message = enume.getMessage();
    }
}
