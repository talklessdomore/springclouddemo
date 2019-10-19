package cn.linc.ribbon.eureka.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonEurekaProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(RibbonEurekaProviderApplication.class, args);
	}

	@RequestMapping("getProvider")
	public String getSpringCloudInfo(){
		return "provider1 info ";
	}

}
