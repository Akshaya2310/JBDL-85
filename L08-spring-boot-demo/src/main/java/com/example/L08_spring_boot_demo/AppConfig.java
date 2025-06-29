package com.example.L08_spring_boot_demo;

import org.example.DefaultKeywordAnalyzer;
import org.example.KeywordAnalyzerInterface;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public KeywordAnalyzerInterface defaultKeywordAnalyzer() {
        return new DefaultKeywordAnalyzer();
    }

}
