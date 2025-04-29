package com.only4play.havenest.framework.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.only4play.havenest.framework.enums.HttpStatusCodeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Setter
@Getter
public class ResponseResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public ResponseResult() {
        this.code = HttpStatusCodeEnum.SUCCESS.getCode();
        this.msg = HttpStatusCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @Description: 成功返回空结果
     * @return
     * @param <T>
     */
    public  static <T>  ResponseResult<T> okResult(){
        return new ResponseResult<>();
    }

    /**
     * @Description: 成功返回结果
     * @param code
     * @param msg
     * @return
     * @param <T>
     */
    public static  <T>  ResponseResult<T> okResult(Integer code, String msg){
        ResponseResult<T> result = new ResponseResult<>();
        return result.ok(code, msg, null);
    }

    private ResponseResult<T> ok(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    private ResponseResult<T> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }

    private ResponseResult<T> ok( T data) {
        this.data = data;
        return this;
    }

    /**
     * @Description: 成功返回结果
     * @param data
     * @return
     * @param <T>
     */
    public static  <T>  ResponseResult<T> okResult(T data) {
        ResponseResult<T> result = setHttpStatusCodeEnum(HttpStatusCodeEnum.SUCCESS, HttpStatusCodeEnum.SUCCESS.getMsg());
        if(data != null){result.setData(data);}
        return result;
    }

    /**
     * @Description: 设置HttpStatusCodeEnum
     * @param httpStatusCodeEnum
     * @param msg
     * @return
     * @param <T>
     */
    private static <T> ResponseResult<T> setHttpStatusCodeEnum(HttpStatusCodeEnum httpStatusCodeEnum, String msg) {
        return okResult(httpStatusCodeEnum.getCode(), msg);
    }
    private static <T> ResponseResult<T> setHttpStatusCodeEnum(HttpStatusCodeEnum httpStatusCodeEnum) {
        return okResult(httpStatusCodeEnum.getCode(), httpStatusCodeEnum.getMsg());
    }

    public static  <T>  ResponseResult<T> errorResult(Integer code, String msg){
        ResponseResult<T> result = new ResponseResult<>();
        return result.error(code, msg);
    }

    private ResponseResult<T> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public static  <T>  ResponseResult<T> errorResult(HttpStatusCodeEnum httpStatusCodeEnum){
       return setHttpStatusCodeEnum(httpStatusCodeEnum, httpStatusCodeEnum.getMsg());
    }

    public static  <T>  ResponseResult<T> errorResult(HttpStatusCodeEnum httpStatusCodeEnum, String msg){
        return setHttpStatusCodeEnum(httpStatusCodeEnum, msg);
    }
}
