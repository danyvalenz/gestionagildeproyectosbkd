package com.gan.gestionagildenegociobkd.controller.core.cajas;

import com.gan.gestionagildenegociobkd.Services.CajaService;
import com.gan.gestionagildenegociobkd.controller.commons.CustomResponse;
import com.gan.gestionagildenegociobkd.dto.CajaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.STATUS_CODE_OK;
import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.SUCCESS_MESSAGE;

@RestController
public class CajasController implements ICajasController{

    private final CajaService cajaService;

    public CajasController(CajaService cajaService) {
        this.cajaService = cajaService;
    }

    @Override
    public ResponseEntity<CustomResponse> createCaja(CajaDTO cajaDTO) {

        CustomResponse response = new CustomResponse();
        response.setMessage(SUCCESS_MESSAGE);
        response.setHttpCode(STATUS_CODE_OK);
        response.setDataTime(LocalDateTime.now().toString());
        response.setData(cajaService.createCaja(cajaDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomResponse> findCajas() {
        CustomResponse response = new CustomResponse();
        response.setMessage(SUCCESS_MESSAGE);
        response.setHttpCode(STATUS_CODE_OK);
        response.setDataTime(LocalDateTime.now().toString());
        response.setData(cajaService.findAllCajas());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
