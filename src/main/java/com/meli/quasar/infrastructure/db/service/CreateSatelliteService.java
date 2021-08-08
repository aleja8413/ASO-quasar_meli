package com.meli.quasar.infrastructure.db.service;


import com.meli.quasar.application.usescases.UtilUseCase;
import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.application.usescases.CreateSatelliteCommunicationUseCase;
import com.meli.quasar.infrastructure.db.mapper.CreateSatelliteMessageMapper;
import com.meli.quasar.infrastructure.db.repository.CreateSatelliteMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSatelliteService implements CreateSatelliteCommunicationUseCase {

    private final CreateSatelliteMessageRepository repository;

    @Override
    public String createCommunication(SatelliteCommunication sat) {
        if( UtilUseCase.isAValidSatellite( sat.getName())) {
            repository.save(CreateSatelliteMessageMapper.INSTANCE.domainEntityToDboEntity(sat));
            return "Message persisted";
        }else{
            return "Not is a valid satellite";
        }
    }
}
