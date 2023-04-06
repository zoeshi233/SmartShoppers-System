package work;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModifyManager {

	public JFrame frame;
	private JTextField UsernameTxt;
	private JTextField emailTxt;
	private JButton btnUpdate;
	private JButton clearButton;
	private JButton btnDelete;
	private JTable table;
	DefaultTableModel model;
	private JTextField StoreTxt;
	private JPasswordField PasswordTxt;
	private JButton backButton;
	private int frameY;
	private int frameX;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyManager window = new ModifyManager();
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
	public ModifyManager() {
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
		frame.getContentPane().setFont(new Font("Verdana", Font.BOLD, 14));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		UsernameTxt = new JTextField();
		UsernameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(UsernameTxt.getText().equals("Username")) {
					UsernameTxt.setText("");
					UsernameTxt.setForeground(Color.BLACK);
				}
				else {
					UsernameTxt.setForeground(Color.BLACK);
					UsernameTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(UsernameTxt.getText().equals("")) {
					UsernameTxt.setText("Username");
					UsernameTxt.setForeground(Color.GRAY);
				}
				else {
					UsernameTxt.setForeground(Color.BLACK);
				}
			}
		});
		UsernameTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		UsernameTxt.setForeground(Color.GRAY);
		UsernameTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		UsernameTxt.setText("Username");
		UsernameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		UsernameTxt.setBackground(Color.WHITE);
		UsernameTxt.setBounds(39, 86, 284, 44);
		frame.getContentPane().add(UsernameTxt);
		UsernameTxt.setColumns(10);
		
		emailTxt = new JTextField();
		emailTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(emailTxt.getText().equals("Email")) {
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
					emailTxt.setText("Email");
					emailTxt.setForeground(Color.GRAY);
				}
				else {
					emailTxt.setForeground(Color.BLACK);
				}
			}
		});
		emailTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		emailTxt.setForeground(Color.GRAY);
		emailTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		emailTxt.setText("Email");
		emailTxt.setColumns(10);
		emailTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		emailTxt.setBackground(Color.WHITE);
		emailTxt.setBounds(39, 142, 284, 44);
		frame.getContentPane().add(emailTxt);
		
		StoreTxt = new JTextField();
		StoreTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(StoreTxt.getText().equals("Store")) {
					StoreTxt.setText("");
					StoreTxt.setForeground(Color.BLACK);
				}
				else {
					StoreTxt.selectAll();
					StoreTxt.setForeground(Color.BLACK);
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(StoreTxt.getText().equals("")) {
					StoreTxt.setText("Store");
					StoreTxt.setForeground(Color.GRAY);
				}
				else {
					StoreTxt.setForeground(Color.BLACK);
				}
			}
		});
		StoreTxt.setText("Store");
		StoreTxt.setForeground(Color.GRAY);
		StoreTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		StoreTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		StoreTxt.setColumns(10);
		StoreTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		StoreTxt.setBackground(Color.WHITE);
		StoreTxt.setBounds(39, 254, 284, 49);
		frame.getContentPane().add(StoreTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 69, 0)));
		scrollPane.setBounds(360, 51, 403, 398);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(245, 245, 245));
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				UsernameTxt.setText(model.getValueAt(i, 0).toString());
				UsernameTxt.setForeground(Color.BLACK);
				emailTxt.setText(model.getValueAt(i, 1).toString());
				emailTxt.setForeground(Color.BLACK);
				PasswordTxt.setText(model.getValueAt(i, 2).toString());
				PasswordTxt.setForeground(Color.BLACK);
				PasswordTxt.setEchoChar('●');
				StoreTxt.setText(model.getValueAt(i, 4).toString());
				StoreTxt.setForeground(Color.BLACK);
				
			}
		});
		scrollPane.setViewportView(table);
		table.setForeground(new Color(255, 69, 0));
		model = new DefaultTableModel();
		Object[] col = {"Username", "Email", "Password", "UserType", "Store"};
		final Object[] row = new Object[5];
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		try {
			Maintain maintain = new Maintain();

			maintain.loadUser();
			for(User u: maintain.users) {
				if(u.userType.equals("Manager")) {
					row[0] = u.name;
					row[1] = u.email;
					row[2] = u.password;
					row[3] = "Manager";
					row[4] = u.preference;
					model.addRow(row);
				}
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UsernameTxt.getText().equals("Username") 
						|| emailTxt.getText().equals("Email") 
						|| UsernameTxt.getText().equals("") 
						|| emailTxt.getText().equals("")
						|| PasswordTxt.getEchoChar() != '●'
						|| StoreTxt.getText().equals("") 
						|| StoreTxt.getText().equals("Store")) {
					JOptionPane.showMessageDialog(frame, "Please fill out the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
					
				}
				else {
					row[0] = UsernameTxt.getText();
					row[1] = emailTxt.getText();
					row[2] = PasswordTxt.getText();
					row[3] = "Manager";
					row[4] = StoreTxt.getText();
//					Admin u = new Admin();
//					u.addManager(row, frame, model);
					try {
						Maintain maintain = new Maintain();
						
						maintain.loadUser();
						int newUser = 1;
						for(User u : maintain.users) {
							if(u.getName().equals(row[0])) {
								newUser = 0;
							}
						}
						if(newUser == 1) {
							Admin mg = new Admin();
							mg.addManager(row[0].toString(), row[1].toString(), row[2].toString(), row[4].toString());
//							maintain.users.add(mg);
//							maintain.updateUser();
							model.addRow(row);
						}
						else {
							JOptionPane.showMessageDialog(frame, "Registration failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					} 
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
				
				
			}
		});
		
		addButton.setFont(new Font("Verdana", Font.BOLD, 14));
		addButton.setForeground(Color.WHITE);
		addButton.setOpaque(true);
		addButton.setBorder(null);
		addButton.setBackground(new Color(255, 69, 0));
		addButton.setBounds(38, 336, 137, 44);
		frame.getContentPane().add(addButton);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Please select a row before updating!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(UsernameTxt.getText().equals("Username") 
							|| emailTxt.getText().equals("Email") 
							|| UsernameTxt.getText().equals("") 
							|| emailTxt.getText().equals("")
							|| PasswordTxt.getEchoChar() != '●'
							|| StoreTxt.getText().equals("") 
							|| StoreTxt.getText().equals("Store")) {
						JOptionPane.showMessageDialog(frame, "Please fill out the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
					}
					else {
//						Admin u = new Admin();
//						u.updateManager(table, UsernameTxt.getText(), emailTxt.getText(), PasswordTxt.getText(), StoreTxt.getText(), frame, model);					
						try {
							int i = table.getSelectedRow();
							int newName = -1;
							String oldName = model.getValueAt(i, 0).toString();
							Maintain maintain = new Maintain();
							
							maintain.loadUser();
							for(User u: maintain.users) {
								if(u.getName().equals(UsernameTxt.getText()) && UsernameTxt.getText().equals(oldName)) {
//									u.setName(Username);
//									u.setEmail(email);
//									u.setPassword(Password);
//									u.setStore(Store);
									Admin a = new Admin();
									a.updateManager(u, UsernameTxt.getText(), emailTxt.getText(), PasswordTxt.getText(), StoreTxt.getText());
									model.setValueAt(UsernameTxt.getText(), i, 0);
									model.setValueAt(emailTxt.getText(), i, 1);
									model.setValueAt(PasswordTxt.getText(), i, 2);
									model.setValueAt(StoreTxt.getText(), i, 4);
									
									maintain.updateUser();
									JOptionPane.showMessageDialog(frame, "Update successfully!");
									break;
								}
								else if(u.getName().equals(UsernameTxt.getText())) {
									newName = -1;
									JOptionPane.showMessageDialog(frame, "Update failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
									break;
								}
								else if(u.getName().equals(oldName)) {
									newName = maintain.users.indexOf(u);
								}
							}
							if(newName != -1) {
//									maintain.users.get(newName).setName(Username);
//									maintain.users.get(newName).setEmail(email);
//									maintain.users.get(newName).setPassword(Password);
//									maintain.users.get(newName).setStore(Store);
									Admin a = new Admin();
									a.updateManager(maintain.users.get(newName), UsernameTxt.getText(), emailTxt.getText(), PasswordTxt.getText(), StoreTxt.getText());
//									model.setValueAt(Username, i, 0);
//									model.setValueAt(email, i, 1);
//									model.setValueAt(Password, i, 2);
//									model.setValueAt(Store, i, 4);
									model.setValueAt(UsernameTxt.getText(), i, 0);
									model.setValueAt(emailTxt.getText(), i, 1);
									model.setValueAt(PasswordTxt.getText(), i, 2);
									model.setValueAt(StoreTxt.getText(), i, 4);
									
									maintain.updateUser();
									JOptionPane.showMessageDialog(frame, "Update successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
								
							}
							
							
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 14));
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(255, 69, 0));
		btnUpdate.setBounds(187, 336, 135, 44);
		frame.getContentPane().add(btnUpdate);
		
		clearButton = new JButton("Clear fields");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsernameTxt.setText("Username");
				UsernameTxt.setForeground(Color.GRAY);
				emailTxt.setText("Email");
				emailTxt.setForeground(Color.GRAY);
				PasswordTxt.setText("Password");
				PasswordTxt.setForeground(Color.GRAY);
				PasswordTxt.setEchoChar((char) 0);
				StoreTxt.setText("Store");
				StoreTxt.setForeground(Color.GRAY);
				
			}
		});
		clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
		clearButton.setOpaque(true);
		clearButton.setForeground(Color.WHITE);
		clearButton.setBorder(null);
		clearButton.setBackground(new Color(255, 69, 0));
		clearButton.setBounds(187, 392, 135, 44);
		frame.getContentPane().add(clearButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
//					Admin u = new Admin();
//					u.deleteManager(table, UsernameTxt.getText(), emailTxt.getText(), PasswordTxt.getText(), StoreTxt.getText(), frame, model);
					try {
						Maintain maintain = new Maintain();
						
						maintain.loadUser();
						int indexToRemove = -1;
						for(User u : maintain.users) {
							if(UsernameTxt.getText().equals(u.getName())
									&& emailTxt.getText().equals(u.getEmail())
									&& PasswordTxt.getText().equals(u.getPassword())
									&& StoreTxt.getText().equals(u.getStore())) {
								indexToRemove = maintain.users.indexOf(u);
								Admin a = new Admin();
								a.deleteManager(UsernameTxt.getText());
								model.removeRow(table.getSelectedRow());
								break;
							}
						}
//						if(indexToRemove >= 0) {
//							maintain.users.remove(indexToRemove);
//						}
						//maintain.users.remove(Home.u);
//						maintain.updateUser();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please select a row before deleting!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(255, 69, 0));
		btnDelete.setBounds(38, 392, 135, 44);
		frame.getContentPane().add(btnDelete);
		
		PasswordTxt = new JPasswordField();
		PasswordTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		PasswordTxt.setForeground(Color.GRAY);
		PasswordTxt.setBackground(Color.WHITE);
		PasswordTxt.setEchoChar((char) 0);
		PasswordTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(PasswordTxt.getText().equals("Password")) {
					PasswordTxt.setEchoChar('●');
					PasswordTxt.setText("");
					PasswordTxt.setForeground(Color.BLACK);
				}
				else {
					PasswordTxt.selectAll();
					PasswordTxt.setForeground(Color.BLACK);
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(PasswordTxt.getText().equals("")) {
					PasswordTxt.setText("Password");
					PasswordTxt.setEchoChar((char) 0);
					PasswordTxt.setForeground(Color.GRAY);
				}
				else {
					PasswordTxt.setForeground(Color.BLACK);	
				}
			}
		});
		PasswordTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		PasswordTxt.setText("Password");
		PasswordTxt.setBounds(39, 198, 284, 44);
		frame.getContentPane().add(PasswordTxt);
		
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
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Home h = new Home();
				h.frame.setVisible(true);
			}
		});
		backButton.setForeground(Color.BLUE);
		backButton.setFont(new Font("Verdana", Font.BOLD, 15));
		backButton.setBorder(null);
		backButton.setBounds(17, 448, 84, 37);
		frame.getContentPane().add(backButton);
		frame.setUndecorated(true);
		
	}
}
