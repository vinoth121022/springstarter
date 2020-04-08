package com.dash.rest;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.dash.rest.security.FpsFilter;

@EnableWebSecurity 
@ImportResource("classpath:security.xml")
@SpringBootApplication
public class RestApplication {

	
	@Bean
	public FilterRegistrationBean<FpsFilter> authorizationFilter() {
		FilterRegistrationBean<FpsFilter> filterRegBean = new FilterRegistrationBean<FpsFilter>();
		filterRegBean.setFilter(new FpsFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		filterRegBean.setUrlPatterns(urlPatterns);
		return filterRegBean;
	}	
	
	@SuppressWarnings("unused")
	private JdbcTemplate jdbcTemplate;
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	
}
