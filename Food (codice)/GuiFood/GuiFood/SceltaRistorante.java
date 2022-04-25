package GuiFood;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Classi.Ordine;
import Classi.Ristorante;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class SceltaRistorante extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
   
    private JComboBox <String> comboBox_sceltaRistorante;
    private JComboBox<String> comboBox_sceltaMezziRider;
    private HashMap<String, Ristorante> possibiliRistoranti = new HashMap<String, Ristorante>();
    private Controller ctrl;

	
    private JButton btnIndietro;
    private JButton Button_SceltaRistorante;
    
	public SceltaRistorante(Controller ctrl) {
		
		setUndecorated(true); setResizable(false); setTitle("Scelta ristorante"); setBounds(100, 100, 404, 207);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 140, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.ctrl=ctrl;

	
		JLabel lbl_sceltaRistorante = new JLabel("Da quale ristorante preferisci acquistare?");
		lbl_sceltaRistorante.setForeground(new Color(255, 255, 255));
		lbl_sceltaRistorante.setBackground(new Color(255, 255, 255));
		lbl_sceltaRistorante.setBounds(26, 47, 277, 16);
		contentPanel.add(lbl_sceltaRistorante);
		
		for(Ristorante r: ctrl.ottieniRistorantiDisponibili()) {
		possibiliRistoranti.put(r.getNome(), r);
		}
		comboBox_sceltaRistorante = new JComboBox(possibiliRistoranti.keySet().toArray());
		comboBox_sceltaRistorante.setBounds(83, 75, 242, 27);
		contentPanel.add(comboBox_sceltaRistorante);
		
		Button_SceltaRistorante = new JButton("Cerca");
		Button_SceltaRistorante.setForeground(new Color(255, 140, 0));
		Button_SceltaRistorante.setBounds(114, 172, 172, 29);
		Button_SceltaRistorante.setToolTipText("Registrati");
		contentPanel.add(Button_SceltaRistorante);
		Button_SceltaRistorante.addActionListener(this);

			
		btnIndietro = new JButton("");
		btnIndietro.setBounds(6, 6, 35, 29);
		contentPanel.add(btnIndietro);
		btnIndietro.setIcon(ctrl.scaleImageIcon(new ImageIcon(Ordine.class.getResource("/Fattura./indietro.png")), 25, 25));
				
		JLabel lbl_sceltaMezziRider = new JLabel("Quale mezzo di trasporto desideri?");
		lbl_sceltaMezziRider.setForeground(Color.WHITE);
		lbl_sceltaMezziRider.setBackground(Color.WHITE);
		lbl_sceltaMezziRider.setBounds(26, 101, 277, 16);
		contentPanel.add(lbl_sceltaMezziRider);
				
		String[] mezziDisponibili = {"Qualunque", "Moto", "Bicicletta"};
		comboBox_sceltaMezziRider = new JComboBox(mezziDisponibili);
		comboBox_sceltaMezziRider.setBounds(83, 129, 242, 27);
		comboBox_sceltaMezziRider.addActionListener(this);
		this.repaint();
		contentPanel.add(comboBox_sceltaMezziRider);
        btnIndietro.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Button_SceltaRistorante)){
			String nomeRistoranteScelto = (String) comboBox_sceltaRistorante.getSelectedItem();
			Ristorante ristoranteScelto = possibiliRistoranti.get(nomeRistoranteScelto);
			ctrl.setRistoranteScelto(ristoranteScelto);
			this.dispose();
			ctrl.visualizzazioneMenu();
		}else if(e.getSource().equals(btnIndietro)){
			this.dispose();
			ctrl.visualizzazioneLogin();
		}else if(e.getSource().equals(comboBox_sceltaMezziRider)) {
			String filter = (String) comboBox_sceltaMezziRider.getSelectedItem();
			if(!filter.equals("Qualunque")) {
				comboBox_sceltaRistorante.removeActionListener(this);
				comboBox_sceltaRistorante.removeAllItems();
				possibiliRistoranti.clear();
				if(filter.equals("Moto")) {
					for(Ristorante r: ctrl.ottieniRistorantiDisponibili()) {
						if(r.disponeDiMoto()) {
							possibiliRistoranti.put(r.getNome(), r);
							comboBox_sceltaRistorante.addItem(r.getNome());
						}
					}
				}else {// bicicletta
					for(Ristorante r: ctrl.ottieniRistorantiDisponibili()) {
						if(r.disponeDiBici()) {
							possibiliRistoranti.put(r.getNome(), r);
							comboBox_sceltaRistorante.addItem(r.getNome());
						}
					}
				}
				comboBox_sceltaRistorante.addActionListener(this);
			}
		}
	}
}