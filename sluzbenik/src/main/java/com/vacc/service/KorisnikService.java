package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.config.WebSecurityConfig;
import com.vacc.dao.KorisnikDAO;
import lombok.SneakyThrows;
import model.korisnik.Korisnik;
import model.role.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KorisnikService implements UserDetailsService {

    private final KorisnikDAO korisnikDAO;
    private final WebSecurityConfig webSecurityConfig;
    public KorisnikService(KorisnikDAO korisnikDAO, WebSecurityConfig webSecurityConfig) {
        this.korisnikDAO = korisnikDAO;
        this.webSecurityConfig = webSecurityConfig;
    }

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

    public Korisnik registerUser(Korisnik korisnik){
        try{
            // STAVI PROVERU DA L POSTOJI VEC TAJ USERNAME
            Role role = new Role();
            role.setId(1L);
            role.setName("ROLE_PACIJENT");
            List<Role> list = new ArrayList<>();
            list.add(role);
            korisnik.setRoles(list);
            korisnik.setPassword(webSecurityConfig.passwordEncoder().encode(korisnik.getPassword()));
            korisnikDAO.save(korisnikDAO.getFolderPath(), korisnik.getUsername()+".xml", korisnik, Korisnik.class);
        }catch (Exception e){
            throw new NotFoundException("Greska");
        }
        return korisnik;
    }

    public UserDetails loadUserByUsername1(String username) throws UsernameNotFoundException {
        try{
            return korisnikDAO.getByUsername1(username);
        }
        catch (Exception e) {
            throw new NotFoundException(String.format("User with username '%s' is not found!", username));
        }

    }

}
