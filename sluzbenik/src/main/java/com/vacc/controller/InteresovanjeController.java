package com.vacc.controller;


import com.vacc.service.InteresovanjeService;
import model.interesovanje.Interesovanje;
import model.korisnik.Korisnik;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(path = "/api/interesovanje")
public class InteresovanjeController {

    private final InteresovanjeService interesovanjeService;

    private final RestTemplate restTemplate;
    public InteresovanjeController(InteresovanjeService interesovanjeService, RestTemplate restTemplate){
        this.interesovanjeService = interesovanjeService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get/{jmbg}")
    @Produces("application/xml")
    public ResponseEntity<?> test(@PathVariable String jmbg) throws Exception {
        List<Interesovanje> interesovanjes = restTemplate.getForObject(
                "http://localhost:9090/api/interesovanje/jmbg/" + jmbg, List.class);
        return new ResponseEntity<>(interesovanjes.get(0), HttpStatus.OK);

    }
}
