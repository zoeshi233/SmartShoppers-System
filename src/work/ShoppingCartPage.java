package work;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ShoppingCartPage {

	public JFrame frame;
	private JTable table;
	DefaultTableModel model;
	public static String store;
	private int frameY;
	private int frameX;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartPage window = new ShoppingCartPage(store);
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
	public ShoppingCartPage(String store) {
		ShoppingCartPage.store = store;
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
		frame.setBounds(100, 100, 571, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
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
		backButton.setBounds(48, 439, 65, 37);
		frame.getContentPane().add(backButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 61, 468, 223);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] col = {"Item Name", "Location", "Category", "Price", "Availability", "Discount %", "size", " Descritpion", "X", "Y"};
		final Object[] row = new Object[10];
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
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
		escape.setBounds(519, 6, 37, 33);
		frame.getContentPane().add(escape);
		
		JButton btnDelete = new JButton("Remove from cart");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Customer n = new Customer();
				final Object[] row = new Object[10];
				if(table.getSelectedRow() != -1) {
					int i = table.getSelectedRow();
				
					for(int j = 0; j <= 9; j++) {
						
						row[j] = table.getValueAt(i, j);
					}
					
					Customer c = new Customer();
//					n.deleteItem(table,sRow, frame, model);
					try {
						
						String ItemName = row[0].toString();
						String Location = row[1].toString();
						String Category = row[2].toString();
						String Price = row[3].toString();
						String Availability = row[4].toString();
						String Discount = row[5].toString();
						String Size = row[6].toString();
						String Description = row[7].toString();
						String XTxt = row[8].toString();
						String YTxt = row[9].toString();
						
						c.loadItem();
						for(Item u : c.sList) {
							if(ItemName.equals(u.getName())
									&& Location.equals(u.getLocation())
									&& Category.equals(u.getCategory())
									&& Price.equals(String.valueOf(u.getPrice()))
									&& Availability.equals(String.valueOf(u.getAvailability()))
									&& Discount.equals(String.valueOf(u.getDiscountPct()))
									&& Size.equals(u.getSize())
									&& Description.equals(u.getDescription())
									&& XTxt.equals(String.valueOf(u.getX()))
									&& YTxt.equals(String.valueOf(u.getY()))) {
								c.deleteItem(ItemName, Location, Size);
								model.removeRow(table.getSelectedRow());
								JOptionPane.showMessageDialog(frame, "Deleted successfully!");
								break;
//								indexToRemove = c.sList.indexOf(u);
//								model.removeRow(table.getSelectedRow());
							}
							
						}
//						if(indexToRemove >= 0) {
//							c.sList.remove(indexToRemove);
//							JOptionPane.showMessageDialog(frame, "Deleted successfully!");
//						}
//						else {
//							JOptionPane.showMessageDialog(frame, "Deletion failed! Please reselect an item from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
//						}
//						//maintain.users.remove(Home.u);
//						
//						c.updateItem();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Deletion failed! Please select an item from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		btnDelete.setOpaque(true);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDelete.setBorder(null);
		btnDelete.setBackground(new Color(255, 69, 0));
		btnDelete.setBounds(48, 319, 468, 44);
		frame.getContentPane().add(btnDelete);
		
		JButton btnBestOrder = new JButton("Best Order");
		btnBestOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Item> order = new ArrayList<Item>();
				for(int i = model.getRowCount() - 1; i >= 0; i--) {
					Item mg = new Item(table.getValueAt(i, 0).toString(), table.getValueAt(i, 1).toString(), table.getValueAt(i, 2).toString(), 
							Double.valueOf(table.getValueAt(i, 3).toString()), Integer.valueOf(table.getValueAt(i, 4).toString()),Integer.valueOf(table.getValueAt(i, 5).toString()), 
							0, table.getValueAt(i, 6).toString(), table.getValueAt(i, 7).toString(), Integer.valueOf(table.getValueAt(i, 8).toString()), Integer.valueOf(table.getValueAt(i, 9).toString()), Home.u.name);
					order.add(mg);
				}
				String output = "The best shopping order is:\n";
				int currentX = 0;
				int currentY = 0;
				double d = 0;
				double min = Integer.MAX_VALUE;
				Item next = null;
				while(order.size() > 0) {
					for(Item k : order) {
						d = Math.pow(k.getX() - currentX, 2) + Math.pow(currentY - k.getY(), 2);
						d = Math.pow(d, 0.5);
						if(d < min) {
							min = d;
							next = k;
						}
						
					}
					min = Integer.MAX_VALUE;
					output += "(" + next.getX()+ "," + next.getY() + ")\n";
					order.remove(next);
				}
				JOptionPane.showMessageDialog(frame, output);
			}
		});
		btnBestOrder.setOpaque(true);
		btnBestOrder.setForeground(Color.WHITE);
		btnBestOrder.setFont(new Font("Verdana", Font.BOLD, 14));
		btnBestOrder.setBorder(null);
		btnBestOrder.setBackground(new Color(255, 69, 0));
		btnBestOrder.setBounds(48, 375, 468, 44);
		frame.getContentPane().add(btnBestOrder);
		frame.setUndecorated(true);
		
		
		try {
			Customer c = new Customer();
			c.loadItem();
			Maintain m = new Maintain();
			m.loadItem();
			for(Item s: c.sList) {
				for(Item i : m.items) {
					if(i.location.equals(s.location) && s.location.equals(store) && i.name.equals(s.name) && i.size.equals(s.size) && i.availability > 0 && s.user.equals(Home.u.getName())) {
						row[0] = i.name;
						row[1] = i.location;
						row[2] = i.category;
						row[3] = i.price;
						row[4] = i.availability;
						row[5] = i.discountPct;
						row[6] = i.size;
						row[7] = i.description;
						row[8] = i.x;
						row[9] = i.y;
						model.addRow(row);
						break;
					}
				}	
				
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
}
