package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.dagy.cafeheroapi.core.constants.GlobalConstant.API_PREFIX;

@RequestMapping(value = API_PREFIX + "/product/category")
public interface ProductCategoryApi {
    @GetMapping(
            value = "get/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher une catégorie",
            description = "Permet de Rechercher une  catégorie par id. La réponse est une liste de catégorie"
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
    public ResponseEntity<ProductCategoryRequest> find(@PathVariable Long id);
    @GetMapping(
            value = "all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher la liste categorie ",
            description = "Permet de Rechercher la liste catégorie. La réponse est une liste de catégorie"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<List<ProductCategoryRequest>> findMany();
    @PostMapping(
            value = "create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Création d'une categorie ",
            description = "Permet de créer une nouvelle catégorie. La réponse est un objet de catégorie"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<Optional<ProductCategoryRequest>> save(
            @RequestBody @Valid ProductCategoryRequest dto
    );
    @PutMapping(
            value = "update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modification d'une categorie ",
            description = "Permet de modifier une catégorie en fournissant un id. La réponse est la de catégorie modifié"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<Optional<ProductCategoryRequest>> update(
            @RequestBody @Valid ProductCategoryRequest dto
    );
    @DeleteMapping(
            value = "delete/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Suppression d'une categorie ",
            description = "Permet de supprimer une nouvelle catégorie en fournissant un id. La réponse est la de catégorie supprimé"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id);
    @GetMapping(
            value = "search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher d'une categorie ",
            description = "Permet de Rechercher une catégorie par un mot clé. La réponse est une liste de catégorie ayant ce mot clé"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<List<ProductCategoryRequest>> search(
            @RequestParam(value = "term") String term
    );
    @PutMapping(
            value = "status/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Activation ou Desactivation d'une categorie ",
            description = "Permet d'activer ou de désactiver une catégorie. La réponse est un message de succès"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<Optional<Boolean>> toggleIsActiveStatus(@PathVariable Long id);
    @ResponseBody
    @GetMapping(value = "/download-template")
    @Operation(
            summary = "Téléchargement de ficher",
            description = "Permet de Télécharger un fichier lié à une catégorie. La réponse est un message de succès"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<Resource> downloadFile() throws IOException;
    @PostMapping(value = "/upload")
    @Operation(
            summary = "Uploader un ficher ",
            description = "Permet de Uploader un ficher. La réponse est un message de succès"
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
                    content = {@Content(schema = @Schema())})})
    public ResponseEntity<?> uploadBatchCategories(@RequestParam("file") MultipartFile file);
}
