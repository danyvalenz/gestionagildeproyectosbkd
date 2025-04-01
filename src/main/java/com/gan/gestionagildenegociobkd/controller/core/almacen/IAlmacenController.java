package com.gan.gestionagildenegociobkd.controller.core.almacen;

import com.gan.gestionagildenegociobkd.controller.commons.CustomResponse;
import com.gan.gestionagildenegociobkd.dto.AlmacenDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.API_ALMACENES;
import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.API_CREATE_ALMACEN;

public interface IAlmacenController {

    @Operation(summary = "Busqueda de almacenes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Almacenes encontrados", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AlmacenDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Almacenes no disponibles",content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno",content = @Content)
    })
    @GetMapping(API_ALMACENES)
    ResponseEntity<CustomResponse> findAlmancenes();

    @Operation(summary = "Alta  de nuevo almacenes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alta de Almacen", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AlmacenDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Almacenes no disponibles",content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno",content = @Content)
    })
    @PostMapping(API_CREATE_ALMACEN)
    ResponseEntity<CustomResponse> createAlmacen(@RequestBody AlmacenDTO almacenDTO);
}
