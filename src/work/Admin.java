package work;

public class Admin extends User{

	public Admin() {
		super();
		
	}
	public void addManager(String name, String email, String password, String store) throws Exception {
		Maintain maintain = new Maintain();
		maintain.loadUser();
		User mg = new User(name, email, password, "Manager", store);
		maintain.users.add(mg);
		maintain.updateUser();
	}
//	public void addManage(final Object[] row, JFrame frame, DefaultTableModel model) {
//		try {
//			Maintain maintain = new Maintain();
//			
//			maintain.loadUser();
//			int newUser = 1;
//			for(User u : maintain.users) {
//				if(u.getName().equals(row[0])) {
//					newUser = 0;
//				}
//			}
//			if(newUser == 1) {
//				User mg = new User(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString(), row[4].toString());
//				maintain.users.add(mg);
//				maintain.updateUser();
//				model.addRow(row);
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Registration failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			
//		} 
//		catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	public void updateManager(User u, String Username, String email, String Password, String Store) {
		u.setName(Username);
		u.setEmail(email);
		u.setPassword(Password);
		u.setStore(Store);
	}

//	public void updateManage(JTable table, String Username, String email, String Password, String Store, JFrame frame, DefaultTableModel model) {
//		try {
//			int i = table.getSelectedRow();
//			int newName = -1;
//			String oldName = model.getValueAt(i, 0).toString();
//			Maintain maintain = new Maintain();
//			
//			maintain.loadUser();
//			for(User u: maintain.users) {
//				if(u.getName().equals(Username) && Username.equals(oldName)) {
//					u.setName(Username);
//					u.setEmail(email);
//					u.setPassword(Password);
//					u.setStore(Store);
//					model.setValueAt(Username, i, 0);
//					model.setValueAt(email, i, 1);
//					model.setValueAt(Password, i, 2);
//					model.setValueAt(Store, i, 4);
//					
//					maintain.updateUser();
//					JOptionPane.showMessageDialog(frame, "Update successfully!");
//					break;
//				}
//				else if(u.getName().equals(Username)) {
//					newName = -1;
//					JOptionPane.showMessageDialog(frame, "Update failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//					break;
//				}
//				else if(u.getName().equals(oldName)) {
//					newName = maintain.users.indexOf(u);
//				}
//			}
//			if(newName != -1) {
//					maintain.users.get(newName).setName(Username);
//					maintain.users.get(newName).setEmail(email);
//					maintain.users.get(newName).setPassword(Password);
//					maintain.users.get(newName).setStore(Store);
//					model.setValueAt(Username, i, 0);
//					model.setValueAt(email, i, 1);
//					model.setValueAt(Password, i, 2);
//					model.setValueAt(Store, i, 4);
//					
//					maintain.updateUser();
//					JOptionPane.showMessageDialog(frame, "Update successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
//				
//			}
//			
//			
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	public void deleteManager(String user) throws Exception {
		Maintain maintain = new Maintain();
		
		maintain.loadUser();
		for(User u : maintain.users) {
			if(u.getName().equals(user)) {
				maintain.users.remove(u);
				break;
			}
		}
		
		maintain.updateUser();
		
	}
	
	
	
//	public void deleteManage(JTable table, String Username, String email, String Password, String Store, JFrame frame, DefaultTableModel model) {
//		try {
//			Maintain maintain = new Maintain();
//			
//			maintain.loadUser();
//			int indexToRemove = -1;
//			for(User u : maintain.users) {
//				if(Username.equals(u.getName())
//						&& email.equals(u.getEmail())
//						&& Password.equals(u.getPassword())
//						&& Store.equals(u.getStore())) {
//					indexToRemove = maintain.users.indexOf(u);
//					model.removeRow(table.getSelectedRow());
//				}
//			}
//			if(indexToRemove >= 0) {
//				maintain.users.remove(indexToRemove);
//			}
//			//maintain.users.remove(Home.u);
//			maintain.updateUser();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	public void addStore(String name, String loc, String open, String close) throws Exception {
		Maintain maintain = new Maintain();
		maintain.loadStore();
		Store mg = new Store(name, loc, open, close);
		maintain.stores.add(mg);
		maintain.updateStore();
//	public void addStore(final Object[] row, JFrame frame, DefaultTableModel model) {
//		try {
//			Maintain maintain = new Maintain();
//			maintain.loadStore();
//			int newStore = 1;
//			for(Store s : maintain.stores) {
//				if(s.getLocation().equals(row[1])) {
//					newStore = 0;
//				}
//			}
//			if(newStore == 1) {
//				Store mg = new Store(row[0].toString(), row[1].toString(), row[2].toString(), row[3].toString());
//				maintain.stores.add(mg);
//				maintain.updateStore();
//				model.addRow(row);
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Registration failed! Store location already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			
//		} 
//		catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
	
	public void updateStore(Store s, String storeName, String location, String open, String close) {
		s.setName(storeName);
		s.setLocation(location);
		s.setFrom(open);
		s.setTo(close);
	}
	
	
//	public void updateStore(JTable table, String storeName, String location, String open, String close, JFrame frame, DefaultTableModel model) {
//		try {
//			int i = table.getSelectedRow();
//			int newLoc = -1;
//			String oldName = model.getValueAt(i, 1).toString();
//			Maintain maintain = new Maintain();
//			maintain.loadStore();
//			for(Store s: maintain.stores) {
//				if(s.getLocation().equals(location) && location.equals(oldName)) {
//					s.setName(storeName);
//					s.setLocation(location);
//					s.setFrom(open);
//					s.setTo(close);
//					model.setValueAt(storeName, i, 0);
//					model.setValueAt(location, i, 1);
//					model.setValueAt(open, i, 2);
//					model.setValueAt(close, i, 3);
//					
//					maintain.updateStore();
//					JOptionPane.showMessageDialog(frame, "Update successfully!");
//					break;
//				}
//				else if(s.getLocation().equals(location)) {
//					newLoc = -1;
//					JOptionPane.showMessageDialog(frame, "Update failed! Store location already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//					break;
//				}
//				else if(s.getLocation().equals(oldName)) {
//					newLoc = maintain.stores.indexOf(s);
//				}
//			}
//			if(newLoc != -1) {
//				maintain.stores.get(newLoc).setName(storeName);
//				maintain.stores.get(newLoc).setLocation(location);
//				maintain.stores.get(newLoc).setFrom(open);
//				maintain.stores.get(newLoc).setTo(close);
//				model.setValueAt(storeName, i, 0);
//				model.setValueAt(location, i, 1);
//				model.setValueAt(open, i, 2);
//				model.setValueAt(close, i, 3);
//				
//				maintain.updateStore();
//				JOptionPane.showMessageDialog(frame, "Update successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
//					
//			}
//				
//				
//				
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	public void deleteStore(String store) throws Exception {
		Maintain maintain = new Maintain();
		
		maintain.loadStore();
		for(Store s : maintain.stores) {
			if(s.getLocation().equals(store)) {
				maintain.stores.remove(s);
				break;
			}
		}
		
		maintain.updateStore();
	}
		
//	public void deleteStore(JTable table, String storeName, String location, String open, String close, JFrame frame, DefaultTableModel model) {
//		try {
//			Maintain maintain = new Maintain();
//			
//			maintain.loadStore();
//			int indexToRemove = -1;
//			for(Store u : maintain.stores) {
//				if(storeName.equals(u.getName())
//						&& location.equals(u.getLocation())
//						&& open.equals(u.getFrom())
//						&& close.equals(u.getTo())) {
//					indexToRemove = maintain.stores.indexOf(u);
//					model.removeRow(table.getSelectedRow());
//				}
//				
//			}
//			if(indexToRemove >= 0) {
//				maintain.stores.remove(indexToRemove);
//				JOptionPane.showMessageDialog(frame, "Deleted successfully!");
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Deletion failed! Please reselect a store from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			//maintain.users.remove(Home.u);
//			
//			maintain.updateStore();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void addItem(String name, String location, String category, 
			double price, int availability, int salepct, int quantity, 
			String size, String description, int x, int y, String user) throws Exception {
		Maintain maintain = new Maintain();
		
		maintain.loadItem();
		Item mg = new Item(name, location, category, price, availability, salepct, quantity, size, description, x, y, user);
		maintain.items.add(mg);
		maintain.updateItem();
	}
		
//	public void addItem(Object[] row, JFrame frame, DefaultTableModel model) {
//		// TODO Auto-generated method stub
//		try {
//			Maintain maintain = new Maintain();
//			
//			maintain.loadItem();
//			int newUser = 1;
//			for(Item u1 : maintain.items) {
//				if(u1.getName().equals(row[0]) && u1.getLocation().equals(row[1]) && u1.getSize().equals(row[6])) {
//					newUser = 0;
//				}
//			}
//			if(newUser == 1) {
//				Item mg = new Item(row[0].toString(), row[1].toString(), row[2].toString(), 
//						Double.valueOf(row[3].toString()), Integer.valueOf(row[4].toString()),Integer.valueOf(row[5].toString()), 
//						0, row[6].toString(), row[7].toString(), Integer.valueOf(row[8].toString()), Integer.valueOf(row[9].toString()), "");
//				maintain.items.add(mg);
//				maintain.updateItem();
//				model.addRow(row);
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Adding item failed! Item name or size already exists in the same location, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			
//		} 
//		catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	
	
	public void updateItem(Item s, String ItemName, String Location, String Category,
			String Price, String Availability, String Discount,
			String Size, String Description, String XTxt, String YTxt) {
		s.setName(ItemName);
		s.setLocation(Location);
		s.setCategory(Category);
		
		s.setPrice(Double.valueOf(Price));
		
		s.setAvailability(Integer.valueOf(Availability));
		s.setDiscountPct(Integer.valueOf(Discount));
		
		s.setSize(Size);
		s.setDescription(Description);
		s.setX(Integer.valueOf(XTxt));
		s.setY(Integer.valueOf(YTxt));
		s.setUser("");
		
	}
		
//	public void updateItem(JTable table, String ItemName, String Location, String Category,
//			String Price, String Availability, String Discount,
//			String Size, String Description, String XTxt, String YTxt, JFrame frame, DefaultTableModel model) {
//		try {
//			int i = table.getSelectedRow();
//			int newItem = -1;
//			String oldName = model.getValueAt(i, 0).toString();
//			String oldSize = model.getValueAt(i, 6).toString();
//			String oldLoc = model.getValueAt(i, 1).toString();
//			Maintain maintain = new Maintain();
//			maintain.loadItem();
//			for(Item s: maintain.items) {
//				if((s.getName().equals(ItemName) && ItemName.equals(oldName))
//						&& (s.getLocation().equals(Location) && Location.equals(oldLoc))
//						&& (s.getSize().equals(Size) && oldSize.equals(Size))) {
//					s.setName(ItemName);
//					s.setLocation(Location);
//					s.setCategory(Category);
//					
//					s.setPrice(Double.valueOf(Price));
//					
//					s.setAvailability(Integer.valueOf(Availability));
//					s.setDiscountPct(Integer.valueOf(Discount));
//					
//					s.setSize(Size);
//					s.setDescription(Description);
//					s.setX(Integer.valueOf(XTxt));
//					s.setY(Integer.valueOf(YTxt));
//					s.setUser("");
//					
//					model.setValueAt(ItemName, i, 0);
//					model.setValueAt(Location, i, 1);
//					model.setValueAt(Category, i, 2);
//					
//					model.setValueAt(Price, i, 3);
//					
//					model.setValueAt(Availability, i, 4);
//					model.setValueAt(Discount, i, 5);
//					
//					model.setValueAt(Size, i, 6);
//					model.setValueAt(Description, i, 7);
//					model.setValueAt(XTxt, i, 8);
//					model.setValueAt(YTxt, i, 9);
//					
//					
//					
//					
//					
//					maintain.updateItem();
//					JOptionPane.showMessageDialog(frame, "Update successfully!");
//					break;
//				}
//				else if(s.getName().equals(ItemName) && s.getLocation().equals(Location) && s.getSize().equals((Size))) {
//					newItem = -1;
//					JOptionPane.showMessageDialog(frame, "Update failed! Store location and size already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//					break;
//				}
//				else if(s.getName().equals(oldName) && s.getLocation().equals(oldLoc) && s.getSize().equals(oldSize)) {
//					newItem = maintain.items.indexOf(s);
//				}
//			}
//			if(newItem != -1) {
//				maintain.items.get(newItem).setName(ItemName);
//				maintain.items.get(newItem).setLocation(Location);
//				maintain.items.get(newItem).setCategory(Category);
//				
//				maintain.items.get(newItem).setPrice(Double.valueOf(Price));
//				
//				maintain.items.get(newItem).setAvailability(Integer.valueOf(Availability));
//				maintain.items.get(newItem).setDiscountPct(Integer.valueOf(Discount));
//				
//				maintain.items.get(newItem).setSize(Size);
//				maintain.items.get(newItem).setDescription(Description);
//				maintain.items.get(newItem).setX(Integer.valueOf(XTxt));
//				maintain.items.get(newItem).setY(Integer.valueOf(YTxt));
//				
//				model.setValueAt(ItemName, i, 0);
//				model.setValueAt(Location, i, 1);
//				model.setValueAt(Category, i, 2);
//				
//				model.setValueAt(Price, i, 3);
//				
//				model.setValueAt(Availability, i, 4);
//				model.setValueAt(Discount, i, 5);
//				
//				model.setValueAt(Size, i, 6);
//				model.setValueAt(Description, i, 7);
//				model.setValueAt(XTxt, i, 8);
//				model.setValueAt(YTxt, i, 9);
//				
//				
////				model.setValueAt(ItemNameTxt.getText(), i, 0);
////				model.setValueAt(LocationTxt.getText(), i, 1);
////				model.setValueAt(CategoryTxt.getText(), i, 2);
////				
////				model.setValueAt(PriceTxt.getText(), i, 3);
////				
////				model.setValueAt(AvailabilityTxt.getText(), i, 4);
////				model.setValueAt(DiscountTxt.getText(), i, 5);
////				
////				model.setValueAt((String)selectSize.getSelectedItem(), i, 6);
////				model.setValueAt(DescriptionTxt.getText(), i, 7);
//				
//				maintain.updateItem();
//				JOptionPane.showMessageDialog(frame, "Update successfully!", "Warning", JOptionPane.WARNING_MESSAGE);
//					
//			}
//				
//				
//				
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
	public void deleteItem( String ItemName , String location, String Size) throws Exception {
		Maintain maintain = new Maintain();
		
		maintain.loadItem();
		for(Item s : maintain.items) {
			if(s.getLocation().equals(location) && s.getName().equals(ItemName) && s.size.equals(Size)) {
				maintain.items.remove(s);
				break;
			}
		}
		
		maintain.updateItem();
		
	}
		
//	public void deleteItem(JTable table, String ItemName, String Location, String Category,
//			String Price, String Availability, String Discount,
//			String Size, String Description, String XTxt, String YTxt, JFrame frame, DefaultTableModel model) {
//		try {
//			Maintain maintain = new Maintain();
//			
//			maintain.loadItem();
//			int indexToRemove = -1;
//			for(Item u : maintain.items) {
//				if(ItemName.equals(u.getName())
//						&& Location.equals(u.getLocation())
//						&& Category.equals(u.getCategory())
//						&& Price.equals(String.valueOf(u.getPrice()))
//						&& Availability.equals(String.valueOf(u.getAvailability()))
//						&& Discount.equals(String.valueOf(u.getDiscountPct()))
//						&& Size.equals(u.getSize())
//						&& Description.equals(u.getDescription())
//						&& XTxt.equals(String.valueOf(u.getX()))
//						&& YTxt.equals(String.valueOf(u.getY()))) {
//					indexToRemove = maintain.items.indexOf(u);
//					model.removeRow(table.getSelectedRow());
//				}
//				
//			}
//			if(indexToRemove >= 0) {
//				maintain.items.remove(indexToRemove);
//				JOptionPane.showMessageDialog(frame, "Deleted successfully!");
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Deletion failed! Please reselect an item from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			//maintain.users.remove(Home.u);
//			
//			maintain.updateItem();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//	}

}
