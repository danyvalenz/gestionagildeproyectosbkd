package com.gan.gestionagildenegociobkd.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericController {
    /*
    protected ResponseEntity<CustomResponse> getResponse(List<?> lst) throws NotContentException {
        if (!isContent(lst)) {
            throw new NotContentException();
        }
        CustomResponse customResponse = CustomResponse.builder()
                .message(API_MSG_RESPONSE_CONSULTA + lst.size())
                .httpCode(HttpStatus.OK.value() + "-" + HttpStatus.OK.name()).dataTime(LocalDateTime.now().toString())
                .data(lst).build();
        return ResponseEntity.ok(customResponse);
    } */

    // 	protected ControllerException getException(Exception e) {
    //		return new ControllerException(e);
    //	}

    protected ResponseEntity<?> internalError() {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<List<Map<String, String>>> getErrors(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {

                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }
        ).toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    protected ResponseEntity<?> str(String str) {
        if (isNull(str)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}
