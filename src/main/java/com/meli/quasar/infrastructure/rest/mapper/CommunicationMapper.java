package com.meli.quasar.infrastructure.rest.mapper;

import com.meli.quasar.domain.Communication;
import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.infrastructure.rest.dto.CommunicationResponse;
import com.meli.quasar.infrastructure.rest.dto.SatelliteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommunicationMapper {
    CommunicationMapper INSTANCE = Mappers.getMapper(CommunicationMapper.class);

    List<SatelliteCommunication> listDtoToEntity(List<SatelliteDto> satelliteDtoList);

    SatelliteCommunication dtoToEntity(SatelliteDto satelliteDto);

    CommunicationResponse entityToResponse(Communication communication);


}
