package com.atguigu.springboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.atguigu.springboot.component.LoginHandlerInterceptor;
import com.atguigu.springboot.component.MyLocaleResolver;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// super.addViewControllers(registry);
		// 浏览器发送 /atguigu 请求来到 success
		registry.addViewController("/atguigu").setViewName("success");
	}

	@Bean
	public WebMvcConfigurerAdapter wbMvcConfigurerAdapter() {

		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				// TODO Auto-generated method stub
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}

//			@Override
//			public void addInterceptors(InterceptorRegistry registry) {
//				// TODO Auto-generated method stub
//				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//						.excludePathPatterns("/index.html", "/", "/user/login");
//			}

		};
		return adapter;
	}

	@Bean
	public LocaleResolver localeResolver() {

		return new MyLocaleResolver();
	}

}
