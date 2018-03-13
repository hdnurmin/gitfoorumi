package fi.academy.foorumi;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OtsikkoRepositorio extends CrudRepository<Otsikko, Integer> {
    List<Otsikko> findByAihealue(String aihe) ;
}
