package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KayttajaServiceImpl implements KayttajaService {
    @Autowired
    private KayttajaRepositorio kayttajaRepositorio;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void tallenna(Kayttaja kayttaja) {
        kayttaja.setSalasana(bCryptPasswordEncoder.encode(kayttaja.getSalasana()));
        kayttajaRepositorio.save(kayttaja);
    }

    @Override
    public Kayttaja haeKayttajatunnuksella(String tunnus) {
        return kayttajaRepositorio.findByKayttajatunnus(tunnus);
    }
}
