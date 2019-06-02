demo来源：
https://www.jianshu.com/p/1751046d1491

下载地址：4.1.1
https://download.eclipse.org/equinox/


////////////////////////////
OSGi框架从概念上可以分为三层：
Module Layer：模块层主要涉及包及共享的代码；
Lifecycle Layer：生命周期层主要涉及Bundle的运行时生命周期管理；
Service Layer：服务层主要涉及模块之间的交互和通信

Bundle:
bundle 是以 jar 包形式存在的一个模块化物理单元，里面包含了代码，资源文件和元数据（metadata），并且jar包的物理边界也同时是运行时逻辑模块的封装边界

//////////// 生命周期层 ////////////////

生命周期层在OSGi框架中属于模块层上面的一层，它的运作是建立在模块层的功能之上的。
生命周期层的主要功能是控制动态安装、开启、关闭、更新和卸载的bundles。
生命周期层让你能够从外部管理应用或者建立能够自我管理的应用（或者两者的结合），并且给了应用本身很大的动态性。

前面已经了解了 Bundle 的概念和作用。但是要真正使用 Bundle，需要使用生命周期层的API，来和OSGi框架的生命周期层进行交互。

在标准的Java编程中，可以通过将jar包放到classpath中来使用它。而bundle则不是这样，Bundle只有在被安装（install）到一个OSGi框架的运行实例中才能用起来。
并且OSGi框架支持对这些bundle完整的生命周期管理，并且支持这些管理操作在应用执行完成。

重要接口:
生命周期层的API主要是由以下三个核心接口来组成的：BundleActivator，BundleContext 和 Bundle。
BundleActivator：让你能够捕捉bundle的start和stop事件，并对这两个事件作出自定义的反应。
BundleContext：一个bundle在框架中的执行时上下文，这个上下文提供了和框架进行交互的方法。
Bundle：在逻辑上表示了一个bundle，OSGi环境中的一个物理bundle对应了一个bundle对象。该对象中包含了bundle的基本信息和bundle生命周期的控制接口


////////// 服务层  ////////////////

一个OSGi 服务就是注册到 OSGi 框架中的一个 Java 对象。
注册的时候可以设置这个 Service 的属性。而在获取 Service的时候可以根据属性进行过滤。

Bundle 可以通过 Bundle的上下文去注册Service或去查询Service。
一个提供服务的bundle可以发布POJO作为服务的实体；一个使用服务的bundle可以通过这个注册表找到和绑定服务


////////// BundleContext  ////////////////
OSGi容器中运行的各个Bundle共同构成了一个微型的生态系统，Bundle的许多行为都无法孤立进行，
必须在特定的上下文环境中才有意义，因为要与上下文的其他Bundle或OSGi框架进行互动。
在代码中使用BundleContext对象来代表上下文环境，当Bundle启动的时候，OSGi框架就创建这个Bundle的BundleContext对象，直到Bundle停止运行从OSGi容器卸载为止