package com.gan.gestionagildenegociobkd.mappers;


import com.gan.gestionagildenegociobkd.dto.CajaDTO;
import com.gan.gestionagildenegociobkd.entities.Cajas;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CajaMapper {

    CajaMapper INSTANCE = Mappers.getMapper(CajaMapper.class);
    Cajas cajasDTOtoCaja(CajaDTO cajaDTO);
    CajaDTO cajaToCajaDTO(Cajas caja);
    List<CajaDTO> cajasListToCajasDTO(List<Cajas> cajaslist);
}
