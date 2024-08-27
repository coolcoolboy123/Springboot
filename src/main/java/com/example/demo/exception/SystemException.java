package com.example.demo.exception;

import com.example.demo.enums.AppHttpCodeEnum;
import lombok.Getter;

/**
 * 自定义异常
 * @author ljy
 */
@Getter
public class SystemException extends RuntimeException{

    private final int code;

    private final String msg;

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

}