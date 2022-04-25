package Classi;

import java.util.Date;

public class Bevanda extends Prodotto {
	
	public Bevanda(String nome, double prezzo, int codiceSeriale, String pathFoto, String categoria, Date scadenza) {
		super(nome, prezzo, codiceSeriale, categoria, pathFoto, scadenza);
	}

}
