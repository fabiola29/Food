package GuiFood;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;


import Classi.Controller;
import Classi.Prodotto;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import java.awt.Cursor;

public class Menu extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private JPanel container;
	
    private JButton buttonQualunque;
    private JButton Button_antipasti;
	private JButton Button_primi;
	private JButton Button_secondi;
	private JButton Button_contorni;
	private JButton Button_dolci;
	private JButton Button_bevande;

	
	private JButton btnConcludiOrdine;
	private JButton Button_aggiungiOrdine;
	private JMenuItem Button_modificaProfilo;
	private JMenuItem Button_uscire;

    private Controller ctrl;

    private double min = -1;
    private double max = Double.MAX_VALUE;

	private JComboBox comboBoxFiltroPrezzo;
	private JComboBox<String> comboBox_quantità;

	private JComboBox<String> comboBox_scegliProdotto;
	
	private HashMap<Prodotto, Integer> quantitaProdotto;
	
	private String[][] nomiProdottoCategoria = new String[7][];
	private int category = 0;
	private Prodotto[][] prodottoCategoria = new Prodotto[7][];
	
	private String[] prezzo = {
		     "qualunque",
		     "0-5 €",
		     "5-10 €",
		     "10-20 €",
		     "20-75 €" };

	public Menu(Controller ctrl) {
        setTitle("Menù");
        this.getContentPane().setBackground(new Color(255, 140, 0));
        this.setResizable(false);
        this.setBounds(100, 100, 678, 504);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.ctrl=ctrl;
        
        
        this.setVisible(true);
                
        JPanel globalContainer = new JPanel();
        globalContainer.setBounds(0, 0, 560, 481);
        getContentPane().add(globalContainer);
        globalContainer.setLayout(null);
        
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(255, 140, 0));
        panelMenu.setBounds(0, 0, 560, 53);
        globalContainer.add(panelMenu);
        panelMenu.setLayout(null);
        
        JPanel panelBtn = new JPanel();
        panelBtn.setBackground(new Color(255, 140, 0));
        panelBtn.setBounds(0, 0, 748, 51);
        panelMenu.add(panelBtn);
        panelBtn.setLayout(null);
        
        buttonQualunque = new JButton("Qualunque");
        buttonQualunque.setForeground(new Color(255, 140, 0));
        buttonQualunque.setBounds(26, 364, 153, 29);
        buttonQualunque.addActionListener(this);
        panelBtn.add(buttonQualunque);
        
        Button_antipasti = new JButton("Antipasti");
        Button_antipasti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_antipasti.setForeground(new Color(255, 140, 0));
        Button_antipasti.setBackground(new Color(255, 255, 255));
        Button_antipasti.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        Button_antipasti.setActionCommand("Antipasti");
        Button_antipasti.setBounds(6, 12, 102, 39);
        Button_antipasti.setToolTipText("Antipasti");
		Button_antipasti.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./antipasti.png")), 30, 30));
        panelBtn.add(Button_antipasti);
        Button_antipasti.addActionListener(this);
        
        Button_primi = new JButton("Primi");
        Button_primi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_primi.setForeground(new Color(255, 140, 0));
        Button_primi.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        Button_primi.setActionCommand("Primi");
        Button_primi.setBounds(107, 12, 84, 39);
        Button_primi.setToolTipText("Primi");
		Button_primi.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./primi.png")), 30, 30));
        panelBtn.add(Button_primi);
        Button_primi.addActionListener(this);

        Button_secondi = new JButton("Secondi");
        Button_secondi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_secondi.setForeground(new Color(255, 140, 0));
        Button_secondi.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        Button_secondi.setActionCommand("Secondi");
        Button_secondi.setBounds(189, 12, 96, 39);
        Button_secondi.setToolTipText("Secondi");
		Button_secondi.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./secondi.png")), 30, 30));
        panelBtn.add(Button_secondi);
        Button_secondi.addActionListener(this);

        Button_contorni = new JButton("contorni");
        Button_contorni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_contorni.setForeground(new Color(255, 140, 0));
        Button_contorni.setActionCommand("Contorini");
        Button_contorni.setBounds(284, 11, 96, 39);
        Button_contorni.setToolTipText("Contorini");
		Button_contorni.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./contorni.png")), 30, 30));
        panelBtn.add(Button_contorni);
        Button_contorni.addActionListener(this);
        
        Button_dolci = new JButton("dolci");
        Button_dolci.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_dolci.setForeground(new Color(255, 140, 0));
        Button_dolci.setActionCommand("Dolci");
        Button_dolci.setBounds(379, 11, 84, 39);
        Button_dolci.setToolTipText("Dolci");
		Button_dolci.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./dolci.png")), 30, 30));
        panelBtn.add(Button_dolci);
        Button_dolci.addActionListener(this);
        
        Button_bevande = new JButton("Bevande");
        Button_bevande.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Button_bevande.setForeground(new Color(255, 140, 0));
        Button_bevande.setActionCommand("Bevande");
        Button_bevande.setBounds(464, 11, 90, 39);
        Button_bevande.setToolTipText("Bevande");
		Button_bevande.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./bevande.png")), 30, 30));
        panelBtn.add(Button_bevande);
        Button_bevande.addActionListener(this);
        
        panelMenu.add(panelBtn);
        
        container = new JPanel();
        container.setBackground(new Color(255, 140, 0));
        container.setBounds(0, 50, 560, 431);
        globalContainer.add(container);
       
        globalContainer.add(panelMenu, BorderLayout.NORTH);
        globalContainer.add(container, BorderLayout.NORTH);
        container.setLayout(null);
        
        JPanel panel_prodotti = new JPanel();
        panel_prodotti.setBackground(new Color(255, 165, 0));
        panel_prodotti.setBounds(6, 47, 548, 272);
        container.add(panel_prodotti);
        panel_prodotti.setLayout(null);
        
        JSeparator separator_prezzo = new JSeparator();
        separator_prezzo.setForeground(new Color(255, 255, 255));
        separator_prezzo.setBounds(0, 153, 554, 12);
        panel_prodotti.add(separator_prezzo);
        
        JLabel Label_scegliProdotto = new JLabel("Scegli prodotto");
        Label_scegliProdotto.setForeground(new Color(255, 255, 255));
        Label_scegliProdotto.setBackground(new Color(255, 255, 255));
        Label_scegliProdotto.setBounds(28, 33, 109, 16);
        panel_prodotti.add(Label_scegliProdotto);


	this.quantitaProdotto = (HashMap<Prodotto, Integer>) ctrl.getProdottiDalRistoranteSelezionato().clone();
	int length = quantitaProdotto.size();
	this.prodottoCategoria[0] = new Prodotto[length];
	this.nomiProdottoCategoria[0] = new String[length]; 
	int i = 0;
	for(Prodotto p : quantitaProdotto.keySet()) {
		prodottoCategoria[0][i] = p;
		nomiProdottoCategoria[0][i] = p.getNome() + " " + "$" + p.getPrezzo();
		i++;
	}
	
   	String[] categoryName = {"qualunque", "antipasti", "primi", "secondi", "contorni", "dolci", "bevande"}; 
	for(int j=1; j<7; j++) {
		String filter = categoryName[j];
		int lengthCategory = numOfProductByCategory(j);
		prodottoCategoria[j] = new Prodotto[lengthCategory];
		nomiProdottoCategoria[j] = new String[lengthCategory];
		int z = 0; 
		for(Prodotto p : prodottoCategoria[0]) {
			if(p.getCategoria().equals(filter)) {
				prodottoCategoria[j][z] = p;
				nomiProdottoCategoria[j][z] = p.getNome() + " " + "$" + p.getPrezzo();
				z++;
			}
		}
	}
	
	comboBox_scegliProdotto = new JComboBox(nomiProdottoCategoria[0]);
	comboBox_scegliProdotto.setBackground(Color.WHITE);
	comboBox_scegliProdotto.addActionListener(this);
	comboBox_scegliProdotto.setBounds(167, 45, 229, 27);
	panel_prodotti.add(comboBox_scegliProdotto);
	
	JSeparator separator_sceltaProdotto = new JSeparator();
	separator_sceltaProdotto.setForeground(Color.WHITE);
	separator_sceltaProdotto.setBounds(0, 70, 554, 12);
	panel_prodotti.add(separator_sceltaProdotto);
	
	JLabel Label_quantità = new JLabel("Quantità");
	Label_quantità.setForeground(Color.WHITE);
	Label_quantità.setBackground(Color.WHITE);
	Label_quantità.setBounds(28, 118, 109, 16);
	panel_prodotti.add(Label_quantità);
	
	comboBox_quantità = new JComboBox();
        ////////////////////////////////////////
        ////// imposto la quantita di default //
        ////////////////////////////////////////
        int quantitaPrimoProdottoIndex = this.quantitaProdotto.get(this.prodottoCategoria[0][0]);
        String quantitaPrimoProdotto[] = new String[quantitaPrimoProdottoIndex];
        for(Integer j=1; j<=quantitaPrimoProdottoIndex; j++) {
        	quantitaPrimoProdotto[j-1] = j.toString();
        }
        for(String s : quantitaPrimoProdotto) {
        	comboBox_quantità.addItem(s);
        }
        comboBox_quantità.setBounds(167, 114, 229, 27);
        comboBox_quantità.addActionListener(this);
        panel_prodotti.add(comboBox_quantità);
        
        JLabel Label_prezzo = new JLabel("filtra per prezzo");
        Label_prezzo.setBounds(28, 200, 109, 16);
        panel_prodotti.add(Label_prezzo);
        Label_prezzo.setForeground(Color.WHITE);
        
        comboBoxFiltroPrezzo = new JComboBox(prezzo);
        comboBoxFiltroPrezzo.setBounds(167, 196, 229, 27);
        comboBoxFiltroPrezzo.addActionListener(this);
        comboBoxFiltroPrezzo.setSelectedIndex(0);
        panel_prodotti.add(comboBoxFiltroPrezzo);
        
        btnConcludiOrdine = new JButton("Concludi ordine");
        btnConcludiOrdine.setBounds(292, 364, 153, 29);
        container.add(btnConcludiOrdine);
        btnConcludiOrdine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConcludiOrdine.setForeground(new Color(255, 140, 0));
        btnConcludiOrdine.setToolTipText("Acquista");
        btnConcludiOrdine.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./carrello.png")), 25, 25));
        btnConcludiOrdine.addActionListener(this);
        
        Button_aggiungiOrdine = new JButton("Aggiungi all'ordine");
        Button_aggiungiOrdine.setToolTipText("Acquista");
        Button_aggiungiOrdine.setForeground(new Color(255, 140, 0));
        Button_aggiungiOrdine.setBounds(89, 364, 153, 29);
        Button_aggiungiOrdine.addActionListener(this);
        container.add(Button_aggiungiOrdine);
        Button_aggiungiOrdine.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./Aggiungi.png")), 15, 15));
        comboBoxFiltroPrezzo.setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 165, 0));
        panel.setBounds(557, 0, 121, 481);
        getContentPane().add(panel);
        panel.setLayout(null);
                
        JPanel panel_servizi = new JPanel();
        panel_servizi.setBounds(79, 6, 36, 32);
        panel.add(panel_servizi);
        panel_servizi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel_servizi.setOpaque(false);
        panel_servizi.setEnabled(false);
        panel_servizi.setFocusable(false);
        panel_servizi.setBackground(new Color(255, 165, 0));
                
        JMenuBar menuBar1 = new JMenuBar();
        panel_servizi.add(menuBar1);
        menuBar1.setToolTipText("Servizi");
        JMenu Servizi = new JMenu();
        menuBar1.add(Servizi);
        Servizi.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./Menu.png")), 18, 18));
        Servizi.addActionListener(this);
                
        Button_modificaProfilo = new JMenuItem("Modifica Profilo");
        Button_modificaProfilo.setForeground(new Color(255, 140, 0));
        Servizi.add(Button_modificaProfilo);
        Button_modificaProfilo.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./Modifica.png")), 20, 20));
        Button_modificaProfilo.addActionListener(this);
                        
        Button_uscire = new JMenuItem("Uscire");
        Button_uscire.setForeground(new Color(255, 140, 0));
        Servizi.add(Button_uscire);
        Button_uscire.setIcon(ctrl.scaleImageIcon(new ImageIcon(Menu.class.getResource("/Menu./Uscire.png")), 25, 25));
        Button_uscire.addActionListener(this);
                        
        JSeparator separator_Menu = new JSeparator();
        separator_Menu.setBounds(0, 39, 124, 12);
        panel.add(separator_Menu);
        separator_Menu.setForeground(new Color(255, 255, 255));
        
        JLabel foto = new JLabel("  Foto prodotto");
        foto.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        foto.setBounds(16, 202, 99, 56);
        panel.add(foto);
        
     
    }
    
     public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnConcludiOrdine))
			{
				this.dispose();
				ctrl.visualizzazioneFattura(); 
			}
			else if(e.getSource().equals(Button_modificaProfilo)) 
			{
				  ctrl.ModificaProfilo(); 
			}
		    else if(e.getSource().equals(Button_uscire)) 	
		    {
		       if(JOptionPane.showConfirmDialog(null,"sicuro di voler uscire?")==0) {
		    	     ctrl.visualizzazioneLogin(); 	
	           }
		    }
		    else if(e.getSource().equals(comboBox_scegliProdotto)) {
		    	int index = comboBox_scegliProdotto.getSelectedIndex();
		    	Prodotto prodottoSelezionato = this.prodottoCategoria[category][index];
		    	if(prodottoSelezionato.getPrezzo() >= min && prodottoSelezionato.getPrezzo() <= max) {
		    		comboBox_scegliProdotto.setBackground(Color.WHITE);
		    	}else {
		    		comboBox_scegliProdotto.setBackground(Color.RED);
		    	}
		    	int quantitaProdotto = this.quantitaProdotto.get(prodottoSelezionato);
		    	if(quantitaProdotto <= 0) {
		    		this.comboBox_quantità.removeAllItems();
		    		this.comboBox_quantità.addItem("prodotto non disponibile");
		    		this.Button_aggiungiOrdine.setEnabled(false);
		    		this.Button_aggiungiOrdine.setForeground(Color.DARK_GRAY);
		    	}else {
		    		this.Button_aggiungiOrdine.setEnabled(true);
		    		this.Button_aggiungiOrdine.setForeground(new Color(255, 140, 0));
		    		String[] disponibilita = new String[quantitaProdotto];
		    		for(Integer i=1; i<=quantitaProdotto; i++) {
		    			disponibilita[i-1] = i.toString();
		    		}
		    		comboBox_quantità.removeAllItems();
		    		for(String s : disponibilita) {
		    			comboBox_quantità.addItem(s);
		    		}
		    	}
		    }else if(e.getSource().equals(buttonQualunque)) {
		    	updateComboBoxProdotti();
		    	category = 0;
		    }else if(e.getSource().equals(Button_primi)) {
		    	updateComboBoxProdotti(2);
		    	category = 2;
		    }else if(e.getSource().equals(Button_secondi)) {
		    	updateComboBoxProdotti(3);
		    	category = 3;
		    }else if(e.getSource().equals(Button_antipasti)) {
		    	updateComboBoxProdotti(1);
		    	category = 1;
		    }else if(e.getSource().equals(Button_contorni)) {
		    	updateComboBoxProdotti(4);
		    	category = 4;
		    }else if(e.getSource().equals(Button_dolci)) {
		    	updateComboBoxProdotti(5);
		    	category = 5;
		    }else if(e.getSource().equals(Button_bevande)) {
		    	updateComboBoxProdotti(6);
		    	category = 6;
		    }else if(e.getSource().equals(Button_aggiungiOrdine)){
		    	int indexProdottoSelezionato = comboBox_scegliProdotto.getSelectedIndex();
		    	Prodotto prodottoSelezionato = prodottoCategoria[category][indexProdottoSelezionato];
		    	int quantitaDisponibile = quantitaProdotto.get(prodottoSelezionato);
		    	int quantitaProdottoSelezionato = comboBox_quantità.getSelectedIndex() + 1;
		    	quantitaProdotto.replace(prodottoSelezionato, quantitaDisponibile - quantitaProdottoSelezionato);
		    	ctrl.aggiungiProdottoAlCarrello(prodottoSelezionato, quantitaProdottoSelezionato);
		    	updateComboBoxProdotti(category);
		    }else if(e.getSource().equals(comboBoxFiltroPrezzo)) {
		    	int index = comboBoxFiltroPrezzo.getSelectedIndex();
		    	String filtro = this.prezzo[index];
		    	if(filtro.equals("qualuque")) {
		    		min = -1;
		    		max = Double.MAX_VALUE;
		    	}else if(filtro.equals("0-5 €")) {
		    		min = 0;
		    		max = 5;
		    	}else if(filtro.equals("5-10 €")) {
		    		min = 5;
		    		max = 10;
		    	}else if(filtro.equals("10-20 €")) {
		    		min = 10;
		    		max = 20;
		    	}else { // 20-75
		    		min = 20;
		    		max = 75;
		    	}
		    }
    }
     
    // 0 qualunque, 1 antipasti, 2 primi, 3 secondi, 4 contorni, 5 dolci, 6 bevande
    private int numOfProductByCategory(int categoryIndex) {
    	String[] categoryName = {"qualunque", "antipasti", "primi", "secondi", "contorni", "dolci", "bevande"}; 
    	int len = 0; 
    	String filter = categoryName[categoryIndex];
    	for(Prodotto p : prodottoCategoria[0]) {
    		if(p.getCategoria().equals(filter)) {
    			len++;
    		}
    	}
    	return len;
    }
    
    private void updateComboBoxProdotti(int indexCategory) {
    	comboBox_scegliProdotto.removeActionListener(this);
    	comboBox_scegliProdotto.removeAllItems();
    	comboBox_quantità.removeAllItems();
    	int len = nomiProdottoCategoria[indexCategory].length;
    	if(len == 0) {
    		comboBox_scegliProdotto.addItem("non disponibile");
    		Button_aggiungiOrdine.setEnabled(false);
    		this.Button_aggiungiOrdine.setForeground(Color.DARK_GRAY);
    		return;
    	}
   		this.Button_aggiungiOrdine.setEnabled(true);
   		this.Button_aggiungiOrdine.setForeground(new Color(255, 140, 0));
    	for(String s : nomiProdottoCategoria[indexCategory]) {
    		comboBox_scegliProdotto.addItem(s);
    	}
        int quantitaPrimoProdottoIndex = this.quantitaProdotto.get(this.prodottoCategoria[indexCategory][0]);
        String quantitaPrimoProdotto[] = new String[quantitaPrimoProdottoIndex];
        for(Integer j=1; j<=quantitaPrimoProdottoIndex; j++) {
        	quantitaPrimoProdotto[j-1] = j.toString();
        }
        for(String s : quantitaPrimoProdotto) {
        	comboBox_quantità.addItem(s);
        }
        comboBox_scegliProdotto.addActionListener(this);
    }
    
    private void updateComboBoxProdotti() {
    	this.updateComboBoxProdotti(0);
    }
    }
