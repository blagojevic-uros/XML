package com.vacc.controller;

import com.vacc.service.InteresovanjeService;
import com.vacc.service.ZahtevService;
import model.interesovanje.Interesovanje;
import model.korisnik.Korisnik;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;
import java.text.ParseException;

@RestController
@RequestMapping(path = "/api/zahtev")
public class ZahtevSertifikatController {

    private final ZahtevService zahtevService;
    public ZahtevSertifikatController(ZahtevService zahtevService){
        this.zahtevService = zahtevService;
    }

    @PostMapping("/save")
    @Produces("application/xml")
    public ResponseEntity<String> save(@RequestBody ZahtevZaSertifikat zahtevZaSertifikat, Authentication authentication) throws Exception {
        try{
            String id = this.zahtevService.save(zahtevZaSertifikat,zahtevZaSertifikat.getLicniPodaci().getJMBG().toString());
            return new ResponseEntity<>("Kreiran dokument zahteva id: " + id, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @GetMapping("/{start}/{end}")
    @Produces("application/xml")
    public ResponseEntity<?> getCountInRange(@PathVariable("start") String start, @PathVariable("end") String end) throws ParseException {
        return new ResponseEntity<>(this.zahtevService.getCountInRange(start,end),HttpStatus.OK);
    }
    @GetMapping("/decline/{id}/{reason}")
    public ResponseEntity<?> declineZahtev(@PathVariable String id,@PathVariable String reason) throws Exception {
        this.zahtevService.declineZahtev(id,"DECLINED",reason);
        return new ResponseEntity<>("Declined Zahtev with id : " + id, HttpStatus.OK);
    }
    @GetMapping("/accept/{id}")
    public ResponseEntity<?> acceptZahtev(@PathVariable String id) throws Exception {
        this.zahtevService.updateStatus(id,"ACCEPTED");
        return new ResponseEntity<>("Accepted Zahtev with id : " + id, HttpStatus.OK);
    }
    @GetMapping("/pending/{jmbg}")
    public ResponseEntity<?> getAllPendingJmbg(@PathVariable String jmbg){
        return new ResponseEntity<>(this.zahtevService.getAllPendingUserZahtevi(jmbg),HttpStatus.OK);
    }

    @GetMapping(value = "/generisiXhtml/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> generisiXHTML(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new InputStreamResource(zahtevService.generisiXHTML(id)), HttpStatus.OK);
    }

    @GetMapping(value = "/generisiPdf/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<InputStreamResource> generisiPdf(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new InputStreamResource(zahtevService.generisiPdf(id)), HttpStatus.OK);
    }
}