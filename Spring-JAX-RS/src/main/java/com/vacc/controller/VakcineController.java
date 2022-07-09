package com.vacc.controller;

import com.vacc.service.VakcineService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;

import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;

@RestController
@RequestMapping(path = "/api/vakcine")
public class VakcineController {
    private final VakcineService vakcineService;


    public VakcineController(VakcineService vakcineService) {
        this.vakcineService = vakcineService;
    }
    @GetMapping("/all")
    @Produces("application/xml")
    public ResponseEntity<?> getAllVakcine() throws XMLDBException, JAXBException {
        return new ResponseEntity<>(vakcineService.getAll(), HttpStatus.OK);
    }


}
