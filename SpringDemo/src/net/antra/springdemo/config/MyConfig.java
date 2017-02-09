package net.antra.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan(basePackages = { "net.antra.Springdemo" })
public class MyConfig {
	
	@Bean(name="myString")
	public String getAString(){
		return "hello";
	}
}
