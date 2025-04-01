package com.gan.gestionagildenegociobkd.controller.core.almacen;

import com.gan.gestionagildenegociobkd.Services.AlmacenService;
import com.gan.gestionagildenegociobkd.controller.commons.CustomResponse;
import com.gan.gestionagildenegociobkd.dto.AlmacenDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.SUCCESS_MESSAGE;
import static com.gan.gestionagildenegociobkd.controller.constants.ApiMessageConstant.STATUS_CODE_OK;

@RestController
public class AlmacenController implements IAlmacenController{

    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @Override
    public ResponseEntity<CustomResponse> findAlmancenes() {
        CustomResponse response = new CustomResponse();

        response.setMessage(SUCCESS_MESSAGE);
        response.setHttpCode(STATUS_CODE_OK);
        response.setDataTime(LocalDateTime.now().toString());
        response.setData(almacenService.findAllAlmacenes());


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CustomResponse> createAlmacen(AlmacenDTO almacenDTO) {
        CustomResponse response = new CustomResponse();
        response.setMessage(SUCCESS_MESSAGE);
        response.setHttpCode(STATUS_CODE_OK);
        response.setDataTime(LocalDateTime.now().toString());
        response.setData(almacenService.createAlmacen(almacenDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
