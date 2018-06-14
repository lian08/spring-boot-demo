package com.agxx.app.common.exception;

import com.agxx.app.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/14 0014 下午 9:25      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
public class BaseException extends RuntimeException {
    ResponseEntity<ErrorMessage> responseEntity;

    public BaseException(ResponseEntity<ErrorMessage> responseEntity, Throwable cause) {
        super(responseEntity.getBody().getMessage(), cause);
        this.responseEntity = responseEntity;
    }

    public BaseException(ResponseEntity<ErrorMessage> responseEntity) {
        this(responseEntity, null);
    }

    public BaseException(ErrorMessage errorMessage, HttpStatus status, Throwable cause) {
        this(new ResponseEntity<>(errorMessage, status), cause);
    }

    public BaseException(ErrorMessage errorMessage, HttpStatus status) {
        this(new ResponseEntity<>(errorMessage, status));
    }

    public BaseException(String code, String message, String detail, HttpStatus status, Throwable cause) {
        this(new ErrorMessage(code, message, detail), status, cause);
    }

    public BaseException(String code, String message, String detail, HttpStatus status) {
        this(new ErrorMessage(code, message, detail), status, null);
    }

    public BaseException(String code, String message, HttpStatus status, Throwable cause) {
        this(new ErrorMessage(code, message), status, cause);
    }

    public BaseException(String code, String message, HttpStatus status) {
        this(code, message, status, null);
    }

    public BaseException(String code, String message, Throwable cause) {
        this(new ErrorMessage(code, message), HttpStatus.INTERNAL_SERVER_ERROR, cause);
    }

    public BaseException(String code, String message) {
        this(code, message, (Throwable) null);
    }

    public ResponseEntity<ErrorMessage> getResponseEntity() {
        return responseEntity;
    }

    public ErrorMessage getError() {
        return responseEntity.getBody();
    }

    @Override
    public String getLocalizedMessage() {
//        return I18NProvider.getString(getMessage());
        return getMessage();
    }
}