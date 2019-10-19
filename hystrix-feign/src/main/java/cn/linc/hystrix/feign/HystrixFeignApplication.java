package cn.linc.hystrix.feign;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class HystrixFeignApplication {

	@Autowired
	private FeignClientService feignClientService;

	public static void main(String[] args) {
		SpringApplication.run(HystrixFeignApplication.class, args);
	}


	@HystrixCommand(fallbackMethod = "errorInfo", commandProperties = {
			@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
	}/*这个是不同线程之间scope共享*/)
	@RequestMapping("getConsumer")
	public String getSpringCloudInfo(){
		String message = feignClientService.getSpringCloudInfo();
		return message;
	}
}
