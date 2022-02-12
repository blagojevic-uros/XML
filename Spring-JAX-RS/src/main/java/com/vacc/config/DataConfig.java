package com.vacc.config;


import com.vacc.dao.VakcinaDAO;
import model.korisnik.Korisnik;
import model.vakcine.Vakcina;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Import({DBConfig.class})
public class DataConfig {
    @Bean
    CommandLineRunner DataConfigCMDLineRunner(VakcinaDAO vakcinaDAO) {
        return args -> {
            Vakcina v1 = new Vakcina(1,"Pfizer-BioNTech",100);
            Vakcina v2 = new Vakcina(2,"Sputnik V",100);
            Vakcina v3 = new Vakcina(3,"Sinopharm",100);
            Vakcina v4 = new Vakcina(4,"AstraZeneca",100);
            Vakcina v5 = new Vakcina(5,"Moderna",100);
            List<Vakcina> vakcinaList = List.of(v1,v2,v3,v4,v5);
            List<String> dokumentNames = vakcinaList.stream().map(Vakcina::getNaziv).collect(Collectors.toList());
            vakcinaDAO.saveList(vakcinaDAO.getFolderPath(),dokumentNames,vakcinaList,Vakcina.class);
            Role r1 = new Role(1,"ROLE_PACIJENT");
            Korisnik k = new Korisnik(1,"pera","$2a$12$BKZlNSMhhIVTVsiPt9Qz8eXX/eEoCkP851wlR3/mxJqbfdWsOjgM6","Pera","Peric");
        };
    }
}

