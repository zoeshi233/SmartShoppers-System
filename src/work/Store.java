package work;


public class Store {
	public String name;
	public String from;
	public String to;
	public String location;

	public Store(String name, String location, String from, String to) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.from = from;
		this.to = to;
		this.location = location;
		
	}
	public Store() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getLocation() {
		// TODO Auto-generated method stub
		return location;
	}
	
	
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	
}
