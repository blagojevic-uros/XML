package com.vacc.controller;

import com.vacc.service.PotvrdaService;
import com.vacc.service.ZahtevService;
import model.potvrda.PotvrdaOVakcinaciji;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = "/generisiXhtml/{id}", produces = MediaType.TEXT_HTML_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_GRADJANIN', 'ROLE_SLUZBENIK')")
    public ResponseEntity<InputStreamResource> generisiXHTML(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new InputStreamResource(potvrdaService.generisiXHTML(id)), HttpStatus.OK);
    }

    @GetMapping(value = "/generisiPdf/{jmbg}/{brojDoze}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> generisiPdf(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new InputStreamResource(potvrdaService.generisiPdf(id)), HttpStatus.OK);
    }
}
