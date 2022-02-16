[nacos-config](https://www.iocoder.cn/Spring-Cloud-Alibaba/Nacos-Config/)


Nacos Config 提供了三种配置 Nacos 配置集的方式：

A：通过 spring.cloud.nacos.config.shared-configs 配置项，支持多个共享 Nacos 配置集。

B：通过 spring.cloud.nacos.config.extension-configs 配置项，支持多个拓展 Nacos 配置集。

C：通过 spring.cloud.nacos.config.name 配置项，支持一个 Nacos 配置集。

当三种方式共同使用时，它们的优先级关系是：A < B < C。另外，A 和 B 的命名带有“共享”或是“拓展”，没有任何含义，只是优先级不同。

每一个 Nacos 配置集，对应一个 PropertySource 对象，并且优先级符合 C > B > A。另外，注意每一组内部的优先级。

所有 Nacos 配置集的 PropertySource 对象，排在 application.yaml 配置文件的 PropertySource 对象前面，基本是最高优先级。




