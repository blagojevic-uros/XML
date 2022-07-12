package com.vacc.controller;


import com.vacc.service.PorudzbinaService;
import model.vakcine.Vakcina;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;
import java.util.List;

@RestController
@RequestMapping(path ="/vakcine")
public class VakcineController {

    private final RestTemplate restTemplate;

    private final PorudzbinaService porudzbinaService;
    public VakcineController(RestTemplate restTemplate, PorudzbinaService porudzbinaService) {
        this.restTemplate = restTemplate;
        this.porudzbinaService = porudzbinaService;
    }

    @GetMapping("/all")
    @Produces("application/xml")
    public ResponseEntity<?> getAllVakcine() {
        List<Vakcina> vakcine = restTemplate.getForObject(
                "http://localhost:9090/api/vakcine/all", List.class);
        return new ResponseEntity<>(vakcine, HttpStatus.OK);
    }

    @GetMapping("/porudzbine")
    @Produces("application/xml")
    public ResponseEntity<?> getAllPorudzbine() throws XMLDBException, JAXBException {
        return new ResponseEntity<>(porudzbinaService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/porudzbine/pending")
    @Produces("application/xml")
    public ResponseEntity<?> getAllPorudzbinePending() throws XMLDBException, JAXBException {
        return new ResponseEntity<>(porudzbinaService.getAllPending(), HttpStatus.OK);
    }

    @GetMapping("/porudzbine/finish/{id}")
    @Produces("application/xml")
    public ResponseEntity<?> finishPorudzbinaPending(@PathVariable String id) throws XMLDBException, JAXBException {
        porudzbinaService.finishPorudzbina(id);
        return new ResponseEntity<>("Porudzbina updated",HttpStatus.OK);
    }

    @GetMapping("/update/kolicina/{naziv}/{kolicina}")
    @Produces("application/xml")
    public ResponseEntity<?> updateKolicina(@PathVariable String naziv,@PathVariable Integer kolicina) throws XMLDBException, JAXBException {
        String response = restTemplate.getForObject(
                "http://localhost:9090/api/vakcine/update/"+ naziv + "/" + kolicina, String.class);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
