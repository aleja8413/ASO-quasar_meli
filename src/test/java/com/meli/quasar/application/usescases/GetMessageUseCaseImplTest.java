package com.meli.quasar.application.usescases;

import com.meli.quasar.MockFactory;
import com.meli.quasar.domain.Satellites;
import com.meli.quasar.application.usescases.impl.GetMessageUseCaseImpl;
import com.meli.quasar.domain.exceptions.GetMessageException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetMessageUseCaseImplTest {

    private final GetMessageUseCase getMessageUseCase = new GetMessageUseCaseImpl();


    @Test
    public void GivenReapetingSatellites_ThenReturnMesagge() throws GetMessageException {
        String expected = "este es un mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenReapetingSatellitesEmptyMessageArray_ThenReturnEmpty() throws GetMessageException {

        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites_emptymesagge");
        Assertions.assertThrows(GetMessageException.class, () -> {
            getMessageUseCase.getMessageSatellite(satList.getSatellites());
        });

    }

    @Test
    public void GivenReapetingSatellitesEmptyValuesInMessage_ThenReturnWildCard() throws GetMessageException {

        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites_emptyvaluesmesagge");
        Assertions.assertThrows(GetMessageException.class, () -> {
            getMessageUseCase.getMessageSatellite(satList.getSatellites());
        });

    }

    @Test
    public void GivenSatellitesCompletedMessage_ThenReturnCompletedMessage() throws GetMessageException {
        String expected = "este es un mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_reapeting_satellites_completed_message");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenInvalidSatellite_ThenReturnMessageWithWildCard() throws GetMessageException {
        Satellites satList = MockFactory.getSateliteCommunication("communication_invalid_satellite_wildcard");
        Assertions.assertThrows(GetMessageException.class, () -> {
            getMessageUseCase.getMessageSatellite(satList.getSatellites());
        });

    }

    @Test
    public void GivenCValidSatellite_ThenCompletedMessage() throws GetMessageException {
        String expected = "este es un mensaje secreto";
        Satellites satList = MockFactory.getSateliteCommunication("communication_satellites_completed_message");
        assertThat(getMessageUseCase.getMessageSatellite(satList.getSatellites()), is(expected));

    }

    @Test
    public void GivenAllInvalidSatellites_ThenReturnEmpty() throws GetMessageException {
        Satellites satList = MockFactory.getSateliteCommunication("communication_invalid_satellites");
        Assertions.assertThrows(GetMessageException.class, () -> {
            getMessageUseCase.getMessageSatellite(satList.getSatellites());
        });
    }

    @Test
    public void GivenValidSatellitesWithDiffLenMessage_ThenMessage() throws GetMessageException {
        Satellites satList = MockFactory.getSateliteCommunication("communication_valid_satellites_diff_message_len");
        Assertions.assertThrows(GetMessageException.class, () -> {
            getMessageUseCase.getMessageSatellite(satList.getSatellites());
        });
    }






}
