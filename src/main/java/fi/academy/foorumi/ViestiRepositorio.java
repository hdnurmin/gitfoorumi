package fi.academy.foorumi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.util.List;

public interface ViestiRepositorio extends CrudRepository<Viesti, Integer>{
    @Query ("Select v from Viesti v where v.otsikko.id=:haettu")
    public List<Viesti> haeViestit(@Param("haettu") Integer id);
    List<Viesti> findByTunniste(int viesti);
}
