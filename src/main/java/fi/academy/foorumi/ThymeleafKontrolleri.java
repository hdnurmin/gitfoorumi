package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ThymeleafKontrolleri {

    @Autowired
    private OtsikkoRepositorio otsikkorepo;

    @Autowired
    private ViestiRepositorio viestirepo;

    @GetMapping ("/etusivu")
    public String aihelistausEtusivulle (Model model) {
        model.addAttribute("otsikko", otsikkorepo.findAll());
        return "etusivu";
    }

    @GetMapping ("/aiheenkeskustelut")
    public String keskusteluListaus (@RequestParam (name="id") String aihe, Model model) {
        List<Otsikko> optaihe = otsikkorepo.findByAihealue(aihe);
            model.addAttribute("otsikonnimi", optaihe);

        return "aiheenkeskustelut";
    }

    @GetMapping ("/viestisivu")
    public String viestiListaus (@RequestParam (name="id") int id, Model model) {
        List<Viesti> optviesti = viestirepo.haeViestit(id);
        model.addAttribute("viesti", optviesti);
        model.addAttribute("otsikkoteksti", otsikkorepo.findById(id).get());
        model.addAttribute("uusiviesti", new Viesti());
        return "viestisivu";
    }

    @PostMapping ("/viestisivu")
    public String uudenViestinLahetys(Model model, @ModelAttribute Viesti viesti, @RequestParam ("id") int tunniste) {
     viesti.setOtsikko(otsikkorepo.findById(tunniste).get());
     viesti.setLahetysAika(LocalDateTime.now());
     viestirepo.save(viesti);
        return "redirect:/viestisivu"+ "?id=" + tunniste;
    }

    @GetMapping ("/rekisteroidy")
    public String rekisteroityminen() {
        return "rekisteroidy";
    }


}
