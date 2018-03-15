package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailService implements UserDetailsService  {

    @Autowired
    private KayttajaRepositorio kayttajaRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Kayttaja kayttaja = kayttajaRepo.findByKayttajatunnus(s);
        if (kayttaja == null) {
            throw new UsernameNotFoundException("Seuraava tunnusta ei ole : " + s);
        }

        return new org.springframework.security.core.userdetails.User(
                kayttaja.getKayttajatunnus(),
                kayttaja.getSalasana(),
                true,
                true,
                true,
                true,
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
