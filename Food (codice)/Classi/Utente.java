package Classi;

import java.util.ArrayList;

public class Utente {
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
    private String numeroTelefonico;
	private Indirizzo indirizzo;
	private ArrayList<Ordine> ordini;
	
 

public  Utente(String nome, String cognome, String email, String password, String numeroTelefonico, Indirizzo indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
		this.numeroTelefonico = numeroTelefonico;
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	
	public ArrayList<Ordine> getOrdini() {
			return ordini;
	}

	public void setOrdini(ArrayList<Ordine> ordini) {
		   this.ordini = ordini;
	}

}



