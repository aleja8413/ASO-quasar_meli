package com.meli.quasar.application.services;

import com.meli.quasar.application.usescases.GetSplitMessageUseCase;
import com.meli.quasar.domain.Communication;
import com.meli.quasar.domain.Position;
import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.application.usescases.CreateSatelliteCommunicationUseCase;
import com.meli.quasar.application.usescases.GetLocationUseCase;
import com.meli.quasar.application.usescases.GetMessageUseCase;
import com.meli.quasar.domain.exceptions.GetLocationException;
import com.meli.quasar.domain.exceptions.GetMessageException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommunicationService {

    private final GetMessageUseCase getMessageUseCase;
    private final GetLocationUseCase getLocationUseCase;

    private final CreateSatelliteCommunicationUseCase createCommunicationUseCase;
    private final GetSplitMessageUseCase splitMessageUseCase;


    public Communication getTopSecretCommunication(List<SatelliteCommunication> satellites) throws GetLocationException, GetMessageException {
        Communication communication = new Communication();
        communication.setMessage(getMessageUseCase.getMessageSatellite(satellites));
        communication.setPosition(new Position());
        communication.getPosition().setCoordinates(getLocationUseCase.getShipPosition(satellites));
        return communication;
    }

    public String createMessage(SatelliteCommunication satellite){
          return createCommunicationUseCase.createCommunication(satellite);
    }

    public Communication getSplitMessages() throws GetMessageException, GetLocationException {
         List<SatelliteCommunication> satList =  splitMessageUseCase.getMessageCommunication();
         return this.getTopSecretCommunication(satList);
    }



}
