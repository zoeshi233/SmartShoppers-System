package work;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Customer extends User{
	public ArrayList<Item> sList = new ArrayList<Item>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	public void loadItem() throws Exception{
		//String path = "//Users//shuyi//eecs2030//3311project//src//res//shoppingList.csv";
		CsvReader reader = new CsvReader(CsvPath.SHOPPING_LIST); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Item i = new Item();
			//name,id,email,password
			i.setName(reader.get("Name"));
			i.setLocation(reader.get("Location"));
			i.setCategory(reader.get("Category"));
			i.setPrice(Double.valueOf(reader.get("Price")));
			i.setAvailability(Integer.valueOf(reader.get("Availability")));
			i.setDiscountPct(Integer.valueOf(reader.get("Discount")));
			i.setQuantity(Integer.valueOf(reader.get("Quantity")));
			i.setSize(reader.get("Size"));
			i.setDescription(reader.get("Description"));
			

			i.setX(Integer.valueOf(reader.get("X")));
			i.setY(Integer.valueOf(reader.get("Y")));
			i.setUser(reader.get("User"));
			
			sList.add(i);
		}
	}
	
	
	public void updateItem() {
		// TODO Auto-generated method stub
		try {
			//String path = "//Users//shuyi//eecs2030//3311project//src//res//shoppingList.csv";
			CsvWriter csvOutput = new CsvWriter(new FileWriter(CsvPath.SHOPPING_LIST, false), ',');
			//name,id,email,password
			csvOutput.write("Name");
			csvOutput.write("Location");
			csvOutput.write("Category");
			csvOutput.write("Price");
			csvOutput.write("Availability");
			csvOutput.write("Discount");
			csvOutput.write("Quantity");
			csvOutput.write("Size");
			csvOutput.write("Description");
			
			csvOutput.write("X");
			csvOutput.write("Y");
			
			csvOutput.write("User");
			
			
			csvOutput.endRecord();

			// else assume that the file already has the correct header line
			// write out a few records
			for(Item i: sList){
				csvOutput.write(i.getName());
				csvOutput.write(i.getLocation());
				csvOutput.write(i.getCategory());
				csvOutput.write(String.valueOf(i.getPrice()));
				csvOutput.write(String.valueOf(i.getAvailability()));
				csvOutput.write(String.valueOf(i.getDiscountPct()));
				csvOutput.write(String.valueOf(i.getQuantity()));
				csvOutput.write(i.getSize());
				csvOutput.write(i.getDescription());
				
				csvOutput.write(String.valueOf(i.getX()));
				csvOutput.write(String.valueOf(i.getY()));
				
				
				csvOutput.write(i.getUser());
				
				
				
				
				
				csvOutput.endRecord();
			}
			csvOutput.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void addItem(String name, String location, String category, 
			double price, int availability, int salepct, int quantity, 
			String size, String description, int x, int y, String user) throws Exception {
			Customer c = new Customer();
			c.loadItem();
			Item mg = new Item(name, location, category, price, availability, salepct, quantity, size, description, x, y, user);
			c.sList.add(mg);
			c.updateItem();
		// TODO Auto-generated method stub
//		try {
//			
//			loadItem();
//			int newUser = 1;
//			for(Item u1 : sList) {
//				if(u1.getName().equals(row[0]) && u1.getLocation().equals(row[1]) && u1.getSize().equals(row[6]) && u1.getUser().equals(Home.u.getName())) {
//					newUser = 0;
//				}
//			}
//			if(newUser == 1) {
//				Item mg = new Item(row[0].toString(), row[1].toString(), row[2].toString(), 
//						Double.valueOf(row[3].toString()), Integer.valueOf(row[4].toString()),Integer.valueOf(row[5].toString()), 
//						0, row[6].toString(), row[7].toString(), Integer.valueOf(row[8].toString()), Integer.valueOf(row[9].toString()), Home.u.name);
//				
//				
//				sList.add(mg);
//				updateItem();
//				JOptionPane.showMessageDialog(frame, "Item added to shopping list!");
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Item already exists in the shopping cart!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			
//		} 
//		catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
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
//			
//			loadItem();
//			for(Item s: sList) {
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
//					
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
//					updateItem();
//					JOptionPane.showMessageDialog(frame, "Update successfully!");
//					break;
//				}
//				else if(s.getName().equals(ItemName) && s.getLocation().equals(Location) && s.getSize().equals((Size))) {
//					newItem = -1;
//					JOptionPane.showMessageDialog(frame, "Update failed! Store location and size already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//					break;
//				}
//				else if(s.getName().equals(oldName) && s.getLocation().equals(oldLoc) && s.getSize().equals(oldSize)) {
//					newItem = sList.indexOf(s);
//				}
//			}
//			if(newItem != -1) {
//				sList.get(newItem).setName(ItemName);
//				sList.get(newItem).setLocation(Location);
//				sList.get(newItem).setCategory(Category);
//				
//				sList.get(newItem).setPrice(Double.valueOf(Price));
//				
//				sList.get(newItem).setAvailability(Integer.valueOf(Availability));
//				sList.get(newItem).setDiscountPct(Integer.valueOf(Discount));
//				
//				sList.get(newItem).setSize(Size);
//				sList.get(newItem).setDescription(Description);
//				sList.get(newItem).setX(Integer.valueOf(XTxt));
//				sList.get(newItem).setY(Integer.valueOf(YTxt));
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
//				model.setValueAt(YTxt, i, 8);
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
//				updateItem();
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
	
//	public void deleteItem(JTable table, String ItemName, String Location, String Category,
//			String Price, String Availability, String Discount,
//			String Size, String Description, String XTxt, String YTxt, JFrame frame, DefaultTableModel model) {
	public void deleteItem(String ItemName , String location, String Size) throws Exception {
		Customer c= new Customer();
		c.loadItem();
		for(Item s : c.sList) {
			if(s.getLocation().equals(location) && s.getName().equals(ItemName) && s.size.equals(Size)) {
				c.sList.remove(s);
				break;
			}
		}
		
		c.updateItem();
//		try {
//			
//			String ItemName = row[0].toString();
//			String Location = row[1].toString();
//			String Category = row[2].toString();
//			String Price = row[3].toString();
//			String Availability = row[4].toString();
//			String Discount = row[5].toString();
//			String Size = row[6].toString();
//			String Description = row[7].toString();
//			String XTxt = row[8].toString();
//			String YTxt = row[9].toString();
//			
//			loadItem();
//			int indexToRemove = -1;
//			for(Item u : sList) {
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
//					indexToRemove = sList.indexOf(u);
//					model.removeRow(table.getSelectedRow());
//				}
//				
//			}
//			if(indexToRemove >= 0) {
//				sList.remove(indexToRemove);
//				JOptionPane.showMessageDialog(frame, "Deleted successfully!");
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Deletion failed! Please reselect an item from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			//maintain.users.remove(Home.u);
//			
//			updateItem();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
