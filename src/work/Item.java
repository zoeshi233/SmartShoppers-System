package work;

public class Item {
	public String name;
	public String location;
	public String category;
	
	public double price;
	
	public int availability;
	public int discountPct;
	public int quantity;
	
	public int x;
	public int y;
	
	public String user;
	
	public String size;
	public String description;
	
	public Item(String name, String location, String category, 
			double price, 
			int availability, int discountPct, int quantity, 
			String size, String description, int x, int y, String user) {
		this.name = name;
		this.location = location;
		this.category = category;
		
		this.price = price;
		
		this.availability = availability;
		this.discountPct = discountPct;
		this.quantity = quantity;
		
		this.size = size;
		this.description = description;
		
		this.x = x;
		this.y = y;
		this.user = user;
	}
	
	public Item() {
		super();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return location;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	
	
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public int getAvailability() {
		return availability;
	}
	public void setDiscountPct(int discountPct) {
		this.discountPct = discountPct;
	}
	public int getDiscountPct() {
		return discountPct;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
