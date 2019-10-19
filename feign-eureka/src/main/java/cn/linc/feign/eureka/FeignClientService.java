package cn.linc.feign.eureka;

import cn.linc.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "eureka-provider",configuration = FeignConfig.class)
public interface FeignClientService {

    @GetMapping("/getProvider")
    String getSpringCloudInfo();

}
