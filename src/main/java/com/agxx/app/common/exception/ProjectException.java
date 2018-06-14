package com.agxx.app.common.exception;

import org.springframework.http.HttpStatus;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/14 0014 下午 10:01      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
public class ProjectException extends BaseException {

    private static String prefix = "AGXX_APP_SERVER/";

    public ProjectException(ErrorCode errorCode, Object... objects) {
        super(prefix + errorCode.getCode(), errorCode.getMessage(objects), HttpStatus.valueOf(errorCode.getHttpCode()));
    }

    public ProjectException(String message) {
        super(prefix + "BAD_REQUEST", message, HttpStatus.BAD_REQUEST);
    }
}