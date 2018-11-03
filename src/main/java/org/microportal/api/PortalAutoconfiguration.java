package org.microportal.api;

import org.microportal.api.config.ApplicationClientProperies;
import org.microportal.api.listener.ApplicationEventListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(prefix = "portal.client", name = "service", havingValue = "true")
@EnableFeignClients
@Configuration
@EnableConfigurationProperties(ApplicationClientProperies.class)
public class PortalAutoconfiguration {

    @Bean
    public ApplicationEventListener applicationEventListener() {
        return new ApplicationEventListener();
    }
}
