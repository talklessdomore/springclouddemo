package cn.linc.feign.eureka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableFeignClients
public class FeignEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignEurekaApplication.class, args);
	}

	@Autowired
	private  FeignClientService feignClientService;

	@RequestMapping("getConsumer")
	public String getSpringCloudInfo(){
		String message = feignClientService.getSpringCloudInfo();
		return message;
	}

}
