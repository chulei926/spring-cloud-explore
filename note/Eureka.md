# 注册中心 - Eureka
[微服务注册中心 Eureka 架构深入解读](https://www.infoq.cn/article/jldjq*3wtn2pcqtdyokh)
- Eureka Server
- Eureka Client

## Eureka Server 搭建
- 引入依赖
```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```
- 修改 hosts
```text
127.0.0.1 eureka7000.com
127.0.0.1 eureka7001.com
```
- application.yml
```yaml
server:
    port: 7000

eureka:
    instance:
        # hostname: localhost       # eureka服务端的实例名称（单节点）
        hostname: eureka7000.com    # eureka服务端的实例名称（集群）
    client:
        register-with-eureka: false # false表示不向注册中心注册自己。
        fetch-registry: false       # false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
        service-url:
            # defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/   #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。（单节点）
            defaultZone: http://eureka7001.com:7001/eureka/                            #设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址。（集群）
            # 这里有两个 eureka server，分别是 eureka7000.com、eureka7001.com
            # hostname = eureka7000.com 的服务的 defaultZone = http://eureka7001.com:7001/eureka/
            # hostname = eureka7001.com 的服务的 defaultZone = http://eureka7000.com:7000/eureka/
```
- 启动类
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsEurekaServer7001 {

	public static void main(String[] args) {
		SpringApplication.run(MsEurekaServer7001.class, args);
	}

}
```


## Eureka Client 搭建
- 引入依赖
```xml
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
```
- application.yml
```yaml
# ms-user-provider
server:
    port: 7002
spring:
    application:
        name: ms-user-provider
    datasource:
        type: com.alibaba.druid.pool.DruidDataSource            # 当前数据源操作类型
        driver-class-name: org.gjt.mm.mysql.Driver              # mysql驱动包 com.mysql.jdbc.Driver
        url: jdbc:mysql://10.8.0.246:3306/ei_rpt_kitty?useUnicode=true&characterEncoding=utf-8&useSSL=false
        username: 
        password: 
eureka:
    client:
        register-with-eureka: true   # 表示是否将自己注册进EurekaServer默认为true。
        fetchRegistry: true          # 是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
        service-url:
            # defaultZone: http://localhost:7001/eureka
            defaultZone: http://eureka7000.com:7000/eureka,http://eureka7001.com:7001/eureka  # 集群版


# ms-user-consumer
server:
    port: 7003
spring:
    application:
        name: ms-user-consumer
eureka:
    client:
        register-with-eureka: true   # 表示是否将自己注册进EurekaServer默认为true。
        fetchRegistry: true          # 是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
        service-url:
            # defaultZone: http://localhost:7001/eureka
            defaultZone: http://eureka7000.com:7000/eureka,http://eureka7001.com:7001/eureka  # 集群版


```
- 启动类
```java
// 服务提供方
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsUserProviderApplication7002 {

	public static void main(String[] args) {
		SpringApplication.run(MsUserProviderApplication7002.class, args);
	}

}

// 服务消费方
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsUserConsumerApplication7003 {

	public static void main(String[] args) {
		SpringApplication.run(MsUserConsumerApplication7003.class, args);
	}

}

```
- 引入 RestTemplate
```java
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringContextConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
```
- 测试接口
```java
import com.leichu.spring.cloud.explore.common.dto.JsonResult;
import com.leichu.spring.cloud.explore.common.model.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	private RestTemplate restTemplate;

//	private static final String host = "http://localhost:8001/user-service/"; // 单节点
	private static final String host = "http://MS-USER-PROVIDER/"; // 这里的 MS-USER-PROVIDER 是服务提供方的 spring.application.name

	@GetMapping("user/{id}")
	@ResponseBody
	public JsonResult<User> user(@PathVariable("id") Long id) {
		final JsonResult<User> result = restTemplate.getForObject(host + "user/" + id, JsonResult.class, id);
		return result;
	}


	@PostMapping("user/create")
	@ResponseBody
	public JsonResult<User> create(@RequestBody User user) {
		final JsonResult<User> result = restTemplate.postForObject(host + "user/create", user, JsonResult.class);
		return result;
	}

}

```


