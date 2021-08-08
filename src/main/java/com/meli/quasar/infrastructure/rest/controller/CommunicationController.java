package com.meli.quasar.infrastructure.rest.controller;

import com.meli.quasar.infrastructure.rest.dto.SatelliteDto;
import com.meli.quasar.infrastructure.rest.mapper.CommunicationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meli.quasar.application.services.CommunicationService;
import com.meli.quasar.infrastructure.rest.dto.CommunicationResponse;
import com.meli.quasar.infrastructure.rest.payload.CommunicationPayLoad;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CommunicationController {

	private final CommunicationService communication;

	@PostMapping("/topsecret")
	public ResponseEntity<CommunicationResponse> topsecret(@RequestBody CommunicationPayLoad payLoad) {
		return new ResponseEntity<CommunicationResponse> ( CommunicationMapper.INSTANCE.entityToResponse(
										communication.getTopSecretCommunication(
											CommunicationMapper.INSTANCE.listDtoToEntity(payLoad.getSatellites())
										)
									), HttpStatus.OK

		);
	}

	@PostMapping("/topsecret_split/{satellite_name}")
	public ResponseEntity<String> topsecret_split(@PathVariable String satellite_name, @RequestBody SatelliteDto satelliteDto) {
		satelliteDto.setName(satellite_name);
		return new ResponseEntity<String> (communication.
												createMessage(CommunicationMapper.INSTANCE.dtoToEntity(satelliteDto)),
											HttpStatus.OK
		);
	}

}
