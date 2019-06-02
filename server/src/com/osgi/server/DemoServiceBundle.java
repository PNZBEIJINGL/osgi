package com.osgi.server;

import com.osgi.api.IDemoService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Dictionary;
import java.util.Hashtable;

public class DemoServiceBundle implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        IDemoService service=new DemoServiceImp();
        Dictionary<String , Object> properties = new Hashtable<>();
        //服务注册
        bundleContext.registerService(IDemoService.class, service, properties);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
