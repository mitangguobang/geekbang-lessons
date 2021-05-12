## 第 10 周作业
### 作业题目
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
 
