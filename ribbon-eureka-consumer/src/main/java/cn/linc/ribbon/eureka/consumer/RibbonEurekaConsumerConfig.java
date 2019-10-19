package cn.linc.ribbon.eureka.consumer;


import cn.linc.ribbon.eureka.RibbonConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 * 配置
 *
 * @author xiechenglin
 * @create 2019-10-05 10:53
 */
@Configuration
//方式二:直接配置需要负载均衡的提供者
@RibbonClient("RIBBON-EUREKA-PROVIDER")
//方式三:引入自定义,案例和方式二一样
//@RibbonClient(name = "RIBBON-EUREKA-PROVIDER",configuration = RibbonConfig.class)
public class RibbonEurekaConsumerConfig {
    @Bean
    //方式一：在配置bean方法上面添加注解 @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
