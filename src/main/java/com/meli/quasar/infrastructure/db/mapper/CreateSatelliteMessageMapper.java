package com.meli.quasar.infrastructure.db.mapper;

import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.infrastructure.db.entity.SatelliteDboEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreateSatelliteMessageMapper {

    CreateSatelliteMessageMapper INSTANCE = Mappers.getMapper(CreateSatelliteMessageMapper.class);

    List<SatelliteCommunication> dboToEntityList (List<SatelliteDboEntity> dbo);
    SatelliteCommunication dboToEntity(SatelliteDboEntity dbo);
    SatelliteDboEntity domainEntityToDboEntity(SatelliteCommunication domainEntity);
}
