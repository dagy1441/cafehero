package com.dagy.cafeheroapi.features.auth.presenter.api;

import com.dagy.cafeheroapi.core.constants.GlobalConstant;
import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.AccountRequest;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.CompanyEmployeeSearchRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = GlobalConstant.API_PREFIX + "/auth/account")
public interface AccountApi {
    @PostMapping(
            value = "/search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un employé",
            description = "Permet de rechercher les employées d'une entreprise. La réponse est une liste d'employéé"
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
    public ResponseEntity<PageSearchResult<List<AccountRequest>>>
    searchForUsersAccountInPages(
            @RequestBody PageSearchRequest<CompanyEmployeeSearchRequest> request);

    @PutMapping(
            value = "/update-expiry-date/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifier la date  d'expiration",
            description = "Permet de modifier la date d'expiration d'une session d'utilisateur. La réponse est un message de succès"
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
    public ResponseEntity<Boolean>
    updateExpiryDate(@PathVariable Long userId, @RequestBody AccountRequest request);

    @PutMapping(
            value = "/update-role/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifier un role",
            description = "Permet de modifier le role d'un utilisateur. La réponse est un message de succès"
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
    public ResponseEntity<Boolean>
    updateRole(@PathVariable Long userId, @RequestBody AccountRequest request);

    @PutMapping(
            value = "/update-password/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifier un mot de passe",
            description = "Permet de modifier le mot de passe d'un utilisateur. La réponse est un message de succès"
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
    public ResponseEntity<Boolean>
    updatePassword(@PathVariable Long userId, @RequestBody AccountRequest request);

    @PutMapping(
            value = "/toggle-status/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Changer un statut",
            description = "Permet de changer le statut d'un utilisateur. La réponse est un message de succès"
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
    public ResponseEntity<Boolean> toggleStatus(@PathVariable Long userId);
}
