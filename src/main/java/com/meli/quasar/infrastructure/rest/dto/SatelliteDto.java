package com.meli.quasar.infrastructure.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SatelliteDto {
	
	private String name;
	private float distance;
	private String[] message;

}
