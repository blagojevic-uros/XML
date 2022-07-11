package com.vacc.controller;

import com.vacc.service.SertifikatService;
import model.korisnik.Korisnik;
import model.sertifikat.ZeleniSertifikat;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/sertifikat")
public class SertifikatController {

    private final SertifikatService sertifikatService;

    public SertifikatController(SertifikatService sertifikatService) {
        this.sertifikatService = sertifikatService;
    }

    @PostMapping("/save")
    public void save(@RequestBody ZeleniSertifikat sertifikat) throws Exception {

        sertifikatService.save(sertifikat);

    }
    @GetMapping("/all/{jmbg}")
    public ResponseEntity<?> getAllJmbg(@PathVariable String jmbg){
        return new ResponseEntity<>(sertifikatService.getAllJmbg(jmbg), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ZeleniSertifikat>> getAllJmbg(Authentication authentication){
        Korisnik k = (Korisnik) authentication.getPrincipal();
        return new ResponseEntity<>(sertifikatService.getAllJmbg(k.getJmbg()), HttpStatus.OK);
    }

    @GetMapping(value = "/generisiXhtml/{id}", produces = MediaType.TEXT_HTML_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_GRADJANIN', 'ROLE_SLUZBENIK')")
    public ResponseEntity<InputStreamResource> generisiXHTML(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new InputStreamResource(sertifikatService.generisiXHTML(id)), HttpStatus.OK);
    }

    @GetMapping(value = "/generisiPdf/{id}", produces = MediaType.TEXT_HTML_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_GRADJANIN', 'ROLE_SLUZBENIK')")
    public ResponseEntity<InputStreamResource> generisiPdf(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(new InputStreamResource(sertifikatService.generisiPdf(id)), HttpStatus.OK);
    }
}
