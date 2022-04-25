package Classi;

import java.util.ArrayList;
import java.util.HashMap;

public class Ristorante {
	
	private String nome;
    private ArrayList<Rider> riders;
	private int codiceRistorante;

	private HashMap<Prodotto, Integer> prodottiInVendita;

	public Ristorante(String nome, int codiceRistorante) {
		this.nome = nome;
		this.codiceRistorante = codiceRistorante;
		this.riders = new ArrayList<Rider>();
		this.prodottiInVendita = new HashMap<Prodotto, Integer>();
	}

	public int getCodiceRistorante() {
		return codiceRistorante;
	}

	public void setProdottiInVendita(HashMap<Prodotto, Integer> prodottiInVendita){
		this.prodottiInVendita = prodottiInVendita;
	}

	public ArrayList<Rider> getRiders() {
		return riders;
	}
	
	public void addRider(Rider rider) {
		this.riders.add(rider);
	}

	public HashMap<Prodotto, Integer> getProdottiInVendita() {
		return prodottiInVendita;
	} 
	public String getNome() {
		return nome;
	}

	public void setRiders(ArrayList<Rider> riders) {
		this.riders = riders;
	}
	
	public boolean disponeDiMoto() {
		boolean ret = false;
		for(Rider r : this.riders) {
			for(Veicolo v : r.getParcoVeicoli()) {
				if (v instanceof Moto) {
					ret = true;
					break;
				}
			}
			if(ret) {
				break;
			}
		}
		return ret;
	}

	public boolean disponeDiBici() {
		boolean ret = false;
		for(Rider r : this.riders) {
			for(Veicolo v : r.getParcoVeicoli()) {
				if (v instanceof Bicicletta) {
					ret = true;
					break;
				}
			}
			if(ret) {
				break;
			}
		}
		return ret;
	}
 
}
