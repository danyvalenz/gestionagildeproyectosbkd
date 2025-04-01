package com.gan.gestionagildenegociobkd.Services.Impl;

import com.gan.gestionagildenegociobkd.Services.AlmacenService;
import com.gan.gestionagildenegociobkd.dto.AlmacenDTO;
import com.gan.gestionagildenegociobkd.entities.Almacen;
import com.gan.gestionagildenegociobkd.mappers.AlmacenMapper;
import com.gan.gestionagildenegociobkd.repositories.SQLServer.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    private final AlmacenRepository almacenRepository;

    @Autowired
    private AlmacenMapper almacenMapper;



    public AlmacenServiceImpl(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;

    }

    @Override
    public List<AlmacenDTO> findAllAlmacenes() {
        return almacenMapper.almacenesToAlmacenesDTOs(almacenRepository.findAll());
    }

    @Override
    public AlmacenDTO createAlmacen(AlmacenDTO almacenDTO) {
        Almacen almacen = almacenMapper.almacenDTOtoAlmacen(almacenDTO);
        return almacenMapper.almacenToAlmacenDTO(almacenRepository.save(almacen));
    }
}
