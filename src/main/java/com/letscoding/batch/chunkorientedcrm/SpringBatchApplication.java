package com.letscoding.batch.chunkorientedcrm;


import com.letscoding.batch.annotation.BatchAutoConfigurationApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.core.env.StandardEnvironment;


@BatchAutoConfigurationApplication
public class SpringBatchApplication {
	public static void main(String[] args) {
		SpringApplication application=new SpringApplication(SpringBatchApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.setEnvironment(new StandardEnvironment());
		application.addListeners(new ApplicationPidFileWriter("./application.pid"));
		application.run(args);

	}
}
