package wordbuilder;

import database.DatabaseOperations;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class QuizAnalysis extends JFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    WindowAdapter  windowadapter;
    public QuizAnalysis(final String title) {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
        windowadapter = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
              
              setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
                
                //System.out.println("hello world");
                //System.exit(0);
            }
        };

     addWindowListener(windowadapter);

    }

    /**
     * Returns a sample dataset.
     * 
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
        
        
        double scoreR=0,scoreW=0,scoreD=0;
        int scoreLR=0,scoreLW=0,scoreLD=0;
        try {
            DatabaseOperations.init();
            ArrayList<Double> scoreGetD = DatabaseOperations.getScoreDepth(WordBuilder.getCurrentUser());
            ArrayList<Double> scoreGetR = DatabaseOperations.getScoreRention(WordBuilder.getCurrentUser());
            ArrayList<Double> scoreGetW = DatabaseOperations.getScoreWidth(WordBuilder.getCurrentUser());
            ArrayList<Integer> scoreGetL = DatabaseOperations.getLastQuizData(WordBuilder.getCurrentUser());
            if(scoreGetD.size()>0)
            {
                scoreD = scoreGetD.get(1);
            }
            if(scoreGetR.size()>0)
            {
                 scoreR = scoreGetR.get(1);
            }
            if(scoreGetW.size()>0)
            {
                 scoreW = scoreGetW.get(1);
            }
            if(scoreGetL.size()>0)
            {
                scoreLR = scoreGetL.get(0);
                scoreLW = scoreGetL.get(2);
                scoreLD = scoreGetL.get(1);
                        
            }
        } catch (Exception ex) {
            Logger.getLogger(QuizAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // row keys...
        final String series1 = "Last Quiz";
        final String series2 = "Average";
        

        // column keys...
        final String category1 = "Retention";
        final String category2 = "Width";
        final String category3 = "Depth";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        dataset.addValue(scoreLR, series1, category1);
        dataset.addValue(scoreLD, series1, category2);
        dataset.addValue(scoreLW, series1, category3);
        

        dataset.addValue(scoreR, series2, category1);
        dataset.addValue(scoreW, series2, category2);
        dataset.addValue(scoreD, series2, category3);

        
        return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Last Quiz Vs Average",         // chart title
            "Average",               // domain axis label
            "Score",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
   

}
