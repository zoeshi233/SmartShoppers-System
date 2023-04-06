package work;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UserProfile {

	public JFrame frame;
	private JTextField EmailTxt;
	private JPasswordField passwordTxt;
	private JTextField usernameTxt;
	private JTextField SavedStoreTxt;
	private int frameY;
	private int frameX;
	public String oldUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile window = new UserProfile();
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
	public UserProfile() {
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel sideBar = new JPanel();
		sideBar.setBorder(null);
		sideBar.setBackground(new Color(255, 69, 0));
		sideBar.setBounds(0, 0, 230, 600);
		frame.getContentPane().add(sideBar);
		sideBar.setLayout(null);
		
		JButton logo = new JButton("SmartShoppers");
		logo.setFont(new Font("Verdana", Font.BOLD, 20));
		logo.setBounds(20, 261, 188, 63);
		logo.setForeground(Color.WHITE);
		logo.setBorder(null);
		sideBar.add(logo);
		
		JButton backButton = new JButton("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Home h = new Home();
				h.frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setForeground(Color.WHITE);
			}
		});
		backButton.setBounds(22, 528, 84, 37);
		sideBar.add(backButton);
		
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Verdana", Font.BOLD, 15));
		backButton.setBorder(null);
		
		JPanel username = new JPanel();
		username.setLayout(null);
		username.setForeground(Color.WHITE);
		username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		username.setBackground(Color.WHITE);
		username.setBounds(397, 65, 308, 55);
		frame.getContentPane().add(username);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(0, 0, 308, 53);
		username.add(usernameTxt);
		usernameTxt.setText(Home.u.name);
		usernameTxt.setForeground(Color.GRAY);
		usernameTxt.setFont(new Font("Arial", Font.PLAIN, 15));
		usernameTxt.setColumns(22);
		usernameTxt.setBorder(null);
		usernameTxt.setBackground(Color.WHITE);
		
		JPanel email = new JPanel();
		email.setForeground(Color.WHITE);
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		email.setBackground(Color.WHITE);
		email.setBounds(397, 143, 308, 55);
		frame.getContentPane().add(email);
		email.setLayout(null);
		
		EmailTxt = new JTextField();
		EmailTxt.setBounds(0, 0, 308, 53);
		email.add(EmailTxt);
		EmailTxt.setText(Home.u.email);
		EmailTxt.setForeground(Color.GRAY);
		EmailTxt.setFont(new Font("Arial", Font.PLAIN, 15));
		EmailTxt.setColumns(22);
		EmailTxt.setBorder(null);
		EmailTxt.setBackground(Color.WHITE);
		
		JPanel password = new JPanel();
		password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		password.setBackground(Color.WHITE);
		password.setBounds(397, 220, 308, 55);
		frame.getContentPane().add(password);
		password.setLayout(new GridLayout(0, 1, 0, 0));
		
		passwordTxt = new JPasswordField();
		password.add(passwordTxt);
		passwordTxt.setToolTipText("");
		passwordTxt.setText(Home.u.password);
		passwordTxt.setForeground(Color.GRAY);
		passwordTxt.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordTxt.setEchoChar('●');
		passwordTxt.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		passwordTxt.setColumns(20);
		passwordTxt.setBorder(null);
		passwordTxt.setBackground(Color.WHITE);
		
		JPanel SavedStore = new JPanel();
		SavedStore.setLayout(null);
		SavedStore.setForeground(Color.WHITE);
		SavedStore.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		SavedStore.setBackground(Color.WHITE);
		SavedStore.setBounds(397, 302, 308, 55);
		frame.getContentPane().add(SavedStore);
		
		SavedStoreTxt = new JTextField();
		SavedStoreTxt.setBounds(0, 0, 308, 53);
		SavedStore.add(SavedStoreTxt);
		SavedStoreTxt.setText(Home.u.getStore());
		SavedStoreTxt.setForeground(Color.GRAY);
		SavedStoreTxt.setFont(new Font("Arial", Font.PLAIN, 15));
		SavedStoreTxt.setColumns(22);
		SavedStoreTxt.setBorder(null);
		SavedStoreTxt.setBackground(Color.WHITE);
		
		usernameTxt.setEditable(false);
		EmailTxt.setEditable(false);
		passwordTxt.setEditable(false);
		SavedStoreTxt.setEditable(false);
		
		oldUserName = usernameTxt.getText();
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameTxt.setEditable(true);
				EmailTxt.setEditable(true);
				passwordTxt.setEditable(true);
				if(Home.u.userType.equals("Manager")) {
					SavedStoreTxt.setEditable(false);
				}
				else {
					SavedStoreTxt.setEditable(true);
				}
				
				JOptionPane.showMessageDialog(frame, "Fields are editable now!");
			}
		});
		btnEdit.setOpaque(true);
		btnEdit.setBackground(new Color(255, 69, 0));
		btnEdit.setBounds(356, 408, 143, 55);
		frame.getContentPane().add(btnEdit);
		btnEdit.setVerticalTextPosition(SwingConstants.TOP);
		btnEdit.setMargin(new Insets(2, 2, 2, 2));
		btnEdit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Verdana", Font.BOLD, 18));
		btnEdit.setBorder(null);
		
		JButton deletionButton = new JButton("Request Deletion");
		deletionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deletionButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(JOptionPane.showConfirmDialog(null, "Are you confimed to delete this account?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						String path = "//Users//shuyi//eecs2030//3311project//src//res//user.csv";
						Maintain maintain = new Maintain();

						maintain.loadUser();
						int indexToRemove = -1;
						for(User u : maintain.users) {
							if(u.getName().equals(Home.u.getName())) {
								indexToRemove = maintain.users.indexOf(u);
							}
						}
						if(indexToRemove >= 0) {
							maintain.users.remove(indexToRemove);
						}
						//maintain.users.remove(Home.u);
						maintain.updateUser();
						Home.u = null;
						JOptionPane.showMessageDialog(frame, "Account deleted!");
						frame.dispose();
						Login lg = new Login();
						lg.frame.setVisible(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		deletionButton.setBounds(356, 487, 308, 55);
		frame.getContentPane().add(deletionButton);
		deletionButton.setOpaque(true);
		deletionButton.setBackground(new Color(255, 0, 0));
		deletionButton.setVerticalTextPosition(SwingConstants.TOP);
		deletionButton.setMargin(new Insets(2, 2, 2, 2));
		deletionButton.setHorizontalTextPosition(SwingConstants.CENTER);
		deletionButton.setForeground(Color.WHITE);
		deletionButton.setFont(new Font("Verdana", Font.BOLD, 18));
		deletionButton.setBorder(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(266, 65, 94, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEmailAddress.setBounds(266, 143, 119, 55);
		frame.getContentPane().add(lblEmailAddress);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPassword.setBounds(266, 220, 94, 55);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblSavedStore = new JLabel("Saved store");
		lblSavedStore.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSavedStore.setBounds(266, 302, 104, 55);
		frame.getContentPane().add(lblSavedStore);
		
		JLabel escape = new JLabel("✕");
		escape.setHorizontalAlignment(SwingConstants.CENTER);
		escape.setBounds(757, 6, 37, 33);
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
		
		JButton SaveButton = new JButton("Save");
		SaveButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameTxt.setEditable(false);
				EmailTxt.setEditable(false);
				passwordTxt.setEditable(false);
				SavedStoreTxt.setEditable(false);
				
			
				try {
					String path = "//Users//shuyi//eecs2030//3311project//src//res//user.csv";
					Maintain maintain = new Maintain();

					maintain.loadUser();
					
					for(User u : maintain.users) {
						if(u.getName().equals(oldUserName)) {
							if(u.isDuplicate(usernameTxt.getText(), maintain.users) == -1 || oldUserName.equals(usernameTxt.getText())) {
								u.setName(usernameTxt.getText());
								oldUserName = u.getName();
								JOptionPane.showMessageDialog(frame, "Changes saved!");
								
							}
							else {
								JOptionPane.showMessageDialog(frame, "Edit username failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
							}
							usernameTxt.setText(oldUserName);
							u.setEmail(EmailTxt.getText());
							u.setPassword(passwordTxt.getText());
							u.setStore(SavedStoreTxt.getText());
							
							Home.u = u;
							maintain.updateUser();
							
						}
					}
					
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		SaveButton.setVerticalTextPosition(SwingConstants.TOP);
		SaveButton.setOpaque(true);
		SaveButton.setMargin(new Insets(2, 2, 2, 2));
		SaveButton.setHorizontalTextPosition(SwingConstants.CENTER);
		SaveButton.setForeground(Color.WHITE);
		SaveButton.setFont(new Font("Verdana", Font.BOLD, 18));
		SaveButton.setBorder(null);
		SaveButton.setBackground(new Color(255, 69, 0));
		SaveButton.setBounds(521, 408, 143, 55);
		frame.getContentPane().add(SaveButton);
		frame.setUndecorated(true);
	}
}
