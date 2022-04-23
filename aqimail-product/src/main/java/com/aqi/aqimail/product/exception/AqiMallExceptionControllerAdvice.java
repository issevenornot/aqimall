package com.aqi.aqimail.product.exception;

import com.aqi.common.exception.BizCodeEnume;
import com.aqi.common.utils.R;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @Author koi
 * @Date 2022/4/19 16:29
 * @Version 1.0
 * 集中处理所有异常
 */
@RestControllerAdvice(basePackages = "com.aqi.aqimail.product.controller")
//@ControllerAdvice
public class AqiMallExceptionControllerAdvice {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, String> map = new HashMap<>(8);
        bindingResult.getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(),fieldError.getDefaultMessage()));
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(), BizCodeEnume.VALID_EXCEPTION.getMsg()).put("data",map);
    }
    @ExceptionHandler(value = Throwable.class)
    public R handleException(){
        return R.error(BizCodeEnume.UNKNOWN_EXCEPTION.getCode(), BizCodeEnume.UNKNOWN_EXCEPTION.getMsg());
    }
}
