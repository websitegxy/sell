package com.zzz.sell.exception;

/**
 * @author zzz
 * @description 参数校验异常
 * @date 2020/3/4
 */
public class CheckParamException extends Exception{
    public CheckParamException(){
        super();
    }
    public CheckParamException(String message){
        super(message);
    }
}
