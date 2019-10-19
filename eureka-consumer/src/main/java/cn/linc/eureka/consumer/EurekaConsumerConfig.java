package cn.linc.eureka.consumer;

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
public class EurekaConsumerConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
