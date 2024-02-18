package com.dagy.cafeheroapi.features.auth.data.dto.response;

import com.dagy.cafeheroapi.features.auth.data.dto.LoginUser;
import com.dagy.cafeheroapi.features.auth.data.dto.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    private Long id;
    private LoginUser user;
    private List<Menu> menu;
    private Map<String, String> app;
}
