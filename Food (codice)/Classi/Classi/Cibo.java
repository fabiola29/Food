package Classi;

import java.util.Date;

public class Cibo extends Prodotto {

	public Cibo(String nome, double prezzo, int codiceSeriale, String pathFoto, String categoria, Date scadenza) {
		super(nome, prezzo, codiceSeriale, categoria, pathFoto, scadenza);
	}

}
