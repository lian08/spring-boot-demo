package com.agxx.app.service.impl;

import com.agxx.app.dao.UserDao;
import com.agxx.app.entity.User;
import com.agxx.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/12 0012 下午 2:44      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public int insertByUser(User user) {
        return userDao.insertByUser(user);
    }

}