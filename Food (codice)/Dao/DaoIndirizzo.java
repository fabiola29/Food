package Dao;


import Classi.Indirizzo;

public interface DaoIndirizzo {

	public boolean esisteIndirizzo(String nomeVia, int numeroCivico, String cap, String citta, String provincia);
	
	public boolean inserisciNuovoIndirizzo(String nomeVia, int numeroCivico, String cap, String citta, String provincia);
	
	public int ottieniCodiceIndirizzo(String nomeVia, int numeroCivico, String cap, String citta, String provincia); 	

	public Indirizzo ottieniIndirizzo(int codiceIndirizzo);
	
}