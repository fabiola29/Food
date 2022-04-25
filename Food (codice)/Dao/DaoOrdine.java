package Dao;

import Classi.Carrello;
import Classi.Rider;
import Classi.Ristorante;
import Classi.Utente;

public interface DaoOrdine {
	public boolean inserisciNuovoOrdine(Utente utente, Carrello carrello, Ristorante ristorante, Rider rider);
}
