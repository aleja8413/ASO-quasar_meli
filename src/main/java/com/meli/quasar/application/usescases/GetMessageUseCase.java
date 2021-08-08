package com.meli.quasar.application.usescases;

import com.meli.quasar.domain.SatelliteCommunication;

import java.util.List;

public interface GetMessageUseCase {
	
	public String getMessageSatellite(List<SatelliteCommunication> satelliteCommunicationList);
}
