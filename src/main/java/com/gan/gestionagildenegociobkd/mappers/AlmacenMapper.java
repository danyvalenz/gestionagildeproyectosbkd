package com.gan.gestionagildenegociobkd.mappers;

import com.gan.gestionagildenegociobkd.dto.AlmacenDTO;
import com.gan.gestionagildenegociobkd.entities.Almacen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring")
public interface AlmacenMapper {



    AlmacenMapper INSTANCE = Mappers.getMapper(AlmacenMapper.class);

    AlmacenDTO almacenToAlmacenDTO(Almacen almacen);
    List<AlmacenDTO> almacenesToAlmacenesDTOs(List<Almacen> almacenes);

    Almacen almacenDTOtoAlmacen(AlmacenDTO almacenDTO);

}
