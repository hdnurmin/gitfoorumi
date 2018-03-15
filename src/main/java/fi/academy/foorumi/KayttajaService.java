package fi.academy.foorumi;


public interface KayttajaService {
    void tallenna(Kayttaja kayttaja);

    Kayttaja haeKayttajatunnuksella(String tunnus);
}
