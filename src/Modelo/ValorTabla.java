/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author Aris
 */
public class ValorTabla {
    
//        DefaultTableModel model = new DefaultTableModel();
            
//    ArrayList iteraciones = new ArrayList();

  
        
        public void metTabla( DefaultTableModel model, JTable JTabla, ArrayList iteraciones  ){
                   DecimalFormat df = new DecimalFormat("0.000");
                               // pasamos a mostrar todas las iteraciones realizadas en la tabla
            for (int i = 1; i < iteraciones.size(); i++) {

                JTabla.setValueAt(i, i - 1, 0);

                JTabla.setValueAt(iteraciones.get(i), i - 1, 1);
                JTabla.setValueAt(iteraciones.get(i - 1), i - 1, 3);
//       Ocultar las columnas '3 y 4'(
                JTabla.getColumnModel().getColumn(3).setMaxWidth(0);
                JTabla.getColumnModel().getColumn(3).setMinWidth(0);
                JTabla.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
                JTabla.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);

                JTabla.getColumnModel().getColumn(4).setMaxWidth(0);
                JTabla.getColumnModel().getColumn(4).setMinWidth(0);
                JTabla.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
                JTabla.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
////       )         

            }

            double total = 0;
                for (int k = 0; k < iteraciones.size(); k++) {

                double numero = 0;
                double numera = 0;
                try {

                    numero = Double.valueOf(model.getValueAt(k, 1).toString());
                    numera = Double.valueOf(model.getValueAt(k, 3).toString()); 

                    double t = 0;
                    double g = 0;

                    t = ((numero - numera) / numero) * 100;
                    g = Math.abs((numero - numera) / numero);

                    double u = Math.abs(t);

                    String CITRD = df.format(u);

                    JTabla.setValueAt(CITRD + " %", k, 2);

                    JTabla.setValueAt(CITRD, k, 4);
                    JTabla.setValueAt(null, 0, 2);
                    JTabla.setValueAt(null, 0, 4);
                } //            }
                catch (NumberFormatException nfe) {

                }
            }
            
            
        }
}
