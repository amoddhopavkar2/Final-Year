package cl8;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("unused")
public class User {
	protected boolean logged_in;

    protected int user_id;
    protected String user_name;
    protected String user_type;

    protected boolean getLoginStatus() {
        return logged_in;
    }

    protected void logout() {
        this.logged_in = false;
    }
    
    public boolean login() {
        Scanner sc=new Scanner(System.in);
		System.out.print("Enter username:");
		String uname=sc.next();
		System.out.print("Enter password:");
		String pw=sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl8", "root", "amod02021999"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("select user_id from user where user_name=? and password=?");
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
    
    public void view_groups() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl8", "root", "amod02021999"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("select group_id, group_name, group_description from cl8.groups");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(3);
				
				System.out.print("ID: " + id + "\t");
				System.out.print("\tGROUP NAME: " + name + "\t");
				System.out.print("\tGROUP DESCRIPTION: " + desc + "\t");
				System.out.println();
			}
			c.close();
			}
			catch(Exception E)
			{
				System.out.println("An error occured");
			}
    }
    
    public void view_events() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    // loads driver
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cl8", "root", "amod02021999"); // gets a new connection
			PreparedStatement ps=c.prepareStatement("select event_id, event_name, event_description, date from cl8.events");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String desc=rs.getString(3);
				LocalDate date=rs.getDate(4).toLocalDate();
				
				System.out.print("ID: " + id + "\t");
				System.out.print("\tEVENT NAME: " + name + "\t");
				System.out.print("\tEVENT DATE: " + date + "\t");
				System.out.print("\tEVENT DESCRIPTION: " + desc + "\t");
				
				System.out.println();
			}
			c.close();
			}
			catch(Exception E)
			{
				System.out.println("An error occured");
			}
    	
    }
    
    public int user_actions() {
    	Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice:");
		System.out.println("1. View all groups");
		System.out.println("2. View all events");
		System.out.println("3. Join a group");
		System.out.println("4. Join an event");
		System.out.println("5. Logout");
		int choice=sc.nextInt();
		return choice;
    }
    
    public void join_group() {
    	
    }
    
    public void join_event() {
    	
    }
    
}
