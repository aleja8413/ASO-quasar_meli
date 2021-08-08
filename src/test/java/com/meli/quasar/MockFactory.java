package com.meli.quasar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.quasar.domain.Satellites;

import java.io.File;
import java.io.IOException;


public class MockFactory {


    private MockFactory(){};

    public static Satellites getSateliteCommunication(String fileName) {
        return readJson("usescases/message/"+fileName+".json");
    }

    private static Satellites readJson(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return  mapper.readValue(new File("src/test/resources/" + fileName), Satellites.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
