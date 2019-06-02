package com.osgi.server;

import com.osgi.api.IDemoService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;

public class DemoServiceBundle implements BundleActivator {


    //每个Bundle新建时都会默认生成Activator类，该类实现了BundleActivator类，实现了其start()和stop()两个方法
    //框架运行时，容器中存有唯一的BundleContext对象，与Spring容器中唯一的ApplicationContext对象同理


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        IDemoService service = new DemoServiceImp();

        //为了让别的bundle能发现这个服务，你必须在发布它之前对其进行特征描述
        Dictionary<String, Object> properties = new Hashtable<>();
        //特征可以是接口名字，或者其他信息
        String[] interfaces = new String[]{IDemoService.class.getName(), IDemoService.class.getSimpleName()};
        properties.put("name", interfaces);
        properties.put("info", "for test");


        //通过接口名从注册的服务中获取到IDemoService服务引用
        //使用到BundleContext中所提供的registerService方法进行注册服务、
        //通过getServiceReference方法获取服务引用及getService获取最终指向的服务对象
        ServiceRegistration registration = bundleContext.registerService(IDemoService.class, service, properties);

        //返回结果对象ServiceRegistration，可以通过这个对象更新服务的元数据，这个对象不能和其他bundle共享
        //也可以通过registration.unregister();把这个服务移除
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
