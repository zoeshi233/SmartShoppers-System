package work;

public class Manager extends User{
	public Store store;
	
	
	
	public Manager() {
		// TODO Auto-generated constructor stub
		super();
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
	
//	public void addItem(final Object[] row, JFrame frame, DefaultTableModel model) {
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
