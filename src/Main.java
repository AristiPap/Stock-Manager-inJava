/**
 * @author Aristi_Papastavrou
 */
    import javax.swing.SwingUtilities;  
    import javax.swing.WindowConstants;  

public class Main {   
    
    public static void main(String[] args) {
        Interface obj = new Interface();
        UserRecords history = new UserRecords();
        obj.CreateInterface(history);
        
        //*******************************CREATE CHARTS***********************************//
    
    //we'll use the pie chart to show what portion of the earnings each stock has
        SwingUtilities.invokeLater(() -> {  
        PieChartExample example = new PieChartExample("Partial Gains of my Stocks",history.getRecord().get(history.getRecord().size()-1));  
        example.setSize(800, 400);  //size of pie chart (width,height)
        example.setLocationRelativeTo(null);  
    //the program will end when we close the window of the chart
        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        example.setVisible(true);  
        });        
    //we'll use the line chart to see the value of a stock throughout a time period
        
        SwingUtilities.invokeLater(() -> {
        LineChartExample example = new LineChartExample("Stock-Cost Variance",history.getRecord().get(history.getRecord().size()-1).getUsername(),history.getRecord().get(history.getRecord().size()-1));
        example.setAlwaysOnTop(true);
        example.pack();
        example.setSize(600, 400);
        example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        example.setVisible(true);
        });
       if(history.getRecord().get(history.getRecord().size()-1).getStockRecord().size()>1){
       history.getRecord().get(history.getRecord().size()-1).getStockRecord().get( history.getRecord().get(history.getRecord().size()-1).getStockRecord().size()-1).HelpSell( history.getRecord().get(history.getRecord().size()-1), history.getRecord().get(history.getRecord().size()-1).getStockRecord().get( history.getRecord().get(history.getRecord().size()-1).getStockRecord().size()-1));
       }
    }
}
