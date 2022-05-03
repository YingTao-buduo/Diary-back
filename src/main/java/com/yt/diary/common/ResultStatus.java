package com.yt.diary.common;

/**
 * @author YingTao
 */

public enum ResultStatus implements ErrorStatus {

    //请求成功
    SUCCESS(200, "OK"),
    //请求失败
    FAILED(500, "Internal Server Error"),
    //没有登录
    UNAUTHORIZED(401, "Unauthorized"),
    //没有访问权限
    FORBIDDEN(403, "Forbidden"),
    //不存在的接口
    VALIDATE_FAILED(404, "Not Found");

    private final long status;
    private final String message;

    ResultStatus(long status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public long getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

