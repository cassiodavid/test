package com.cassito.controller.mapper;

import com.cassito.domain.entities.RoboCoordenada;
import main.openapi.openapi.model.RoboCoordenadaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApiControllerMapper {

    ApiControllerMapper INSTANCE = Mappers.getMapper( ApiControllerMapper.class );

    RoboCoordenadaDTO map(RoboCoordenada roboCoordenada);

}
