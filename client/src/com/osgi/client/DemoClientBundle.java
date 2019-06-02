package com.osgi.client;

import com.osgi.api.IDemoService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Objects;

public class DemoClientBundle implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        //获取到IHelloService服务引用
        ServiceReference<IDemoService> reference = bundleContext.getServiceReference(IDemoService.class);
        if (Objects.nonNull(reference)) {
            //发现服务
            IDemoService service = bundleContext.getService(reference);
            if (Objects.nonNull(service)) {
                System.out.println(service.sayHello("jecyhw"));
            }
            //注销服务
            bundleContext.ungetService(reference);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
