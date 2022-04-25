package Classi;

import java.util.ArrayList;

public class Rider {
	
	private String nome;
	private int codiceRider;

	public int getCodiceRider() {
		return codiceRider;
	}

	private ArrayList<Veicolo> parcoVeicoli = new ArrayList<Veicolo>() ;
	private Ristorante[] ristoranteAssociato = new Ristorante[3];
    private int indexRistoranteAssociato = 0;
	
	public Rider(String nome, String cognome, String biografia, String pathFoto, int codiceRider, ArrayList<Veicolo> parcoVeicoli) {
		this.nome = nome;
		this.codiceRider = codiceRider;
		this.parcoVeicoli = parcoVeicoli;
	}

	public String getNome() {
		return nome;
	}
	
	public void addRistoranteAssociato(Ristorante ristorante) {
		this.ristoranteAssociato[indexRistoranteAssociato++] = ristorante;
	}
	
	public ArrayList<Veicolo> getParcoVeicoli(){
		return this.parcoVeicoli;
	}

}
