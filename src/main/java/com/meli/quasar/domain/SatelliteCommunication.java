package com.meli.quasar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SatelliteCommunication {

    private String name;
    private float distance;
    private String[] message;
}
