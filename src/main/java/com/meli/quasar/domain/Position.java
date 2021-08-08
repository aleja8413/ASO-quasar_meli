package com.meli.quasar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Position {

    private double x;
    private double y;

    public void setCoordinates(double[] location){
        this.x = location[0];
        this.y = location[1];
    }

}
