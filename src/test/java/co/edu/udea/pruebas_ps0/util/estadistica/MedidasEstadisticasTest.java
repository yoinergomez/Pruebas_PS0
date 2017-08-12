/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util.estadistica;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.ldl.NodoDoble;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Comprueba el funcionamiento de los métodos de la clase
 * MedidasEstadisticasTest
 *
 * @author Yoiner Gómez - yoiner.gomez22@gmail.com
 * @date 2017/08/11
 * @version v1
 */
public class MedidasEstadisticasTest {

    private LDL listaPrueba;
    private ArrayList testList;

    @Before
    public void inicializarLista() {
        listaPrueba = new LDL();
        listaPrueba.insertar(new NodoDoble(new Double("2")));
        listaPrueba.insertar(new NodoDoble(new Double("1")));
        listaPrueba.insertar(new NodoDoble(new Double("9")));
        listaPrueba.insertar(new NodoDoble(new Double("7.6")));
        listaPrueba.insertar(new NodoDoble(new Double("0.4")));
    }
    
    @Test
    public void testMedia() {
        
    }
    
//    @Test
//    public void testVarianza() {
//        final Double MEDIA = new Double("5");
//        
//        
//    }

}
