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
    public ResponseEntity<ProductCategoryRequest> find(@PathVariable Long id);
    @GetMapping("all")
    public ResponseEntity<List<ProductCategoryRequest>> findMany();
    @PostMapping("create")
    public ResponseEntity<Optional<ProductCategoryRequest>> save(
            @RequestBody @Valid ProductCategoryRequest dto
    );
    @PutMapping("update")
    public ResponseEntity<Optional<ProductCategoryRequest>> update(
            @RequestBody @Valid ProductCategoryRequest dto
    );
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Optional<Boolean>> remove(@PathVariable Long id);
    @GetMapping("search")
    public ResponseEntity<List<ProductCategoryRequest>> search(
            @RequestParam(value = "term") String term
    );
    @PutMapping("status/{id}")
    public ResponseEntity<Optional<Boolean>> toggleIsActiveStatus(@PathVariable Long id);
    @GetMapping("/download-template")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile() throws IOException;
    @PostMapping(value = "/upload")
    public ResponseEntity<?> uploadBatchCategories(@RequestParam("file") MultipartFile file);
}
