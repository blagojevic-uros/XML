package com.vacc.controller;

import com.vacc.service.PotvrdaService;
import com.vacc.service.ZahtevService;
import model.potvrda.PotvrdaOVakcinaciji;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.Produces;

@RestController
@RequestMapping(path = "/api/potvrda")
public class PotvrdaController {

    private final PotvrdaService potvrdaService;

    public PotvrdaController(PotvrdaService potvrdaService){
        this.potvrdaService = potvrdaService;
    }

    @PostMapping("/save")
    @Produces("application/xml")
    public ResponseEntity<String> save(@RequestBody PotvrdaOVakcinaciji potvrdaOVakcinaciji) throws Exception {
        try{
            String id = this.potvrdaService.save(potvrdaOVakcinaciji);
            return new ResponseEntity<>("Kreiran dokument potvrde id: " + id, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

}
