package com.meli.quasar.application.usescases;

import com.meli.quasar.domain.SatelliteCommunication;

import java.util.List;

public interface GetLocationUseCase {

    public double[] getPositionFromShip(List<SatelliteCommunication> satellites);
}