package fi.academy.foorumi;

public interface SecurityService {
    String haeKirjautunutKayttaja();

    void autoKirjaudu(String kayttajatunnus, String salasana);
}
