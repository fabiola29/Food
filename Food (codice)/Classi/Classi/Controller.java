package Classi;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;


import Dao.*;
import GuiFood.*;

public class Controller {
	
	private Login login;
	private Login loginApp;
    private Registrazioni registrazione;
	private Password_Dimenticata passwordDimenticata;
	private VisualizzazioneAvvisi dialogErrore;
	private ModificaProfilo modificaProfilo;
	private Fattura fattura;
    private Menu menu;
    private SceltaRistorante sceltaRistorante;
    private ArrayList<Ristorante> ristoranti;
    private ArrayList<Rider> riders;
    private Utente utenteLoggato;
    private Ristorante ristoranteSelezionato;
    private Rider riderSelezionato;
    private Carrello carrello;
    
	public Controller() {
		this.ottieniRistoranti();
		this.ottieniRider();
		this.associaRiderRistoranti();
		login = new Login(this);
		login.setVisible(true);
		login.setLocationRelativeTo(null);
	}

	 public void visualizzazioneLogin() {
		 if(loginApp == null) {
			 loginApp = new Login(this);
		 }
		 loginApp.setVisible(true);
		 loginApp.setLocationRelativeTo(login);
	   }
	 
	 public void visualizzazioneRegistrazione() {
		    registrazione = new Registrazioni(this);
		    registrazione.setVisible(true);
		    registrazione.setLocationRelativeTo(login);
	 }
   
	 public void visualizzazioneMenu() {
		creaNuovoCarrello();
   		menu = new Menu(this);
   		menu.setLocationRelativeTo(null);
    	menu.setVisible(true);	
    }
	  
	 public void VisualizzazioneAvvisi(String messaggioErrore) {
		    VisualizzazioneAvvisi(Arrays.asList(messaggioErrore));
		}

		public void VisualizzazioneAvvisi(List<String> messaggiErrore) {
		    if (dialogErrore == null) {
		        dialogErrore = new VisualizzazioneAvvisi(this);    
		        dialogErrore.setBounds(0, 0,360, 150);
		        dialogErrore.setLocationRelativeTo(menu);
		    }

		    dialogErrore.setMessaggiErrore(messaggiErrore);
		    dialogErrore.setVisible(true);
		}
		
	public void visualizzazionePwdDimenticata() {
		passwordDimenticata = new Password_Dimenticata(this);
		passwordDimenticata.setVisible(true);
		passwordDimenticata.setLocationRelativeTo(login);

	}
	
	public void visualizzazioneFattura() {
		fattura = new Fattura(this);
		fattura.setVisible(true);
		fattura.setLocationRelativeTo(menu);
	}
	
	public void VisualizzaSceltaRistorante() {
	    sceltaRistorante = new SceltaRistorante(this);
	    sceltaRistorante.setVisible(true);
	    sceltaRistorante.setLocationRelativeTo(menu);
 }
	
	public void ModificaProfilo() 
	    {
		 modificaProfilo = new ModificaProfilo(this);
		 modificaProfilo.setVisible(true);
		 modificaProfilo.setLocationRelativeTo(menu);
	    }
		

	public ImageIcon scaleImageIcon(ImageIcon image, int width, int height) {
			Image tmp = image.getImage();
			Image scaledImage = tmp.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
			return scaledImageIcon;
		}
	  
	  public boolean effettuaRegistrazione(String nome, String cognome, String email, String password,  String numeroTelefono, 
				String nomeVia, int numeroCivico, String cap, String citta, String provincia) {
			DaoUtente daoUtente = new DaoUtenteDatabase();
			DaoIndirizzo daoIndirizzo = new DaoIndirizzoDatabase(); 
			boolean insertSucced = false;
			int codiceIndirizzo = -1;
			if(!daoUtente.esisteUtente(email)) { 
				if(! daoIndirizzo.esisteIndirizzo(nomeVia, numeroCivico, cap, citta, provincia)) { 
					daoIndirizzo.inserisciNuovoIndirizzo(nomeVia, numeroCivico, cap, citta, provincia); 
					registrazione.setVisible(false); 		
				}
				codiceIndirizzo = daoIndirizzo.ottieniCodiceIndirizzo(nomeVia, numeroCivico, cap, citta, provincia);
				if (codiceIndirizzo != -1) {
					insertSucced = daoUtente.inserisciNuovoUtente(nome, cognome, email, password, numeroTelefono, codiceIndirizzo);

				}
			} 
			return insertSucced;
		} 
	  
	  public boolean effettuaAccesso(String email, String password) {
		  boolean loginSucced = false;
		  DaoUtente daoUtente = new DaoUtenteDatabase(); 
		  if(daoUtente.concediAccesso(email, password)) {
			  this.utenteLoggato = daoUtente.effettuaAccesso(email, password);
			  if(this.utenteLoggato == null) {
				  this.VisualizzazioneAvvisi("Impossibile accedere, problema interno");
			  }
			  loginSucced = true;
		  }else {
			  this.VisualizzazioneAvvisi("Credenziali errate");
			  this.visualizzazioneLogin();
		  }
		  return loginSucced;
	  }
	  
	 public void cambiaPassword(String email, String nuovaPassword) {
		new DaoUtenteDatabase().cambiaPassword(email, nuovaPassword); 
	 }
	 
	public boolean isLoggato() {
		return this.utenteLoggato != null;
	}

	public String getEmail() {
		return this.utenteLoggato.getEmail();
	}

	private void  ottieniRistoranti() {
		DaoRistorante daoRistorante = new DaoRistoranteDatabase();
		try {
			this.ristoranti = daoRistorante.ottieniRistoranti();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Impossibile connettersi al database");
			this.VisualizzazioneAvvisi(Arrays.asList("E' stato riscontrato un problema interno a Food", "Impossibile connettersi al database", "Chiusura applicazione"));
			System.exit(-1);
		}
	}
	
	private void ottieniRider() {
		DaoRider daoRider = new DaoRiderDatabase();
		try {
			this.riders = daoRider.ottieniRider();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Impossibile connettersi al database");
			this.VisualizzazioneAvvisi(Arrays.asList("E' stato riscontrato un problema interno a Food", "Impossibile connettersi al database", "Chiusura applicazione"));
			System.exit(-1);
		}
	}
	
	private void associaRiderRistoranti() {
		DaoRistorante daoRistorante = new DaoRistoranteDatabase();
		HashMap<Integer, ArrayList<Integer>> associazzioni = null;
		try {
			associazzioni = daoRistorante.ottieniAssociazioni();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Impossibile connettersi al database");
			this.VisualizzazioneAvvisi(Arrays.asList("E' stato riscontrato un problema interno a Food", "Impossibile connettersi al database", "Chiusura applicazione"));
			System.exit(-1);
		}
		int codiceRistorante;
		for(Ristorante ristorante : this.ristoranti) {
			codiceRistorante = ristorante.getCodiceRistorante();
			ArrayList<Integer> codiciRiderAssociati = associazzioni.get(codiceRistorante);
			for(Integer codiceRider : codiciRiderAssociati) {
				for(Rider rider : this.riders) {
					if(rider.getCodiceRider() == codiceRider) {
						ristorante.addRider(rider);
						rider.addRistoranteAssociato(ristorante);
					}
				}
			}
		}
	}

	private void creaNuovoCarrello() {
		DaoCarrello daoCarrello = new DaoCarrelloDatabase();
		try {
			this.carrello = daoCarrello.creaNuovoCarrello();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Impossibile connettersi al database");
			this.VisualizzazioneAvvisi(Arrays.asList("E' stato riscontrato un problema interno a Food", "Impossibile connettersi al database", "Chiusura applicazione"));
			System.exit(-1);
		}
		
	}

	public ArrayList<Ristorante> ottieniRistorantiDisponibili() {
		return this.ristoranti;
	}

	public void setRistoranteScelto(Ristorante ristoranteScelto) {
		this.ristoranteSelezionato = ristoranteScelto;
	}

	public HashMap<Prodotto, Integer> getProdottiDalRistoranteSelezionato() {
		return this.ristoranteSelezionato.getProdottiInVendita();
	}

	public void aggiungiProdottoAlCarrello(Prodotto prodotto, int quantita) {
		this.carrello.aggiungiProdotto(prodotto, quantita);
	}

	public ArrayList<Rider> ottieniRiderDelRistorante() {
		return this.ristoranteSelezionato.getRiders();
	}

	public void setRiderSelezionato(Rider riderSelezionato) {
		this.riderSelezionato = riderSelezionato;
	}

	public void svuotaCarrello() {
		int codiceCarrello = this.carrello.getCodiceCarrello();
		Carrello nuovoCarrello = new Carrello(codiceCarrello);
		this.carrello = nuovoCarrello;
	}

	public void effettuaOrdine() {
		DaoRistorante daoRistorante = new DaoRistoranteDatabase();
		try {
			daoRistorante.aggiornaForniture(ristoranteSelezionato, carrello.getQuantitaProdotto());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Impossibile connettersi al database");
			this.VisualizzazioneAvvisi(Arrays.asList("E' stato riscontrato un problema interno a Food", "Impossibile connettersi al database", "Chiusura applicazione"));
			System.exit(-1);
			e.printStackTrace();
		}
		DaoOrdine daoOrdine = new DaoOrdineDatabase();
		daoOrdine.inserisciNuovoOrdine(utenteLoggato, carrello, ristoranteSelezionato, riderSelezionato);
	}

	public Utente ottieniUtente() {
		return this.utenteLoggato;
	}

	public Carrello ottieniCarrello() {
		return this.carrello;
	}

}