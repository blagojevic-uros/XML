package com.vacc.service;

import com.vacc.Exception.NotFoundException;
import com.vacc.dao.KorisnikDAO;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService implements UserDetailsService {

    private final KorisnikDAO korisnikDAO;
    public KorisnikService(KorisnikDAO korisnikDAO) {
        this.korisnikDAO = korisnikDAO;
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
    public UserDetails loadUserByUsername1(String username) throws UsernameNotFoundException {
        try{
            return korisnikDAO.getByUsername1(username);
        }
        catch (Exception e) {
            throw new NotFoundException(String.format("User with username '%s' is not found!", username));
        }

    }

}
