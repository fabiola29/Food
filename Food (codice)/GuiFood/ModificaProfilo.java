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
import javax.swing.JTextField;
import javax.swing.JSeparator;
import Classi.Controller;
import java.awt.Cursor;

public  class ModificaProfilo extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JTextField textField_NuovaPassword;
	private Controller ctrl;

	private JButton btnApplicaModifiche;
	
	public ModificaProfilo(Controller ctrl) {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("Modifica profilo");
		setResizable(false);
		setBounds(100, 100, 445, 214);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 165, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
        this.ctrl=ctrl;
		
		JLabel Label_NuovaPassword = new JLabel("Nuova password");
		Label_NuovaPassword.setForeground(Color.WHITE);
		Label_NuovaPassword.setBounds(35, 76, 109, 29);
		contentPanel.add(Label_NuovaPassword);
		
		JLabel lblIconaNuovaPassword = new JLabel("");
		lblIconaNuovaPassword.setBounds(156, 76, 21, 20);
		lblIconaNuovaPassword.setIcon(ctrl.scaleImageIcon(new ImageIcon(ModificaProfilo.class.getResource("/ModificaProfilo./Password.png")), 20, 20));
        contentPanel.add(lblIconaNuovaPassword);
		
		JSeparator separator_NuovaPassword = new JSeparator();
		separator_NuovaPassword.setForeground(Color.WHITE);
		separator_NuovaPassword.setBounds(156, 93, 263, 12);
		contentPanel.add(separator_NuovaPassword);
		
		textField_NuovaPassword = new JTextField();
		textField_NuovaPassword.setText("");
		textField_NuovaPassword.setSelectionColor(Color.LIGHT_GRAY);
		textField_NuovaPassword.setForeground(Color.BLACK);
		textField_NuovaPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_NuovaPassword.setDisabledTextColor(Color.BLACK);
		textField_NuovaPassword.setColumns(10);
		textField_NuovaPassword.setBorder(null);
		textField_NuovaPassword.setBackground(new Color(255, 165, 0));
		textField_NuovaPassword.setBounds(180, 74, 237, 20);
		contentPanel.add(textField_NuovaPassword);
		
		
		btnApplicaModifiche = new JButton("Applica Modifiche");
		btnApplicaModifiche.setToolTipText("Modifica");
		btnApplicaModifiche.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApplicaModifiche.setBounds(122, 137, 187, 29);
		btnApplicaModifiche.setForeground(new  Color(255, 165, 0));
		contentPanel.add(btnApplicaModifiche);
		
		JLabel lblNewLabel = new JLabel("Food");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewLabel.setBounds(173, 16, 74, 34);
		contentPanel.add(lblNewLabel);
		btnApplicaModifiche.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnApplicaModifiche))
        	{
				ctrl.visualizzazioneMenu();
			}		
	}
	
}
