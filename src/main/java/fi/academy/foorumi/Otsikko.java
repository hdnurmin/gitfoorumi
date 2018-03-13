package fi.academy.foorumi;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Otsikko {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String aihealue;
    private String otsikonNimi;
    @JsonIgnore
    @OneToMany (mappedBy = "otsikko")
    public List<Viesti> aiheenViestit;

    public Otsikko() {
    }

    public Otsikko(String aihealue, String otsikonNimi) {
        this.aihealue = aihealue;
        this.otsikonNimi = otsikonNimi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAihealue() {
        return aihealue;
    }

    public void setAihealue(String aihealue) {
        this.aihealue = aihealue;
    }

    public String getOtsikonNimi() {
        return otsikonNimi;
    }

    public void setOtsikonNimi(String otsikonNimi) {
        this.otsikonNimi = otsikonNimi;
    }

    @Override
    public String toString() {
        return "Otsikko{" +
                "id=" + id +
                ", aihealue='" + aihealue + '\'' +
                ", otsikonNimi='" + otsikonNimi + '\'' +
                '}';
    }
}
