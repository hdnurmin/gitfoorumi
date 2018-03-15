package fi.academy.foorumi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kayttajatunniste;
    private String kayttajatunnus;
    private String salasana;

    public Kayttaja() {
    }

    public Kayttaja(String kayttajatunnus, String salasana) {
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;

    }

    public int getKayttajatunniste() {
        return kayttajatunniste;
    }

    public void setKayttajatunniste(int kayttajatunniste) {
        this.kayttajatunniste = kayttajatunniste;
    }

    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }




}
