package work;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.JButton;

public class Register extends JFrame {

	/**
	 * 
	 */
	JFrame frame;
	private JTextField userNameTxt;
	private JTextField emailTxt;
	private JPasswordField password1Txt;
	private JPasswordField password2Txt;
	private int frameX;
	private int frameY;
	private Image img_logo = new ImageIcon(Register.class.getResource("/res/shoppingcart.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	String[] userTypes = {"Customer", "Administrator"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				frameX = e.getXOnScreen() - frame.getX();
				frameY = e.getYOnScreen() - frame.getY();
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				frame.setLocation(e.getXOnScreen() - frameX, e.getYOnScreen() - frameY);
			}
		});
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setBounds(new Rectangle(0, 0, 600, 500));
		frame.getContentPane().setLayout(null);
		
		JComboBox<?> selectType = new JComboBox<Object>(userTypes);
		selectType.setSelectedItem(1);
		selectType.setBounds(466, 82, 186, 27);
		frame.getContentPane().add(selectType);
		selectType.setForeground(Color.BLACK);
		selectType.setBackground(Color.WHITE);
		selectType.setBorder(null);
		
		JPanel username = new JPanel();
		username.setBackground(Color.WHITE);
		username.setBounds(352, 140, 300, 45);
		username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		frame.getContentPane().add(username);
		username.setLayout(null);
		
		userNameTxt = new JTextField();
		userNameTxt.setForeground(Color.GRAY);
		userNameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(userNameTxt.getText().equals("Username")) {
					userNameTxt.setText("");
					userNameTxt.setForeground(Color.BLACK);
				}
				else {
					userNameTxt.setForeground(Color.BLACK);
					userNameTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userNameTxt.getText().equals("")) {
					userNameTxt.setText("Username");
					userNameTxt.setForeground(Color.GRAY);
				}
				else {
					userNameTxt.setForeground(Color.BLACK);
				}
			}
		});
		userNameTxt.setBorder(null);
		userNameTxt.setBounds(6, 5, 288, 34);
		userNameTxt.setText("Username");
		username.add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JPanel email = new JPanel();
		email.setBackground(Color.WHITE);
		email.setBounds(352, 197, 300, 45);
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		frame.getContentPane().add(email);
		email.setLayout(null);
		
		emailTxt = new JTextField();
		emailTxt.setForeground(Color.GRAY);
		emailTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(emailTxt.getText().equals("Email address")) {
					emailTxt.setText("");
					emailTxt.setForeground(Color.BLACK);
				}
				else {
					emailTxt.selectAll();
					emailTxt.setForeground(Color.BLACK);
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(emailTxt.getText().equals("")) {
					emailTxt.setText("Email address");
					emailTxt.setForeground(Color.GRAY);
				}
				else {
					emailTxt.setForeground(Color.BLACK);
				}
			}
		});
		emailTxt.setBorder(null);
		emailTxt.setBounds(6, 5, 288, 34);
		emailTxt.setText("Email address");
		email.add(emailTxt);
		emailTxt.setColumns(10);
		
		JPanel password1 = new JPanel();
		password1.setBackground(Color.WHITE);
		password1.setBounds(352, 254, 300, 45);
		password1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		frame.getContentPane().add(password1);
		password1.setLayout(null);
		
		password1Txt = new JPasswordField();
		password1Txt.setForeground(Color.GRAY);
		password1Txt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(password1Txt.getText().equals("Set password")) {
					password1Txt.setEchoChar('●');
					password1Txt.setText("");
					password1Txt.setForeground(Color.BLACK);
				}
				else {
					password1Txt.selectAll();
					password1Txt.setForeground(Color.BLACK);
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(password1Txt.getText().equals("")) {
					password1Txt.setText("Set password");
					password1Txt.setEchoChar((char) 0);
					password1Txt.setForeground(Color.GRAY);
				}
				else {
					password1Txt.setForeground(Color.BLACK);	
				}
			}
		});
		password1Txt.setEchoChar((char) 0);
		password1Txt.setText("Set password");
		password1Txt.setToolTipText("");
		password1Txt.setBorder(null);
		password1Txt.setBounds(6, 6, 288, 34);
		password1.add(password1Txt);
		
		JPanel password2 = new JPanel();
		password2.setBackground(Color.WHITE);
		password2.setBounds(352, 311, 300, 45);
		password2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		frame.getContentPane().add(password2);
		password2.setLayout(null);
		
		password2Txt = new JPasswordField();
		password2Txt.setForeground(Color.GRAY);
		password2Txt.setEchoChar((char) 0);
		password2Txt.setText("Confirm password");
		password2Txt.setBorder(null);
		password2Txt.setBounds(6, 5, 288, 34);
		password2.add(password2Txt);
		password2Txt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(password2Txt.getText().equals("Confirm password")) {
					password2Txt.setEchoChar('●');
					password2Txt.setText("");
					password2Txt.setForeground(Color.BLACK);
				}
				else {
					password2Txt.selectAll();
					password2Txt.setForeground(Color.BLACK);
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(password2Txt.getText().equals("")) {
					password2Txt.setText("Confirm password");
					password2Txt.setEchoChar((char) 0);
					password2Txt.setForeground(Color.GRAY);
				}
			}
		});
		
		JPanel register = new JPanel();
		register.setBounds(352, 392, 300, 45);
		register.setBorder(null);
		register.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(register);
		register.setLayout(null);
		
		JLabel registerButton = new JLabel("Create Account");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if(password1Txt.getEchoChar() != '●' || password2Txt.getEchoChar() != '●' ) {
//					JOptionPane.showMessageDialog(frame, "Please fill out the password fields!", "Warning", JOptionPane.WARNING_MESSAGE);
//				}
				if(userNameTxt.getText().equals("Username") || emailTxt.getText().equals("Email address") || userNameTxt.getText().equals("") || emailTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Please fill out the username and email address!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else if(password1Txt.getEchoChar() != '●' || password2Txt.getEchoChar() != '●' || password1Txt.getText().equals("") || password2Txt.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Please fill out all the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else if(!password2Txt.getText().equals(password1Txt.getText())) {
					JOptionPane.showMessageDialog(frame, "Confirm password is not matching!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
//					User u = new User();
//					u.createUser(userNameTxt.getText(), emailTxt.getText(), password1Txt.getText(), (String) selectType.getSelectedItem(), frame);
					try {
						Maintain maintain = new Maintain();
					
						maintain.loadUser();
						
						int newUser = 1;
						for(User u : maintain.users) {
							if(u.getName().equals(userNameTxt.getText())) {
								newUser = 0;
							}
						}
						if(newUser == 1) {
							User regUser = new User(userNameTxt.getText(), emailTxt.getText(), password1Txt.getText(), (String) selectType.getSelectedItem(), "");
							maintain.users.add(regUser);
							maintain.updateUser();
						
							frame.dispose();
							Login lg = new Login();
							lg.frame.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(frame, "Registration failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		registerButton.setFont(new Font("Verdana", Font.BOLD, 15));
		registerButton.setForeground(Color.WHITE);
		registerButton.setHorizontalAlignment(SwingConstants.CENTER);
		registerButton.setBounds(6, 0, 288, 45);
		registerButton.setBorder(null);
		register.add(registerButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 280, 500);
		panel.setBackground(new Color(255, 69, 0));
		panel.setBorder(null);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel logoTxt = new JLabel("SmartShoppers");
		logoTxt.setBounds(0, 172, 280, 54);
		logoTxt.setHorizontalAlignment(SwingConstants.CENTER);
		logoTxt.setFont(new Font("Verdana", Font.BOLD, 27));
		logoTxt.setForeground(Color.WHITE);
		logoTxt.setBorder(null);
		panel.add(logoTxt);
		
		JLabel logoPic = new JLabel("");
		logoPic.setHorizontalAlignment(SwingConstants.CENTER);
		logoPic.setBounds(0, 238, 280, 129);
		logoPic.setIcon(new ImageIcon(img_logo));
		panel.add(logoPic);
		
		JLabel escape = new JLabel("✕");
		escape.setBounds(668, 0, 52, 50);
		escape.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		escape.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you confimed to exit the application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					frame.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				escape.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				escape.setForeground(Color.DARK_GRAY);
			}
		});
		escape.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(escape);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(597, 465, 117, 29);
		frame.getContentPane().add(backButton);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you confirmed to go back? The information in the fields will not be saved.", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					frame.dispose();
					Login lg = new Login();
					lg.frame.setVisible(true);
				}
				
			}
		});
		backButton.setFont(new Font("Verdana", Font.BOLD, 14));
		backButton.setForeground(Color.BLUE);
		backButton.setBorder(null);
		
		
		
		frame.setBounds(100, 100, 720, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
