## 第 12 周作业
### 作业
* 将上次 MyBatis@Enable 模块驱动，封装成 SpringBoot Starter 方式。
* 参考:MyBatis Spring Project 里面会有 Spring Boot 实现
### 实现
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
org.geektimes.projects.user.mybatis.annotation.EnableMyBatisExample
  
## 第 11 周作业
### 作业
* 通过 Java 实现两种 (以及) 更多的一致性 Hash 算法 
* (可选) 实现服务节点动态更新
  org.apache.dubbo.rpc.cluster.loadbalance.ConsistentHashLoadBalance
### 实现
* 一致性 Hash 算法
  * 方式一：实际节点
    * org.geektimes.projects.user.consistenthash.NodeArray
  * 方式二：有虚拟节点
    * org.geektimes.projects.user.consistenthash.VirtualNodeArray
  * 测试类：
    * org.geektimes.configuration.consistenthash.ConsistenthashTest
  * 存在问题：hashCode()仅是简单处理，节点分布不平均

## 第 10 周作业
### 作业
* 完善 @org.geektimes.projects.user.mybatis.annotation.EnableMyBatis 实现，尽可能多地注入 org.mybatis.spring.SqlSessionFactoryBean 中依赖的组件
### 实现
* org.geektimes.projects.user.mybatis.annotation.MyBatisBeanDefinitionRegistrar


## 第 9 周作业
### 作业
* 如何清除某个 Spring Cache 所有的 Keys 关联的对象
    * 如果 Redis 中心化方案，Redis + Sentinel,
    * 如果 Redis 去中心化方案，Redis Cluster)
* 如何将 RedisCacheManager 与 @Cacheable 注解打通
  
### 实现
* 清除某个 Spring Cache 所有的 Keys 关联的对象
    * redis的key增加name前缀区分，将所有的key存如 redis list。
    * 清除时，遍历redis list，按key删除缓存。
 
