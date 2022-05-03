package com.yt.diary.common;

import lombok.Data;

/**
 * @author YingTao
 */
@Data
public class CommonResult<T> {
    private long status;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultStatus.SUCCESS.getStatus(), ResultStatus.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultStatus.SUCCESS.getStatus(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorStatus 错误码
     */
    public static <T> CommonResult<T> failed(ErrorStatus errorStatus) {
        return new CommonResult<T>(errorStatus.getStatus(), errorStatus.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultStatus.FAILED.getStatus(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultStatus.FAILED);
    }


    /**
     * 角色权限验证失败返回结果
     */
    public static <T> CommonResult<T> roleFailed() {
        return failed(ResultStatus.FORBIDDEN);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultStatus.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultStatus.VALIDATE_FAILED.getStatus(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultStatus.UNAUTHORIZED.getStatus(), ResultStatus.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未登录返回结果
     *
     * @param message 提示信息
     */
    public static <T> CommonResult<T> unauthorized(String message) {
        return new CommonResult<T>(ResultStatus.UNAUTHORIZED.getStatus(), message, null);
    }
}

