package com.gan.gestionagildenegociobkd.Services;

import com.gan.gestionagildenegociobkd.dto.AlmacenDTO;

import java.util.List;

public interface AlmacenService {

    List<AlmacenDTO> findAllAlmacenes();
    AlmacenDTO createAlmacen(AlmacenDTO almacenDTO);
}
