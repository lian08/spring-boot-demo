package com.agxx.app.model;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * <p>Title: Module 错误信息封装类 </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/14 0014 下午 9:27      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
public class ErrorMessage implements Serializable {

    private String code;
    private String message;
    private String detail;
    private ResponseErrorMessage cause;

    public ErrorMessage() {
    }

    public ErrorMessage(String code) {
        this(code, null, null);
    }

    public ErrorMessage(String code, String message) {
        this(code, message, null);
    }

    public ErrorMessage(String code, String message, String detail) {
        this(code, message, detail, null);
    }

    public ErrorMessage(String code, String message, String detail, ResponseErrorMessage cause) {
        this.message = StringUtils.isEmpty(message)?"null":message;
        this.code    = code;
        this.detail  = detail;
        this.cause   = cause;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public String getLocalizedMessage(){
////        return I18NProvider.getString(message);
//        return message;
//    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获得远程服务返回的错误信息
     *
     * @return 远程该服务返回的错误信息
     * @since 0.9.6
     */
    public ResponseErrorMessage getCause() {
        return cause;
    }

    /**
     * 设置远程服务返回的错误信息
     *
     * @param cause 远程服务返回的错误信息
     * @since 0.9.6
     */
    public void setCause(ResponseErrorMessage cause) {
        this.cause = cause;
    }

    public ResponseErrorMessage convert(Throwable throwable) {
        ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage(throwable);
//        responseErrorMessage.setMessage(getLocalizedMessage());
        responseErrorMessage.setCode(code);
        responseErrorMessage.setDetail(detail);
        responseErrorMessage.setCause(cause);
        return responseErrorMessage;
    }

}