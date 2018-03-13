package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestKontrolleri {
     private OtsikkoRepositorio otsikkorepo;
     private ViestiRepositorio viestirepo;

     public RestKontrolleri (@Autowired OtsikkoRepositorio otsikkorepo, @Autowired ViestiRepositorio viestirepo){
         this.otsikkorepo = otsikkorepo;
         this.viestirepo = viestirepo;
     }

    @GetMapping("/viestit")
    public Iterable<Viesti> listaaViestit() {
        return viestirepo.findAll();
    }
}

