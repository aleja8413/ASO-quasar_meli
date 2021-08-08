package com.meli.quasar.application.services;

import com.meli.quasar.domain.Communication;
import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.application.usescases.CreateSatelliteCommunicationUseCase;
import com.meli.quasar.application.usescases.GetLocationUseCase;
import com.meli.quasar.application.usescases.GetMessageUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommunicationService {

    private final GetMessageUseCase getMessageUseCase;
    private final GetLocationUseCase getLocationUseCase;

    private final CreateSatelliteCommunicationUseCase createCommunicationUseCase;


    public Communication getTopSecretCommunication(List<SatelliteCommunication> satellites){
        Communication communication = new Communication();
        communication.setMessage(getMessageUseCase.getMessageSatellite(satellites));
        double[] location = getLocationUseCase.getPositionFromShip(satellites);

        communication.getPosition().setCoordinates(location);

        return communication;
    }

    public String createMessage(SatelliteCommunication satellite){
          return createCommunicationUseCase.createCommunication(satellite);
    }



}
