package com.ssafy.home;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.home.Interceptor.SessionInterceptor;

@Configuration
public class MyConfig extends SpringBootServletInitializer implements WebMvcConfigurer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HappyHouseApplication.class);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns(
                        "/test/a",
                        "/board/write",
                        "/board/edit",
						"/interest/**",
                        "/member/mvInfo",
                        "/member/update") // 해당 경로에 접근하기
                // 전에 가로챔
                .excludePathPatterns("/test/b");// 해당 경로는 인터셉터가 가로채지 않는다.
    }
}