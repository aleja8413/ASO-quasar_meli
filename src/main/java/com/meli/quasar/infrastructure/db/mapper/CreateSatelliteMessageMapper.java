package com.meli.quasar.infrastructure.db.mapper;

import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.infrastructure.db.entity.SatelliteDboEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateSatelliteMessageMapper {

    CreateSatelliteMessageMapper INSTANCE = Mappers.getMapper(CreateSatelliteMessageMapper.class);

    SatelliteCommunication dboToEntity(SatelliteDboEntity dbo);
    SatelliteDboEntity domainEntityToDboEntity(SatelliteCommunication domainEntity);
}
