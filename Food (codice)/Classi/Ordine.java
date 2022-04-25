package Classi;

import java.util.ArrayList;
import java.util.Date;

public class Ordine {
	private double prezzo;	
    private boolean stato;
	private Date dataAcquisto;
	private Utente utente;
    private Rider rider;
	private Ristorante ristorante; 
	
	

	public Ordine(String nome, String[] prodotto, double prezzo, boolean stato, Date data, ArrayList<Utente> utenti,
			Rider rider) {
		this.prezzo = prezzo;
		this.stato = stato;
		this.rider = rider;
	}
	
     public double getPrezzo() {
		return prezzo;
	}
     
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public boolean isStato() {
		return stato;
	}
	
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	public Rider getRider() {
		return rider;
	}
	
	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public Date getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	
	public Ristorante getRistorante() {
		return ristorante;
	}
	
	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

}