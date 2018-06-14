package com.agxx.app.common.exception;

import com.agxx.app.common.util.ErrorCodeUtil;

/**
 * <p>
 * 公共的异常定义枚举。各业务不需要重复定义此枚举已包含的项。
 * </p>
 * 
 * @author LianGuoQing
 */
public enum BaseErrorCode implements ErrorCode {

    BAD_REQUEST(400, "无效请求"),
    BAD_REQUEST_WITH_MESSAGE(400, "无效请求, %1s"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    INTERNAL_SERVER_ERROR_WITH_MESSAGE(500, "服务器内部错误: %1s"),

    UNAUTHORIZED(401, "未授权: %1s"),

    REQUEST_DENIED(403, "请求受限"),

    AUTH_DENIED(403, "授权受限"),

    UNSUPPORTED_MEDIA_TYPE(415, "服务器不支持请求所提交的数据格式 ：%1s"),

    NOT_ACCEPTABLE(406, " 服务器无法提供请求指定的数据响应格式  "),

    METHOD_NOT_ALLOWED(405, "请求的方法不支持 ：%1s"),

    INVALID_ARGUMENT(400, "无效参数（格式不对,长度过长或过短等）：%1s"),
    INVALID_QUERY(400, "查询参数值无效：%1s"),

    REQUIRE_ARGUMENT(400, "缺少参数：%1s"),

    NOT_FOUND(404, "请求的路径不存在");

    /**
     * HTTP 请求状态吗
     */
    private int httpCode;

    /**
     * 异常代码
     */
    private String code;

    /**
     * 异常消息
     */
    private String message;

    /**
     * 初始化 code 与 message 的值。
     * 
     * @param httpCode 状态码
     * @param message 异常消息
     */
    BaseErrorCode(int httpCode, String message) {
        this.httpCode = httpCode;
        this.code = ErrorCodeUtil.generateCode(this);
        this.message = message;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage(Object... args) {
        return ErrorCodeUtil.formatMessage(message, args);
    }

}
