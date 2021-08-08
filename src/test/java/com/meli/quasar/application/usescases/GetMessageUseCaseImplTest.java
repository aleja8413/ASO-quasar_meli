package com.meli.quasar.application.usescases;

import com.meli.quasar.MockFactory;
import com.meli.quasar.domain.Satellites;
import com.meli.quasar.application.usescases.impl.GetMessageUseCaseImpl;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GetMessageUseCaseImplTest {

    private final GetMessageUseCase getMessageUseCase = new GetMessageUseCaseImpl();


    @Test
    public void GivenReapetingSatellites_ThenReturnMesagge(){
        String expected = "este es un mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenReapetingSatellitesEmptyMessageArray_ThenReturnEmpty(){
        String expected = "";
        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites_emptymesagge");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenReapetingSatellitesEmptyValuesInMessage_ThenReturnWildCard(){
        String expected = "{0}";
        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites_emptyvaluesmesagge");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenSatellitesCompletedMessage_ThenReturnCompletedMessage(){
        String expected = "este es un mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites_completed_message");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenInvalidSatellite_ThenReturnMessageWithWildCard(){
        String expected = "este es un mensaje {0}";
        Satellites satList = MockFactory.getSateliteCommunication("communication_invalid_satellite_wildcard");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenCValidSatellite_ThenCompletedMessage(){
        String expected = "este es un mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_satellites_completed_message");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenAllInvalidSatellites_ThenReturnEmpty(){
        String expected = "";
        Satellites satList = MockFactory.getSateliteCommunication("communication_invalid_satellites");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));
    }

    @Test
    public void GivenValidSatellitesWithDiffLenMessage_ThenMessage(){
        String expected = "este es {0} mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_valid_satellites_diff_message_len");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));
    }






}
