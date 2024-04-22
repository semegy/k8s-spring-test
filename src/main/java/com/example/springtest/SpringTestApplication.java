package com.example.springtest;

import com.demo.starter.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringTestApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = SpringApplication.run(SpringTestApplication.class, args);
		DemoService bean = applicationContext.getBean("demo", DemoService.class);
		System.out.println(bean.say());
		while (true) {
			Thread.sleep(2000);
		}
	}


}
