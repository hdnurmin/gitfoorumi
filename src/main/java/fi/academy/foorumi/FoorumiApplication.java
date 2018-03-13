package fi.academy.foorumi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FoorumiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoorumiApplication.class, args);
	}

	@Transactional
	@Bean
	CommandLineRunner luoOppilaat(ViestiRepositorio viestirepo, OtsikkoRepositorio otsikkorepo) {
		return (args) -> {
			List<Viesti> viestit = new ArrayList<>();
			Otsikko ekaOtsikko = new Otsikko("Kanit", "Hieno päivä tänään");
			Otsikko tokaOtsikko = new Otsikko("Karhut", "Vielä hienompi päivä");
			Viesti ekaViesti = new Viesti("Blah blah blah", ekaOtsikko);
			Viesti tokaViesti = new Viesti("Laalaalaa", ekaOtsikko);
			Viesti kolmasViesti = new Viesti("Tadaa", ekaOtsikko);


			Viesti neljasViesti = new Viesti("Jeejee", tokaOtsikko);
    		viestit.add(ekaViesti);
			viestit.add(tokaViesti);
			viestit.add(kolmasViesti);
			viestit.add(neljasViesti);

			viestirepo.saveAll(viestit);

			/*viestirepo.save(ekaViesti);
			viestirepo.save(tokaViesti);
			viestirepo.save(kolmasViesti);*/
			/*otsikkorepo.save(ekaOtsikko);*/

/*			Koulu academySuomi = new Koulu("Academy Suomi", "Espoo");
			academySuomi= koulurepositorio.save(academySuomi);
			Koulu academyRuotsi = new Koulu("Academy Ruotsi", "Tukholma");
			academyRuotsi= koulurepositorio.save(academyRuotsi);

			jani.setKoulu(academySuomi);
			minna.setKoulu(academySuomi);
			ase.setKoulu(academyRuotsi);

			oppilasrepository.save(jani);
			oppilasrepository.save(minna);
			oppilasrepository.save(ase);*/


//			oppilasrepository.saveAll(oppilaat);

		};
	}
}
