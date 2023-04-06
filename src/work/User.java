package work;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class User {
	public String name;
	public String email;
	public String password;
	public String userType;
	public String preference;
	
	public User(String name, String email, String password, String userType, String store) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.preference = store;
		
	}
	
	public User() {
		super();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getStore() {
		return preference;
	}
	public void setStore(String store) {
		this.preference = store;
	}
	public int isDuplicate(String username, ArrayList<User> users) {
		
		int newUser = - 1;
		for(User u : users) {
			if(u.getName().equals(username)) {
				newUser = users.indexOf(u);
				return newUser;
			}
			
		}
		return newUser;
		
	}
//	public void createUser(String userName, String email, String password, String userType, JFrame frame) {
//		try {
//			Maintain maintain = new Maintain();
//		
//			maintain.loadUser();
//			
//			int newUser = 1;
//			for(User u : maintain.users) {
//				if(u.getName().equals(userName)) {
//					newUser = 0;
//				}
//			}
//			if(newUser == 1) {
//				User regUser = new User(userName, email, password, userType, "");
//				maintain.users.add(regUser);
//				maintain.updateUser();
//			
//				frame.dispose();
//				Login lg = new Login();
//				lg.frame.setVisible(true);
//			}
//			else {
//				JOptionPane.showMessageDialog(frame, "Registration failed! Username already exists, please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
//			}
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
//	public void addManager(final Object[] row, JFrame frame, DefaultTableModel model) {
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
	

	
	
	@Override
	public String toString() {
		return "User [Username = " + name + ", Email = " + email + ", Password = " + password + ", UserType = " + userType + ", Store = " + preference + "]";
	}
	
}
