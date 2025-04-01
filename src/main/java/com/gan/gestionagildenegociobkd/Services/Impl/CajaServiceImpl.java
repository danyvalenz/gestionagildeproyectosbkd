package com.gan.gestionagildenegociobkd.Services.Impl;

import com.gan.gestionagildenegociobkd.Services.CajaService;
import com.gan.gestionagildenegociobkd.dto.CajaDTO;
import com.gan.gestionagildenegociobkd.entities.Cajas;
import com.gan.gestionagildenegociobkd.mappers.CajaMapper;
import com.gan.gestionagildenegociobkd.repositories.postgresql.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaServiceImpl implements CajaService {
    @Autowired
    CajaMapper cajaMapper;
    private final CajaRepository cajaRepository;

    public CajaServiceImpl(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    @Override
    public CajaDTO createCaja(CajaDTO cajaDTO) {
        Cajas caja = cajaMapper.cajasDTOtoCaja(cajaDTO);
        return cajaMapper.cajaToCajaDTO(cajaRepository.save(caja));
    }

    @Override
    public List<CajaDTO> findAllCajas() {
        return cajaMapper.cajasListToCajasDTO(cajaRepository.findAll());
    }

}
