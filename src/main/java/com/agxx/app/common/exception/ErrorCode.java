package com.agxx.app.common.exception;

import java.io.Serializable;

/**
 * <p>
 * 异常代码枚举接口。
 * </p>
 * <p>
 * 每个业务自已定义一个枚举类，并实现该接口，其中每个枚举值都表示一个业务异常的基本定义。<br/>
 * 枚举名称为 "Exxxxxx" ，其中 "xxxxxx" 代表异常代码，如 "E400000"。各业务所定义的枚举名称注意不要与其它业务重名。<br/>
 * 公共的异常枚举定义在 {@link BaseErrorCode} 中。
 * </p>
 * <p>
 * 每个异常代码均包含有一个httpCode 、code与一个 message。<br/>
 * {@code httpCode} 是按照HTTP协议所定义的 3 位数字请求状态码。 <br/>
 * {@code code} 是一个包含 6 位数字的字符串，前三位与 HTTP Status 定义相同，后三位 按业务本身需要进行定义。 <br/>
 * {@code message} 是一个消息文本，其中可以包含占位符，规则参考 {@link String#format(String, Object...)} 方法的定义。
 * </p>
 * 
 * @author LianGuoQing
 */
public interface ErrorCode extends Serializable {

    /**
     * 返回 HTTP 状态码
     * 
     * @return
     */
    int getHttpCode();

    /**
     * 返回异常代码
     * 
     * @return 异常代码
     * @since 0.1
     */
    String getCode();

    /**
     * 根据指定的占位符参数格式化异常消息。
     * 
     * @param args 占位符参数
     * @return 格式化后的异常消息
     * @since 0.1
     */
    String getMessage(Object... args);
}
