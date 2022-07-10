package com.vacc.controller;


import com.vacc.service.InteresovanjeService;
import model.interesovanje.Interesovanje;
import model.korisnik.Korisnik;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/interesovanje")
public class InteresovanjeController {

    private final InteresovanjeService interesovanjeService;

    public InteresovanjeController(InteresovanjeService interesovanjeService){
        this.interesovanjeService = interesovanjeService;
    }

    @PostMapping("/save")
    @Produces("application/xml")
    public ResponseEntity<String> save(@RequestBody Interesovanje interesovanje) throws Exception {
        try{
            String id = this.interesovanjeService.save(interesovanje);
            return new ResponseEntity<>("Kreiran dokument interesovanja id: " + id, HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
    @GetMapping("/all")
    @Produces("application/xml")
    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    public ResponseEntity<List<String>> getAll() throws Exception {
        try{
            return new ResponseEntity<>(this.interesovanjeService.getAll(), HttpStatus.OK);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    @GetMapping("/{start}/{end}")
    @Produces("application/xml")
    public ResponseEntity<?> getCountInRange(@PathVariable("start") String start, @PathVariable("end") String end) throws ParseException {
        return new ResponseEntity<>(this.interesovanjeService.getCountInRange(start,end),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Produces("application/xml")
    public ResponseEntity<String> getOne(@PathVariable("id") String id) throws Exception {
        try{
            return new ResponseEntity<>(this.interesovanjeService.getById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/object/{id}")
    @Produces("application/xml")
    public ResponseEntity<Interesovanje> getOneObject(@PathVariable("id") String id) throws Exception{
        return new ResponseEntity<>(this.interesovanjeService.getByIdObject(id), HttpStatus.OK);
    }

    @GetMapping("/jmbg")
    @Produces("application/xml")
    @PreAuthorize("hasRole('ROLE_PACIJENT')")
    public ResponseEntity<?> getAllJMBG(Authentication authentication) throws XMLDBException {
        Korisnik k = (Korisnik) authentication.getPrincipal();
        return new ResponseEntity<>(this.interesovanjeService.getAllJMBG(k.getJmbg()),HttpStatus.OK);
    }




}
