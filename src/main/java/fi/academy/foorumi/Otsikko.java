package fi.academy.foorumi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Otsikko {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String aihealue;
    private String otsikonNimi;

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
