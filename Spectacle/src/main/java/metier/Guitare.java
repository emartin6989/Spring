package metier;


import org.springframework.stereotype.Component;


@Component("maGuitare")
public class Guitare implements Instrument {

	public void jouer() {
		System.out.println("GUIT GUITARE...");
	}

}
