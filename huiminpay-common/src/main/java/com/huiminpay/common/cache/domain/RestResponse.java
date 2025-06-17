package com.huiminpay.common.cache.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
@ApiModel(value = "RestResponse<T>", description = "Generic response wrapper")
public class RestResponse<T> {

    @ApiModelProperty("Response error code, 0 means success")
    private int code;

    @ApiModelProperty("Response error message")
    private String msg;

    @ApiModelProperty("Response content")
    private T result;

    public static <T> RestResponse<T> success() {
        return new RestResponse<T>();
    }

    public static <T> RestResponse<T> success(T result) {
        RestResponse<T> response = new RestResponse<T>();
        response.setResult(result);
        return response;
    }

    public static <T> RestResponse<T> validfail(String msg) {
        RestResponse<T> response = new RestResponse<T>();
        response.setCode(-2);
        response.setMsg(msg);
        return response;
    }

    public RestResponse() {
        this(0, "");
    }

    public RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RestResponse [code=" + code + ", msg=" + msg + ", result="
                + result + "]";
    }

}
