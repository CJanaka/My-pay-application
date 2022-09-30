package com.mypay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class Configure{
//Use to implements the third party SMS service configurations.
//This class is not used anywhere due to the SMS free-service no longer available at their
    private String accountSid;
    private String authToken;
    private String trialNumber;
}
