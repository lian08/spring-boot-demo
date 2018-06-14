/*
* @CoypRight: nd.com (c) 2018 All Rights Reserved
* @Title: HelloController.java
* @Package com.agxx.app.controller
* @author LianGuoQing
* @date 2018年6月19日 上午11:35:54
* @version V1.0
*/
package com.agxx.app.controller;

import com.agxx.app.common.constant.VersionConstant;
import com.agxx.app.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/6 0006 下午 7:16      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
//@RestController
@Controller
@RequestMapping(value = VersionConstant.V01 + "/hellos")
public class HelloController {

    private static final String INDEX = "index";

    @Autowired
    private HelloService helloService;

//    @ResponseBody
//    @RequestMapping(value = "/{helloName}", method = RequestMethod.GET)
//    public String index(@PathVariable String helloName, @RequestParam(required = false) String userId) {
//        return helloService.index(helloName);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String test(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return INDEX;
    }

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }



}