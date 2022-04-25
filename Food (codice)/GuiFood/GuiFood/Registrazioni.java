package GuiFood;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import Classi.Controller;
import java.awt.Cursor;

public  class Registrazioni extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  JPanel textField_Iscrizione = new JPanel();
	private JTextField textField_Nome;
	private JTextField textField_Password;	
	private JTextField textField_Cognome;
	private JTextField textField_Email;
	private JTextField textField_NumTelefonico;
	private JTextField textField_Provincia;
	private JTextField textField_Città;
	private JTextField textField_Cap;
	private JTextField textField_NomeVia;
	private JTextField textField_N_Civico;
	private JButton Button_Iscriviti;

	private Controller ctrl;

	 public Registrazioni(final Controller ctrl) {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("Iscrizione");
		setResizable(false);
		setBounds(100, 100, 528, 389);
		getContentPane().setLayout(new BorderLayout());
        this.ctrl=ctrl;
		textField_Iscrizione.setBackground(new Color(255, 165, 0));
		textField_Iscrizione.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(textField_Iscrizione, BorderLayout.CENTER);
		textField_Iscrizione.setLayout(null);
		
		JLabel Label_Food1 = new JLabel("Food");
		Label_Food1.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Food1.setForeground(Color.WHITE);
		Label_Food1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		Label_Food1.setBounds(208, 6, 134, 46);
		textField_Iscrizione.add(Label_Food1);
		
		JLabel Label_Nome = new JLabel("Nome");
		Label_Nome.setForeground(Color.WHITE);
		Label_Nome.setBounds(82, 69, 45, 21);
		textField_Iscrizione.add(Label_Nome);
		
		JLabel lbIconaNome = new JLabel("");
		lbIconaNome.setBounds(139, 71, 15, 16);
		lbIconaNome.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./utente.png")), 15, 15));
		textField_Iscrizione.add(lbIconaNome);
		
		JSeparator separator_Nome = new JSeparator();
		separator_Nome.setForeground(Color.WHITE);
		separator_Nome.setBounds(139, 85, 348, 12);
		textField_Iscrizione.add(separator_Nome);
		
		textField_Nome = new JTextField();
		textField_Nome.setText("");
		textField_Nome.setSelectionColor(Color.LIGHT_GRAY);
		textField_Nome.setForeground(Color.BLACK);
		textField_Nome.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Nome.setDisabledTextColor(Color.BLACK);
		textField_Nome.setColumns(10);
		textField_Nome.setBorder(null);
		textField_Nome.setBackground(new Color(255, 165, 0));
		textField_Nome.setBounds(166, 71, 321, 16);
		textField_Iscrizione.add(textField_Nome);
		
		JLabel Label_Cognome = new JLabel("Cognome");
		Label_Cognome.setForeground(Color.WHITE);
		Label_Cognome.setBounds(66, 92, 61, 29);
		textField_Iscrizione.add(Label_Cognome);
		
		JLabel lbIconaCognome = new JLabel("");
		lbIconaCognome.setBounds(139, 93, 16, 18);
		lbIconaCognome.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./utente.png")), 15, 15));
		textField_Iscrizione.add(lbIconaCognome);
		
		JSeparator separator_Cognome = new JSeparator();
		separator_Cognome.setForeground(Color.WHITE);
		separator_Cognome.setBounds(139, 109, 348, 12);
		textField_Iscrizione.add(separator_Cognome);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setText("");
		textField_Cognome.setSelectionColor(Color.LIGHT_GRAY);
		textField_Cognome.setForeground(Color.BLACK);
		textField_Cognome.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Cognome.setDisabledTextColor(Color.BLACK);
		textField_Cognome.setColumns(10);
		textField_Cognome.setBorder(null);
		textField_Cognome.setBackground(new Color(255, 165, 0));
		textField_Cognome.setBounds(166, 95, 323, 16);
		textField_Iscrizione.add(textField_Cognome);
		
		JLabel Label_Email_Registrazione = new JLabel("Email");
		Label_Email_Registrazione.setForeground(Color.WHITE);
		Label_Email_Registrazione.setBounds(93, 119, 34, 21);
		textField_Iscrizione.add(Label_Email_Registrazione);
		
		JLabel lbIconaEmail = new JLabel("");
		lbIconaEmail.setBounds(139, 119, 16, 16);
		lbIconaEmail.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./email.png")), 15, 15));
		textField_Iscrizione.add(lbIconaEmail);
		
		JSeparator separator_Email = new JSeparator();
		separator_Email.setForeground(Color.WHITE);
		separator_Email.setBounds(139, 133, 348, 12);
		textField_Iscrizione.add(separator_Email);
		
		textField_Email = new JTextField();
		textField_Email.setText("");
		textField_Email.setSelectionColor(Color.LIGHT_GRAY);
		textField_Email.setForeground(Color.BLACK);
		textField_Email.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Email.setDisabledTextColor(Color.BLACK);
		textField_Email.setColumns(10);
		textField_Email.setBorder(null);
		textField_Email.setBackground(new Color(255, 165, 0));
		textField_Email.setBounds(166, 123, 331, 12);
		textField_Iscrizione.add(textField_Email);
		
		JLabel Label_NumTelefonico = new JLabel("Numero Telefonico");
		Label_NumTelefonico.setForeground(Color.WHITE);
		Label_NumTelefonico.setBounds(6, 140, 120, 29);
		textField_Iscrizione.add(Label_NumTelefonico);
		
		JLabel lbIconaCellulare = new JLabel("");
		lbIconaCellulare.setBounds(139, 143, 15, 16);
		lbIconaCellulare.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./cellulare.png")), 15, 15));
		textField_Iscrizione.add(lbIconaCellulare);
		
		JSeparator separator_NumeroTelefonico = new JSeparator();
		separator_NumeroTelefonico.setForeground(Color.WHITE);
		separator_NumeroTelefonico.setBounds(139, 157, 348, 12);
		textField_Iscrizione.add(separator_NumeroTelefonico);
			
		textField_NumTelefonico = new JTextField();
		textField_NumTelefonico.setText("");
		textField_NumTelefonico.setSelectionColor(Color.LIGHT_GRAY);
		textField_NumTelefonico.setForeground(Color.BLACK);
		textField_NumTelefonico.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        textField_NumTelefonico.setDisabledTextColor(Color.BLACK);
		textField_NumTelefonico.setColumns(10);
		textField_NumTelefonico.setBorder(null);
		textField_NumTelefonico.setBackground(new Color(255, 165, 0));
		textField_NumTelefonico.setBounds(166, 141, 321, 19);
		textField_Iscrizione.add(textField_NumTelefonico);
			
		
		JLabel Label_Password = new JLabel("Password");
		Label_Password.setForeground(Color.WHITE);
		Label_Password.setBounds(66, 168, 61, 29);
		textField_Iscrizione.add(Label_Password);
		
		JLabel lbIconaPassword = new JLabel("");
		lbIconaPassword.setBounds(139, 181, 15, 16);
		lbIconaPassword.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./Password.png")), 15, 15));
		textField_Iscrizione.add(lbIconaPassword);
		
		JSeparator separator_Password = new JSeparator();
		separator_Password.setForeground(Color.WHITE);
		separator_Password.setBounds(139, 192, 348, 12);
		textField_Iscrizione.add(separator_Password);
		
		textField_Password = new JTextField();
		textField_Password.setText("");
		textField_Password.setSelectionColor(Color.LIGHT_GRAY);
		textField_Password.setForeground(Color.BLACK);
		textField_Password.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Password.setDisabledTextColor(Color.BLACK);
		textField_Password.setColumns(10);
		textField_Password.setBorder(null);
		textField_Password.setBackground(new Color(255, 165, 0));
		textField_Password.setBounds(159, 181, 328, 16);
		textField_Iscrizione.add(textField_Password);
		
		JLabel Label_Provincia = new JLabel("Provincia");
		Label_Provincia.setForeground(Color.WHITE);
		Label_Provincia.setBounds(66, 210, 61, 16);
		textField_Iscrizione.add(Label_Provincia);
		
		JLabel lbIconaProvincia = new JLabel("");
		lbIconaProvincia.setBounds(139, 204, 25, 21);
		lbIconaProvincia.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./strada.png")), 25, 25));
		textField_Iscrizione.add(lbIconaProvincia);
		
		JSeparator separator_Password_1 = new JSeparator();
		separator_Password_1.setForeground(Color.WHITE);
		separator_Password_1.setBounds(139, 218, 348, 12);
		textField_Iscrizione.add(separator_Password_1);
		
		textField_Provincia = new JTextField();
		textField_Provincia.setText("");
		textField_Provincia.setSelectionColor(Color.LIGHT_GRAY);
		textField_Provincia.setForeground(Color.BLACK);
		textField_Provincia.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Provincia.setDisabledTextColor(Color.BLACK);
		textField_Provincia.setColumns(10);
		textField_Provincia.setBorder(null);
		textField_Provincia.setBackground(new Color(255, 165, 0));
		textField_Provincia.setBounds(166, 201, 311, 21);
		textField_Iscrizione.add(textField_Provincia);
		
		JLabel Label_Citta = new JLabel("Città");
		Label_Citta.setForeground(Color.WHITE);
		Label_Citta.setBounds(93, 238, 34, 16);
		textField_Iscrizione.add(Label_Citta);
		
		JLabel lbIconaCittà = new JLabel("");
		lbIconaCittà.setBounds(139, 229, 25, 21);
		lbIconaCittà.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./strada.png")), 25, 25));
		textField_Iscrizione.add(lbIconaCittà);
		
		JSeparator separator_Password_1_1 = new JSeparator();
		separator_Password_1_1.setForeground(Color.WHITE);
		separator_Password_1_1.setBounds(139, 246, 134, 12);
		textField_Iscrizione.add(separator_Password_1_1);
		
		textField_Città = new JTextField();
		textField_Città.setText("");
		textField_Città.setSelectionColor(Color.LIGHT_GRAY);
		textField_Città.setForeground(Color.BLACK);
		textField_Città.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Città.setDisabledTextColor(Color.BLACK);
		textField_Città.setColumns(10);
		textField_Città.setBorder(null);
		textField_Città.setBackground(new Color(255, 165, 0));
		textField_Città.setBounds(166, 234, 107, 19);
		textField_Iscrizione.add(textField_Città);
		
		JLabel Label_CAP = new JLabel("CAP");
		Label_CAP.setForeground(Color.WHITE);
		Label_CAP.setBounds(310, 238, 39, 16);
		textField_Iscrizione.add(Label_CAP);
		
		JLabel lbIconaCap = new JLabel("");
		lbIconaCap.setBounds(361, 228, 23, 21);
		lbIconaCap.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./strada.png")), 25, 25));
		textField_Iscrizione.add(lbIconaCap);
		
		JSeparator separator_Password_1_1_1 = new JSeparator();
		separator_Password_1_1_1.setForeground(Color.WHITE);
		separator_Password_1_1_1.setBounds(361, 246, 126, 12);
		textField_Iscrizione.add(separator_Password_1_1_1);

		textField_Cap = new JTextField();
		textField_Cap.setText("");
		textField_Cap.setSelectionColor(Color.LIGHT_GRAY);
		textField_Cap.setForeground(Color.BLACK);
		textField_Cap.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Cap.setDisabledTextColor(Color.BLACK);
		textField_Cap.setColumns(10);
		textField_Cap.setBorder(null);
		textField_Cap.setBackground(new Color(255, 165, 0));
		textField_Cap.setBounds(386, 233, 101, 16);
		textField_Iscrizione.add(textField_Cap);
		
		JLabel Label_NomeVia = new JLabel("Nome via");
		Label_NomeVia.setForeground(Color.WHITE);
		Label_NomeVia.setBounds(66, 266, 61, 16);
		textField_Iscrizione.add(Label_NomeVia);
		
		JLabel lbIconaNomeVia = new JLabel("");
		lbIconaNomeVia.setBounds(139, 266, 25, 16);
		lbIconaNomeVia.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./strada.png")), 25, 25));
		textField_Iscrizione.add(lbIconaNomeVia);
		
		JSeparator separator_Password_1_1_2 = new JSeparator();
		separator_Password_1_1_2.setForeground(Color.WHITE);
		separator_Password_1_1_2.setBounds(139, 280, 134, 21);
		textField_Iscrizione.add(separator_Password_1_1_2);
		
		textField_NomeVia = new JTextField();
		textField_NomeVia.setText("");
		textField_NomeVia.setSelectionColor(Color.LIGHT_GRAY);
		textField_NomeVia.setForeground(Color.BLACK);
		textField_NomeVia.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_NomeVia.setDisabledTextColor(Color.BLACK);
		textField_NomeVia.setColumns(10);
		textField_NomeVia.setBorder(null);
		textField_NomeVia.setBackground(new Color(255, 165, 0));
		textField_NomeVia.setBounds(166, 262, 107, 20);
		textField_Iscrizione.add(textField_NomeVia);
		
		JLabel Label_NumCivico = new JLabel("N° Civico");
		Label_NumCivico.setForeground(Color.WHITE);
		Label_NumCivico.setBounds(295, 266, 61, 21);
		textField_Iscrizione.add(Label_NumCivico);
		
		JLabel lbIconaN_Civico = new JLabel("");
		lbIconaN_Civico.setBounds(361, 261, 23, 26);
		lbIconaN_Civico.setIcon(ctrl.scaleImageIcon(new ImageIcon(Registrazioni.class.getResource("/Iscrizione./strada.png")), 25, 25));
		textField_Iscrizione.add(lbIconaN_Civico);
		
		JSeparator separator_Password_1_1_1_1 = new JSeparator();
		separator_Password_1_1_1_1.setForeground(Color.WHITE);
		separator_Password_1_1_1_1.setBounds(361, 280, 126, 12);
		textField_Iscrizione.add(separator_Password_1_1_1_1);
		
		textField_N_Civico = new JTextField();
		textField_N_Civico.setText("");
		textField_N_Civico.setSelectionColor(Color.LIGHT_GRAY);
		textField_N_Civico.setForeground(Color.BLACK);
		textField_N_Civico.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_N_Civico.setDisabledTextColor(Color.BLACK);
		textField_N_Civico.setColumns(10);
		textField_N_Civico.setBorder(null);
		textField_N_Civico.setBackground(new Color(255, 165, 0));
		textField_N_Civico.setBounds(386, 268, 101, 14);
		textField_Iscrizione.add(textField_N_Civico);
		
		Button_Iscriviti = new JButton("Iscriviti");
		Button_Iscriviti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Button_Iscriviti.setBounds(218, 313, 187, 29);
		Button_Iscriviti.setForeground(new  Color(255, 165, 0));
		Button_Iscriviti.setToolTipText("Iscriviti");
		textField_Iscrizione.add(Button_Iscriviti);
		Button_Iscriviti.addActionListener(this);
	}

	 @Override 
		public void actionPerformed(ActionEvent e) {   
			if(e.getSource().equals(Button_Iscriviti)) {
				String nome=textField_Nome.getText();
				String cognome=textField_Cognome.getText();
				String email=textField_Email.getText();
				String numeroTelefonico=textField_NumTelefonico.getText();
				String password=textField_Password.getText();
				String provincia=textField_Provincia.getText();
				String citta=textField_Città.getText();
				String Cap=textField_Cap.getText();
				String nomeVia=textField_NomeVia.getText();
				int numCivico = 0;
				
			     Validazioni validazioni = new Validazioni();
			     validazioni.emailObbligatoria(email, "Inserisci una email", "La email inserita non è valida");
			     validazioni.provinciaObbligatoria(provincia, "Inserisci una provincia", "La provincia inserita non è valida[2 caratteri]");
			     validazioni.capObbligatorio(Cap, "Inserisci un CAP", "Il CAP inserito non è valido[5 caratteri]");
		         validazioni.numeroCivicoObbligatorio(Integer.toString(numCivico), "Inserisci il numero civico", "Il numero Civico inserita non è valida[Inserire solo valori numerici]");
			     validazioni.nomeViaObbligatoria(nomeVia, "Inserisci una via", "La via inserita non è valida");
			     validazioni.cittaObbligatoria(citta, "Inserisci una citta", "La citta inserita non è valida");
			     validazioni.passwordObbligatoria(password, "Inserisci una password", "La password inserita non è valida[Almeno una lettera maiuscola,Almeno una lettera minuscola,Almeno una cifra,Almeno un carattere speciale,Lunghezza minima 8]");
			     validazioni.numeroTelefonicoObbligatoria(numeroTelefonico, "Inserisci un numero di telefono", "Il numero di telefono inserito non è valido[8 valori]");
			     validazioni.nomeObbligatoria(nome, "Inserisci un nome", "Il nome inserito non è valido");
			     validazioni.cognomeObbligatoria(cognome, "Inserisci un cognome", "Il cognome inserito non è valido");

			     if (validazioni.valido()) {
			    	numCivico=Integer.parseInt(textField_N_Civico.getText().toString());
	      	        ctrl.effettuaRegistrazione(nome, cognome, email, password,  numeroTelefonico, nomeVia, numCivico, Cap, citta, provincia);  
			    	if(ctrl.effettuaRegistrazione(nome, cognome, email, password,  numeroTelefonico, nomeVia, numCivico, Cap, citta, provincia)==false) {
					     ctrl.VisualizzazioneAvvisi(Arrays.asList("Utente è stato registrato con successo"));
			    		
				    }  else {
     				     ctrl.VisualizzazioneAvvisi(Arrays.asList("Utente già presente")); 
				    	 ctrl.visualizzazioneLogin();

				     }
			    }
			     else {
			    	 ctrl.VisualizzazioneAvvisi(validazioni.getMessaggiErrore());

			    }	
		   }
	 }
}
	 

	
		     