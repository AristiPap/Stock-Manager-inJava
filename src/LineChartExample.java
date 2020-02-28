import javax.swing.JFrame;
import javax.swing.SwingUtilities;
//import javax.swing.SwingUtilities;  
//import javax.swing.WindowConstants;  
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.*; 
/**
 * @author imssbora
 *
 */
public class LineChartExample extends JFrame {

  private static final long serialVersionUID = 1L;

  public LineChartExample(String title,String username,User user) {
    super(title);
    // Create dataset
    DefaultCategoryDataset dataset = createDataset(user);
    // Create chart
    JFreeChart chart = ChartFactory.createLineChart(
        "Stock-Cost Variance", // Chart title
        "Date", // X-Axis Label
        "Profit", // Y-Axis Label
        dataset
        );

    ChartPanel panel = new ChartPanel(chart);
    setContentPane(panel);
  }

  private DefaultCategoryDataset createDataset(User obj) {
      
    List<String> series;
// Instantiate
    series=new ArrayList<>();
    for(int i=0; i<obj.getStockRecord().size(); i++){
      series.add(obj.getStockRecord().get(i).getStockName());//.getUsername();
    }
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    int thesis=0,pos;
    for(int j=0; j<obj.getStockRecord().size(); j++){
        pos=0;
        for(int k=0; k<obj.getStockRecord().get(thesis).getCost().size(); k++){
            dataset.addValue(obj.getStockRecord().get(thesis).getCost().get(pos),series.get(thesis),Integer.toString(pos+1)+"/"+Integer.toString(02)+"/"+Integer.toString(2020));
            pos++;
        }
        thesis++;
    }
    return dataset;
  }

}