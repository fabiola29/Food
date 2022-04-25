package GuiFood;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import Classi.Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;


public  class Login extends JFrame implements ActionListener,MouseListener,KeyListener{
	private static final long serialVersionUID = 1L;
	private JPasswordField textField_Password;
	private JTextField textField_Email;
    private Controller ctrl;
    
    private JButton Button_Accedi;
    private JButton Button_Registrazione;
    private JButton Button_HaiDimenticatoLaPassword;

	public Login(Controller ctrl) {
		setTitle("Login");
		this.getContentPane().setBackground(new Color(255, 165, 0));
		this.setResizable(false);
		this.setBounds(100, 100, 747, 504);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		setSize(new Dimension(744, 503));
		this.ctrl=ctrl;
			
		JLabel Label_Food = new JLabel("Food");
		Label_Food.setForeground(new Color(255, 255, 255));
		Label_Food.setFont(new Font("Lucida Grande", Font.BOLD, 35));
		Label_Food.setBounds(621, 64, 92, 63);
		this.getContentPane().add(Label_Food);
		
		JLabel Label_Email = new JLabel("E-mail");
		Label_Email.setForeground(new Color(255, 255, 255));
		Label_Email.setBounds(593, 162, 61, 16);
		this.getContentPane().add(Label_Email);

		
		JLabel lblIconaEmail = new JLabel("");
		lblIconaEmail.setBounds(593, 181, 21, 20);
		getContentPane().add(lblIconaEmail);
		lblIconaEmail.setIcon(ctrl.scaleImageIcon(new ImageIcon(Login.class.getResource("/Accesso./email.png")), 15, 15));
		
		JSeparator separator_email = new JSeparator();
		separator_email.setForeground(Color.WHITE);
		separator_email.setBounds(593, 196, 138, 12);
		this.getContentPane().add(separator_email);
			
		textField_Email = new JTextField();		
		textField_Email.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    	textField_Email.setSelectionColor(null);
		textField_Email.setDisabledTextColor(new Color(255, 140, 0));
		textField_Email.setForeground(Color.BLACK);
		textField_Email.setText("Inserisci la tua email");
		textField_Email.setBackground(new Color(255, 165, 0));
		textField_Email.setBorder(null);
		textField_Email.setBounds(613, 179, 118, 22);
	    textField_Email.addMouseListener((MouseListener) this);
	    textField_Email.addKeyListener((KeyListener) this);
		this.getContentPane().add(textField_Email);
			
		JLabel Label_Password = new JLabel("Password");
		Label_Password.setForeground(new Color(255, 255, 255));
		Label_Password.setBounds(593, 220, 61, 16);
		this.getContentPane().add(Label_Password);
		
		textField_Password = new JPasswordField();
		textField_Password.setForeground(Color.BLACK);
		textField_Password.setBackground(new Color(255, 165, 0));
		textField_Password.setBorder(null);
		textField_Password.setBounds(613, 237, 118, 22);
		textField_Password.addMouseListener((MouseListener) this);

		this.getContentPane().add(textField_Password);
		
		JLabel lblIconaPassword = new JLabel("");
		lblIconaPassword.setBounds(593, 240, 21, 20);
		getContentPane().add(lblIconaPassword);
		lblIconaPassword.setIcon(ctrl.scaleImageIcon(new ImageIcon(Login.class.getResource("/Accesso./Password.png")), 15, 15));
		
		JSeparator separator_password = new JSeparator();
		separator_password.setForeground(Color.WHITE);
		separator_password.setBounds(593, 254, 138, 12);
		this.getContentPane().add(separator_password);
		
		Button_Accedi = new JButton("Accedi!");
		Button_Accedi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Button_Accedi.setFocusable(false);
		Button_Accedi.setToolTipText("Accedi");
		Button_Accedi.setForeground(new  Color(255, 165, 0));
		Button_Accedi.setBounds(583, 291, 158, 29);
		this.getContentPane().add(Button_Accedi);
		Button_Accedi.addActionListener(this);

		Button_HaiDimenticatoLaPassword = new JButton("Password dimenticata?");
		Button_HaiDimenticatoLaPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		Button_HaiDimenticatoLaPassword.setBorder(null);
		Button_HaiDimenticatoLaPassword.setForeground(Color.WHITE);
		Button_HaiDimenticatoLaPassword.setBounds(583, 313, 158, 29);
		this.getContentPane().add(Button_HaiDimenticatoLaPassword);
		Button_HaiDimenticatoLaPassword.addActionListener(this);

		JSeparator separator_HaiDimenticatoLaPassword = new JSeparator();
		separator_HaiDimenticatoLaPassword.setForeground(new Color(255, 255, 255));
		separator_HaiDimenticatoLaPassword.setBounds(593, 330, 138, 12);
		this.getContentPane().add(separator_HaiDimenticatoLaPassword);
		
		Button_Registrazione = new JButton("Registrati!");
		Button_Registrazione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Button_Registrazione.setFocusable(false);
		Button_Registrazione.setToolTipText("Registrati");
        Button_Registrazione.setForeground(new  Color(255, 165, 0));
		Button_Registrazione.setBounds(583, 354, 158, 29);
		this.getContentPane().add(Button_Registrazione);
		Button_Registrazione.addActionListener(this);
	
	    JPanel panel = new JPanel();
		panel.setBounds(0, 0, 581, 482);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIconaLogin = new JLabel("");
		lblIconaLogin.setIcon(new ImageIcon(Login.class.getResource("/Accesso./Accesso.png")));
		lblIconaLogin.setBounds(0, -19, 581, 529);
		panel.add(lblIconaLogin);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(Button_HaiDimenticatoLaPassword))
			{
				ctrl.visualizzazionePwdDimenticata();
			}
			else if(e.getSource().equals(Button_Registrazione))
			{
				ctrl.visualizzazioneRegistrazione();

			}
			else if(e.getSource().equals(Button_Accedi))
			{
				String password=new String(textField_Password.getPassword());
				if(!password.equals("") && !textField_Email.getText().equals("")) {
					this.dispose();
					if(ctrl.effettuaAccesso(textField_Email.getText(), password)) {
						ctrl.VisualizzaSceltaRistorante();
					}
				}else {
					ctrl.VisualizzazioneAvvisi("Inserisci le tue credenziali");
				}
			}

     }
      
		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource().equals(textField_Email)) {
				if(textField_Email.getText().equalsIgnoreCase("Inserisci la tua email")) {
					textField_Email.setText("");
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource().equals(textField_Email)) {
				if(textField_Email.getText().equalsIgnoreCase("")) {
					textField_Email.setText("Inserisci la tua email");
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getSource().equals(textField_Email)) {
				if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE && textField_Email.getText().equals("")) {
					textField_Email.setText("Inserisci la tua email");
				}
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getSource().equals(textField_Email)) {
				if(textField_Email.getText().equals("Inserisci la tua email")) {
					textField_Email.setText("");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
     
}
