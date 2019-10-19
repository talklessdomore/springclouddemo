package cn.linc.eureka.consumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaConsumerApplication {

	@Autowired
	public EurekaConsumerApplication(@Qualifier("eurekaClient") EurekaClient eurekaClient, RestTemplate restTemplate) {
		this.eurekaClient = eurekaClient;
		this.restTemplate = restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}

	private final EurekaClient eurekaClient;

	private final RestTemplate restTemplate;

	@RequestMapping("getConsumer")
	public String getSpringCloudInfo(){
		InstanceInfo instanceInfo =eurekaClient.getNextServerFromEureka("EUREKA-PROVIDER",false);
		String url = instanceInfo.getHomePageUrl();
		return restTemplate.getForObject(url+"/getProvider",String.class);
	}

}
