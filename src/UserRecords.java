/*
 * @author Aristi_Papastavrou
 */
import java.util.*; 
//keeps a history record of all the users usernames and passwords
//helps with the sign-in/sign-up 
public class UserRecords {
    private List<User> users;
    //the constructor just creates 3 new users so that our application has some users to work with
    public UserRecords(){
        users=new ArrayList<>();
        users.add(new User("Aria_Papastavrou","A1B2"));
        users.add(new User("Bill_Gates","Bill123"));
        users.add(new User("Elon_Musk","Tesla24k"));
    }
    //add new user to the record of the "app"
    //we call this function if the user chooses to signup
    public void AddtoRecord(String _username,String _password){
        users.add(new User(_username,_password));
    }
    
    public List<User> getRecord() {
        return users;
    }
}