package com.dagy.cafeheroapi.features.product.presenter.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductUnitOfMeasureRequest;
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

@RequestMapping(value = API_PREFIX + "/product/unit-of-measurement")
public interface ProductUnitOfMeasureApi {
    @GetMapping(
            value = "/get/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une unité de mesure",
            description = "Permet de Rechercher une unité de mesure par id. La réponse est l'unité de mesure recherchée"
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
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>>
    find(@PathVariable Long id);
    @GetMapping(
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher toutes les unitées de mesure",
            description = "Permet de Rechercher toutes les unités de mesure par id. La réponse la liste de toutes unités de mesure"
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
    public ResponseEntity<List<ProductUnitOfMeasureRequest>> findMany();
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Enregistrer une unitée de mesure",
            description = "Permet d'enregistrer une unité de mesure. La réponse l'unités de mesure enregistrée"
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
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> save(
            @RequestBody @Valid ProductUnitOfMeasureRequest dto
    );
    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifier une unitée de mesure",
            description = "Permet modifier une unité de mesure. La réponse l'unités de mesure modifiée"
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
    public ResponseEntity<Optional<ProductUnitOfMeasureRequest>> update(
            @RequestBody @Valid ProductUnitOfMeasureRequest dto
    );
    @DeleteMapping(
            value = "/delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Supprimer une unitée de mesure",
            description = "Permet de supprimer une unité de mesure. La réponse l'unités de mesure supprimée"
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
