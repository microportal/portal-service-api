package org.microportal.api.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationBase implements Serializable {

    private static final long serialVersionUID = 4027749787235466131L;

    private String name;

    private String path;

    private String imageUrl;

    private String indexUrl;

    private String storeUrl;

    private Boolean service;
}
