package Classi;

import java.util.Date;

public class Veicolo {

	protected Date annoMatricolazioneMoto;
	protected String marcaMoto;
	protected String modelloMoto;
	protected int codiceSeriale;

	public Veicolo(int codiceSeriale) {
		this.codiceSeriale = codiceSeriale;
	}
	
	protected Veicolo() {
		
	}
 
}
