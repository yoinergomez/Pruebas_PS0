/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0_ldl;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frank
 */
public class NodeTest {

    /**
     * Test of getDato method, of class Node.
     */
    @Test
    public void testGetDato() {
        Node instance = new Node(new Double(10));
        assertEquals(instance.getDato(), new Double(10));
    }

    /**
     * Test of setDato method, of class Node.
     */
    @Test
    public void testSetDato() {
        Double dato = new Double(20);
        Node instance = new Node();
        instance.setDato(dato);
        assertEquals(instance.getDato(), new Double(20));
    }

    /**
     * Test of getSiguiente method, of class Node.
     */
    @Test
    public void testGetSiguiente() {
        Node siguiente = new Node();
        Node instance = new Node(siguiente, null, null);
        assertEquals(instance.getSiguiente(), siguiente);
    }

    /**
     * Test of setSiguiente method, of class Node.
     */
    @Test
    public void testSetSiguiente() {
        Node siguiente = new Node();
        Node instance = new Node();
        instance.setSiguiente(siguiente);
        assertEquals(instance.getSiguiente(), siguiente);
    }

    /**
     * Test of getAnterior method, of class Node.
     */
    @Test
    public void testGetAnterior() {
        Node anterior = new Node();
        Node instance = new Node(null, anterior, null);
        assertEquals(instance.getAnterior(), anterior);
    }

    /**
     * Test of setAnterior method, of class Node.
     */
    @Test
    public void testSetAnterior() {
        Node anterior = new Node();
        Node instance = new Node();
        instance.setAnterior(anterior);
        assertEquals(instance.getAnterior(), anterior);
    }
    
}
