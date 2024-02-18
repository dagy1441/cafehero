package com.dagy.cafeheroapi.features.auth.data.service.abstracts;

import com.dagy.cafeheroapi.features.auth.data.dto.response.LoginResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface ILoginService {
    ResponseEntity<LoginResponse> login(LoginRequest request);

}
