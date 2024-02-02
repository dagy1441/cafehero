package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductStatusRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/product-status")
public interface ProductStatusApi {
    @GetMapping(
            value = "get/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un statut",
            description = "Permet de Rechercher un statut par id. La réponse est le statut recherché"
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
    public ResponseEntity<Optional<ProductStatusRequest>> find(@PathVariable Long id);
    @GetMapping(
            value = "all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Rechercher une statut",
            description = "Permet de Rechercher plusieurs statut . La réponse est une liste de statut"
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
    public ResponseEntity<List<ProductStatusRequest>> findMany();
    @PostMapping(
            value = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer un statut",
            description = "Permet de Enregistrer un statut. La réponse est le statut enregistré"
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
    public ResponseEntity<Optional<ProductStatusRequest>> save(@RequestBody @Valid ProductStatusRequest dto);

    @PutMapping(
            value = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifier un statut",
            description = "Permet de Modifier un statut par id. La réponse est le statut modifié"
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
    public ResponseEntity<Optional<ProductStatusRequest>> update(@RequestBody @Valid ProductStatusRequest request);

    @DeleteMapping(
            value = "delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Supprimer un statut",
            description = "Permet de Supprimer un statut par id. La réponse est le statut supprimer"
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
                    content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id);
}
