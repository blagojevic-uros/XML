package com.vacc.controller;

import com.vacc.service.ZahtevService;
import model.zahtev.ZahtevZaSertifikat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(path = "/zahtev")
public class ZahtevSertifikatController {

    private final RestTemplate restTemplate;
    private final ZahtevService zahtevService;
    public ZahtevSertifikatController(RestTemplate restTemplate, ZahtevService zahtevService){
        this.restTemplate = restTemplate;
        this.zahtevService = zahtevService;
    }

    @GetMapping("/pending/{jmbg}")
    @Produces("application/xml")
    public ResponseEntity<?> save(@PathVariable String jmbg) throws Exception {
        List<ZahtevZaSertifikat> zahtevi = restTemplate.getForObject(
                "http://localhost:9090/api/zahtev/pending/"+ jmbg, List.class);
        return new ResponseEntity<>(zahtevi, HttpStatus.OK);

    }
    @GetMapping("/decline/{id}/{reason}")
    @Produces("application/xml")
    public ResponseEntity<?> declineZahtev(@PathVariable String id,@PathVariable String reason) throws Exception {
        String response = restTemplate.getForObject(
                "http://localhost:9090/api/zahtev/decline/"+ id + "/" + reason, String.class);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("/accept/{id}")
    @Produces("application/xml")
    public ResponseEntity<?> acceptZahtev(@PathVariable String id) throws Exception {
        String response = restTemplate.getForObject(
                "http://localhost:9090/api/zahtev/accept/"+ id, String.class);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}