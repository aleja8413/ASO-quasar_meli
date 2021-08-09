package com.meli.quasar.infrastructure.rest.controller;

import com.meli.quasar.domain.exceptions.GetLocationException;
import com.meli.quasar.domain.exceptions.GetMessageException;
import com.meli.quasar.infrastructure.rest.dto.SatelliteDto;
import com.meli.quasar.infrastructure.rest.mapper.CommunicationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.meli.quasar.application.services.CommunicationService;
import com.meli.quasar.infrastructure.rest.dto.CommunicationResponse;
import com.meli.quasar.infrastructure.rest.payload.CommunicationPayLoad;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class CommunicationController {

	private final CommunicationService communication;

	@PostMapping("/topsecret")
	public ResponseEntity<CommunicationResponse> topsecret(@RequestBody CommunicationPayLoad payLoad) throws GetLocationException, GetMessageException {
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

	@GetMapping("/topsecret_split")
	public ResponseEntity<CommunicationResponse> topsecret_split_mesagge() throws GetMessageException, GetLocationException {
		return new ResponseEntity<CommunicationResponse> (CommunicationMapper.INSTANCE.entityToResponse(
				communication.getSplitMessages()),
				HttpStatus.OK
		);
	}

}
