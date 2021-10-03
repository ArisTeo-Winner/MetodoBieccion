/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Darwin
 */
public class Biseccion {

    private static ArrayList<String> iteraciones = new ArrayList<String>();

    public static ArrayList getIteraciones() {
        return iteraciones;
    }

    public double raiz(Funcion f, double a, double b, int nMAx, double tolerancia) {
        double r = Double.NaN;// le damos un valor por defecto por siacaso no encontramos la raiz 
        double c = a;
        int k = 0;
        iteraciones.add(0, Double.toString(c));// añade a la colecion la primera iteraion

        if (f.eval(a) * f.eval(b) < 0) {
            while (Math.abs(f.eval(c)) > tolerancia && k < nMAx) {

                c = (a + b) / 2;
                if (f.eval(a) * f.eval(c) < 0) {
                    b=c;     
                }else{
                    a=c;
                }

                iteraciones.add(Double.toString(c));// añade a la colecion la tietacion k
                k++;
            }

        }


        if (k < nMAx ) {
            r = c;
        }
        if (f.eval(a) * f.eval(b) > 0) {
            JOptionPane.showMessageDialog(null,"f(a)f(b)>0", "no hay cambio de signo",JOptionPane.ERROR_MESSAGE);
             r = Double.NaN;
             iteraciones.clear();
            
        }
        return r;
    }

    public void borrarColeccion() {
        iteraciones.clear();
    }
}
