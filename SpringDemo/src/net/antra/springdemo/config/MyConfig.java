package net.antra.springdemo.config;

import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = { "net.antra.springdemo" })
@EnableAspectJAutoProxy
public class MyConfig {
	
	@Bean(name="myString")
	public String getAString(){
		return "hello";
	}

	@Bean(name="myString2")
	@Primary
	public String getAString2(){
		return "hi";
	}

}
