package fi.academy.foorumi;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Viesti {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int tunniste;
    @Lob
    private String sisalto;
    private LocalDate lahetysAika;
    private String kirjoittaja;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn
    public Otsikko otsikko;

    public Viesti(String sisalto, Otsikko otsikko) {
        this.sisalto = sisalto;
        this.otsikko = otsikko;
    }

    public Viesti() {
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public int getTunniste() {
        return tunniste;
    }

    public void setTunniste(int tunniste) {
        this.tunniste = tunniste;
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public Otsikko getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(Otsikko otsikko) {
        this.otsikko = otsikko;
    }

    public LocalDate getLahetysAika() {
        return lahetysAika;
    }

    public void setLahetysAika(LocalDate lahetysAika) {
        this.lahetysAika = lahetysAika;
    }

    @Override
    public String toString() {
        return "Viesti{" +
                "tunniste=" + tunniste +
                ", sisalto='" + sisalto + '\'' +
                ", lahetysAika=" + lahetysAika +
                ", kirjoittaja='" + kirjoittaja + '\'' +
                ", otsikko=" + otsikko +
                '}';
    }
}
