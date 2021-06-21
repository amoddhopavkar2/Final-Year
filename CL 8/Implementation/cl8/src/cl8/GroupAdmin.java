package cl8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

@SuppressWarnings("unused")
public class GroupAdmin extends User{
	private int group_id;
	   
    public boolean login() {
        Scanner sc=new Scanner(System.in);
		System.out.print("Enter group admin username:");
		String uname=sc.next();
		System.out.print("Enter group admin password:");
		String pw=sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl8", "root", "amod02021999"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("select group_admin_id from group_admin where group_admin_name=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pw);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				user_id=rs.getInt(1);
				user_name=uname;
				logged_in=true;
			}
			c.close();
		}
		catch(Exception E) {
			System.out.println("An error occured");
			return false;
		}
		this.logged_in=true;
		return true;
	}
    
    public int group_admin_actions() {
    	Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. Add a new event");
		System.out.println("2. View all groups");
		System.out.println("3. View all events");
		System.out.println("4. Logout");
		int choice=sc.nextInt();
		return choice;
    }
    
    public void new_event() {
    	try {
    		Scanner sc=new Scanner(System.in);
    		System.out.print("Enter event name:");
    		String ename=sc.next();
    		System.out.print("Enter event description:");
    		String edescription=sc.next();
			
    		Class.forName("com.mysql.cj.jdbc.Driver");
		    // loads driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl8", "root", "amod02021999"); // gets a new connection
			PreparedStatement ps = conn.prepareStatement("insert into events(event_name, event_description) values (?, ?)");
			
			ps.setString(1,  ename);
			ps.setString(2,  edescription);
			ResultSet rs = ps.executeQuery();
			System.out.println("Inserted Successfully");
			
			conn.close();
			}
			catch(Exception E)
			{
				System.out.println("An error occured");
			}
    }

}
