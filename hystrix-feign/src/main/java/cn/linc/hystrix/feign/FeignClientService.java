package cn.linc.hystrix.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "eureka-provider",fallback = FeignClientFallBaceService.class)
public interface FeignClientService {

    @GetMapping("/getProvider")
    String getSpringCloudInfo();

}
