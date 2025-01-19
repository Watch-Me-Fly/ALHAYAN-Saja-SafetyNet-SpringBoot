package com.safetynet.alertsystem.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsystem.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class JsonReaderService {

    private final ResourceLoader loader;
    private static final Logger LOGGER = Logger.getLogger(JsonReaderService.class.getName());

    @Autowired
    public JsonReaderService(ResourceLoader loader) {
        this.loader = loader;
    }

    public Data readJson(String fileName) {

        ObjectMapper mapper = new ObjectMapper();
        Data data = null;

        try {
            // load json file from ressources
            Resource resource = loader.getResource("classpath:" + fileName);
            LOGGER.log(Level.INFO, "Loading file from : " + resource.getURI());
            // check if resource exists
            if (!resource.exists()) {
                LOGGER.log(Level.SEVERE, "Resource not found: " + fileName);
                return null;
            }
            // read json contents
            data = mapper.readValue(resource.getInputStream(), Data.class);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error reading json file : ", e);
        }
        return data;
    }
}
