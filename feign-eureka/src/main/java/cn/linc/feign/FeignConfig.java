package cn.linc.feign;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;


/**
 * 描述:
 * feign配置
 *
 * @author xiechenglin
 * @create 2019-10-05 22:04
 */
@Configuration
public class FeignConfig {

    /*自定义契约*/
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

    /*设置url访问用户名密码*/
    @Bean
    public BasicAuthorizationInterceptor initBasicAuthorizationInterceptor(){
        return new BasicAuthorizationInterceptor("user","123");
    }

    /*设置日志*/
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


}
