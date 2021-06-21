import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;



public class User {   
    //Base Class
    private int user_id;
    private long contact_number;
    private String user_name;
    private String email_id;
    private String password;
    private String gender;
    Group g;

    public Boolean forgotPassword(String email_id);
    public Boolean signIn(String email_id, String password);
    public Boolean signUp(String email_id, String password,String user_name,long contact_number,String email_id,String gender);

    //Getter Functions
    public int getAge();
    public long getContact_Number();
    public String getName();
    public String getEmail();
    
    //Setter Functions
    public Boolean setAge(int new_age);
    public Boolean setContactNumber(long Contact_number);
    public Boolean setName(String name);
    public Boolean setEmail(String email);
}

// Group Admin inherits from User
public class Group_Admin extends User {
	private int group_admin_id;
    
    
    public Boolean userRequest(Group g,int user_id);
    public Boolean removeUser(int group_id,int user_id);
    public Boolean deleteEvent(Group g,int event_id);



}

// Super Admin inherits from User
public class Super_Admin extends User {
	private int super_admin_id;
    

    public Boolean groupRequest(int group_id);
    public Boolean removeUser(int user_id);
    public Boolean deteteGroup(int group_id);



}


class Group {
    private String group_name;
    private int group_id;
    private int group_admin;
    private String group_description;
    private int total_members;
    private Boolean status;

    User u;
    Group_Admin admin;

   

    public List<Group> viewGroup(int group_id,String group_name);
    public Boolean createGroup(int user_id);
    public Boolean updateGroup(int group_id,Group_Admin group_admin);
    public Boolean addUserGroup(User u,int group_id,Group_Admin group_admin);

    //Getter Functions
    public String getName();
    public int  getId();
    public Boolean status();
    public int group_admin();
    
    //Setter Functions
    public Boolean setName(String name);
    public int  setId(int group_id);
    public Boolean getStatus(Boolean status);
    public int group_admin(int group_admin);
}



class Events {
    private Timestamp startTime;
    private Timestamp endTime;
    private int members;
    private int event_id;
    private String event_name;
    private String event_description;

    Group g;
    User u;

    public Boolean createEvent(Group g,String event_name, String event_description, int members,Timestamp startTime, Timestamp endTime);
    public List<Event> viewEvent(Group g,String event_name,int event_id);
    public Boolean updateEvent(Group g,int event_id);
    public Boolean addUserEvent(Group g,User u,int event_id);
}

class Post {
     private Timestamp date_created;
    private int post_id;
    private int reply_id;
    private String post_content;

    Group g;

    public Boolean createPost(Group g,int post_id,String post_content,int reply_id);
    public Boolean updatePost(Group g,int post_id);
    public Boolean deletePost(Group g,int post_id);
    

   
}
