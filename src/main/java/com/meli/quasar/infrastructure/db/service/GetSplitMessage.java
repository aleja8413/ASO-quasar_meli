package com.meli.quasar.infrastructure.db.service;

import com.meli.quasar.application.usescases.CreateSatelliteCommunicationUseCase;
import com.meli.quasar.application.usescases.GetSplitMessageUseCase;
import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.infrastructure.db.mapper.CreateSatelliteMessageMapper;
import com.meli.quasar.infrastructure.db.repository.CreateSatelliteMessageRepository;
import com.meli.quasar.infrastructure.db.repository.GetSplitMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetSplitMessage implements GetSplitMessageUseCase {

    private final GetSplitMessageRepository repository;

    @Override
    public List<SatelliteCommunication> getMessageCommunication() {
        return  CreateSatelliteMessageMapper.INSTANCE.dboToEntityList(repository.findAll());
    }
}
