package com.vacc.controller;

import com.vacc.service.ImunizacijaService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/imunizacija")
public class ImunizacijaController {

    private final ImunizacijaService imunizacijaService;

    public ImunizacijaController(ImunizacijaService imunizacijaService){
        this.imunizacijaService = imunizacijaService;
    }

    

}
