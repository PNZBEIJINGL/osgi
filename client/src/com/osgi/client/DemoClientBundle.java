package com.osgi.client;

import com.osgi.api.IDemoService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Objects;

/**
 *
 */
public class DemoClientBundle implements BundleActivator {

    //每个Bundle新建时都会默认生成Activator类，该类实现了BundleActivator类，实现了其start()和stop()两个方法
    //框架运行时，容器中存有唯一的BundleContext对象，与Spring容器中唯一的ApplicationContext对象同理

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        //如果用多个同一类型的服务，则默认获取排序最前的一个，但在正常开发中，是很少会出现发布同一类型的多个服务
        ServiceReference<IDemoService> reference = bundleContext.getServiceReference(IDemoService.class);

        if (Objects.nonNull(reference)) {
            //bundleContext通过getService来获取具体的服务
            IDemoService service = bundleContext.getService(reference);
            if (Objects.nonNull(service)) {

                System.out.println(service.sayHello("liuy"));
            }
            //注销服务
            bundleContext.ungetService(reference);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
