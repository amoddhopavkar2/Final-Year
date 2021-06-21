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
}

// Group Admin inherits from User
public class Group_Admin extends User {
    private int group_admin_id;
}

// Super Admin inherits from User
public class Super_Admin extends User {
    private int super_admin_id;
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
}

class Post {
     private Timestamp date_created;
    private int post_id;
    private int reply_id;
    private String post_content;

    Group g;  
}
