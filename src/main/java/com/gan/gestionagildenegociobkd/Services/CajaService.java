package com.gan.gestionagildenegociobkd.Services;

import com.gan.gestionagildenegociobkd.dto.CajaDTO;

import java.util.List;

public interface CajaService {

    CajaDTO createCaja(CajaDTO cajaDTO);

    List<CajaDTO> findAllCajas();
}
