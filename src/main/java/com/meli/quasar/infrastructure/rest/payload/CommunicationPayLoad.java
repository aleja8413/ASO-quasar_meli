package com.meli.quasar.infrastructure.rest.payload;

import java.util.List;

import com.meli.quasar.infrastructure.rest.dto.SatelliteDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommunicationPayLoad {
	
	List<SatelliteDto> satellites;

}
