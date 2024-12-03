package org.example.softwarearchitecture.config;

import lombok.RequiredArgsConstructor;
import org.example.softwarearchitecture.interceptor.AdminInterceptor;
import org.example.softwarearchitecture.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;
    private final AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login");

        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/api/admin/**");
    }
}
