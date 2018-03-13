package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Viesti> optviesti = viestirepo.findByTunniste(id);
        model.addAttribute("viesti", optviesti);
        return "viestisivu";
    }


}
