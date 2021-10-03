/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.math.plot.Plot2DPanel;


public class ClaseBoton {
    
   public void metodoBoton(DefaultTableModel model,  ArrayList iteraciones, JTable JTabla, JRadioButton jRBLineas,
                            JPanel lineas,  Plot2DPanel grafica, JLabel jLabel4,JPanel jPanel3){
              ChartPanel panel = null;
        JFreeChart chart = null;

        model.setRowCount(iteraciones.size());
        model.setColumnCount(5);
        JTabla.setModel(model);
        
        if (jRBLineas.isSelected()) {

            int validar = 1;
            XYSplineRenderer renderer = new XYSplineRenderer();
            XYSeriesCollection dataset = new XYSeriesCollection();
            ValueAxis x = new NumberAxis();
            ValueAxis y = new NumberAxis();
            XYSeries serie = new XYSeries("Datos");
            XYPlot plot;
         
            lineas.removeAll();
            try {
                for (int fila = 2; fila < iteraciones.size(); fila++) {
//              Asiganto valor a la grafica "Gráfica de Error rel. aprox."
                    serie.add(Float.parseFloat(String.valueOf(JTabla.getValueAt(fila - 1, 0))),
                            Float.parseFloat(String.valueOf(JTabla.getValueAt(fila - 1, 4))));
                }
            } catch (Exception ex) {
                validar = 0;
            }
            if (validar == 1) {
                dataset.addSeries(serie);
                x.setLabel("Eje X  (No. de iteraciones)");
//                x.setLabel("No de iteraciones");
                y.setLabel("Eje Y  (Error rel. aprox.)");
                plot = new XYPlot(dataset, x, y, renderer);
                chart = new JFreeChart(plot);
                chart.setTitle("Gráfica de Error rel. aprox.");
            }
        }
        panel = new ChartPanel(chart);
        panel.setBounds(5, 10, 410, 350);

        if (jRBLineas.isSelected()) {
            lineas.add(panel);
            lineas.repaint();

        } else if (jRBLineas.isDisplayable()) {
//            Para ocultar la grafica

            lineas.setVisible(false);
            grafica.setVisible(false);
            jLabel4.setVisible(false);
            jPanel3.setVisible(false);

        }
   }
       
    
}
