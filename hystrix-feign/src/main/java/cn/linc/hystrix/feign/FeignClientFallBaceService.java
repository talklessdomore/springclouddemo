package cn.linc.hystrix.feign;

import org.springframework.stereotype.Component;

/**
 * 描述:
 * feign错误处理
 *
 * @author xiechenglin
 * @create 2019-10-06 9:59
 */
@Component
public class FeignClientFallBaceService implements FeignClientService {

    @Override
    public String getSpringCloudInfo() {
        return "feign-hystrix error deal";
    }
}
