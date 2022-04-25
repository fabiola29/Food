package Classi;


import java.util.Date;

import javax.swing.ImageIcon;

import GuiFood.Login;

public class Prodotto {

	private String nome;
	private double prezzo;
	private int codiceSeriale;

	private String categoria;
	private Date scadenzaProdotto;
	private ImageIcon fotoProdotto = null;
	private String pathFoto;

 	public Prodotto(String nome, double prezzo, int codiceSeriale, String categoria, String pathFoto, Date scadenzaProdotto) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.codiceSeriale = codiceSeriale;
		this.categoria = categoria;
		this.scadenzaProdotto = scadenzaProdotto;
		this.pathFoto = pathFoto;
		this.fotoProdotto = new ImageIcon(Login.class.getResource(pathFoto));
	}
 	
 	public Prodotto(int codiceSeriale) {
 			this.codiceSeriale = codiceSeriale;
 	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codiceSeriale;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (codiceSeriale != other.codiceSeriale)
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String getDescrizione() {
		return categoria;
	}

	public Date getScadenzaProdotto() {
		return scadenzaProdotto;
	}

	public ImageIcon getFotoProdotto() {
		return fotoProdotto;
	}

	public int getCodiceSeriale() {
		return codiceSeriale;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public String getCategoria() {
		return this.categoria;
	}

}
