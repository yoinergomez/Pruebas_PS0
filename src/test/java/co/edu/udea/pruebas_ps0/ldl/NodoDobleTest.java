/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.ldl;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frank
 */
public class NodoDobleTest {

    /**
     * Test of getDato method, of class NodoDoble.
     */
    @Test
    public void testGetDato() {
        NodoDoble instancia = new NodoDoble(new Double(10));
        assertEquals(instancia.getDato(), new Double(10));
    }

    /**
     * Test of setDato method, of class NodoDoble.
     */
    @Test
    public void testSetDato() {
        Double dato = new Double(20);
        NodoDoble instancia = new NodoDoble();
        instancia.setDato(dato);
        assertEquals(instancia.getDato(), new Double(20));
    }
    
    @Test(expected = NumberFormatException.class)
    public void testSetDatoString() {
        NodoDoble instancia = new NodoDoble();
        instancia.setDato(new Double("sadasda"));
    }

    /**
     * Test of getSiguiente method, of class NodoDoble.
     */
    @Test
    public void testGetSiguiente() {
        NodoDoble siguiente = new NodoDoble();
        NodoDoble instancia = new NodoDoble(siguiente, null, null);
        assertEquals(instancia.getSiguiente(), siguiente);
    }

    /**
     * Test of setSiguiente method, of class NodoDoble.
     */
    @Test
    public void testSetSiguiente() {
        NodoDoble siguiente = new NodoDoble();
        NodoDoble instancia = new NodoDoble();
        instancia.setSiguiente(siguiente);
        assertEquals(instancia.getSiguiente(), siguiente);
    }

    /**
     * Test of getAnterior method, of class NodoDoble.
     */
    @Test
    public void testGetAnterior() {
        NodoDoble anterior = new NodoDoble();
        NodoDoble instancia = new NodoDoble(null, anterior, null);
        assertEquals(instancia.getAnterior(), anterior);
    }

    /**
     * Test of setAnterior method, of class NodoDoble.
     */
    @Test
    public void testSetAnterior() {
        NodoDoble anterior = new NodoDoble();
        NodoDoble instancia = new NodoDoble();
        instancia.setAnterior(anterior);
        assertEquals(instancia.getAnterior(), anterior);
    }
    
}
