package fi.academy.foorumi;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ViestiRepositorio extends CrudRepository<Viesti, Integer>{
    List<Viesti> findByTunniste(int viesti);

}
