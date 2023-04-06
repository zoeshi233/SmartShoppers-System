package work;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Maintain {
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Store> stores = new ArrayList<Store>();
	public ArrayList<Item> items = new ArrayList<Item>();
	public String path;
	
	public void loadUser() throws Exception{
//		String path = "//Users//shuyi//eecs2030//3311project//src//res//user.csv";
		CsvReader reader = new CsvReader(CsvPath.USER);
		
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			//name,id,email,password
			user.setName(reader.get("Username"));
			user.setEmail(reader.get("Email"));
			user.setPassword(reader.get("Password"));
			user.setUserType(reader.get("UserType"));
			user.setStore(reader.get("Store"));
			users.add(user);
		}
	}
	
	public void updateUser() throws Exception{
		try {		
//				String path = "//Users//shuyi//eecs2030//3311project//src//res//user.csv";
				CsvWriter csvOutput = new CsvWriter(new FileWriter(CsvPath.USER, false), ',');
				//name,id,email,password
				csvOutput.write("Username");
		    	csvOutput.write("Email");
				csvOutput.write("Password");
				csvOutput.write("UserType");
				csvOutput.write("Store");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getName());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getUserType());
					csvOutput.write(u.getStore());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	public void loadStore() throws Exception{
//		String path = "//Users//shuyi//eecs2030//3311project//src//res//store.csv";
		CsvReader reader = new CsvReader(CsvPath.STORE); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Store s = new Store();
			//name,id,email,password
			s.setName(reader.get("Name"));
			s.setLocation(reader.get("Location"));
			s.setFrom(reader.get("Opening"));
			s.setTo(reader.get("Closing"));
			stores.add(s);
		}
	}
	
	public void updateStore() throws Exception{
		try {
			//String path = "//Users//shuyi//eecs2030//3311project//src//res//store.csv";
			CsvWriter csvOutput = new CsvWriter(new FileWriter(CsvPath.STORE, false), ',');
			//name,id,email,password
			csvOutput.write("Name");
			csvOutput.write("Location");
			csvOutput.write("Opening");
			csvOutput.write("Closing");
			csvOutput.endRecord();

			// else assume that the file already has the correct header line
			// write out a few records
			for(Store s: stores){
				csvOutput.write(s.getName());
				csvOutput.write(s.getLocation());
				csvOutput.write(s.getFrom());
				csvOutput.write(s.getTo());
				csvOutput.endRecord();
			}
			csvOutput.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadItem() throws Exception{
		//String path = "//Users//shuyi//eecs2030//3311project//src//res//item.csv";
		CsvReader reader = new CsvReader(CsvPath.ITEM); 
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
			
			items.add(i);
		}
	}

	public void updateItem() {
		// TODO Auto-generated method stub
		try {
			//String path = "//Users//shuyi//eecs2030//3311project//src//res//item.csv";
			CsvWriter csvOutput = new CsvWriter(new FileWriter(CsvPath.ITEM, false), ',');
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
			
			
			csvOutput.endRecord();

			// else assume that the file already has the correct header line
			// write out a few records
			for(Item i: items){
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
				
				
				
				
				
				
				csvOutput.endRecord();
			}
			csvOutput.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
//	public static void main(String [] args) throws Exception{
//		
//		String path = "//Users//shuyi//eecs2030//3311project//src//res//user.csv";
//		File f = new File(path);
//		MaintainUser maintain = new MaintainUser();
//	
//		maintain.load(path);
//		for(User u: maintain.users){
//			System.out.println(u.toString());
//		}
//		
//
//		//User newUser = new User("t4", 4, "t4@yorku.ca", "t4t4");
//		//maintain.users.add(newUser);
//		
//		maintain.update(path);
//	}
}
