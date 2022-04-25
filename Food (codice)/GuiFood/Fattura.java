package GuiFood;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import Classi.Controller;
import Classi.Ordine;
import Classi.Prodotto;
import Classi.Rider;
import Classi.Utente;

import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.JList;

import javax.swing.JScrollPane;

public class Fattura extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField textField_Nome;
    private JTextField textField_Cognome;
    private JTextField textField_Telefono;
    private JTextField textField_IndirizzoEmail;
    private JTextField textField_Provincia;
    private JTextField textField_Via;
    private JTextField textField_CAP;
    private String Annulla_cmd = "Annulla";
    private String EffettuaOrdine_cmd = "Effettua Ordine";
    private Controller ctrl;
    
    private Rider[] riderDisponibili;
    private String[] nomiRider; 


    private JButton btnAnnulla;
    private JButton btnEffettuaOrdine;

    private JComboBox<String> comboBox_Riders; 
	public Fattura(Controller ctrl){
    	
    	Utente utente = ctrl.ottieniUtente(); 

		setResizable(false);
		setTitle("Dettagli fattura");
		this.getContentPane().setBackground(new Color(255, 165, 0));
		this.setBounds(100, 100, 747, 504);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.ctrl=ctrl;
			
		JLabel Label_Fattura_1 = new JLabel("DETTAGLI DI FATTURAZIONE");
		Label_Fattura_1.setForeground(Color.WHITE);
		Label_Fattura_1.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		Label_Fattura_1.setBounds(37, 6, 507, 43);
		getContentPane().add(Label_Fattura_1);
			
		JLabel label_nome = new JLabel("Nome");
		label_nome.setForeground(Color.WHITE);
		label_nome.setBounds(6, 61, 61, 16);
		getContentPane().add(label_nome);
		
		JLabel lblIconaNome = new JLabel("");
		lblIconaNome.setBounds(6, 77, 21, 20);
		lblIconaNome.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./utente.png")), 15, 15));
		getContentPane().add(lblIconaNome);
		
		JSeparator separator_Nome = new JSeparator();
		separator_Nome.setForeground(Color.WHITE);
		separator_Nome.setBounds(6, 93, 178, 12);
		getContentPane().add(separator_Nome);
		
		textField_Nome = new JTextField(utente.getNome());
		textField_Nome.setSelectionColor(Color.LIGHT_GRAY);
		textField_Nome.setForeground(Color.BLACK);
		textField_Nome.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Nome.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_Nome.setColumns(10);
		textField_Nome.setBorder(null);
		textField_Nome.setBackground(new Color(255, 165, 0));
		textField_Nome.setBounds(26, 77, 158, 18);
		textField_Nome.setEditable(false);
		getContentPane().add(textField_Nome);
		
		JLabel label_cognome = new JLabel("Cognome");
		label_cognome.setForeground(Color.WHITE);
		label_cognome.setBounds(240, 61, 61, 16);
		getContentPane().add(label_cognome);
		
		JLabel lblconaCognome = new JLabel("");
		lblconaCognome.setBounds(240, 77, 21, 20);
		lblconaCognome.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./utente.png")), 15, 15));
		getContentPane().add(lblconaCognome);

		JSeparator separator_Cognome = new JSeparator();
		separator_Cognome.setForeground(Color.WHITE);
		separator_Cognome.setBounds(239, 93, 199, 12);
		getContentPane().add(separator_Cognome);
		
		textField_Cognome = new JTextField(utente.getCognome());
		textField_Cognome.setSelectionColor(Color.LIGHT_GRAY);
		textField_Cognome.setForeground(Color.BLACK);
		textField_Cognome.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Cognome.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_Cognome.setColumns(10);
		textField_Cognome.setBorder(null);
		textField_Cognome.setBackground(new Color(255, 165, 0));
		textField_Cognome.setBounds(260, 77, 178, 18);
		textField_Cognome.setEditable(false);
		getContentPane().add(textField_Cognome);
		
		JLabel lblVia = new JLabel("Via ");
		lblVia.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblVia.setForeground(Color.WHITE);
		lblVia.setBounds(6, 107, 89, 16);
		getContentPane().add(lblVia);
		
		JLabel lblconaVia = new JLabel("");
		lblconaVia.setBounds(6, 128, 26, 23);
		lblconaVia.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./strada.png")), 30, 30));
		getContentPane().add(lblconaVia);
		
		JSeparator separator_Via = new JSeparator();
		separator_Via.setForeground(Color.WHITE);
		separator_Via.setBounds(6, 146, 188, 12);
		getContentPane().add(separator_Via);
		
		Integer numCivico = utente.getIndirizzo().getNumeroCivico();
		textField_Via = new JTextField(utente.getIndirizzo().getNomeVia() + " " + numCivico.toString());
		textField_Via.setEditable(false);
		textField_Via.setSelectionColor(Color.LIGHT_GRAY);
		textField_Via.setForeground(Color.BLACK);
		textField_Via.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Via.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_Via.setColumns(10);
		textField_Via.setBorder(null);
		textField_Via.setBackground(new Color(255, 165, 0));
		textField_Via.setBounds(36, 133, 148, 18);
		getContentPane().add(textField_Via);
		
		JLabel label_CAP = new JLabel("CAP");
		label_CAP.setForeground(Color.WHITE);
		label_CAP.setBounds(240, 107, 49, 16);
		getContentPane().add(label_CAP);
		
		JLabel lblconaCap = new JLabel("");
		lblconaCap.setBounds(240, 127, 29, 23);
		lblconaCap.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./strada.png")), 30, 30));
		getContentPane().add(lblconaCap);
		
		JSeparator separator_Cap = new JSeparator();
		separator_Cap.setForeground(Color.WHITE);
		separator_Cap.setBounds(240, 146, 199, 11);
		getContentPane().add(separator_Cap);
		
		textField_CAP = new JTextField(utente.getIndirizzo().getCap());
		textField_CAP.setEditable(false);
		textField_CAP.setSelectionColor(Color.LIGHT_GRAY);
		textField_CAP.setForeground(Color.BLACK);
		textField_CAP.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_CAP.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_CAP.setColumns(10);
		textField_CAP.setBorder(null);
		textField_CAP.setBackground(new Color(255, 165, 0));
		textField_CAP.setBounds(270, 128, 168, 23);
		getContentPane().add(textField_CAP);
		
		JLabel label_provincia = new JLabel("Provincia");
		label_provincia.setForeground(Color.WHITE);
		label_provincia.setBounds(6, 170, 89, 16);
		getContentPane().add(label_provincia);
		
		JLabel lblconaProvincia = new JLabel("");
		lblconaProvincia.setBounds(6, 190, 26, 23);
		lblconaProvincia.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./strada.png")), 30, 30));
		getContentPane().add(lblconaProvincia);
		
		JSeparator Provincia = new JSeparator();
		Provincia.setForeground(Color.WHITE);
		Provincia.setBounds(6, 207, 188, 12);
		getContentPane().add(Provincia);
		
		textField_Provincia = new JTextField(utente.getIndirizzo().getProvincia());
		textField_Provincia.setEditable(false);
		textField_Provincia.setSelectionColor(Color.LIGHT_GRAY);
		textField_Provincia.setForeground(Color.BLACK);
		textField_Provincia.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Provincia.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_Provincia.setColumns(10);
		textField_Provincia.setBorder(null);
		textField_Provincia.setBackground(new Color(255, 165, 0));
		textField_Provincia.setBounds(36, 190, 158, 18);
		getContentPane().add(textField_Provincia);		
		
		JLabel label_telefono = new JLabel("Telefono");
		label_telefono.setForeground(Color.WHITE);
		label_telefono.setBounds(6, 231, 89, 16);
		getContentPane().add(label_telefono);
		
		JLabel lblconaTelefono = new JLabel("");
		lblconaTelefono.setBounds(6, 253, 21, 23);
		lblconaTelefono.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./cellulare.png")), 15, 15));
		getContentPane().add(lblconaTelefono);
		
		JSeparator separator_Telefono = new JSeparator();
		separator_Telefono.setForeground(Color.WHITE);
		separator_Telefono.setBounds(6, 270, 188, 12);
		getContentPane().add(separator_Telefono);
		
		textField_Telefono = new JTextField(utente.getNumeroTelefonico());
		textField_Telefono.setSelectionColor(Color.LIGHT_GRAY);
		textField_Telefono.setForeground(Color.BLACK);
		textField_Telefono.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Telefono.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_Telefono.setColumns(10);
		textField_Telefono.setBorder(null);
		textField_Telefono.setBackground(new Color(255, 165, 0));
		textField_Telefono.setBounds(26, 253, 168, 18);
		textField_Telefono.setEditable(false);
		getContentPane().add(textField_Telefono);
				
		JLabel label_indirizzoEmail = new JLabel("Indirizzo email");
		label_indirizzoEmail.setForeground(Color.WHITE);
		label_indirizzoEmail.setBounds(6, 293, 108, 16);
		getContentPane().add(label_indirizzoEmail);
		
		JLabel lblconaEmail = new JLabel("");
		lblconaEmail.setBounds(6, 306, 21, 33);
		lblconaEmail.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./email.png")), 15, 15));
		getContentPane().add(lblconaEmail);
		
		JSeparator separator_IndirizzoEmail = new JSeparator();
		separator_IndirizzoEmail.setForeground(Color.WHITE);
		separator_IndirizzoEmail.setBounds(1, 327, 193, 12);
		getContentPane().add(separator_IndirizzoEmail);
		
		textField_IndirizzoEmail = new JTextField(utente.getEmail());
		textField_IndirizzoEmail.setSelectionColor(Color.LIGHT_GRAY);
		textField_IndirizzoEmail.setForeground(Color.BLACK);
		textField_IndirizzoEmail.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_IndirizzoEmail.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_IndirizzoEmail.setColumns(10);
		textField_IndirizzoEmail.setBorder(null);
		textField_IndirizzoEmail.setBackground(new Color(255, 165, 0));
		textField_IndirizzoEmail.setBounds(26, 310, 168, 18);
		textField_IndirizzoEmail.setEditable(false);
		getContentPane().add(textField_IndirizzoEmail);
		
		JLabel label_riders = new JLabel("Riders");
		label_riders.setForeground(Color.WHITE);
		label_riders.setBounds(6, 359, 49, 16);
		getContentPane().add(label_riders);
			
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setForeground(new Color(255, 140, 0));
		panel.setBounds(450, 61, 288, 359);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Label_IlTuoOrdine = new JLabel("IL TUO ORDINE");
		Label_IlTuoOrdine.setBounds(88, 6, 100, 23);
		panel.add(Label_IlTuoOrdine);
		Label_IlTuoOrdine.setForeground(Color.WHITE);
		Label_IlTuoOrdine.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 51));
		panel_1.setBounds(6, 34, 276, 238);
		panel.add(panel_1);
		panel_1.setLayout(null);

		
		JLabel label_prodotto = new JLabel("PRODOTTO");
		label_prodotto.setForeground(Color.WHITE);
		label_prodotto.setBounds(0, 6, 85, 16);
		panel_1.add(label_prodotto);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 22, 276, 12);
		panel_1.add(separator_1);
		separator_1.setForeground(Color.WHITE);
		
		String[] prodottiNelCarrello = ottieniProdottiNelCarrello();
		JList list = new JList(prodottiNelCarrello);
		list.setBounds(10, 46, 253, 155);
		list.setBackground(new Color(255, 140, 0));
		panel_1.add(list);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 3, 3);
		panel_1.add(scrollPane);
		
		JLabel label_Totale = new JLabel("TOTALE");
		label_Totale.setForeground(Color.WHITE);
		label_Totale.setBounds(0, 213, 55, 16);
		panel_1.add(label_Totale);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(0, 200, 276, 12);
		panel_1.add(separator_2);
		
		btnEffettuaOrdine = new JButton("Effettua Ordine");
		btnEffettuaOrdine.addActionListener(this);
		btnEffettuaOrdine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEffettuaOrdine.setForeground(new Color(255, 165, 0));
		btnEffettuaOrdine.setBounds(143, 295, 139, 29);
		btnEffettuaOrdine.setToolTipText("Effettua Ordine");
		panel.add(btnEffettuaOrdine);
		btnEffettuaOrdine.setActionCommand(EffettuaOrdine_cmd);

		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(this);
		btnAnnulla.setToolTipText("Annulla");
		btnAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnnulla.setForeground(new  Color(255, 165, 0));
		btnAnnulla.setBounds(6, 295, 139, 29);
		panel.add(btnAnnulla);
		btnAnnulla.setActionCommand(Annulla_cmd);
		
		JLabel prezzo = new JLabel(totaleCarrello());
		prezzo.setBounds(209, 268, 53, 15);
		panel.add(prezzo);
		
		associaRider();
		
		comboBox_Riders = new JComboBox(nomiRider);
		comboBox_Riders.setBounds(3, 387, 199, 27);
		comboBox_Riders.setSelectedIndex(0);
		comboBox_Riders.addActionListener(this);
		getContentPane().add(comboBox_Riders);

	}

	private String[] ottieniProdottiNelCarrello() {
		String[] prodotti = new String[ctrl.ottieniCarrello().getQuantitaProdotto().size()];
		int i = 0;
		for(Prodotto p : ctrl.ottieniCarrello().getQuantitaProdotto().keySet()) {
			prodotti[i++] = p.getNome() + " " + p.getPrezzo(); 
		}
		return prodotti;
	}
	
	private String totaleCarrello() {
		Double totale = ctrl.ottieniCarrello().getTotale();
		return totale.toString();
	}

	public void actionPerformed(ActionEvent e) {
	    if(e.getSource().equals(btnAnnulla))
		{
	    	this.dispose();
	    	ctrl.svuotaCarrello();
		    ctrl.VisualizzaSceltaRistorante();
		}
		else if(e.getSource().equals(btnEffettuaOrdine))
		{
			ctrl.effettuaOrdine();
			JOptionPane.showMessageDialog(null, "Ordine effettuato con successo");
	    	this.dispose();
		    ctrl.VisualizzaSceltaRistorante();
	    }else if(e.getSource().equals(comboBox_Riders)) {
	    	Rider riderSelezionato = this.riderDisponibili[comboBox_Riders.getSelectedIndex()];
	    	ctrl.setRiderSelezionato(riderSelezionato);
	    }
     }
	
	private void associaRider() {
		ArrayList<Rider> riders = ctrl.ottieniRiderDelRistorante();
		int length = riders.size();
		this.riderDisponibili = new Rider[length];
		this.nomiRider = new String[length];
		int i = 0;
		for(Rider r : riders) {
			this.riderDisponibili[i] = r;
			this.nomiRider[i] = r.getNome();
			i++;
		}
	}
}
	
	
