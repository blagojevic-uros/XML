package com.vacc.controller;

import com.vacc.service.ImunizacijaService;
import model.interesovanje.Interesovanje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(path = "/api/imunizacija")
public class ImunizacijaController {

    private final ImunizacijaService imunizacijaService;

    public ImunizacijaController(ImunizacijaService imunizacijaService){
        this.imunizacijaService = imunizacijaService;
    }

//    @PostMapping("/save")
//    @Produces("application/xml")
//    public ResponseEntity<String> save(@RequestBody Interesovanje interesovanje) throws Exception {
//        try{
//            String id = this.interesovanjeService.save(interesovanje);
//            return new ResponseEntity<>("Kreiran dokument interesovanja id: " + id, HttpStatus.OK);
//        }
//        catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//        }
//
//    }
//    @GetMapping("/all")
//    @Produces("application/xml")
//    public ResponseEntity<List<String>> getAll() throws Exception {
//        try{
//            return new ResponseEntity<>(this.interesovanjeService.getAll(), HttpStatus.OK);
//        }
//        catch (Exception e){
//            throw new Exception();
//        }
//    }

}
