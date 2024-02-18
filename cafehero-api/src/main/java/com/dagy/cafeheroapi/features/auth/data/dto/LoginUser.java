package com.dagy.cafeheroapi.features.auth.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUser {
    private Long id;
    private String username;
    private String token;
    private String fullName;
    private String email;
    private boolean enabled;
    private List<String> access;
}