package work;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class ModifyItem {

	public JFrame frame;
	private JTable table;
	private JTextField ItemNameTxt;
	private JTextField LocationTxt;
	private JTextField AvailabilityTxt;
	private JTextField PriceTxt;
	private JTextField CategoryTxt;
	private JTextField DiscountTxt;
	private JTextField DescriptionTxt;
	private JButton addButton;
	private JButton btnUpdate;
	private JButton clearButton;
	private JButton btnDelete;
	private int frameY;
	private int frameX;
	String[] itemSizes = {"Small", "Medium", "Large"};
	DefaultTableModel model;
	private JButton backButton;
	private JTextField XTxt;
	private JTextField YTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyItem window = new ModifyItem();
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
	public ModifyItem() {
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
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1100, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox selectSize = new JComboBox(itemSizes);
		selectSize.setToolTipText("Item size, includes small, medium and large");
		selectSize.setSelectedItem(2);
		selectSize.setFont(new Font("Verdana", Font.PLAIN, 13));
		selectSize.setBackground(Color.WHITE);
		
		selectSize.setBounds(303, 184, 233, 44);
		frame.getContentPane().add(selectSize);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 69, 0)));
		scrollPane.setBounds(574, 64, 486, 392);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				ItemNameTxt.setText(model.getValueAt(i, 0).toString());
				ItemNameTxt.setForeground(Color.BLACK);
				LocationTxt.setText(model.getValueAt(i, 1).toString());
				LocationTxt.setForeground(Color.BLACK);
				CategoryTxt.setText(model.getValueAt(i, 2).toString());
				CategoryTxt.setForeground(Color.BLACK);
				
				PriceTxt.setText(model.getValueAt(i, 3).toString());
				PriceTxt.setForeground(Color.BLACK);
				AvailabilityTxt.setText(model.getValueAt(i, 4).toString());
				AvailabilityTxt.setForeground(Color.BLACK);
				DiscountTxt.setText(model.getValueAt(i, 5).toString());
				DiscountTxt.setForeground(Color.BLACK);
				selectSize.setSelectedItem(model.getValueAt(i, 6).toString());
				DescriptionTxt.setText(model.getValueAt(i, 7).toString());
				DescriptionTxt.setForeground(Color.BLACK);
				
				XTxt.setText(model.getValueAt(i, 8).toString());
				XTxt.setForeground(Color.BLACK);
				YTxt.setText(model.getValueAt(i, 9).toString());
				YTxt.setForeground(Color.BLACK);
				
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		model = new DefaultTableModel();
		Object[] col = {"Item Name", "Location", "Category", "Price", "Availability", "Discount %", "size", " Descritpion", "X", "Y"};
		final Object[] row = new Object[10];
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		try {
			Maintain maintain = new Maintain();
			maintain.loadItem();
			for(Item s: maintain.items) {
				if(Home.u.userType.equals("Manager") && s.location.equals(Home.u.getStore())) {
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
					model.addRow(row);
				}		
				else if(Home.u.userType.equals("Administrator")) {
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
					model.addRow(row);
				}
				
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		
		ItemNameTxt = new JTextField();
		ItemNameTxt.setToolTipText("Item name");
		ItemNameTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(ItemNameTxt.getText().equals("Item name")) {
					ItemNameTxt.setText("");
					ItemNameTxt.setForeground(Color.BLACK);
				}
				else {
					ItemNameTxt.setForeground(Color.BLACK);
					ItemNameTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(ItemNameTxt.getText().equals("")) {
					ItemNameTxt.setText("Item name");
					ItemNameTxt.setForeground(Color.GRAY);
				}
				else {
					ItemNameTxt.setForeground(Color.BLACK);
				}
			}
		});
		ItemNameTxt.setText("Item name");
		ItemNameTxt.setForeground(Color.GRAY);
		ItemNameTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		ItemNameTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		ItemNameTxt.setColumns(10);
		ItemNameTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		ItemNameTxt.setBackground(Color.WHITE);
		ItemNameTxt.setBounds(43, 64, 233, 44);
		frame.getContentPane().add(ItemNameTxt);
		
		LocationTxt = new JTextField();
		if(Home.u.userType.equals("Manager")) {
			LocationTxt.setText(Home.u.getStore());
			LocationTxt.setEditable(false);
		}
		else {
			LocationTxt.setEditable(true);
		}
		LocationTxt.setToolTipText("Store location");
//		LocationTxt.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//				if(LocationTxt.getText().equals("Location")) {
//					LocationTxt.setText("");
//					LocationTxt.setForeground(Color.BLACK);
//				}
//				else {
//					LocationTxt.setForeground(Color.BLACK);
//					LocationTxt.selectAll();
//				}
//			
//			}
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(LocationTxt.getText().equals("")) {
//					LocationTxt.setText("Location");
//					LocationTxt.setForeground(Color.GRAY);
//				}
//				else {
//					LocationTxt.setForeground(Color.BLACK);
//				}
//			}
//		});
//		LocationTxt.setText("Location");
		LocationTxt.setForeground(Color.BLACK);
		LocationTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		LocationTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		LocationTxt.setColumns(10);
		LocationTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		LocationTxt.setBackground(Color.WHITE);
		LocationTxt.setBounds(43, 120, 233, 44);
		frame.getContentPane().add(LocationTxt);
		
		AvailabilityTxt = new JTextField();
		AvailabilityTxt.setToolTipText("<html>\nPlease type in an integer to represent<br>\nthe availability in store.\n</html>");
		AvailabilityTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(AvailabilityTxt.getText().equals("Availability")) {
					AvailabilityTxt.setText("");
					AvailabilityTxt.setForeground(Color.BLACK);
				}
				else {
					AvailabilityTxt.setForeground(Color.BLACK);
					AvailabilityTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(AvailabilityTxt.getText().equals("")) {
					AvailabilityTxt.setText("Availability");
					AvailabilityTxt.setForeground(Color.GRAY);
				}
				else {
					AvailabilityTxt.setForeground(Color.BLACK);
				}
			}
		});
		AvailabilityTxt.setText("Availability");
		AvailabilityTxt.setForeground(Color.GRAY);
		AvailabilityTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		AvailabilityTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		AvailabilityTxt.setColumns(10);
		AvailabilityTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		AvailabilityTxt.setBackground(Color.WHITE);
		AvailabilityTxt.setBounds(43, 176, 233, 44);
		frame.getContentPane().add(AvailabilityTxt);
		
		PriceTxt = new JTextField();
		PriceTxt.setToolTipText("<html>\nPlease type in a floating point number<br>\nto indicate the item price.\n</html>");
		PriceTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(PriceTxt.getText().equals("Price")) {
					PriceTxt.setText("");
					PriceTxt.setForeground(Color.BLACK);
				}
				else {
					PriceTxt.setForeground(Color.BLACK);
					PriceTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(PriceTxt.getText().equals("")) {
					PriceTxt.setText("Price");
					PriceTxt.setForeground(Color.GRAY);
				}
				else {
					PriceTxt.setForeground(Color.BLACK);
				}
			}
		});
		PriceTxt.setText("Price");
		PriceTxt.setForeground(Color.GRAY);
		PriceTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		PriceTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		PriceTxt.setColumns(10);
		PriceTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		PriceTxt.setBackground(Color.WHITE);
		PriceTxt.setBounds(43, 232, 233, 44);
		frame.getContentPane().add(PriceTxt);
		
		CategoryTxt = new JTextField();
		CategoryTxt.setToolTipText("Category");
		CategoryTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(CategoryTxt.getText().equals("Category")) {
					CategoryTxt.setText("");
					CategoryTxt.setForeground(Color.BLACK);
				}
				else {
					CategoryTxt.setForeground(Color.BLACK);
					CategoryTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(CategoryTxt.getText().equals("")) {
					CategoryTxt.setText("Category");
					CategoryTxt.setForeground(Color.GRAY);
				}
				else {
					CategoryTxt.setForeground(Color.BLACK);
				}
			}
		});
		CategoryTxt.setText("Category");
		CategoryTxt.setForeground(Color.GRAY);
		CategoryTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		CategoryTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		CategoryTxt.setColumns(10);
		CategoryTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		CategoryTxt.setBackground(Color.WHITE);
		CategoryTxt.setBounds(303, 64, 233, 44);
		frame.getContentPane().add(CategoryTxt);
		
		DiscountTxt = new JTextField();
		DiscountTxt.setToolTipText("<html>Please type in an integer number which is the<br>\n\npercentage off of the original price.<br>\n\nFrom 0 to 100.\n</html>");
		DiscountTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(DiscountTxt.getText().equals("Discount %")) {
					DiscountTxt.setText("");
					DiscountTxt.setForeground(Color.BLACK);
				}
				else {
					DiscountTxt.setForeground(Color.BLACK);
					DiscountTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(DiscountTxt.getText().equals("")) {
					DiscountTxt.setText("Discount %");
					DiscountTxt.setForeground(Color.GRAY);
				}
				else {
					DiscountTxt.setForeground(Color.BLACK);
				}
			}
		});
		DiscountTxt.setText("Discount %");
		DiscountTxt.setForeground(Color.GRAY);
		DiscountTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		DiscountTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		DiscountTxt.setColumns(10);
		DiscountTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		DiscountTxt.setBackground(Color.WHITE);
		DiscountTxt.setBounds(303, 120, 233, 44);
		frame.getContentPane().add(DiscountTxt);
		
		DescriptionTxt = new JTextField();
		DescriptionTxt.setToolTipText("Description");
		DescriptionTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(DescriptionTxt.getText().equals("Description")) {
					DescriptionTxt.setText("");
					DescriptionTxt.setForeground(Color.BLACK);
				}
				else {
					DescriptionTxt.setForeground(Color.BLACK);
					DescriptionTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(DescriptionTxt.getText().equals("")) {
					DescriptionTxt.setText("Description");
					DescriptionTxt.setForeground(Color.GRAY);
				}
				else {
					DescriptionTxt.setForeground(Color.BLACK);
				}
			}
		});
		DescriptionTxt.setText("Description");
		DescriptionTxt.setForeground(Color.GRAY);
		DescriptionTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		DescriptionTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		DescriptionTxt.setColumns(10);
		DescriptionTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		DescriptionTxt.setBackground(Color.WHITE);
		DescriptionTxt.setBounds(303, 231, 233, 44);
		frame.getContentPane().add(DescriptionTxt);
		
		addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ItemNameTxt.getText().equals("Item name") 
						|| LocationTxt.getText().equals("Location") 
						|| CategoryTxt.getText().equals("Category")
						|| PriceTxt.getText().equals("Price")
						|| AvailabilityTxt.getText().equals("Availability")
						|| DiscountTxt.getText().equals("Discount %")
						|| DescriptionTxt.getText().equals("Description")
						|| ItemNameTxt.getText().equals("") 
						|| LocationTxt.getText().equals("")
						|| CategoryTxt.getText().equals("")
						|| PriceTxt.getText().equals("")
						|| AvailabilityTxt.getText().equals("")
						|| DiscountTxt.getText().equals("")
						|| DescriptionTxt.getText().equals("")
						|| XTxt.getText().equals("")
						|| XTxt.getText().equals("Coordinate X")
						|| YTxt.getText().equals("")
						|| YTxt.getText().equals("Coordinate Y")) {
						
					
					
					
					
					JOptionPane.showMessageDialog(frame, "Please fill out the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
							
				}
				else {
					try {
						row[0] = ItemNameTxt.getText();
						row[1] = LocationTxt.getText();
						row[2] = CategoryTxt.getText();
						row[3] = PriceTxt.getText();
						row[4] = AvailabilityTxt.getText();
						row[5] = DiscountTxt.getText();
						row[6] = (String) selectSize.getSelectedItem();
						row[7] = DescriptionTxt.getText();
						row[8] = XTxt.getText();
						row[9] = YTxt.getText();
						Double d1 = Double.parseDouble(PriceTxt.getText());
						Integer i1 = Integer.parseInt(AvailabilityTxt.getText());
						Integer i2 = Integer.parseInt(DiscountTxt.getText());
						if(i1 < 0 || (i2 < 0 || i2 > 100)) {
							JOptionPane.showMessageDialog(frame, "Availability can not be a negative number!\nDiscount percentage needs to be greater than 0 and smaller than 100!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
					}
					catch(NumberFormatException e1){
						JOptionPane.showMessageDialog(frame, "PLease fill the price file with floating point number, fill Availability and Discount percentage with integer!", "Warning", JOptionPane.WARNING_MESSAGE);
						e1.getMessage();
					}
					
					

					
							
//					Admin u = new Admin();
//					u.addItem(row, frame, model);
					try {
						Maintain maintain = new Maintain();
						
						maintain.loadItem();
						int newUser = 1;
						for(Item u1 : maintain.items) {
							if(u1.getName().equals(row[0]) && u1.getLocation().equals(row[1]) && u1.getSize().equals(row[6])) {
								newUser = 0;
							}
						}
						if(newUser == 1) {
							Admin a = new Admin();
							a.addItem(row[0].toString(), row[1].toString(), row[2].toString(), 
									Double.valueOf(row[3].toString()), Integer.valueOf(row[4].toString()),Integer.valueOf(row[5].toString()), 
									0, row[6].toString(), row[7].toString(), Integer.valueOf(row[8].toString()), Integer.valueOf(row[9].toString()), "");
//							maintain.items.add(mg);
//							maintain.updateItem();
							model.addRow(row);
						}
						else {
							JOptionPane.showMessageDialog(frame, "Adding item failed! Item name or size already exists in the same location, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
						}
						
					} 
					catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					try {
//						Maintain maintain = new Maintain();
//						
//						maintain.loadItem();
//						int newUser = 1;
//						for(Item u1 : maintain.items) {
//							if(u1.getName().equals(row[0]) && u1.getLocation().equals(row[1]) && u1.getSize().equals(row[6])) {
//								newUser = 0;
//							}
//						}
//						if(newUser == 1) {
//							Item mg = new Item(row[0].toString(), row[1].toString(), row[2].toString(), 
//									Double.valueOf(row[3].toString()), Integer.valueOf(row[4].toString()),Integer.valueOf(row[5].toString()), 
//									0, row[6].toString(), row[7].toString(), null);
//							maintain.items.add(mg);
//							maintain.updateItem();
//							model.addRow(row);
//						}
//						else {
//							JOptionPane.showMessageDialog(frame, "Adding item failed! Item name or size already exists in the same location, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//						}
//						
//					} 
//					catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
					
				}
						
						
						
					
			}
		});
		addButton.setOpaque(true);
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Verdana", Font.BOLD, 14));
		addButton.setBorder(null);
		addButton.setBackground(new Color(255, 69, 0));
		addButton.setBounds(43, 356, 233, 44);
		frame.getContentPane().add(addButton);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(frame, "Please select a row before updating!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(ItemNameTxt.getText().equals("Item name") 
							|| LocationTxt.getText().equals("Location") 
							|| CategoryTxt.getText().equals("Category")
							|| PriceTxt.getText().equals("Price")
							|| AvailabilityTxt.getText().equals("Availability")
							|| DiscountTxt.getText().equals("Discount %")
							|| DescriptionTxt.getText().equals("Description")
							|| ItemNameTxt.getText().equals("") 
							|| LocationTxt.getText().equals("")
							|| CategoryTxt.getText().equals("")
							|| PriceTxt.getText().equals("")
							|| AvailabilityTxt.getText().equals("")
							|| DiscountTxt.getText().equals("")
							|| DescriptionTxt.getText().equals("")
							|| XTxt.getText().equals("")
							|| XTxt.getText().equals("Coordinate X")
							|| YTxt.getText().equals("")
							|| YTxt.getText().equals("Coordinate Y")) {
							
						
						
						
						
						JOptionPane.showMessageDialog(frame, "Please fill out the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
								
					}
					else {
						
//						Admin u = new Admin();
//						u.updateItem(table, ItemNameTxt.getText(), LocationTxt.getText(), CategoryTxt.getText(),
//								PriceTxt.getText(), AvailabilityTxt.getText(), DiscountTxt.getText(),
//								(String)selectSize.getSelectedItem(), DescriptionTxt.getText(), XTxt.getText(), YTxt.getText(), frame, model);
						try {
							int i = table.getSelectedRow();
							String Size = (String)selectSize.getSelectedItem();
							int newItem = -1;
							String oldName = model.getValueAt(i, 0).toString();
							String oldSize = model.getValueAt(i, 6).toString();
							String oldLoc = model.getValueAt(i, 1).toString();
							Maintain maintain = new Maintain();
							maintain.loadItem();
							for(Item s: maintain.items) {
								if((s.getName().equals(ItemNameTxt.getText()) && ItemNameTxt.getText().equals(oldName))
										&& (s.getLocation().equals(LocationTxt.getText()) && LocationTxt.getText().equals(oldLoc))
										&& (s.getSize().equals(Size) && oldSize.equals(Size))) {
									
									Admin a = new Admin();
									a.updateItem(s, ItemNameTxt.getText(), LocationTxt.getText(), CategoryTxt.getText(),
											PriceTxt.getText(), AvailabilityTxt.getText(), DiscountTxt.getText(),
											Size, DescriptionTxt.getText(), XTxt.getText(), YTxt.getText());
									
//									s.setName(ItemName);
//									s.setLocation(Location);
//									s.setCategory(Category);
//									
//									s.setPrice(Double.valueOf(Price));
//									
//									s.setAvailability(Integer.valueOf(Availability));
//									s.setDiscountPct(Integer.valueOf(Discount));
//									
//									s.setSize(Size);
//									s.setDescription(Description);
//									s.setX(Integer.valueOf(XTxt));
//									s.setY(Integer.valueOf(YTxt));
//									s.setUser("");
									
									model.setValueAt(ItemNameTxt.getText(), i, 0);
									model.setValueAt(LocationTxt.getText(), i, 1);
									model.setValueAt(CategoryTxt.getText(), i, 2);
									
									model.setValueAt(PriceTxt.getText(), i, 3);
									
									model.setValueAt(AvailabilityTxt.getText(), i, 4);
									model.setValueAt(DiscountTxt.getText(), i, 5);
									
									model.setValueAt(Size, i, 6);
									model.setValueAt(DescriptionTxt.getText(), i, 7);
									model.setValueAt(XTxt.getText(), i, 8);
									model.setValueAt(YTxt.getText(), i, 9);
									
									
									
									
									
									maintain.updateItem();
									JOptionPane.showMessageDialog(frame, "Update successfully!");
									break;
								}
								else if(s.getName().equals(ItemNameTxt.getText()) && s.getLocation().equals(LocationTxt.getText()) && s.getSize().equals((Size))) {
									newItem = -1;
									JOptionPane.showMessageDialog(frame, "Update failed! Store location and size already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
									break;
								}
								else if(s.getName().equals(oldName) && s.getLocation().equals(oldLoc) && s.getSize().equals(oldSize)) {
									newItem = maintain.items.indexOf(s);
								}
							}
							if(newItem != -1) {
//								maintain.items.get(newItem).setName(ItemName);
//								maintain.items.get(newItem).setLocation(Location);
//								maintain.items.get(newItem).setCategory(Category);
//								
//								maintain.items.get(newItem).setPrice(Double.valueOf(Price));
//								
//								maintain.items.get(newItem).setAvailability(Integer.valueOf(Availability));
//								maintain.items.get(newItem).setDiscountPct(Integer.valueOf(Discount));
//								
//								maintain.items.get(newItem).setSize(Size);
//								maintain.items.get(newItem).setDescription(Description);
//								maintain.items.get(newItem).setX(Integer.valueOf(XTxt));
//								maintain.items.get(newItem).setY(Integer.valueOf(YTxt));
								Admin a = new Admin();
								a.updateItem(maintain.items.get(newItem), ItemNameTxt.getText(), LocationTxt.getText(), CategoryTxt.getText(),
											PriceTxt.getText(), AvailabilityTxt.getText(), DiscountTxt.getText(),
											Size, DescriptionTxt.getText(), XTxt.getText(), YTxt.getText());
								model.setValueAt(ItemNameTxt.getText(), i, 0);
								model.setValueAt(LocationTxt.getText(), i, 1);
								model.setValueAt(CategoryTxt.getText(), i, 2);
								
								model.setValueAt(PriceTxt.getText(), i, 3);
								
								model.setValueAt(AvailabilityTxt.getText(), i, 4);
								model.setValueAt(DiscountTxt.getText(), i, 5);
								
								model.setValueAt(Size, i, 6);
								model.setValueAt(DescriptionTxt.getText(), i, 7);
								model.setValueAt(XTxt.getText(), i, 8);
								model.setValueAt(YTxt.getText(), i, 9);
//								model.setValueAt(ItemName, i, 0);
//								model.setValueAt(Location, i, 1);
//								model.setValueAt(Category, i, 2);
//								
//								model.setValueAt(Price, i, 3);
//								
//								model.setValueAt(Availability, i, 4);
//								model.setValueAt(Discount, i, 5);
//								
//								model.setValueAt(Size, i, 6);
//								model.setValueAt(Description, i, 7);
//								model.setValueAt(XTxt, i, 8);
//								model.setValueAt(YTxt, i, 9);
//								
								
//								model.setValueAt(ItemNameTxt.getText(), i, 0);
//								model.setValueAt(LocationTxt.getText(), i, 1);
//								model.setValueAt(CategoryTxt.getText(), i, 2);
//								
//								model.setValueAt(PriceTxt.getText(), i, 3);
//								
//								model.setValueAt(AvailabilityTxt.getText(), i, 4);
//								model.setValueAt(DiscountTxt.getText(), i, 5);
//								
//								model.setValueAt((String)selectSize.getSelectedItem(), i, 6);
//								model.setValueAt(DescriptionTxt.getText(), i, 7);
								
								maintain.updateItem();
								JOptionPane.showMessageDialog(frame, "Update successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
									
							}
								
								
								
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
//						try {
//							int i = table.getSelectedRow();
//							int newItem = -1;
//							String oldName = model.getValueAt(i, 0).toString();
//							String oldSize = model.getValueAt(i, 6).toString();
//							String oldLoc = model.getValueAt(i, 1).toString();
//							Maintain maintain = new Maintain();
//							maintain.loadItem();
//							for(Item s: maintain.items) {
//								if((s.getName().equals(ItemNameTxt.getText()) && ItemNameTxt.getText().equals(oldName))
//										&& (s.getLocation().equals(LocationTxt.getText()) && LocationTxt.getText().equals(oldLoc))
//										&& (s.getSize().equals((String)selectSize.getSelectedItem()) && oldSize.equals((String)selectSize.getSelectedItem()))) {
//									s.setName(ItemNameTxt.getText());
//									s.setLocation(LocationTxt.getText());
//									s.setCategory(CategoryTxt.getText());
//									
//									s.setPrice(Double.valueOf(PriceTxt.getText()));
//									
//									s.setAvailability(Integer.valueOf(AvailabilityTxt.getText()));
//									s.setDiscountPct(Integer.valueOf(DiscountTxt.getText()));
//									
//									s.setSize((String)selectSize.getSelectedItem());
//									s.setDescription(DescriptionTxt.getText());
//									
//									model.setValueAt(ItemNameTxt.getText(), i, 0);
//									model.setValueAt(LocationTxt.getText(), i, 1);
//									model.setValueAt(CategoryTxt.getText(), i, 2);
//									
//									model.setValueAt(PriceTxt.getText(), i, 3);
//									
//									model.setValueAt(AvailabilityTxt.getText(), i, 4);
//									model.setValueAt(DiscountTxt.getText(), i, 5);
//									
//									model.setValueAt((String)selectSize.getSelectedItem(), i, 6);
//									model.setValueAt(DescriptionTxt.getText(), i, 7);
//									
//									
//									
//									
//									maintain.updateItem();
//									JOptionPane.showMessageDialog(frame, "Update successfully!");
//									break;
//								}
//								else if(s.getName().equals(ItemNameTxt.getText()) && s.getLocation().equals(LocationTxt.getText()) && s.getSize().equals((String)selectSize.getSelectedItem())) {
//									newItem = -1;
//									JOptionPane.showMessageDialog(frame, "Update failed! Store location and size already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//									break;
//								}
//								else if(s.getName().equals(oldName) && s.getLocation().equals(oldLoc) && s.getSize().equals(oldSize)) {
//									newItem = maintain.items.indexOf(s);
//								}
//							}
//							if(newItem != -1) {
//								maintain.items.get(newItem).setName(ItemNameTxt.getText());
//								maintain.items.get(newItem).setLocation(LocationTxt.getText());
//								maintain.items.get(newItem).setCategory(CategoryTxt.getText());
//								
//								maintain.items.get(newItem).setPrice(Double.valueOf(PriceTxt.getText()));
//								
//								maintain.items.get(newItem).setAvailability(Integer.valueOf(AvailabilityTxt.getText()));
//								maintain.items.get(newItem).setDiscountPct(Integer.valueOf(DiscountTxt.getText()));
//								
//								maintain.items.get(newItem).setSize((String)selectSize.getSelectedItem());
//								maintain.items.get(newItem).setDescription(DescriptionTxt.getText());
//								
//								model.setValueAt(ItemNameTxt.getText(), i, 0);
//								model.setValueAt(LocationTxt.getText(), i, 1);
//								model.setValueAt(CategoryTxt.getText(), i, 2);
//								
//								model.setValueAt(PriceTxt.getText(), i, 3);
//								
//								model.setValueAt(AvailabilityTxt.getText(), i, 4);
//								model.setValueAt(DiscountTxt.getText(), i, 5);
//								
//								model.setValueAt((String)selectSize.getSelectedItem(), i, 6);
//								model.setValueAt(DescriptionTxt.getText(), i, 7);
//								
//								maintain.updateItem();
//								JOptionPane.showMessageDialog(frame, "Update successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
//									
//							}
//								
//								
//								
//						} catch (Exception e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}							
						
					}
					
				}
			}
		});
		btnUpdate.setOpaque(true);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 14));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(255, 69, 0));
		btnUpdate.setBounds(303, 356, 233, 44);
		frame.getContentPane().add(btnUpdate);
		
		clearButton = new JButton("Clear fields");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemNameTxt.setText("Item name");
				ItemNameTxt.setForeground(Color.GRAY);
				LocationTxt.setText("Location");
				LocationTxt.setForeground(Color.GRAY);
				CategoryTxt.setText("Category");
				CategoryTxt.setForeground(Color.GRAY);
				
				PriceTxt.setText("Price");
				PriceTxt.setForeground(Color.GRAY);
				
				AvailabilityTxt.setText("Availability");
				AvailabilityTxt.setForeground(Color.GRAY);
				DiscountTxt.setText("Discount %");
				DiscountTxt.setForeground(Color.GRAY);
				
				
				DescriptionTxt.setText("Description");
				DescriptionTxt.setForeground(Color.GRAY);
				
				XTxt.setText("Coordinate X");
				XTxt.setForeground(Color.GRAY);
				YTxt.setText("Coordinate Y");
				YTxt.setForeground(Color.GRAY);
				
			}
		});
		clearButton.setOpaque(true);
		clearButton.setForeground(Color.WHITE);
		clearButton.setFont(new Font("Verdana", Font.BOLD, 14));
		clearButton.setBorder(null);
		clearButton.setBackground(new Color(255, 69, 0));
		clearButton.setBounds(303, 412, 233, 44);
		frame.getContentPane().add(clearButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
//					Admin u = new Admin();
//					u.deleteItem(table, ItemNameTxt.getText(), LocationTxt.getText(), CategoryTxt.getText(),
//							PriceTxt.getText(), AvailabilityTxt.getText(), DiscountTxt.getText(),
//							(String)selectSize.getSelectedItem(), DescriptionTxt.getText(), XTxt.getText(), YTxt.getText(), frame, model);
//					
					
					try {
						Maintain maintain = new Maintain();
						
						maintain.loadItem();
						int indexToRemove = -1;
						for(Item u : maintain.items) {
							if(ItemNameTxt.getText().equals(u.getName())
									&& LocationTxt.getText().equals(u.getLocation())
									&& CategoryTxt.getText().equals(u.getCategory())
									&& PriceTxt.getText().equals(String.valueOf(u.getPrice()))
									&& AvailabilityTxt.getText().equals(String.valueOf(u.getAvailability()))
									&& DiscountTxt.getText().equals(String.valueOf(u.getDiscountPct()))
									&& u.getSize().equals((String)selectSize.getSelectedItem())
									&& DescriptionTxt.getText().equals(u.getDescription())
									&& XTxt.getText().equals(String.valueOf(u.getX()))
									&& YTxt.getText().equals(String.valueOf(u.getY()))) {
								
								Admin a = new Admin();
								a.deleteItem(ItemNameTxt.getText(), LocationTxt.getText(),
										(String)selectSize.getSelectedItem());
								
								
								
//								indexToRemove = maintain.items.indexOf(u);
								model.removeRow(table.getSelectedRow());
								JOptionPane.showMessageDialog(frame, "Deleted successfully!");
							}
							
						}
//						if(indexToRemove >= 0) {
//							maintain.items.remove(indexToRemove);
//							JOptionPane.showMessageDialog(frame, "Deleted successfully!");
//						}
//						else {
//							JOptionPane.showMessageDialog(frame, "Deletion failed! Please reselect an item from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
//						}
//						//maintain.users.remove(Home.u);
//						
//						maintain.updateItem();
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
		btnDelete.setBounds(43, 412, 233, 44);
		frame.getContentPane().add(btnDelete);
		
		JLabel escape = new JLabel("✕");
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
		escape.setBounds(1057, 6, 37, 33);
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
		backButton.setBounds(28, 468, 84, 37);
		frame.getContentPane().add(backButton);
		
		XTxt = new JTextField();
		XTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(XTxt.getText().equals("Coordinate X")) {
					XTxt.setText("");
					XTxt.setForeground(Color.BLACK);
				}
				else {
					XTxt.setForeground(Color.BLACK);
					XTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(XTxt.getText().equals("")) {
					XTxt.setText("Coordinate X");
					XTxt.setForeground(Color.GRAY);
				}
				else {
					XTxt.setForeground(Color.BLACK);
				}
			}
		});
		XTxt.setToolTipText("Coordinate X in that store");
		XTxt.setText("Coordinate X");
		XTxt.setForeground(Color.GRAY);
		XTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		XTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		XTxt.setColumns(10);
		XTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		XTxt.setBackground(Color.WHITE);
		XTxt.setBounds(43, 289, 233, 44);
		frame.getContentPane().add(XTxt);
		
		YTxt = new JTextField();
		YTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(YTxt.getText().equals("Coordinate Y")) {
					YTxt.setText("");
					YTxt.setForeground(Color.BLACK);
				}
				else {
					YTxt.setForeground(Color.BLACK);
					YTxt.selectAll();
				}
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(YTxt.getText().equals("")) {
					YTxt.setText("Coordinate Y");
					YTxt.setForeground(Color.GRAY);
				}
				else {
					YTxt.setForeground(Color.BLACK);
				}
			}
		});
		
		YTxt.setToolTipText("coordinate Y in that store");
		YTxt.setText("Coordinate Y");
		YTxt.setForeground(Color.GRAY);
		YTxt.setFont(new Font("Verdana", Font.PLAIN, 14));
		YTxt.setDisabledTextColor(Color.LIGHT_GRAY);
		YTxt.setColumns(10);
		YTxt.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 69, 0)));
		YTxt.setBackground(Color.WHITE);
		YTxt.setBounds(303, 288, 233, 44);
		frame.getContentPane().add(YTxt);
		frame.setUndecorated(true);
	}
}
