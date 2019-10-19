package cn.linc.ribbon.eureka;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * ribbonconfig
 *
 * @author xiechenglin
 * @create 2019-10-05 19:19
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }

}
