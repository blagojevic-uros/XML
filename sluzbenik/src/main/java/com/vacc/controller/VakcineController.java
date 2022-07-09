package com.vacc.controller;


import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(path ="/vakcine")
public class VakcineController {

    private final RestTemplate restTemplate;

    public VakcineController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/all")
    @Produces("application/xml")
    public ResponseEntity<?> getAllVakcine() {
        List<String> vakcine = restTemplate.getForObject(
                "http://localhost:9090/api/vakcine/all", List.class);
        return new ResponseEntity<>(vakcine, HttpStatus.OK);
    }
}
