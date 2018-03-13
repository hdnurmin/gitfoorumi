package fi.academy.foorumi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FoorumiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoorumiApplication.class, args);
	}

	@Bean
	CommandLineRunner luoOppilaat(ViestiRepositorio viestirepo, OtsikkoRepositorio otsikkorepo) {
		return (args) -> {
			List<Viesti> oppilaat = new ArrayList<>();
			Otsikko ekaOtsikko = new Otsikko("Kanit", "Hieno päivä tänään");
			Viesti ekaViesti = new Viesti("Blah blah blah", ekaOtsikko);
			viestirepo.save(ekaViesti);
			otsikkorepo.save(ekaOtsikko);

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
