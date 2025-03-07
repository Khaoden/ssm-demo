package com.example.demo.advice;

import com.example.demo.Exception.BizException;
import com.example.demo.Exception.BizExceptionEnume;
import com.example.demo.common.R;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    // 处理业务异常
    @ExceptionHandler(BizException.class)
    public R<String> handleBizException(BizException e) {
        return R.error(e.getCode(), e.getMessage());
    }

    // 处理参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getDefaultMessage();
            }
        }
        return R.error(BizExceptionEnume.PARAM_ERROR.getCode(), message);
    }

    // 处理其他未知异常
    @ExceptionHandler(Exception.class)
    public R<String> handleException(Exception e) {
        return R.error(BizExceptionEnume.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}
