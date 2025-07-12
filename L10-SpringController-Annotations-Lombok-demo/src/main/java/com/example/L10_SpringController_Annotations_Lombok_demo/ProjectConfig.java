package com.example.L10_SpringController_Annotations_Lombok_demo;

import org.example.DefaultKeywordAnalyzer;
import org.example.KeywordAnalyzerInterface;
import org.example.UniqueKeywordAnalyzerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {


    @Bean("defaultKeywordAnalyzer")
    @Primary
    public KeywordAnalyzerInterface defaultKeywordAnalyzer(){
        return new DefaultKeywordAnalyzer();
    }

    @Bean("uniqueKeywordAnalyzer")
    public KeywordAnalyzerInterface uniqueKeywordAnalyzer(){
        return new UniqueKeywordAnalyzerImpl();
    }

}
