package com.meli.quasar.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Satellites {

    private List<SatelliteCommunication> satellites;
}
