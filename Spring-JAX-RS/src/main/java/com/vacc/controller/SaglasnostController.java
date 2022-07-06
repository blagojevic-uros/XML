package com.vacc.controller;

import com.vacc.service.SaglasnostService;
import model.interesovanje.Interesovanje;
import model.saglasnost.LicniPodaci;
import model.saglasnost.SaglasnostZaImunizaciju;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.Produces;

@RestController
@RequestMapping(path = "/api/saglasnost")
public class SaglasnostController {

    private final SaglasnostService saglasnostService;

    public SaglasnostController(SaglasnostService saglasnostService){
        this.saglasnostService = saglasnostService;
    }

    @PostMapping("/save")
    @Produces("application/xml")
    public ResponseEntity<String> save(@RequestBody LicniPodaci saglasnost) throws Exception {
        try{
            this.saglasnostService.save(saglasnost);
            return new ResponseEntity<>("Kreirani licni podaci za saglasnost", HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
