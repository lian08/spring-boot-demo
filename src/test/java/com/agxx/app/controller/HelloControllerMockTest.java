package com.agxx.app.controller;

import com.agxx.app.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;

/**
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2018  </p>
 * <p>Company: ND Co., Ltd.             </p>
 * <p>Create Time: 2018/6/6 0006 下午 7:46      </p>
 *
 * @author LianGuoQing
 *         <p>Update Time:                      </p>
 *         <p>Updater:                          </p>
 *         <p>Update Comments:                  </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloControllerMockTest {

    @InjectMocks
    private HelloController helloController;

    @Mock
    private HelloService helloService;

    @Test
    public void testIndex() {
        Mockito.when(helloService.index(anyString())).thenReturn(new String());

//        Assert.assertNotNull("SUCCESS", helloController.index("hello", "1"));
    }

}