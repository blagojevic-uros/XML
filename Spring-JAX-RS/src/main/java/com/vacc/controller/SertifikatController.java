package com.vacc.controller;

import com.vacc.service.SertifikatService;
import model.korisnik.Korisnik;
import model.sertifikat.ZeleniSertifikat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/sertifikat")
public class SertifikatController {

    private final SertifikatService sertifikatService;

    public SertifikatController(SertifikatService sertifikatService) {
        this.sertifikatService = sertifikatService;
    }

    @PostMapping("/save")
    public void save(@RequestBody ZeleniSertifikat sertifikat){

        sertifikatService.save(sertifikat);

    }
    @GetMapping("/all/{jmbg}")
    public ResponseEntity<?> getAllJmbg(@PathVariable String jmbg){
        return new ResponseEntity<>(sertifikatService.getAllJmbg(jmbg), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllJmbg(Authentication authentication){
        Korisnik k = (Korisnik) authentication.getPrincipal();
        return new ResponseEntity<>(sertifikatService.getAllJmbg(k.getJmbg()), HttpStatus.OK);
    }
}
