package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping ("/viestisivu")
    public String viestiListaus (Model model, Viesti viesti) {
        model.addAttribute("viesti", viestirepo.findAll());
        //model.addAttribute();
        return "viestisivu";
    }
}
