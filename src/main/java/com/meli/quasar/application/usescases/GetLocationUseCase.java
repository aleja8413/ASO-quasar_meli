package com.meli.quasar.application.usescases;

import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.domain.exceptions.GetLocationException;

import java.util.List;

public interface GetLocationUseCase {

    public double[] getShipPosition(List<SatelliteCommunication> satellites) throws GetLocationException;
}