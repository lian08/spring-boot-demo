package com.agxx.app.controller;

import com.agxx.app.common.constant.VersionConstant;
import com.agxx.app.common.exception.AgxxException;
import com.agxx.app.common.exception.BaseErrorCode;
import com.agxx.app.entity.User;
import com.agxx.app.model.UserRequest;
import com.agxx.app.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/13 0013 上午 11:55      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
@RestController
@RequestMapping(value = VersionConstant.V01 + "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public String addUser(@RequestBody UserRequest userRequest) {
        if (StringUtils.isEmpty(userRequest.getName())) {
            throw new AgxxException(BaseErrorCode.INVALID_QUERY, "name");
        }

        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        int num = userService.insertByUser(user);
        return String.valueOf(num);
    }

}