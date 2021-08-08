package com.meli.quasar.application.usescases;

import com.meli.quasar.domain.SatelliteEnum;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor()
public class UtilUseCase {

    public static boolean isAValidSatellite( String name)
    {
        return Arrays.stream(SatelliteEnum.values())
                .anyMatch(st -> st.getCodename().equalsIgnoreCase(name));
    }

    public static boolean isBlankOrNull(String string){
        return string == null || string.trim().isEmpty();

    }

    public static double[][] getSatillesCoordinates( )
    {

        double[][] coordinates = new double[][] {{SatelliteEnum.KENOBI.getX(), SatelliteEnum.KENOBI.getY()},
                                                {SatelliteEnum.SKYWALKER.getX(), SatelliteEnum.SKYWALKER.getY()},
                                                {SatelliteEnum.SATO.getX(), SatelliteEnum.SATO.getY()}};

        return coordinates;
    }
}
