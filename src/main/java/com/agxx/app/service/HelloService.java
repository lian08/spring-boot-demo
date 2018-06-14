package com.agxx.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/6 0006 下午 8:19      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
@Service
public class HelloService {

    @Value("${spring.data.mongodb.uri}")
    private String value;

    public String index(String helloName) {
        return helloName + value;
    }

}