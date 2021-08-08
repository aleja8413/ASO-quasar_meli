package com.meli.quasar.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SatelliteEnum {

    KENOBI("kenobi",-500,-200),
    SKYWALKER("skywalker",100,-100),
    SATO("sato",500,100);

    private String codename;
    private double x;
    private double y;

}
