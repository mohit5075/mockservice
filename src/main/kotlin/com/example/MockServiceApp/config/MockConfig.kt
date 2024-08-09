package com.example.MockServiceApp.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MockConfig {
    @Bean
    fun objectMapper(): ObjectMapper {
        return jacksonObjectMapper().apply {
            propertyNamingStrategy = PropertyNamingStrategies.UPPER_CAMEL_CASE
        }
    }

}