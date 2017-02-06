package com.onlineproduct.config;



import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.onlineproduct.repository.UserRepository;
import com.onlineproduct.repository.UserRepositoryImpl;

@Configuration
@ComponentScan(basePackages = "com.onlineproduct")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/online-product??autoReconnect=true&useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("ramesh123");
		
		return  datasource;
	}
	
	@Bean
	public UserRepository getUserDAO() {
		return new UserRepositoryImpl(getDataSource());
	}
	
}
