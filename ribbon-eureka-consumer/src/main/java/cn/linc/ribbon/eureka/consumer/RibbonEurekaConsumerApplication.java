package cn.linc.ribbon.eureka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonEurekaConsumerApplication {

	@Autowired
	public RibbonEurekaConsumerApplication(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
		this.restTemplate = restTemplate;
		this.loadBalancerClient = loadBalancerClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonEurekaConsumerApplication.class, args);
	}


	private final RestTemplate restTemplate;

	private final LoadBalancerClient loadBalancerClient;

	@RequestMapping("getConsumer/v1")
	public String getSpringCloudInfo(){
		return restTemplate.getForObject("http://RIBBON-EUREKA-PROVIDER/getProvider",String.class);
	}

	@RequestMapping("getConsumer/v2")
	public String getSpringCloudInfo2(){
		ServiceInstance serviceInstance = loadBalancerClient.choose("RIBBON-EUREKA-PROVIDER");
		String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/getProvider";
		String message = restTemplate.getForObject(url,String.class);
		return message;
	}

}
