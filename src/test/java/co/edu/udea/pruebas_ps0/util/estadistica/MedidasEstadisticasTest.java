/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util.estadistica;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.ldl.NodoDoble;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    private MedidasEstadisticas testMedidas;

    @Before
    public void inicializarLista() {
        listaPrueba = new LDL();
        testMedidas = new MedidasEstadisticas();
        listaPrueba.insertar(new NodoDoble(new Double("2")));
        listaPrueba.insertar(new NodoDoble(new Double("1")));
        listaPrueba.insertar(new NodoDoble(new Double("9")));
        listaPrueba.insertar(new NodoDoble(new Double("7.6")));
        listaPrueba.insertar(new NodoDoble(new Double("0.4")));
    }
    
    @Test
    public void testMedia() {
        Double media = testMedidas.calcularMedia(listaPrueba);
        assertTrue(media == 4.0);
    }
    
    @Test (expected=ArithmeticException.class)
    public void testMediaListaVacia() {
        LDL lista = new LDL();
        testMedidas.calcularMedia(lista);
    }
    
    @Test
    public void testVarianza() {
        Double varianza = testMedidas.calcularVarianza(listaPrueba);
        listaPrueba.imprimirLista();
        assertEquals(15.98, varianza, 0);
    }
    
    @Test
    public void testDesviacionEstandar() {
        Double desviacionEstandar = testMedidas.calcularDesviacionEstandar(listaPrueba);
        assertEquals(desviacionEstandar, 3.997499218261337, 0);
    }
    
    @Test
    public void testDesviacionEstandarCero() {
        LDL lista = new LDL();
        lista.insertar(new NodoDoble(new Double("6.9")));
        lista.insertar(new NodoDoble(new Double("6.9")));
        lista.insertar(new NodoDoble(new Double("6.9")));
        Double desviacionEstandar = testMedidas.calcularDesviacionEstandar(lista);
        assertEquals(desviacionEstandar, 0, 0);
    }
 
}
