package com.osgi.server;

import com.osgi.api.IDemoService;

public class DemoServiceImp implements IDemoService {

    /**
     * 接口
     * 实现IDemoService接口，这个接口需要在API的 mainfest 中（Export-Package）发布才能引用
     *
     * @param somebody
     * @return
     * @see IDemoService;
     */
    public String sayHello(String somebody) {
        return "DemServiceImpl: Hello ," + somebody;
    }
}
