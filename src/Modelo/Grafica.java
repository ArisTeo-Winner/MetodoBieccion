/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Funcion;
import Modelo.Biseccion;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import org.nfunk.jep.JEP;
import sun.security.rsa.RSACore;
import org.math.plot.Plot2DPanel;
import org.nfunk.jep.JEP;

/**
 *
 * @author Aris
 */
public class Grafica extends javax.swing.JFrame {

        Plot2DPanel grafica = new Plot2DPanel();
        
        JPanel lineas;

    public Grafica() {

        grafica.setBounds(30, 240, 400, 330);
        add(grafica);
    }
    public void graficar( Plot2DPanel grafica, JPanel lineas, JTextField funcion, JTextField raiz, JTextField x0, 
                        JTextField x1, JTextField e, JTextField n){
        
                JEP j = new JEP();
            j.addStandardConstants();
            j.addStandardFunctions();

            String def = funcion.getText();

            j.parseExpression(x0.getText());
            double lx0 = j.getValue();

            j.parseExpression(x1.getText());
            double lx1 = j.getValue();

            j.parseExpression(e.getText());
            double tolerancia = j.getValue();

            int ln = Integer.parseInt(n.getText());
            
            Funcion f = new Funcion(def);
            Biseccion s = new Biseccion();
            double r = s.raiz(f, lx0, lx1, ln, tolerancia);

            if (Double.toString(r).equals("NaN")) {
//                imprimeIteraciones.setText("el método fallo");
                JOptionPane.showMessageDialog(null, "el método fallo");
            } else {
                raiz.setText(Double.toString(r));
            }
        
            //pasamos a grafiar la funcion:
            double x[] = new double[200];
            double y[] = new double[200];

            double xi = lx0 - 10;
            for (int i = 0; i < 200; i++) {
                x[i] = xi + i * 0.1; 

                JEP funcionx_h = new JEP();
                funcionx_h.addStandardFunctions();
                funcionx_h.addStandardConstants();
                funcionx_h.setImplicitMul(true);
                funcionx_h.addVariable("x", x[i]);
              
                funcionx_h.parseExpression(def); 
                String inde = Double.toString(funcionx_h.getValue());
                if (inde.equals("NaN") || inde.equals("-Infinity") || inde.equals("Infinity")) {

                } else {
                    y[i] = funcionx_h.getValue();
                }

            }
            grafica.addLegend("SOUTH");
            grafica.removeAllPlots();
            grafica.addLinePlot(def, x, y);

        
    }
    
}
