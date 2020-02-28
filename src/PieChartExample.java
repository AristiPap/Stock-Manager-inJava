/*
* @return 
*/
    import java.text.DecimalFormat;  
    
    import javax.swing.JFrame;  
    import javax.swing.SwingUtilities;  
    import javax.swing.WindowConstants;  
      
    import org.jfree.chart.ChartFactory;  
    import org.jfree.chart.ChartPanel;  
    import org.jfree.chart.JFreeChart;  
    import org.jfree.chart.labels.PieSectionLabelGenerator;  
    import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
    import org.jfree.chart.plot.PiePlot;  
    import org.jfree.data.general.DefaultPieDataset;  
    import org.jfree.data.general.PieDataset;  
    
    
public class PieChartExample extends JFrame {  

    private static final long serialVersionUID = 6294689542092367723L;  
      
      public PieChartExample(String title,User obj) {  
        super(title);  
      
        // Create dataset  
        PieDataset dataset = createDataset(obj);  
      
        // Create chart  
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart Example",dataset,true,true,false);  
      
        //Format Label  Marks {0} : ({2})
        //the {2} means that in the chart it will print both the decimal part of the percentage and the "%" sign
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);  
          
        // Create Panel  
        ChartPanel panel = new ChartPanel(chart);  
        setContentPane(panel);  
      }  
      
      private PieDataset createDataset(User obj) {  
      
        DefaultPieDataset dataset=new DefaultPieDataset();
        
        int pos=0,temp=0;
         for(int j=0; j<obj.getStockRecord().size(); j++){
             temp+=obj.getStockRecord().get(pos).getStockChanged();
             pos++;
         }
         pos=0;
        for(int j=0; j<obj.getStockRecord().size(); j++){
            if(obj.getStockRecord().size()==1){
                dataset.setValue(obj.getStockRecord().get(pos).getStockName(),obj.getStockRecord().get(pos).getStockChanged()/temp);
            }
            else{
                dataset.setValue(obj.getStockRecord().get(pos).getStockName(),obj.getStockRecord().get(pos).getStockChanged()%temp);
            }
            pos++;
        }
        return dataset;
      }  
      
    }  