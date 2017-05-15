package metier;

import org.springframework.stereotype.Component;

public class Saxophone implements Instrument {

	@Override
	public void jouer() {
		System.out.println("SAXO SAXO SAXO...");
	}

}
