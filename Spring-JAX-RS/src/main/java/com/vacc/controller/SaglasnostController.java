package com.vacc.controller;

import com.vacc.service.SaglasnostService;
import model.interesovanje.Interesovanje;
import model.saglasnost.Drzavljanstvo;
import model.saglasnost.LicniPodaci;
import model.saglasnost.SaglasnostZaImunizaciju;
import model.saglasnost.Srpsko;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> save(@RequestBody SaglasnostZaImunizaciju saglasnost) throws Exception {
        try{
            this.saglasnostService.save(saglasnost);
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
            return new ResponseEntity<>(this.saglasnostService.getByJmbgOrPassportNumber(jmbg), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping("/test")
    @Produces("application/xml")
    public ResponseEntity<String> save() throws Exception {
        SaglasnostZaImunizaciju saglasnostZaImunizaciju = new SaglasnostZaImunizaciju();
        LicniPodaci licniPodaci = new LicniPodaci();
        Drzavljanstvo drzavljanstvo = new Drzavljanstvo();
        Srpsko.JMBG jmbg = new Srpsko.JMBG();
        jmbg.setValue("1707999850111");
        Srpsko srpsko = new Srpsko();
        srpsko.setJMBG(jmbg);
        drzavljanstvo.setSrpsko(srpsko);

        licniPodaci.setEmail("email@email");
        licniPodaci.setDrzavljanstvo(drzavljanstvo);
        saglasnostZaImunizaciju.setLicniPodaci(licniPodaci);
        this.saglasnostService.save(saglasnostZaImunizaciju);
        return null;
    }
}
