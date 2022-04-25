package Classi;

import java.util.HashMap;

public class Carrello {
	
	private int codiceCarrello;
	private HashMap<Prodotto, Integer> quantitaProdotto; // coppia prodotto, quantita
	
	public Carrello(int codiceCarrello) {
		this.codiceCarrello = codiceCarrello;
		this.quantitaProdotto = new HashMap<Prodotto, Integer>();
	}

	public int getCodiceCarrello() {
		return codiceCarrello;
	}

	public HashMap<Prodotto, Integer> getQuantitaProdotto() {
		return quantitaProdotto;
	}

	public void aggiungiProdotto(Prodotto prodotto, int quantita) {
		if(this.getQuantitaProdotto().containsKey(prodotto)) {
			int quantitaAttuale = this.getQuantitaProdotto().get(prodotto);
			this.getQuantitaProdotto().replace(prodotto, quantitaAttuale + quantita);
		}else {
			this.getQuantitaProdotto().put(prodotto, quantita);
		}
	}
	
	public void cambiaQuantita(Prodotto prodotto, int quantita) {
		this.aggiungiProdotto(prodotto, quantita);
	}
	
	public double getTotale() {
		double totale = 0.0;
		for (Prodotto p : quantitaProdotto.keySet()) {
			totale += p.getPrezzo() * quantitaProdotto.get(p);
		}
		return totale; 
	}
	
}