package com.agxx.app.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgxxException extends RuntimeException {

    private static final long serialVersionUID = 5405156780448975957L;

    private static final Logger logger = LoggerFactory.getLogger(AgxxException.class);

    /**
     * 异常代码枚举
     */
    private ErrorCode errorCode;

    /**
     * 构造指定异常代码与消息参数的业务异常。
     *
     * @param errorCode 异常代码
     * @param args 消息参数，该参数将用于格式化异常代码中的消息字符串
     */
    public AgxxException(ErrorCode errorCode, Object... args) {
        this(errorCode, null, args);
    }

    /**
     * 构造指定异常代码、异常原因与消息参数的业务异常。
     *
     * @param errorCode 异常代码
     * @param cause 异常消息
     * @param args 消息参数，该参数将用于格式化异常代码中的消息字符串
     */
    public AgxxException(ErrorCode errorCode, Throwable cause, Object... args) {
        super(errorCode.getMessage(args), cause);
        if (errorCode == BaseErrorCode.INTERNAL_SERVER_ERROR) {
            StringBuilder sb = new StringBuilder("message:" + cause.getMessage() + "\r\n");
            for (StackTraceElement element : cause.getStackTrace()) {
                sb.append(element.toString() + "\r\n");
            }

            logger.error(sb.toString());
        }

        this.errorCode = errorCode;
    }

    /**
     * 返回 HTTP 状态码
     * 
     * @return HTTP 状态码
     */
    public int getHttpCode() {
        return errorCode.getHttpCode();
    }

    /**
     * 返回异常代码
     * 
     * @return 异常代码
     */
    public String getCode() {
        return String.valueOf(errorCode.getHttpCode());
    }

    /**
     * 返回异常代码枚举
     * 
     * @return
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
