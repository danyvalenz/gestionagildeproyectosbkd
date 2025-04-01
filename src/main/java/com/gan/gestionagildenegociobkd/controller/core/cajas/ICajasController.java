package com.gan.gestionagildenegociobkd.controller.core.cajas;

import com.gan.gestionagildenegociobkd.controller.commons.CustomResponse;
import com.gan.gestionagildenegociobkd.dto.AlmacenDTO;
import com.gan.gestionagildenegociobkd.dto.CajaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.*;

public interface ICajasController {


    @Operation(summary = "Alta  de nueva Caja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alta de Caja", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CajaDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Cajas no disponibles",content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno",content = @Content)
    })
    @PostMapping(API_CREATE_CAJA)
    ResponseEntity<CustomResponse> createCaja(@RequestBody CajaDTO cajaDTO);



    @Operation(summary = "Busqueda de todas las cajas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cajas encontrados", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CajaDTO.class))
            }),
            @ApiResponse(responseCode = "204", description = "Cajas no disponibles",content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno",content = @Content)
    })
    @GetMapping(API_CAJAS_FIND_ALL)
    ResponseEntity<CustomResponse> findCajas();
}
