/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.nfunk.jep.JEP;

/**
 *
 * @author Aris
 */
public class procesafuncion {
    
    public void metprocesa(JTextField funcion, JTextField x0, JTextField x1,JTextField e, JTextField n, JTextField raiz, String def, double lx0){
                JEP j = new JEP();
            j.addStandardConstants();
            j.addStandardFunctions();

           def = funcion.getText();

            j.parseExpression(x0.getText());// pasamos a convertr la expresion ingresada en la casilla x0
            lx0 = j.getValue();

            j.parseExpression(x1.getText());// pasamos a convertr la expresion ingresada en la casilla x1
            double lx1 = j.getValue();

            j.parseExpression(e.getText());// pasamos a convertr la expresion ingresada en la casilla  de tolerancia
            double tolerancia = j.getValue();

            int ln = Integer.parseInt(n.getText());// pasamos a convertr la expresion ingresada en la casilla  de numero maximo de iteraciones

            Funcion f = new Funcion(def);
            Biseccion s = new Biseccion();
            double r = s.raiz(f, lx0, lx1, ln, tolerancia);

            if (Double.toString(r).equals("NaN")) {
//                imprimeIteraciones.setText("el método fallo");
                JOptionPane.showMessageDialog(null, "el método fallo");
            } else {
                raiz.setText(Double.toString(r));
            }
            
            
}
    
}
