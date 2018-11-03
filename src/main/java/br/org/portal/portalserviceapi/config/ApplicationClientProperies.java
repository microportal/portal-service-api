package br.org.portal.portalserviceapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "portal.client")
public class ApplicationClientProperies {

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String path;

    private String imageUrl;

    @NotEmpty
    @NotNull
    private String indexUrl;

    @NotEmpty
    @NotNull
    private String storeUrl;

    private Boolean service = true;
}
