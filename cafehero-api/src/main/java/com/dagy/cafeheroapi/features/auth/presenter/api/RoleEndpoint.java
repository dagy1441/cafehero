package com.dagy.cafeheroapi.features.auth.presenter.api;

import com.dagy.cafeheroapi.features.auth.data.dto.response.PermissionResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.response.RoleResponse;
import com.dagy.cafeheroapi.features.auth.data.dto.resquest.RoleRequest;
import com.dagy.cafeheroapi.features.product.data.request.ProductCategoryRequest;
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

@RequestMapping(value = API_PREFIX + "/auth/role")
public interface RoleEndpoint {
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    @Operation(
            summary = "Créer un rôle",
            description = "Permet de créer un rôle. La réponse est le rôle créer"
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
    public ResponseEntity<RoleResponse> create(@RequestBody @Valid RoleRequest role);
    @GetMapping(
            value = "/all",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Récuperer toutes les rôles",
            description = "Permet de récuperer la liste des rôles. La réponse est la liste des rôles"
    )
    public ResponseEntity<List<RoleResponse>> getAll();
    @GetMapping(
            value = "/find/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Récuperer un rôle",
            description = "Permet de récuperer un rôle par id. La réponse est un rôle"
    )
    public ResponseEntity<Optional<RoleResponse>> getOne(@PathVariable Long id);
    @GetMapping(
            value = "/find-role-permission/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Rechercher un rôle par permission",
            description = "Permet de rechercher un rôle par permission. La réponse est la liste des permissions"
    )
    public ResponseEntity<List<PermissionResponse>> getRolePermissions(@PathVariable Long id);
    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Modifier un rôle",
            description = "Permet de modifier un rôle. La réponse est le rôle modifier"
    )
    public ResponseEntity<Optional<RoleResponse>> update(@RequestBody RoleRequest request);
    @PutMapping(
            value = "/status/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Activer ou Désactiver un rôle",
            description = "Permet de activer ou désactiver un rôle. La réponse est le rôle modifié"
    )
    public ResponseEntity<Optional<Boolean>> updateActiveStatus(@PathVariable Long id);
}
