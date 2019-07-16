package com.dynamic.bv.exception;

import com.dynamic.bv.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebExceptionHandler.class);
    @ExceptionHandler
    public ResponseResult methodArgumentNotValid(final BindException e) {
        LOGGER.error("参数校验失败",e);
        final StringBuilder errorMessage = new StringBuilder();
        e.getAllErrors().forEach(objectError ->
                errorMessage.append(objectError.getDefaultMessage()).append(",")
        );
        return ResponseResult.error(-1, errorMessage.toString());
    }

    @ExceptionHandler
    public ResponseResult methodArgumentNotValidForJsonArgumentResolver(final MethodArgumentNotValidException e) {
        LOGGER.error("json参数绑定到对象失败",e);
        final StringBuilder errorMessage = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach( errors-> errorMessage.append(errors.getDefaultMessage()).append(",") );
        return ResponseResult.error(-1, errorMessage.toString());
    }

    @ExceptionHandler
    public ResponseResult unKnowException(final Exception e) {
        LOGGER.error("未知异常", e);
        return ResponseResult.error(-999, "发生了未知异常，请联系系统管理员");
    }
}
