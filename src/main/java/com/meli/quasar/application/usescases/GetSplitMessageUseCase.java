package com.meli.quasar.application.usescases;

import com.meli.quasar.domain.SatelliteCommunication;

import java.util.List;

public interface GetSplitMessageUseCase {

    public List<SatelliteCommunication> getMessageCommunication();
}
