package fi.academy.foorumi;

import javax.persistence.*;

@Entity
public class Viesti {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int tunniste;
    @Lob
    private String sisalto;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn
    public Otsikko otsikko;

    public Viesti(String sisalto, Otsikko otsikko) {
        this.sisalto = sisalto;
        this.otsikko = otsikko;
    }

    public Viesti() {
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
}
