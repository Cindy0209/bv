package com.dynamic.bv.util;

import java.util.Collection;

/**
 * @ClassName ResponseResult
 * @Description
 * @Author oker
 * @Date 2019-07-08 18:43
 **/
public class ResponseResult<T> {
    private int code;
    private String message;
    private Collection<T> data;

    private ResponseResult() {

    }
    private ResponseResult(final int code, final String message) {
        this.code = code;
        this.message = message;
    }
    private ResponseResult(final int code, final String message, final Collection<T> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }



    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(final Collection<T> data) {
        this.data = data;
    }

    public static   ResponseResult error(final int code, final String message) {
        final ResponseResult result = new ResponseResult(code, message);
        return result;
    }

    public static ResponseResult success() {
        final ResponseResult resultBean = new ResponseResult();
        resultBean.setCode(0);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static <V> ResponseResult<V> success(final Collection<V> data) {
        final ResponseResult resultBean = new ResponseResult();
        resultBean.setMessage("success");
        resultBean.setData(data);
        resultBean.setCode(0);
        return resultBean;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.dynamic.bv.util.ResponseResult{");
        sb.append("code=").append(code);
        sb.append(", message='").append(message).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
