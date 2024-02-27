package com.dagy.cafeheroapi.features.auth.presenter.controller;

import com.dagy.cafeheroapi.features.auth.data.dto.response.LoginResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.LoginRequest;
import com.dagy.cafeheroapi.features.auth.data.service.abstracts.ILoginService;
import com.dagy.cafeheroapi.features.auth.presenter.api.LoginApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController implements LoginApi {
    private final ILoginService loginService;
    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) {
        System.out.println(request);
        return loginService.login(request);
    }
}
