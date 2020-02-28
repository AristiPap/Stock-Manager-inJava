/**
 *
 * @author Aristi_Papastavrou
 */

import java.lang.Math;
import java.util.*; 

public class StockCharacteristics {
    
    private String Stock_name;
    private int InitialCost;
    private int stock_change;
    private List<Integer> CostVariance;// = new ArrayList<>();
    
    //function to add Stock-Information
    public StockCharacteristics(){
        CostVariance=new ArrayList<>();
    }
    public StockCharacteristics(String str){
        CostVariance=new ArrayList<>();
        Stock_name=str;
        
        //obj.getStockRecord().add(new StockCharacteristics(Stock_name));
        InitialCost=(int )(Math.random() * 16487 + 1);
        //CostVariance=new ArrayList<>();
        //adding costvariances of the stock randomly
        int temp=InitialCost,counter=0;
        this.getCost().add(InitialCost);
        for(int i=0; i<7; i++){
            if(counter%2==0){
                temp+=(int )(Math.random() * 248 + 1);
                stock_change=temp;
                this.getCost().add(stock_change);
                counter++;
            }
            else{
                temp-=(int )(Math.random() * 248 + 1);
                stock_change=temp;
                this.getCost().add(stock_change);
                counter++;
            }
        }
    }
 
    public Integer getStockChanged(){
        return stock_change;
    }
    public List<Integer> getCost() {
        return CostVariance;
    }
    public String getStockName(){
        return Stock_name;
    }
    public Integer getInitialCost(){
        return InitialCost;
    }
    public void HelpSell(User a,StockCharacteristics obj){
       // check if the user should sell the stock
       if(obj.getInitialCost()>obj.getStockChanged()){
           System.out.println(obj.getStockName() +"has been removed from your stocks with success!\n");
           a.getStockRecord().remove(obj);
       }
       else{
            System.out.println(obj.getStockName() +" is lucrative,you shouldn't sell.\n");
       }
    }
}
