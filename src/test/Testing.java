package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import work.*;

public class Testing {
	User u;
	User u1;
	ArrayList<User> users;
	Maintain m;
	Store s;
	@Before
	public void setUp() throws Exception {
		u = new User();
		s = new Store();
		users = new ArrayList<User>();
	}

	@Test
	public void test() {
		
		
	}
	
	@Test
	public void USetUp() {
		try {
			m = new Maintain();
			m.loadUser();
			u1 = new User("1", "2", "3", "4", "5");
			assertEquals("1", u1.getName());
			assertEquals("2", u1.getEmail());
			assertEquals("3", u1.getPassword());
			assertEquals("4", u1.getUserType());
			assertEquals("5", u1.getStore());
			m.users.add(u1);
			m.users.remove(u1);
			m.updateUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void USetUp2() {
		u1 = new User("a", "b", "c", "d", "e");
		u1.setName("1");
		u1.setEmail("2");
		u1.setPassword("3");
		u1.setUserType("4");
		u1.setStore("5");
		
		assertEquals("1", u1.getName());
		assertEquals("2", u1.getEmail());
		assertEquals("3", u1.getPassword());
		assertEquals("4", u1.getUserType());
		assertEquals("5", u1.getStore());
		
	}
	@Test
	public void UserProfile() {
		users = new ArrayList<User>();
		u1 = new User("a", "b", "c", "d", "e");
		u = new User("1", "b", "c", "d", "e");
		users.add(u1);
		users.add(u);
		
		assertEquals(0, u1.isDuplicate(u1.getName(), users));
		
	}
	@Test
	public void UserProfile2() {
		users = new ArrayList<User>();
		u1 = new User("a", "b", "c", "d", "e");
		u = new User("1", "b", "c", "d", "e");
		users.add(u);
		users.add(u1);
		assertEquals(u1.isDuplicate(u1.getName(), users), 1);
		
	}
	@Test
	public void createUser() {
		users = new ArrayList<User>();
		u1 = new User("a", "b", "c", "d", "e");
		u = new User("1", "b", "c", "d", "e");
		users.add(u1);
		users.add(u);
		
		
		assertEquals(0, u1.isDuplicate(u1.getName(), users));
		
	}
	@Test
	public void UtoString() {
		u1 = new User("a", "b", "c", "d", "e");
		assertEquals("User [Username = a, Email = b, Password = c, UserType = d, Store = e]", u1.toString());
		
	}
	@Test
	public void addManager1() throws Exception {
		Admin a = new Admin();
		a.addManager("test", "test1", "test2", "test4");
		a.deleteManager("test");
		
	}
	@Test
	public void addManager2() throws Exception {
		Admin a = new Admin();
		u1 = new User("a", "b", "c", "d", "e");
		a.updateManager(u1, "test1", "test2", "test3", "test4");
		
	}
	@Test
	public void storeSetUp() {
		s = new Store("test", "testLoc", "10:00", "20:00");
		assertEquals(s.getName(), "test");
		assertEquals(s.getLocation(), "testLoc");
		assertEquals(s.getFrom(), "10:00");
		assertEquals(s.getTo(), "20:00");
		
	}
	@Test
	public void storeSetUp2() {
		s = new Store("122", "test32c", "10:30", "21:00");
		s.setName("test");
		s.setLocation("testLoc");
		s.setFrom("10:00");
		s.setTo("20:00");
		
		assertEquals(s.getName(), "test");
		assertEquals(s.getLocation(), "testLoc");
		assertEquals(s.getFrom(), "10:00");
		assertEquals(s.getTo(), "20:00");
		
	}
	@Test
	public void addStore1() throws Exception {
		Admin a = new Admin();
		a.addStore("test", "loc", "12:00" , "12:00");
		a.deleteStore("loc");
	}
	@Test
	public void addStore2() throws Exception {
		Admin a = new Admin();
		a.addStore("test", "loc2", "12:00" , "12:00");
		a.deleteStore("loc2");
	}
	@Test
	public void updateStore1() throws Exception {
		Admin a = new Admin();
		s = new Store("test1", "loc1", "12:05" , "13:00");
		a.updateStore(s, "test", "loc", "12:00" , "20:00");
		assertEquals(s.getName(), "test");
		assertEquals(s.getLocation(), "loc");
		assertEquals(s.getFrom(), "12:00");
		assertEquals(s.getTo(), "20:00");
		a.deleteStore("loc");
	}
	@Test
	public void updateStore2() throws Exception {
		Admin a = new Admin();
		s = new Store("te233", "lij", "12:05" , "13:00");
		a.updateStore(s, "test", "loc2", "12:00" , "20:00");
		assertEquals(s.getName(), "test");
		assertEquals(s.getLocation(), "loc2");
		assertEquals(s.getFrom(), "12:00");
		assertEquals(s.getTo(), "20:00");
		a.deleteStore("loc2");
	}
	@Test
	public void addItem() throws Exception {
		
		Item i = new Item("test", "loc", "cate", 
				12, 10, 20, 1,
				"Small", "des", 10, 11, "admi");
		i.setUser("admin");
		assertEquals(i.getName(), "test");
		assertEquals(i.getLocation(), "loc");
		assertEquals(i.getCategory(), "cate");
		assertEquals(true, i.getPrice() == 12);
		assertEquals(true, i.getAvailability() == 10);
		assertEquals(true, i.getDiscountPct() == 20);
		assertEquals(true, i.getQuantity() == 1);
		assertEquals(i.getSize(),"Small");
		assertEquals(i.getDescription(), "des");
		assertEquals(i.getX(), 10);
		assertEquals(i.getY(), 11);
		assertEquals(i.getUser(), "admin");
		
	}
	@Test
	public void addItem2() throws Exception {
		Admin a = new Admin();
		a.addItem("test", "loc", "cate", 
				11.2, 30, 25, 1,
				"Small", "des", 0, 1, "admin");
		a.deleteItem("test", "loc", "Small");
	}
	@Test
	public void updateItem() throws Exception {
		Admin a = new Admin();
		Item i = new Item("test2", "loc", "cate", 
				12, 10, 20, 1,
				"Small", "des", 10, 121, "admin");
		a.updateItem(i, "test", "loc", "cate", 
				"12", "10", "20",
				"Small", "des", "10", "11");
		
		assertEquals(i.getName(), "test");
		assertEquals(i.getLocation(), "loc");
		assertEquals(i.getCategory(), "cate");
		assertEquals(true, i.getPrice() == 12);
		assertEquals(true, i.getAvailability() == 10);
		assertEquals(true, i.getDiscountPct() == 20);
		
		assertEquals(i.getSize(),"Small");
		assertEquals(i.getDescription(), "des");
		assertEquals(i.getX(), 10);
		assertEquals(i.getY(), 11);
		a.deleteItem("test", "loc", "Small");
		
	}
	
	@Test
	public void updateItem2() throws Exception {
		Admin a = new Admin();
		Item i = new Item("test33", "loc", "cate", 
				22, 10, 20, 11,
				"Small", "des", 10, 121, "admin");
		a.updateItem(i, "test", "loc", "cate", 
				"12", "10", "20",
				"Small", "des", "10", "11");
		
		assertEquals(i.getName(), "test");
		assertEquals(i.getLocation(), "loc");
		assertEquals(i.getCategory(), "cate");
		assertEquals(true, i.getPrice() == 12);
		assertEquals(true, i.getAvailability() == 10);
		assertEquals(true, i.getDiscountPct() == 20);
		
		assertEquals(i.getSize(),"Small");
		assertEquals(i.getDescription(), "des");
		assertEquals(i.getX(), 10);
		assertEquals(i.getY(), 11);
		a.deleteItem("test", "loc", "Small");
		
	}
	
	@Test
	public void MaddItem2() throws Exception {
		Manager a = new Manager();
		a.addItem("test", "loc", "cate", 
				11.2, 30, 25, 1,
				"Small", "des", 0, 1, "admin");
		a.deleteItem("test", "loc", "Small");
	}
	@Test
	public void MupdateItem() throws Exception {
		Manager a = new Manager();
		Item i = new Item("test2", "loc", "cate", 
				12, 10, 20, 1,
				"Small", "des", 10, 121, "admin");
		a.updateItem(i, "test", "loc", "cate", 
				"12", "10", "20",
				"Small", "des", "10", "11");
		
		assertEquals(i.getName(), "test");
		assertEquals(i.getLocation(), "loc");
		assertEquals(i.getCategory(), "cate");
		assertEquals(true, i.getPrice() == 12);
		assertEquals(true, i.getAvailability() == 10);
		assertEquals(true, i.getDiscountPct() == 20);
		
		assertEquals(i.getSize(),"Small");
		assertEquals(i.getDescription(), "des");
		assertEquals(i.getX(), 10);
		assertEquals(i.getY(), 11);
		a.deleteItem("test", "loc", "Small");
		
	}
	@Test
	public void addToShoppingList() throws Exception {
		Customer c = new Customer();
		c.loadItem();
		c.addItem("test", "loc", "cate", 
				11.2, 30, 25, 1,
				"Small", "des", 0, 1, "admin");
		c.deleteItem("test", "loc", "Small");
	}
	@Test
	public void addToShoppingList2() throws Exception {
		Customer c = new Customer();
		c.loadItem();
		c.addItem("test", "loc", "cate", 
				12.5, 30, 25, 2,
				"Small", "des", 8, 1, "admin");
		c.deleteItem("test", "loc", "Small");
	}
	@Test
	public void recommandation() throws Exception {
		Customer c = new Customer();
		c.loadItem();
		c.addItem("test", "loc", "cate", 
				12.5, 30, 25, 2,
				"Small", "des", 8, 1, "admin");
		for(Item i : c.sList) {
			if(i.discountPct > 0){
				c.deleteItem("test", "loc", "Small");
			}
		}
		
	}
	@Test
	public void recommandation2() throws Exception {
		Customer c = new Customer();
		c.loadItem();
		c.addItem("test", "rec", "cate", 
				12.5, 30, 25, 2,
				"Small", "des", 8, 1, "admin");
		for(Item i : c.sList) {
			if(i.location.equals("rec")) {
				c.deleteItem("test", "rec", "Small");
			}
			
		}
		
	}
}
