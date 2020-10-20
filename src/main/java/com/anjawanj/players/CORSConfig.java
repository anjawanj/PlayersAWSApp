package com.anjawanj.players;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                      .allowedOrigins("http://localhost:4201")
                      .allowCredentials(false)
                      .maxAge(-1)
                      .allowedMethods("GET", "POST", "DELETE", "OPTIONS", "HEAD")
                      .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT, HttpHeaders.IF_MODIFIED_SINCE, HttpHeaders.ETAG);
            }
        };
    }
}