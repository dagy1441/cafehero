package com.dagy.cafeheroapi.features.product.endpoint.api;

import com.dagy.cafeheroapi.core.params.pages.PageSearchRequest;
import com.dagy.cafeheroapi.core.params.pages.PageSearchResult;
import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductDiscountRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductSearchRequest;
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

@RequestMapping(value = API_PREFIX + "/product")
public interface ProductApi {
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Création d'un produit",
            description = "Permet de créer un  produit. La réponse est un objet de produit"
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
    public ResponseEntity<ProductRequest> create(@RequestBody ProductRequest request);

    @PostMapping(
            value = "/search-request",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un produit",
            description = "Permet de rechercher un  produit. La réponse est une liste de produit filtrées par page"
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
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchProducts(@Valid @RequestBody PageSearchRequest<ProductSearchRequest> request);

//    @PostMapping(value = "/set-price/{id}")
//    public ResponseEntity<Optional<ProductRequest>> setPrice(
//            @PathVariable Long id, @RequestBody StockPriceRequest price
//    );

    @PostMapping(
            value = "/set-discount",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Verifier une remise sur un produit",
            description = "Permet de vérifier s'il ya une remise sur un  produit. La réponse est oui ou non"
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
    public ResponseEntity<Boolean> setDiscount(@RequestBody ProductDiscountRequest discountRequest);

    @PostMapping(
            value = "/set-quantity/{id}/{quantity}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifer la quantité d'un produit",
            description = "Permet de modifier la quantité d'un  produit. La réponse est un produit modifier"
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
    public ResponseEntity<Optional<ProductRequest>> setQuantity(@PathVariable Long id, @PathVariable Integer quantity);

    @GetMapping(
            value = "search",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un produit",
            description = "Permet de rechercher un  produit. La réponse est une liste de  produit"
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
    public ResponseEntity<List<ProductRequest>> search(@RequestParam(value = "term") String term);

    @PostMapping(
            value = "/search-sales-products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un produit",
            description = "Permet de rechercher un  produit. La réponse est une liste de  produit"
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
    public ResponseEntity<PageSearchResult<List<ProductRequest>>> searchSalesProducts(@Valid @RequestBody PageSearchRequest<ProductSearchRequest> request);

    @PostMapping(
            value = "/import-file",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Uploader un produit",
            description = "Permet de Uploader des fichier."
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
    public ResponseEntity<?> uploadBatchService(@RequestParam("file") MultipartFile file) throws IOException;

    @GetMapping(
            value = "/download-template",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseBody
    @Operation(
            summary = "Télécharger un produit",
            description = "Permet de Uploader des fichier."
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
    public ResponseEntity<Resource> downloadFile() throws IOException;
}
