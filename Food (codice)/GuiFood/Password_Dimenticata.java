package GuiFood;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import Classi.Controller;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Cursor;

public class Password_Dimenticata extends JDialog implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_Email;
	private JPasswordField textField_Password;
	private Controller ctrl;

	private JButton cambiaButton; 

	public Password_Dimenticata(Controller ctrl) {
		setResizable(false);
		setTitle("Password Dimenticata");
		setBounds(100, 100, 549, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 165, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.ctrl = ctrl;
		
		if(ctrl.isLoggato()) {
			textField_Email.setText(ctrl.getEmail());
			textField_Email.setEditable(false);
		}
		
		JLabel Label_DimenticaPwd = new JLabel("Hai dimenticato la Password?");
		Label_DimenticaPwd.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		Label_DimenticaPwd.setForeground(new Color(255, 255, 255));
		Label_DimenticaPwd.setBounds(6, 6, 391, 20);
		contentPanel.add(Label_DimenticaPwd);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 26, 559, 12);
		contentPanel.add(separator);
		
		JLabel Label_Email = new JLabel("E-mail");
		Label_Email.setForeground(Color.WHITE);
		Label_Email.setBounds(67, 80, 55, 16);
		contentPanel.add(Label_Email);

		JSeparator separator_Email = new JSeparator();
		separator_Email.setForeground(Color.WHITE);
		separator_Email.setBounds(130, 97, 335, 12);
		contentPanel.add(separator_Email);
			
		textField_Email = new JTextField();
		textField_Email.setText("");
		textField_Email.setSelectionColor(Color.LIGHT_GRAY);
		textField_Email.setForeground(Color.BLACK);
		textField_Email.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		textField_Email.setDisabledTextColor(Color.BLACK);
		textField_Email.setColumns(10);
		textField_Email.setBorder(null);
		textField_Email.setBackground(new Color(255, 165, 0));
		textField_Email.setBounds(155, 79, 310, 20);
		contentPanel.add(textField_Email);
		textField_Email.addMouseListener((MouseListener) this);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(130, 80, 21, 20);
		lblNewLabel_1.setIcon(ctrl.scaleImageIcon(new ImageIcon(Password_Dimenticata.class.getResource("/PasswordDimenticata./email.png")), 15, 15));
		contentPanel.add(lblNewLabel_1);
		
		JLabel Label_NuovaPassword = new JLabel("Nuova Password");
	    Label_NuovaPassword.setForeground(Color.WHITE);
		Label_NuovaPassword.setBounds(17, 132, 115, 16);
	    contentPanel.add(Label_NuovaPassword);
		
		JSeparator separator_NuovaPassword = new JSeparator();
		separator_NuovaPassword.setForeground(Color.WHITE);
		separator_NuovaPassword.setBounds(130, 144, 335, 12);
		contentPanel.add(separator_NuovaPassword);
		
		JLabel lblIconaNuovaPassword = new JLabel("");
		lblIconaNuovaPassword.setBounds(130, 128, 21, 20);
		lblIconaNuovaPassword.setIcon(ctrl.scaleImageIcon(new ImageIcon(Password_Dimenticata.class.getResource("/PasswordDimenticata./Password.png")), 15, 15));
		contentPanel.add(lblIconaNuovaPassword);
		
		textField_Password = new JPasswordField();
	    textField_Password.setForeground(Color.BLACK);
	    textField_Password.setBorder(null);
	    textField_Password.setBackground(new Color(255, 165, 0));
		textField_Password.setBounds(155, 127, 160, 22);
		contentPanel.add(textField_Password);
		
	    JPanel buttonPane = new JPanel();
	    buttonPane.setBackground(new Color(255, 165, 0));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		cambiaButton = new JButton("cambia password");
		cambiaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cambiaButton.setForeground(new  Color(255, 165, 0));
        buttonPane.add(cambiaButton);
        cambiaButton.addActionListener(this);
		
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(cambiaButton)) {
				String password = new String(textField_Password.getPassword());
				this.dispose();
				ctrl.cambiaPassword(textField_Email.getText(),password);
				ctrl.VisualizzazioneAvvisi("Password modificata con successo");
			}

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}
