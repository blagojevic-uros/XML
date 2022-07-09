package com.vacc.controller;

import com.vacc.service.InteresovanjeService;
import com.vacc.service.ZahtevService;
import model.interesovanje.Interesovanje;
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
@RequestMapping(path = "/api/zahtev")
public class ZahtevSertifikatController {

    private final ZahtevService zahtevService;
    public ZahtevSertifikatController(ZahtevService zahtevService){
        this.zahtevService = zahtevService;
    }

    @PostMapping("/save")
    @Produces("application/xml")
    public ResponseEntity<String> save(@RequestBody ZahtevZaSertifikat zahtevZaSertifikat) throws Exception {
        try{
            String id = this.zahtevService.save(zahtevZaSertifikat);
            return new ResponseEntity<>("Kreiran dokument zahteva id: " + id, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

}