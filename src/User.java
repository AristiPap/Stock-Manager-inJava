/**
 * @author aristi
 */
import java.util.*; 

public class User{//1extends StockCharacteristics{
    private final String Username;
    private final String Password;
    private final List<StockCharacteristics> stocks;
    private int thesis;
    
    public User(String a,String b){
        Username=a;
        Password=b;
        thesis=0;
        stocks=new ArrayList<>();
    }    
    
    public String getUsername(){
        return Username;
    }
    public List<StockCharacteristics> getStockRecord() {
        return stocks;
    }
}
