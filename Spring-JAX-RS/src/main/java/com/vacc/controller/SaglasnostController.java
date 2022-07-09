package com.vacc.controller;

import com.vacc.service.SaglasnostService;
import model.interesovanje.Interesovanje;
import model.korisnik.Korisnik;
import model.saglasnost.Drzavljanstvo;
import model.saglasnost.LicniPodaci;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.saglasnost.Srpsko;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> save(@RequestBody SaglasnostZaImunizaciju saglasnost, Authentication auth) throws Exception {
        try{
            Korisnik k = (Korisnik)auth.getPrincipal();
            this.saglasnostService.save(saglasnost,k.getJmbg());
            return new ResponseEntity<>("Kreirani licni podaci za saglasnost", HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/imunizacija")
    @Produces("application/xml")
    public ResponseEntity<?> getSaglasnostForUpdate(@RequestParam("jmbg") String jmbg){
        try{
            return new ResponseEntity<>(this.saglasnostService.getByIdObject(jmbg), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
