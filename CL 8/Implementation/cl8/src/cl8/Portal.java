package cl8;
import java.util.*;

public class Portal {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int utype;
		do
		{
			System.out.print("Press 1 for user login, 2 for super admin login, 3 for group admin login,4 to exit: ");
			utype=sc.nextInt();
			
				if(utype==1)
				{
					User us = new User();
					boolean log_stat =us.login();
					if(log_stat==false)
						System.out.println("Login failed...viewing as Guest...");
				
					int choice=0;
					while(choice!=5)
					{
						choice=us.user_actions();
						switch(choice) 
						{
							case 1:
								us.view_groups();
								break;
							case 2:
								us.view_events();
								break;
							case 3:
								us.join_group();
								break;
							case 4:
								us.join_event();
								break;
							case 5:
								us.logout();
								us=null;
						}
					}
				}
			if(utype==2)
			{
				SuperAdmin super_adm=new SuperAdmin();
				boolean log_stat = super_adm.login();
				if(log_stat==false || super_adm.getLoginStatus()==false)
					super_adm=null;
				else
				{
					System.out.println("\nSuper Admin login successful\n\n");
					int choice=0;
					while(choice!=5)
					{
						choice = super_adm.super_admin_actions();
						switch(choice) 
						{
							case 1:
								super_adm.new_group();
								break;
							case 2:
								super_adm.new_event();
								break;
							case 3:
								super_adm.view_groups();
								break;
							case 4:
								super_adm.view_events();
								break;
							case 5:
								super_adm.logout();
								super_adm=null;
								break;
						}
					}
				}
			}
			
			if(utype==3) {
				GroupAdmin group_adm = new GroupAdmin();
				boolean log_stat = group_adm.login();
				if(log_stat==false || group_adm.getLoginStatus()==false)
					group_adm=null;
				else
				{
					System.out.println("\nGroup Admin login successful\n\n");
					int choice=0;
					while(choice!=4)
					{
						choice = group_adm.group_admin_actions();
						switch(choice) 
						{
							case 1:
								group_adm.new_event();
								break;
							case 2:
								group_adm.view_groups();
								break;
							case 3:
								group_adm.view_events();
								break;
							case 4:
								group_adm.logout();
								group_adm=null;
								break;
						}
					}
				}
			}
		}while(utype!=4);
		sc.close();
	}

}
