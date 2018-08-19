# BeanFactory部分类图演变
## 1.开始
BeanFactory接口用于获取、生成bean的实例。提供一个默认的实现DefaultBeanFactory，解析xml文件，提取bean实例。
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_1_start.jpg)


## 2.分离解析xml的职责
由于BeanFactory应该只关注bean的获取，底层解析XML的操作不希望放在BeanFactory中，于是分离出XmlBeanDefinitionReader。
（BeanDefinition是用于存储bean的定义的数据结构）
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_2_抽出xml方法.jpg)

## 3.单一职责原则,提炼BeanDefinitionRegistry
虽然提炼了XmlBeanDefinitionReader，但是BeanFactory中依然向外暴露了BeanDefinition这种数据结构的操作，于是在接口中进行职责的分离，提炼出
BeanDefinitionRegistry
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_3_beanDifinitionRegistry.jpg)

## 4.使用ApplicationContext封装底层细节
原本获取bean，需要用户手动的调用方法解析xml、注册beanDefinition等，顶层交互的接口不应该让用户关心底层的细节，因此抽取ApplicationContext封装细节。
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_4_ApplicationContext.jpg)

## 5.提取Resource接口，统一资源的访问
无论Spring如何解析xml，或从classPath相对路径、或从FileSystem绝对路径，最终都是返回一个InputStream的流，因此抽象出一个Resource接口。
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_5_resource.jpg)
注：ApplicationContext是高层模块，它关心的东西应该跟BeanFactory一样，是获取bean实例，并不关心资源的路径。
因此多加一层AbstractApplicationContext屏蔽细节。

## 6.灵活配置，ConfigurableBeanFactory
之前获取classLoader时都是写死了一个，现在希望做到可配置，留一个可扩展的口子让子类去实现。但是由于BeanFactory是顶层接口，不希望暴露这些扩展的方法
给外部，于是可以抽象多一层
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_6_ConfigurableBeanFactory.jpg)<br/>
以后有一些属性不希望写死，直到子类或者留给外部去决定，这些属性可以往ConfigurableBeanFactory接口中添加。（此处的实现和Spring的实现稍有不同）

## 7.Spring的Scope实现，提炼SingleltonBeanRegistry接口
SingleltonBeanRegistry接口提供了实现Singleton的能力，默认实现是DefaultSingletonBeanRegistry，此对象保存所有bean的单例。<br/>
![image](https://github.com/lapple06/MySpring/raw/b_bean_factory/uml/BeanFactory/beanFactory_7_SingleltonBeanRegistry.jpg)

## 8.总的类图
待补充。。
