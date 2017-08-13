/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util.estadistica;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.ldl.NodoDoble;

/**
 *
 * @author Jhonatan Orozco Blandón
 */
public class MedidasEstadisticas {
    
    public Double calcularMedia(LDL lista){
        Double sumaNodos = lista.sumar();
        int numNodos = lista.length();
        if (numNodos==0) {
            throw new ArithmeticException("División por cero: La lista está vacía.");
        }
        return sumaNodos/numNodos;
    }

    Double calcularVarianza(LDL listaPrueba) {
        final Double MEDIA = calcularMedia(listaPrueba);
        final int N = listaPrueba.length();
        Double sumatoria = new Double(0);
        NodoDoble nodo = listaPrueba.getPrimerNodo();
        
        while(nodo != null){
            sumatoria += (nodo.getDato() - MEDIA)*(nodo.getDato() - MEDIA);
            nodo = listaPrueba.siguienteNodo(nodo);
        }
        
        return sumatoria/(N-1);
    }

    Double calcularDesviacionEstandar(LDL listaPrueba) {
        return Math.sqrt(calcularVarianza(listaPrueba));
    }
}
