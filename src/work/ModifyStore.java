package work;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class ModifyStore {

	public JFrame frame;
	private JTable table;
	private JTextField closeTxt;
	private JTextField locationTxt;
	private JTextField StoreNameTxt;
	private JTextField openTxt;
	private JButton addButton;
	private JButton btnUpdate;
	private JButton clearButton;
	private JButton btnDelete;
	private JButton backButton;
	DefaultTableModel model;
	private JLabel escape;
	private int frameY;
	private int frameX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyStore window = new ModifyStore();
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
	public ModifyStore() {
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
		frame.setBounds(100, 100, 770, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 69, 0)));
		scrollPane.setBounds(352, 53, 377, 380);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				StoreNameTxt.setText(model.getValueAt(i, 0).toString());
				StoreNameTxt.setForeground(Color.BLACK);
				locationTxt.setText(model.getValueAt(i, 1).toString());
				locationTxt.setForeground(Color.BLACK);
				openTxt.setText(model.getValueAt(i, 2).toString());
				openTxt.setForeground(Color.BLACK);
				closeTxt.setText(model.getValueAt(i, 3).toString());
				closeTxt.setForeground(Color.BLACK);
				
			}
		});
		table.setForeground(new Color(255, 69, 0));
		model = new DefaultTableModel();
		Object[] col = {"Name", "Location", "Opening", "Closing"};
		final Object[] row = new Object[4];
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		try {
			Maintain maintain = new Maintain();
			maintain.loadStore();
			for(Store s: maintain.stores) {
				row[0] = s.name;
				row[1] = s.location;
				row[2] = s.from;
				row[3] = s.to;
				model.addRow(row);
				
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		closeTxt = new JTextField();
		closeTxt.setText("Closing");
		closeTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(closeTxt.getText().equals("Closing")) {
					closeTxt.setText("");
					closeTxt.setForeground(Color.BLACK);
				}
				else {
					closeTxt.setForeground(Color.BLACK);
					closeTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(closeTxt.getText().equals("")) {
					closeTxt.setText("Closing");
					closeTxt.setForeground(Color.GRAY);
				}
				else {
					closeTxt.setForeground(Color.BLACK);
				}
			}
		});
		closeTxt.setForeground(Color.GRAY);
		closeTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		closeTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		closeTxt.setColumns(10);
		closeTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		closeTxt.setBackground(Color.WHITE);
		closeTxt.setBounds(35, 250, 284, 49);
		frame.getContentPane().add(closeTxt);
		
		locationTxt = new JTextField();
		locationTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(locationTxt.getText().equals("Location")) {
					locationTxt.setText("");
					locationTxt.setForeground(Color.BLACK);
				}
				else {
					locationTxt.setForeground(Color.BLACK);
					locationTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(locationTxt.getText().equals("")) {
					locationTxt.setText("Location");
					locationTxt.setForeground(Color.GRAY);
				}
				else {
					locationTxt.setForeground(Color.BLACK);
				}
			}
		});
		locationTxt.setText("Location");
		locationTxt.setForeground(Color.GRAY);
		locationTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		locationTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		locationTxt.setColumns(10);
		locationTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		locationTxt.setBackground(Color.WHITE);
		locationTxt.setBounds(35, 138, 284, 44);
		frame.getContentPane().add(locationTxt);
		
		StoreNameTxt = new JTextField();
		StoreNameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(StoreNameTxt.getText().equals("Store name")) {
					StoreNameTxt.setText("");
					StoreNameTxt.setForeground(Color.BLACK);
				}
				else {
					StoreNameTxt.setForeground(Color.BLACK);
					StoreNameTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(StoreNameTxt.getText().equals("")) {
					StoreNameTxt.setText("Store name");
					StoreNameTxt.setForeground(Color.GRAY);
				}
				else {
					StoreNameTxt.setForeground(Color.BLACK);
				}
			}
		});
		StoreNameTxt.setText("Store name");
		StoreNameTxt.setForeground(Color.GRAY);
		StoreNameTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		StoreNameTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		StoreNameTxt.setColumns(10);
		StoreNameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		StoreNameTxt.setBackground(Color.WHITE);
		StoreNameTxt.setBounds(35, 82, 284, 44);
		frame.getContentPane().add(StoreNameTxt);
		
		openTxt = new JTextField();
		openTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(openTxt.getText().equals("Opening")) {
					openTxt.setText("");
					openTxt.setForeground(Color.BLACK);
				}
				else {
					openTxt.setForeground(Color.BLACK);
					openTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(openTxt.getText().equals("")) {
					openTxt.setText("Opening");
					openTxt.setForeground(Color.GRAY);
				}
				else {
					openTxt.setForeground(Color.BLACK);
				}
			}
		});
		openTxt.setText("Opening");
		openTxt.setForeground(Color.GRAY);
		openTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		openTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		openTxt.setColumns(10);
		openTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		openTxt.setBackground(Color.WHITE);
		openTxt.setBounds(35, 194, 284, 44);
		frame.getContentPane().add(openTxt);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StoreNameTxt.getText().equals("Store name") 
						|| locationTxt.getText().equals("Location") 
						|| StoreNameTxt.getText().equals("") 
						|| locationTxt.getText().equals("")
						|| openTxt.getText().equals("") 
						|| openTxt.getText().equals("Opening")
						|| closeTxt.getText().equals("") 
						|| closeTxt.getText().equals("Closing")) {
					JOptionPane.showMessageDialog(frame, "Please fill out the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
					
				}
				else {
					row[0] = StoreNameTxt.getText();
					row[1] = locationTxt.getText();
					row[2] = openTxt.getText();
					row[3] = closeTxt.getText();
					
//					Admin u = new Admin();
//					u.addStore(row, frame, model);
					try {
						Maintain maintain = new Maintain();
						maintain.loadStore();
						int newStore = 1;
						for(Store s : maintain.stores) {
							if(s.getLocation().equals(row[1])) {
								newStore = 0;
							}
						}
						if(newStore == 1) {
							Admin a = new Admin();
							a.addStore(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString());
//							Store mg = new Store(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString());
//							maintain.stores.add(mg);
//							maintain.updateStore();
							model.addRow(row);
						}
						else {
							JOptionPane.showMessageDialog(frame, "Registration failed! Store location already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					} 
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		
		addButton.setOpaque(true);
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Verdana", Font.BOLD, 14));
		addButton.setBorder(null);
		addButton.setBackground(new Color(255, 69, 0));
		addButton.setBounds(35, 333, 137, 44);
		frame.getContentPane().add(addButton);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Please select a row before updating!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(StoreNameTxt.getText().equals("Store name") 
							|| locationTxt.getText().equals("Location") 
							|| StoreNameTxt.getText().equals("") 
							|| locationTxt.getText().equals("")
							|| openTxt.getText().equals("") 
							|| openTxt.getText().equals("Opening")
							|| closeTxt.getText().equals("") 
							|| closeTxt.getText().equals("Closing")) {
						JOptionPane.showMessageDialog(frame, "Please fill out the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					else {
//						Admin u = new Admin();
//						u.updateStore(table, StoreNameTxt.getText(), locationTxt.getText(), openTxt.getText(), closeTxt.getText(), frame, model);
						try {
							int i = table.getSelectedRow();
							int newLoc = -1;
							String oldName = model.getValueAt(i, 1).toString();
							Maintain maintain = new Maintain();
							maintain.loadStore();
							for(Store s: maintain.stores) {
								if(s.getLocation().equals(locationTxt.getText()) && locationTxt.getText().equals(oldName)) {
									Admin a = new Admin();
									a.updateStore(s, StoreNameTxt.getText(), locationTxt.getText(), openTxt.getText(), closeTxt.getText());
									model.setValueAt(StoreNameTxt.getText(), i, 0);
									model.setValueAt(locationTxt.getText(), i, 1);
									model.setValueAt(openTxt.getText(), i, 2);
									model.setValueAt(closeTxt.getText(), i, 3);
									
									maintain.updateStore();
									JOptionPane.showMessageDialog(frame, "Update successfully!");
									break;
								}
								else if(s.getLocation().equals(locationTxt.getText())) {
									newLoc = -1;
									JOptionPane.showMessageDialog(frame, "Update failed! Store location already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
									break;
								}
								else if(s.getLocation().equals(oldName)) {
									newLoc = maintain.stores.indexOf(s);
								}
							}
							if(newLoc != -1) {
//								maintain.stores.get(newLoc).setName(storeName);
//								maintain.stores.get(newLoc).setLocation(location);
//								maintain.stores.get(newLoc).setFrom(open);
//								maintain.stores.get(newLoc).setTo(close);
								
								Admin a = new Admin();
								a.updateStore(maintain.stores.get(newLoc), StoreNameTxt.getText(), locationTxt.getText(), openTxt.getText(), closeTxt.getText());
								
								model.setValueAt(StoreNameTxt.getText(), i, 0);
								model.setValueAt(locationTxt.getText(), i, 1);
								model.setValueAt(openTxt.getText(), i, 2);
								model.setValueAt(closeTxt.getText(), i, 3);
								
								maintain.updateStore();
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
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 14));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(255, 69, 0));
		btnUpdate.setBounds(184, 333, 135, 44);
		frame.getContentPane().add(btnUpdate);
		
		clearButton = new JButton("Clear fields");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StoreNameTxt.setText("Store name");
				StoreNameTxt.setForeground(Color.GRAY);
				locationTxt.setText("Location");
				locationTxt.setForeground(Color.GRAY);
				openTxt.setText("Opening");
				openTxt.setForeground(Color.GRAY);
				closeTxt.setText("Closing");
				closeTxt.setForeground(Color.GRAY);
				
			}
		});
		clearButton.setOpaque(true);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
		clearButton.setBorder(null);
		clearButton.setBackground(new Color(255, 69, 0));
		clearButton.setBounds(184, 389, 135, 44);
		frame.getContentPane().add(clearButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
//					Admin u = new Admin();
//					u.deleteStore(table, StoreNameTxt.getText(), locationTxt.getText(), openTxt.getText(), closeTxt.getText(), frame, model);
					try {
						Maintain maintain = new Maintain();
						
						maintain.loadStore();
						int indexToRemove = -1;
						for(Store u : maintain.stores) {
							if(StoreNameTxt.getText().equals(u.getName())
									&& locationTxt.getText().equals(u.getLocation())
									&& openTxt.getText().equals(u.getFrom())
									&& closeTxt.getText().equals(u.getTo())) {
								
								Admin a = new Admin();
								a.deleteStore(locationTxt.getText());
								model.removeRow(table.getSelectedRow());
								break;
								
							}
							
						}
//						if(indexToRemove >= 0) {
//							maintain.stores.remove(indexToRemove);
//							JOptionPane.showMessageDialog(frame, "Deleted successfully!");
//						}
//						else {
//							JOptionPane.showMessageDialog(frame, "Deletion failed! Please reselect a store from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
//						}
						//maintain.users.remove(Home.u);
						
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
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(255, 69, 0));
		btnDelete.setBounds(35, 389, 135, 44);
		frame.getContentPane().add(btnDelete);
		
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
		backButton.setBounds(16, 446, 84, 37);
		frame.getContentPane().add(backButton);
		
		escape = new JLabel("✕");
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
		escape.setBounds(727, 6, 37, 33);
		frame.getContentPane().add(escape);
		frame.setUndecorated(true);
		
	}
}
