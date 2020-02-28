/*
 * @author Aristi_Papastavrou
 */
import java.util.Scanner;
import java.util.*; 
import java.io.Console;
public class Interface extends UserRecords{

    public Interface(){}
    
    public void CreateInterface(UserRecords record){
        boolean found=false;
        System.out.println("Welcome to StockManger!\n\n");
        System.out.println("~1)SignIn\n" + "~2)SignUp\n");
        System.out.println("\tIf you are not already a member go on and choose 1. Else choose 2");
        Scanner input_scanner = new Scanner(System.in);
        int choice = input_scanner.nextInt();  
        
        //if the user chose to sign in then go search for the username he enters in the list of users
        if(choice==1){
            while(found==false){
                System.out.println("Enter username:\n");
                Scanner scanner = new Scanner(System.in);
                String _username=scanner.nextLine();
                for (int i = 0; i < getRecord().size(); i++) {
                    System.out.println(getRecord().get(i));
                    if(getRecord().get(i).getUsername()==_username){
                        System.out.println("Welcome back "+ _username +"!");
                        found=true;
                        break;
                    } 
                }
            //user was not found
                if(found==false){
                    System.out.println("The username that you entered doesn't exist.Please try again:\n");
                }
            }
        } 
        //if the user chose to sign up then push back to the list of users his username and password
        //if the username already exists tell the user to find a new one 
        else if(choice==2){
            boolean instruction=true;
            System.out.println("Enter username:");
            Scanner scanner = new Scanner(System.in);
            String username=scanner.nextLine();
            System.out.println("Enter password:\n");
            Scanner newscanner = new Scanner(System.in);
            String password=newscanner.nextLine();
            //add new user to the record of the app
            //System.out.println(username);            
            
            record.getRecord().add(new User(username,password));
            //add stocks to the user's account
            while(instruction==true){
                System.out.println("Enter name of the Stock you just bought :\n");
                Scanner _scanner = new Scanner(System.in);
                String stockname=_scanner.nextLine();
                record.getRecord().get(record.getRecord().size()-1).getStockRecord().add(new StockCharacteristics(stockname));
                System.out.println("Do you have an another stock to insert to your account?\n(Type yes || no)");
                Scanner scanner_val = new Scanner(System.in);
                String order=scanner_val.nextLine();
                if(order.equals("yes")==true){
                    instruction=true;
                }
                else{
                    instruction=false;
                }
            }
        }
    }    
}
