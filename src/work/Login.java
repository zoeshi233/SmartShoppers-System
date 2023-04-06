package work;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	public JFrame frame;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private JTextField textField;
	private int frameX;
	private int frameY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setName("contentPane");
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
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel userName = new JPanel();
		userName.setBounds(40, 181, 308, 55);
		userName.setBackground(Color.WHITE);
		userName.setForeground(Color.WHITE);
		userName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		frame.getContentPane().add(userName);
		
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
					userNameTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userNameTxt.getText().equals("")) {
					userNameTxt.setText("Username");
					userNameTxt.setForeground(Color.GRAY);
				}
			}
		});
		userName.setLayout(new GridLayout(0, 1, 0, 0));
		userNameTxt.setFont(new Font("Arial", Font.PLAIN, 15));
		userNameTxt.setText("Username");
		userNameTxt.setBorder(null);
		userNameTxt.setBackground(Color.WHITE);
		userName.add(userNameTxt);
		userNameTxt.setColumns(22);
		
		
		JPanel password = new JPanel();
		password.setBounds(40, 264, 308, 55);
		password.setBackground(Color.WHITE);
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		frame.getContentPane().add(password);
		password.setLayout(new GridLayout(0, 1, 0, 0));
		
		passwordTxt = new JPasswordField();
		passwordTxt.setEchoChar((char) 0);
		passwordTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(passwordTxt.getText().equals("Password")) {
					passwordTxt.setEchoChar('●');
					passwordTxt.setText("");
					passwordTxt.setForeground(Color.BLACK);
				}
				else {
					passwordTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordTxt.getText().equals("")) {
					passwordTxt.setText("Password");
					passwordTxt.setEchoChar((char) 0);
					passwordTxt.setForeground(Color.GRAY);
				}
			}
		});
		passwordTxt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		passwordTxt.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordTxt.setText("Password");
		passwordTxt.setToolTipText("");
		passwordTxt.setColumns(20);
		passwordTxt.setBorder(null);
		passwordTxt.setBackground(Color.WHITE);
		passwordTxt.setForeground(Color.GRAY);
		password.add(passwordTxt);
		
		
		JPanel buttonPnl = new JPanel();
		buttonPnl.setBounds(40, 350, 308, 55);
		buttonPnl.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(buttonPnl);
		buttonPnl.setLayout(null);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(passwordTxt.getEchoChar() != '●' || userNameTxt.getText().equals("Username") || userNameTxt.getForeground() != Color.black || passwordTxt.getForeground() != Color.BLACK) {
					JOptionPane.showMessageDialog(frame, "Please fill out the username and password!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Maintain maintain = new Maintain();
						
						maintain.loadUser();
					
						User u = null;
						for(User i : maintain.users) {
							if(userNameTxt.getText().equals(i.getName()) && passwordTxt.getText().equals(i.getPassword())) {
								u = i;
							}
						}
						
							
						if(u != null) {
							JOptionPane.showMessageDialog(frame, "Log in successful!");
							frame.dispose();
							Home.u = u;
							Home s = new Home();
							s.u = u;
								
							s.frame.setVisible(true);
								
								
						}
						else {
							JOptionPane.showMessageDialog(frame, "Username or password is incorrect, please try again!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		loginButton.setBounds(6, 5, 296, 44);
		loginButton.setVerticalTextPosition(SwingConstants.TOP);
		loginButton.setForeground(Color.WHITE);
		loginButton.setMargin(new Insets(2, 2, 2, 2));
		loginButton.setHorizontalTextPosition(SwingConstants.CENTER);
		loginButton.setFont(new Font("Verdana", Font.BOLD, 18));
		loginButton.setBorder(null);
		buttonPnl.add(loginButton);
		
		JLabel escape = new JLabel("✕");
		escape.setBounds(372, 4, 22, 22);
		escape.setHorizontalAlignment(SwingConstants.CENTER);
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
		frame.getContentPane().add(escape);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(40, 425, 308, 22);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel signUpTxt = new JLabel("Not have an account yet? Click");
		signUpTxt.setBorder(null);
		signUpTxt.setBounds(21, 2, 199, 20);
		panel.add(signUpTxt);
		
		JButton signUp = new JButton("SignUp");
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Register rg = new Register();
				rg.frame.setVisible(true);
			}
		});
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signUp.setForeground(new Color(255, 69, 0));
			}
			public void mouseExited(MouseEvent e) {
				signUp.setForeground(new Color(0, 0, 255));
			}
		});
		signUp.setBorder(null);
		signUp.setForeground(new Color(0, 0, 255));
		signUp.setBounds(219, 2, 44, 20);
		panel.add(signUp);
		
		JLabel LoginLogo = new JLabel("SmartShoppers");
		LoginLogo.setBounds(40, 65, 308, 96);
		LoginLogo.setHorizontalAlignment(SwingConstants.CENTER);
		LoginLogo.setForeground(new Color(255, 69, 0));
		LoginLogo.setFont(new Font("Verdana", Font.BOLD, 30));
		frame.getContentPane().add(LoginLogo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(6, 4, 6, 5);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		frame.setBounds(100, 100, 400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
	}
}
