package cn.linc.hystrix.turbine;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableCircuitBreaker
public class HystrixTurbineApplication {

	@Autowired
	public HystrixTurbineApplication(@Qualifier("eurekaClient") EurekaClient eurekaClient, RestTemplate restTemplate) {
		this.eurekaClient = eurekaClient;
		this.restTemplate = restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(HystrixTurbineApplication.class, args);
	}

	private final EurekaClient eurekaClient;

	private final RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "errorInfo", commandProperties = {
			@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
	}/*这个是不同线程之间scope共享*/)
	@RequestMapping("getConsumer")
	public String getSpringCloudInfo(){
		InstanceInfo instanceInfo =eurekaClient.getNextServerFromEureka("EUREKA-PROVIDER",false);
		String url = instanceInfo.getHomePageUrl();
		return restTemplate.getForObject(url+"/getProvider",String.class);
	}

	public String errorInfo(){
		return "系统异常";
	}

}
