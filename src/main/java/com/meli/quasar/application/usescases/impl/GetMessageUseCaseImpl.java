package com.meli.quasar.application.usescases.impl;

import com.meli.quasar.domain.SatelliteCommunication;
import com.meli.quasar.application.usescases.GetMessageUseCase;
import com.meli.quasar.application.usescases.UtilUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

@Component
@Slf4j
public class GetMessageUseCaseImpl implements GetMessageUseCase{

	@Override
	public String getMessageSatellite(List<SatelliteCommunication> satelliteCommunicationList) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String msg ="";
		if(satelliteCommunicationList != null) {
			for (SatelliteCommunication sat : satelliteCommunicationList) {
				if (UtilUseCase.isAValidSatellite(sat.getName())) {
					if(sat.getMessage() != null) {
						if (map.containsKey(sat.getName())) {

							map.put(sat.getName(),
									this.getCleanMessagesSatellite(map.get(sat.getName()),
											Arrays.asList(sat.getMessage())));
						} else {
							map.put(sat.getName(), Arrays.asList(sat.getMessage()));

						}
					}else{
						log.trace("The satellite " +sat.getName() +" does not have messages") ;
					}
				} else {
					log.trace("Satellite is not valid");
				}
			}
			if (map.size() > 0) {
				msg = this.getMessage(map.values().stream()
						.map(m -> m.toArray(String[]::new))
						.collect(Collectors.toList()));
			}
		}

		return msg;
	}

	private String getMessage(List<String[]> messages){
		int maxIndex = messages.stream().max(comparing(el -> el.length)).get().length;

		List<String> message = new ArrayList<String>(1);

		for (int i = 0; i < maxIndex; i++) {
			message.add(i,new String(""));
			for (String[] str: messages) {
				if (i < str.length) {
					if(UtilUseCase.isBlankOrNull(message.get(i))){
						if(!UtilUseCase.isBlankOrNull(str[i])){
							message.set(i,str[i]);
						}
					}

				}
			}
			if(UtilUseCase.isBlankOrNull(message.get(i))) {
				message.set(i,"{0}");
			}
		}

		return message.stream().collect(Collectors.joining(" "));
	}

	private List<String> getCleanMessagesSatellite(List<String> origin, List<String> source){
		int index;
		if(origin.equals(source)){
			return origin;
		}else if(origin.size() >= source.size()){
			index = 0;
			for (String el: source) {
				if(UtilUseCase.isBlankOrNull(origin.get(index))
						&&
						!UtilUseCase.isBlankOrNull(el)
				) {
					origin.set(index, el);
				}
				index ++;
			}
			return origin;
		}else{
			index = 0;

			for (String el: origin) {
				if(UtilUseCase.isBlankOrNull(el)
						&&
						!UtilUseCase.isBlankOrNull(source.get(index))
				) {
					origin.set(index, source.get(index));
				}
				index ++;
			}
			origin = Stream.concat(origin.stream(), source.subList(index,source.size()).stream()).parallel()
					.collect(Collectors.toList());

			return origin;
		}

	}
}
