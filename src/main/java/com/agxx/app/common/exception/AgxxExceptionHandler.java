package com.agxx.app.common.exception;

import com.agxx.app.model.ResponseErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: 统一异常处理器 </p>
 * <p>Description: 所有控制器未捕获的异常将会在该类进行处理，并返回统一定义的异常响应信息。 </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/14 0014 下午 10:18      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
@ControllerAdvice
public class AgxxExceptionHandler {

    /**
     * 异常处理逻辑。
     *
     * @param e 异常对象
     * @param request
     *            HTTP请求对象
     * @param response
     *            HTTP响应对象
     * @return 异常信息响应VO
     * @throws Throwable
     * @since 0.1
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseErrorMessage handleException(Throwable e, HttpServletRequest request, HttpServletResponse response)
            throws Throwable {
        AgxxException agxxException = null;
        if (e instanceof AgxxException) {
            agxxException = (AgxxException) e;
        } else {
            String debug = request.getParameter("debug");
            if (debug != null && debug.equals("1")) {
                throw e;
            }

            agxxException = new AgxxException(BaseErrorCode.INTERNAL_SERVER_ERROR, e);
        }

        return handleAgxxException(agxxException, request, response);
    }

    /**
     * server_time 属性格式化
     */
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private ResponseErrorMessage handleAgxxException(AgxxException e, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(e.getHttpCode());

        ResponseErrorMessage resp = new ResponseErrorMessage();
        resp.setHostId(request.getServerName());
        resp.setServerTime(new Date());
        resp.setCode(e.getErrorCode().toString());
        resp.setMessage(e.getMessage());

        return resp;
    }

}