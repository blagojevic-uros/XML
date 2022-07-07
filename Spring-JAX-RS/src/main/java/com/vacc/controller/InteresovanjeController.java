package com.vacc.controller;


import com.vacc.service.InteresovanjeService;
import model.interesovanje.Interesovanje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.Produces;
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
    public ResponseEntity<List<String>> getAll() throws Exception {
        try{
            return new ResponseEntity<>(this.interesovanjeService.getAll(), HttpStatus.OK);
        }
        catch (Exception e){
            throw new Exception();
        }
    }
    @GetMapping("/{id}")
    @Produces("application/xml")
    public ResponseEntity<String> getOne(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<>(this.interesovanjeService.getById(id), HttpStatus.OK);
    }
    @GetMapping("/object/{id}")
    @Produces("application/xml")
    public ResponseEntity<Interesovanje> getOneObject(@PathVariable("id") String id) throws Exception{
        return new ResponseEntity<>(this.interesovanjeService.getByIdObject(id), HttpStatus.OK);
    }

    @GetMapping("/all/{jmbg}")
    @Produces("application/xml")
    public ResponseEntity<List<Interesovanje>> getAllJMBG(@PathVariable("jmbg") String jmbg) throws XMLDBException {
        return new ResponseEntity<>(this.interesovanjeService.getAllJMBG(jmbg),HttpStatus.OK);
    }
}
