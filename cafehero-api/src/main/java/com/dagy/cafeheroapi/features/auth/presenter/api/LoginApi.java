package com.dagy.cafeheroapi.features.auth.presenter.api;

import com.dagy.cafeheroapi.core.constants.GlobalConstant;
import com.dagy.cafeheroapi.features.auth.data.dto.response.LoginResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.LoginRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = GlobalConstant.API_PREFIX + "/auth")
public interface LoginApi {
    @PostMapping(
            value = "login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    @Operation(
            summary = "Se connecter",
            description = "Permet à l'utilisateur de se connecter. La réponse est l'utilisateur connecté"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = {@Content(
                            schema = @Schema(implementation = ProductCategoryRequest.class),
                            mediaType = "application/json")}),
            @ApiResponse(
                    responseCode = "404",
                    content = {@Content(schema = @Schema())}),
            @ApiResponse(
                    responseCode = "500",
                    content = {@Content(schema = @Schema())})}
    )
    ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    );
}
