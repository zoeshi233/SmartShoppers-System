package work;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Insets;

public class Home {

	public JFrame frame;
	public static User u;
	private Image profile_logo = new ImageIcon(Home.class.getResource("/res/userProfile.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private int frameX;
	private int frameY;
	DefaultTableModel model;
	DefaultTableModel modelt;
	private JTable StoreTable;
	private JTextField StoreSearch;
	private JTextField SearchItem;
	private JTable ItemTable;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
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
		frame.setBounds(100, 100, 1000, 770);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBorder(null);
		menu.setBounds(0, 0, 227, 770);
		menu.setBackground(new Color(255, 69, 0));
		frame.getContentPane().add(menu);
		menu.setLayout(null);
		
		JButton profile = new JButton("User Profile");
		profile.setBackground(new Color(255, 69, 0));
		profile.setHorizontalAlignment(SwingConstants.LEADING);
		profile.setForeground(Color.WHITE);
		profile.setFont(new Font("Verdana", Font.BOLD, 15));
		profile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				profile.setForeground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				profile.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				UserProfile pf = new UserProfile();
				pf.frame.setVisible(true);
			}
		});
		profile.setBorder(null);
		profile.setBounds(42, 145, 108, 29);
		menu.add(profile);
		
		JButton logOut = new JButton("Log Out");
		logOut.setBackground(new Color(255, 69, 0));
		logOut.setHorizontalAlignment(SwingConstants.LEADING);
		logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logOut.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logOut.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Login lg = new Login();
				lg.frame.setVisible(true);
			}
		});
		logOut.setForeground(Color.WHITE);
		logOut.setFont(new Font("Verdana", Font.BOLD, 15));
		logOut.setBorder(null);
		logOut.setBounds(69, 712, 81, 29);
		menu.add(logOut);
		
		JLabel profileLogo = new JLabel("");
		profileLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		profileLogo.setForeground(Color.WHITE);
		profileLogo.setBorder(null);
		profileLogo.setBounds(42, 29, 90, 90);
		profileLogo.setIcon(new ImageIcon(profile_logo));
		menu.add(profileLogo);
		
		
		
		JButton btnModifyManager = new JButton("Modify Manager");
		btnModifyManager.setBackground(new Color(255, 69, 0));
		btnModifyManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModifyManager.setForeground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnModifyManager.setForeground(Color.WHITE);
			}
		});
		if(u.userType.equals("Administrator")) {
			btnModifyManager.setVisible(true);
		}
		else {
			btnModifyManager.setVisible(false);
		}
		btnModifyManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModifyManager mg = new ModifyManager();
				mg.frame.setVisible(true);
			}
		});
		btnModifyManager.setHorizontalAlignment(SwingConstants.LEADING);
		btnModifyManager.setForeground(Color.WHITE);
		btnModifyManager.setFont(new Font("Verdana", Font.BOLD, 15));
		btnModifyManager.setBorder(null);
		btnModifyManager.setBounds(42, 269, 138, 29);
		menu.add(btnModifyManager);
		
		
		
		JButton btnModifyStore = new JButton("Modify Stores");
		btnModifyStore.setBackground(new Color(255, 69, 0));
		btnModifyStore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModifyStore.setForeground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnModifyStore.setForeground(Color.WHITE);
			}
		});
		if(u.userType.equals("Administrator")) {
			btnModifyStore.setVisible(true);
		}
		else {
			btnModifyStore.setVisible(false);
		}
		btnModifyStore.setHorizontalAlignment(SwingConstants.LEADING);
		btnModifyStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModifyStore ms = new ModifyStore();
				ms.frame.setVisible(true);
			}
		});
		btnModifyStore.setForeground(Color.WHITE);
		btnModifyStore.setFont(new Font("Verdana", Font.BOLD, 15));
		btnModifyStore.setBorder(null);
		btnModifyStore.setBounds(42, 228, 138, 29);
		menu.add(btnModifyStore);
		
		JButton btnItem = new JButton("Modify Item");
		btnItem.setBackground(new Color(255, 69, 0));
		btnItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnItem.setForeground(Color.BLUE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnItem.setForeground(Color.WHITE);
			}
		});
		btnItem.setHorizontalAlignment(SwingConstants.LEADING);
		if(Home.u.userType.equals("Manager") || Home.u.userType.equals("Administrator")) {
			btnItem.setVisible(true);
			
		}
		else {
			btnItem.setVisible(false);
		}
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Home.u.userType.equals("Manager") || Home.u.userType.equals("Administrator")) {
					frame.dispose();
					ModifyItem mi = new ModifyItem();
					mi.frame.setVisible(true);
					
				}
			}
		});
		btnItem.setForeground(Color.WHITE);
		btnItem.setFont(new Font("Verdana", Font.BOLD, 15));
		btnItem.setBorder(null);
		btnItem.setBounds(42, 186, 138, 29);
		menu.add(btnItem);
		
		JLabel escape = new JLabel("✕");
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
		escape.setBounds(957, 6, 37, 33);
		frame.getContentPane().add(escape);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(277, 482, 678, 209);
		frame.getContentPane().add(scrollPane_1);
		
		ItemTable = new JTable();
		ItemTable.setBackground(Color.WHITE);
		ItemTable.setForeground(new Color(255, 69, 0));
		ItemTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane_1.setViewportView(ItemTable);
		modelt = new DefaultTableModel();
		Object[] col = {"Item Name", "Location", "Category", "Price", "Availability", "Discount %", "size", " Descritpion", "X", "Y"};
		final Object[] row = new Object[10];
		modelt.setColumnIdentifiers(col);
		ItemTable.setModel(modelt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		scrollPane.setBounds(277, 94, 678, 229);
		frame.getContentPane().add(scrollPane);
		
		StoreTable = new JTable();
		StoreTable.setForeground(new Color(255, 69, 0));
		StoreTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(int i = modelt.getRowCount() - 1; i >= 0; i--) {
					modelt.removeRow(i);
				}
				try {
					int i = StoreTable.getSelectedRow();
					//JOptionPane.showMessageDialog(frame, "Store " + StoreTable.getValueAt(i, 1) + " is selected!");
					Maintain maintain = new Maintain();
					maintain.loadItem();
					for(Item s: maintain.items) {
						if(s.location.equals(StoreTable.getValueAt(i, 1))) {
							row[0] = s.name;
							row[1] = s.location;
							row[2] = s.category;
							row[3] = s.price;
							row[4] = s.availability;
							row[5] = s.discountPct;
							row[6] = s.size;
							row[7] = s.description;
							row[8] = s.x;
							row[9] = s.y;
							modelt.addRow(row);
						}		
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		
		StoreTable.setBackground(Color.WHITE);
		model = new DefaultTableModel();
		Object[] storeCol = {"Name", "Location", "Opening", "Closing"};
		final Object[] storeRow = new Object[4];
		model.setColumnIdentifiers(storeCol);
		StoreTable.setModel(model);
		
		try {
			Maintain maintain = new Maintain();
			maintain.loadStore();
			for(Store s: maintain.stores) {
				storeRow[0] = s.name;
				storeRow[1] = s.location;
				storeRow[2] = s.from;
				storeRow[3] = s.to;
				model.addRow(storeRow);
				
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		scrollPane.setViewportView(StoreTable);
		
		StoreSearch = new JTextField();
		StoreSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel table = (DefaultTableModel) StoreTable.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
				StoreTable.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(StoreSearch.getText()));
			}
		});
		StoreSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(StoreSearch.getText().equals("Search Store")) {
					StoreSearch.setText("");
					StoreSearch.setForeground(Color.BLACK);
				}
				else {
					StoreSearch.setForeground(Color.BLACK);
					StoreSearch.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(StoreSearch.getText().equals("")) {
					StoreSearch.setText("Search Store");
					StoreSearch.setForeground(Color.GRAY);
				}
				else {
					StoreSearch.setForeground(Color.BLACK);
				}
			}
		});
		StoreSearch.setToolTipText("Search Store");
		StoreSearch.setText("Search Store");
		StoreSearch.setForeground(Color.GRAY);
		StoreSearch.setFont(new Font("Verdana", Font.PLAIN, 14));
		StoreSearch.setDisabledTextColor(Color.LIGHT_GRAY);
		StoreSearch.setColumns(10);
		StoreSearch.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		StoreSearch.setBackground(Color.WHITE);
		StoreSearch.setBounds(277, 29, 502, 44);
		frame.getContentPane().add(StoreSearch);
		
		SearchItem = new JTextField();
		SearchItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel table = (DefaultTableModel) ItemTable.getModel();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
				ItemTable.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(SearchItem.getText()));
			}
		});
		SearchItem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(SearchItem.getText().equals("Search Item")) {
					SearchItem.setText("");
					SearchItem.setForeground(Color.BLACK);
				}
				else {
					SearchItem.setForeground(Color.BLACK);
					SearchItem.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(SearchItem.getText().equals("")) {
					SearchItem.setText("Search Item");
					SearchItem.setForeground(Color.GRAY);
				}
				else {
					SearchItem.setForeground(Color.BLACK);
				}
			}
		});
		SearchItem.setToolTipText("Search Item");
		SearchItem.setText("Search Item");
		SearchItem.setForeground(Color.GRAY);
		SearchItem.setFont(new Font("Verdana", Font.PLAIN, 14));
		SearchItem.setDisabledTextColor(Color.LIGHT_GRAY);
		SearchItem.setColumns(10);
		SearchItem.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		SearchItem.setBackground(Color.WHITE);
		SearchItem.setBounds(277, 417, 502, 44);
		frame.getContentPane().add(SearchItem);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Object[] row = new Object[10];
					int i = ItemTable.getSelectedRow();
				try {
					
					if(i != - 1) {
						for(int j = 0; j <= 9; j++) {
							
							row[j] = ItemTable.getValueAt(i, j);
						}
					
//					Customer c = new Customer();
//					
//					
//					c.addItem(sRow, frame);
						Customer c = new Customer();
						c.loadItem();
						int newUser = 1;
						for(Item u1 : c.sList) {
							if(u1.getName().equals(row[0]) && u1.getLocation().equals(row[1]) && u1.getSize().equals(row[6]) && u1.getUser().equals(Home.u.getName())) {
								newUser = 0;
							}
						}
						if(newUser == 1) {
							c.addItem(row[0].toString(), row[1].toString(), row[2].toString(), 
									Double.valueOf(row[3].toString()), Integer.valueOf(row[4].toString()),Integer.valueOf(row[5].toString()), 
									0, row[6].toString(), row[7].toString(), Integer.valueOf(row[8].toString()), Integer.valueOf(row[9].toString()), Home.u.name);
							
							
//							c.sList.add(mg);
//							c.updateItem();
							JOptionPane.showMessageDialog(frame, "Item added to shopping list!");
						}
						else {
							JOptionPane.showMessageDialog(frame, "Item already exists in the shopping cart!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "Please select a row from table!", "Warning", JOptionPane.WARNING_MESSAGE);
						
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddToCart.setVerticalTextPosition(SwingConstants.TOP);
		btnAddToCart.setOpaque(true);
		btnAddToCart.setMargin(new Insets(2, 2, 2, 2));
		btnAddToCart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddToCart.setForeground(Color.WHITE);
		btnAddToCart.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAddToCart.setBorder(null);
		btnAddToCart.setBackground(new Color(255, 69, 0));
		btnAddToCart.setBounds(277, 706, 250, 44);
		frame.getContentPane().add(btnAddToCart);
		
		JButton btnSavePreference = new JButton("Save preference");
		btnSavePreference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(Home.u.userType.equals("Manager")){
						
					}
					else {
						Maintain maintain = new Maintain();
						try {
							maintain.loadUser();
							int i = StoreTable.getSelectedRow();
							for(User u : maintain.users) {
								if(u.name.equals(Home.u.name)) {
									u.setStore(StoreTable.getValueAt(i, 1).toString());
									Home.u = u;
									JOptionPane.showMessageDialog(frame, "Store preference changed!");
									break;
								}
							}
							maintain.updateUser();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				}
		});
		btnSavePreference.setVerticalTextPosition(SwingConstants.TOP);
		btnSavePreference.setOpaque(true);
		btnSavePreference.setMargin(new Insets(2, 2, 2, 2));
		btnSavePreference.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSavePreference.setForeground(Color.WHITE);
		btnSavePreference.setFont(new Font("Verdana", Font.BOLD, 18));
		btnSavePreference.setBorder(null);
		btnSavePreference.setBackground(new Color(255, 69, 0));
		btnSavePreference.setBounds(277, 346, 227, 44);
		frame.getContentPane().add(btnSavePreference);
		
		JButton checkCart = new JButton("Check Shopping List");
		checkCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StoreTable.getSelectedRow() != -1) {
					
					int i = StoreTable.getSelectedRow();
					JOptionPane.showMessageDialog(frame, "Store " + StoreTable.getValueAt(i, 1) + " is selected!");
					
					ShoppingCartPage sc = new ShoppingCartPage(StoreTable.getValueAt(i, 1).toString());
					frame.dispose();
					sc.frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please select a row before deleting!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		checkCart.setToolTipText("Check shopping List");
		checkCart.setVerticalTextPosition(SwingConstants.TOP);
		checkCart.setOpaque(true);
		checkCart.setMargin(new Insets(2, 2, 2, 2));
		checkCart.setHorizontalTextPosition(SwingConstants.CENTER);
		checkCart.setForeground(Color.WHITE);
		checkCart.setFont(new Font("Verdana", Font.BOLD, 18));
		checkCart.setBorder(null);
		checkCart.setBackground(new Color(255, 69, 0));
		checkCart.setBounds(523, 346, 239, 44);
		frame.getContentPane().add(checkCart);
		
		JButton sale = new JButton("Sale Items");
		sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = modelt.getRowCount() - 1; i >= 0; i--) {
					modelt.removeRow(i);
				}
				try {
					int i = StoreTable.getSelectedRow();
					//JOptionPane.showMessageDialog(frame, "Store " + StoreTable.getValueAt(i, 1) + " is selected!");
					Maintain maintain = new Maintain();
					maintain.loadItem();
					for(Item s: maintain.items) {
						if(s.location.equals(StoreTable.getValueAt(i, 1)) && s.discountPct != 0) {
							row[0] = s.name;
							row[1] = s.location;
							row[2] = s.category;
							row[3] = s.price;
							row[4] = s.availability;
							row[5] = s.discountPct;
							row[6] = s.size;
							row[7] = s.description;
							row[8] = s.x;
							row[9] = s.y;
							modelt.addRow(row);
						}		
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		
		sale.setVerticalTextPosition(SwingConstants.TOP);
		sale.setOpaque(true);
		sale.setMargin(new Insets(2, 2, 2, 2));
		sale.setHorizontalTextPosition(SwingConstants.CENTER);
		sale.setForeground(Color.WHITE);
		sale.setFont(new Font("Verdana", Font.BOLD, 18));
		sale.setBorder(null);
		sale.setBackground(new Color(255, 69, 0));
		sale.setBounds(548, 706, 250, 44);
		frame.getContentPane().add(sale);
		frame.setUndecorated(true);
		
		
		
		
	}
}
