package com.safetynet.alertsystem.controller;

import com.safetynet.alertsystem.model.*;
import com.safetynet.alertsystem.service.JsonReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JsonController {

    private final JsonReaderService service;

    @Autowired
    public JsonController(JsonReaderService service) {
        this.service = service;
    }

    @GetMapping("/data")
    public Data getData() {
        Data data = service.readJson("data.json");
        if (data == null) {
            throw new RuntimeException("Failed to read data");
        }
        return data;
    }
    @GetMapping("/persons")
    public List<Person> getPersons() {
        Data data = service.readJson("data.json");
        return data != null ? data.getPersons() : null;
    }

    @GetMapping("/firestations")
    public List<FireStation> getFireStations() {
        Data data = service.readJson("data.json");
        return data != null ? data.getFirestations() : null;
    }

    @GetMapping("/medicalrecords")
    public List<MedicalRecord> getMedicalRecords() {
        Data data = service.readJson("data.json");
        return data != null ? data.getMedicalrecords() : null;
    }
}
