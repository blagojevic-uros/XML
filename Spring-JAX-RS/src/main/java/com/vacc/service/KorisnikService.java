package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.dao.KorisnikDAO;
import lombok.SneakyThrows;
import model.interesovanje.Interesovanje;
import model.korisnik.Korisnik;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class KorisnikService implements UserDetailsService {

    private final KorisnikDAO korisnikDAO;
    public KorisnikService(KorisnikDAO korisnikDAO) {
        this.korisnikDAO = korisnikDAO;
    }
    private final String folderPath="/db/korisnik";

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{

            UserDetails k = korisnikDAO.getByUsername(username);
            return k;
        }
        catch (Exception e) {
            throw new NotFoundException(String.format("User with username '%s' is not found!", username));
        }

    }
    public UserDetails loadUserByUsername1(String username) throws UsernameNotFoundException {
        try{
            return korisnikDAO.getByUsername1(username);
        }
        catch (Exception e) {
            throw new NotFoundException(String.format("User with username '%s' is not found!", username));
        }

    }
    public String save(Korisnik korisnik) throws Exception{
        //emailService.sendMailForSaglasnost(interesovanje.getLicniPodaci().getEmail(),new Date());
        String uniqueID = UUID.randomUUID().toString();
        String documentId = "interesovanje-" + uniqueID + ".xml";
        try{
            this.korisnikDAO.save(folderPath, uniqueID, korisnik, Korisnik.class);

            // TODO: Vratiti id za http
            return "uniqueID";
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}
