package Classi;

public class Indirizzo {
	private String nomeVia;
	private int numeroCivico;
	private String CAP;
	private String citta;
	private String provincia;
	
	public String getNomeVia() {
		return nomeVia;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public String getCap() {
		return CAP;
	}

	public Indirizzo(String nomeVia, int numeroCivico, String cap, String citta, String provincia) {
		this.nomeVia = nomeVia;
		this.numeroCivico = numeroCivico;
		this.citta = citta;
		this.provincia = provincia;
		this.CAP = cap;
	}

	public String getCitta() {
		return citta;
	}
	public  String getProvincia() {
		return provincia;
	}

}
