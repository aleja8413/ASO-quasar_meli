package com.meli.quasar.application.usescases.impl;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.meli.quasar.application.usescases.GetLocationUseCase;
import com.meli.quasar.application.usescases.UtilUseCase;
import com.meli.quasar.domain.SatelliteCommunication;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GetLocationUseCaseImpl implements GetLocationUseCase {

    public double[] getPositionFromShip(List<SatelliteCommunication> satellites){

        double[] distances = satellites.stream().mapToDouble(m -> m.getDistance()).toArray();
        double[] location = this.getLocation(distances);

        return location;

    }

    private double[] getLocation(double[] distances){

        NonLinearLeastSquaresSolver squareSolver = new NonLinearLeastSquaresSolver(
                new TrilaterationFunction(UtilUseCase.getSatillesCoordinates(), distances),
                new LevenbergMarquardtOptimizer()
        );

        return squareSolver.solve().getPoint().toArray();

    }

  }
