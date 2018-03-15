package fi.academy.foorumi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class ThymeleafKontrolleri {

    @Autowired
    private OtsikkoRepositorio otsikkorepo;

    @Autowired
    private ViestiRepositorio viestirepo;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private  KayttajaServiceImpl kayttajaService;


    @GetMapping ("/etusivu")
    public String aihelistausEtusivulle (Model model) {
        model.addAttribute("otsikko", otsikkorepo.naytaEriAihealueet());
        return "etusivu";
    }

    @GetMapping ("/aiheenkeskustelut")
    public String keskusteluListaus (@RequestParam (name="id") String aihe, Model model) {
        List<Otsikko> optaihe = otsikkorepo.findByAihealue(aihe);
            model.addAttribute("otsikonnimi", optaihe);
//            model.addAttribute("aiheteksti", otsikkorepo.findById(id).get());
            model.addAttribute("uusiotsikko", new Otsikko());
            model.addAttribute("aihealueennimi", aihe);
        return "aiheenkeskustelut";
    }

    @PostMapping ("/aiheenkeskustelut")
    public String uudenKeskustelunLisays( Otsikko saapuvaOtsikko) {
//        otsikko.setAihealue(otsikkorepo.findById(id).get());
        Otsikko apuotsikko= new Otsikko();
        apuotsikko.setAihealue(saapuvaOtsikko.getAihealue());
        apuotsikko.setOtsikonNimi(saapuvaOtsikko.getOtsikonNimi());

        Otsikko tallennettuOtsikko = otsikkorepo.save(apuotsikko);

        /*return "redirect:/viestisivu" + "?id=" + saapuvaOtsikko.getAihealue();*/

        return "redirect:/viestisivu"+ "?id=" + tallennettuOtsikko.getId();


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
    public String rekisteroityminen(Model model) {
        model.addAttribute("kayttajalomake", new Kayttaja());

        return "rekisteroidy";
    }

    @GetMapping ("/poistaviesti")
    public String poistaViesti(@RequestParam (value="tunniste", required = false) Integer tunniste) {
     Viesti tallennettuViesti=  viestirepo.findByTunniste(tunniste);
     viestirepo.delete(tallennettuViesti);
     return "redirect:viestisivu"+ "?id=" + tallennettuViesti.getOtsikko().getId();
    }

    @GetMapping ("/muokkaaviestia")
    public String muokkaaViestia (@RequestParam (name="id") Integer tunniste, Model model) {
        List<Viesti> optviesti = viestirepo.haeViestit(tunniste);
        Viesti muokattava = viestirepo.findById(tunniste).get();
        model.addAttribute("viesti", optviesti);
        model.addAttribute("otsikkoteksti", otsikkorepo.findById(muokattava.otsikko.getId()).get());
        model.addAttribute("uusiviesti", new Viesti());
        model.addAttribute("muokattu", muokattava);
        return "viestinmuokkaus";


    }

    @PostMapping ("/muokkausok")
    public String viestiMuokattuOK (Model model, Viesti viesti) {
        Viesti tatamuokataan = viestirepo.findById(viesti.getTunniste()).get();
        tatamuokataan.setSisalto(viesti.getSisalto());
//        tatamuokataan.setLahetysAika(LocalDateTime.now());
        viestirepo.save(tatamuokataan);
        //Otsikko tallennettuOtsikko = otsikko;
        return "redirect:/viestisivu"+ "?id=" + tatamuokataan.getOtsikko().getId();


//    return "redirect:viestisivu"+ "?id=" + muokattava.getOtsikko().getId();
    }



    @GetMapping ("/haetut")
    public String haetutkeskustelut (Hakusana hakusana, Model model) {
        if (hakusana == null || hakusana.getHakusana() == null || hakusana.getHakusana().trim().isEmpty())
            return "etusivu";
        model.addAttribute("hakusana", hakusana.getHakusana());
        model.addAttribute("loytynytviesti", viestirepo.haeViestitHakusanalla(hakusana.getHakusana()));
        return "haetut";
    }

    @PostMapping ("/rekisteroidy")
    public  String rekisteroi (Kayttaja luotuKayttaja) {
        kayttajaService.tallenna(luotuKayttaja);
        securityService.autoKirjaudu(luotuKayttaja.getKayttajatunnus(),luotuKayttaja.getSalasana());
        return "redirect:/etusivu";
    }

    @GetMapping ("/login")
    public String kirjautmissivulle (Model model) {
        model.addAttribute("kayttajalomake", new Kayttaja());
        return "kirjautuminen";
    }

    @GetMapping ("/")
    public String alkuun () {
        return "redirect:/etusivu";
    }
}
