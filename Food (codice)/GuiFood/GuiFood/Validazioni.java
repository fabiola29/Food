package GuiFood;

import java.util.ArrayList;
import java.util.List;


public class Validazioni {
    private List<String> messaggiErrore = new ArrayList<String>();

    public boolean valido() {
        return messaggiErrore.isEmpty();
    }

    public List<String> getMessaggiErrore() {
        return messaggiErrore;
    }

    public boolean capObbligatorio(String cap, String msgMancante, String msgInvalido) {
        if (cap == null || cap.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        if (!cap.matches("[0-9]{5}")) {
            messaggiErrore.add(msgInvalido);
            return false;
        }

        return true;
    }
    
    
    public boolean numeroCivicoObbligatorio(String numeroCivico, String msgMancante, String msgInvalido) {
        if (numeroCivico == null || numeroCivico.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        try {
            if (Integer.parseInt(numeroCivico) <= 0) {
               
            	return false;
            	
            }
        } catch (NumberFormatException e) {
        	return false;
        }

        if (!numeroCivico.matches("^[A-Za-z0-9\\-\\s,\\/]{1,}*$")) {
            messaggiErrore.add(msgInvalido);
        }

        return true;
    }
    
    
    public boolean emailObbligatoria(String email, String msgMancante, String msgInvalido) {
        if (email == null || email.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            messaggiErrore.add(msgInvalido);
            return false;
        }

        return true;
    }
    
    public boolean provinciaObbligatoria(String provincia, String msgMancante, String msgInvalido) {
        if (provincia == null || provincia.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        if (!provincia.matches("[A-Za-z]{2}")) {
            messaggiErrore.add(msgInvalido);
            return false;
        }

        return true;
    }
    
    public boolean passwordObbligatoria(String password, String msgMancante, String msgInvalido) {
        if (password == null || password.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            messaggiErrore.add(msgInvalido);
            return false;
        }

        return true;
    }
    
    public boolean numeroTelefonicoObbligatoria(String numeroTelefonico, String msgMancante, String msgInvalido) {
        if (numeroTelefonico == null || numeroTelefonico.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        if (!numeroTelefonico.matches("[0-9]{10}")) {
            messaggiErrore.add(msgInvalido);
            return false;
        }

        return true;
    }
    
    public boolean nomeObbligatoria(String nome, String msgMancante, String msgInvalido) {
        if (nome == null || nome.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }
      
        return true;
        }
    
    
    public boolean cognomeObbligatoria(String cognome, String msgMancante, String msgInvalido) {
        if (cognome == null || cognome.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }

        return true;
    }
    
    public boolean cittaObbligatoria(String citta, String msgMancante, String msgInvalido) {
        if (citta == null || citta.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }


        return true;
    }
    
    public boolean nomeViaObbligatoria(String nomeVia, String msgMancante, String msgInvalido) {
        if (nomeVia == null || nomeVia.isEmpty()) {
            messaggiErrore.add(msgMancante);
            return false;
        }  

        return true;
    }
}