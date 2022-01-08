package com.irisi.facturationservice.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfig {
    public Sampler SleuthConfig(){
        return Sampler.ALWAYS_SAMPLE;
    }
}
