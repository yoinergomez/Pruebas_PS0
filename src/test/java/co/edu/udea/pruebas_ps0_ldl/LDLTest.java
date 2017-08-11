/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0_ldl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author frank
 */
public class LDLTest {
    
    public LDLTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertar method, of class LDL.
     */
    @Test
    public void testInsertar() {
        Node nuevo = new Node();
        LDL instance = new LDL();
        instance.insertar(nuevo);
        assertEquals(instance.getUltimo(), nuevo);
    }

    /**
     * Test of eliminar method, of class LDL.
     */
    @Test
    public void testEliminar() {
        Node candidato = new Node(new Double(60));
        LDL instance = new LDL();
        instance.insertar(new Node(new Double(20)));
        instance.insertar(new Node(new Double(10)));
        instance.insertar(new Node(new Double(50)));
        instance.insertar(candidato);
        instance.imprimirLista();
        System.out.println("\n");
        boolean result = instance.eliminar(candidato);
        instance.imprimirLista();
        assertEquals(Boolean.TRUE, result);
    }
    
     @Test
    public void testEliminarCabeza() {
        LDL instance = new LDL();
        instance.insertar(new Node(new Double(20)));
        instance.insertar(new Node(new Double(10)));
        instance.insertar(new Node(new Double(50)));
        instance.imprimirLista();
        System.out.println("\n");
        boolean result = instance.eliminar(instance.getCabeza());
        instance.imprimirLista();
        assertEquals(Boolean.FALSE, result);
    }

      @Test
    public void testEliminarUltimo() {
        LDL instance = new LDL();
        instance.insertar(new Node(new Double(20)));
        instance.insertar(new Node(new Double(10)));
        instance.insertar(new Node(new Double(50)));
        instance.imprimirLista();
        System.out.println("\n");
        boolean result = instance.eliminar(instance.getUltimo());
        instance.imprimirLista();
        assertEquals(Boolean.TRUE, result);
    }   
    /**
     * Test of getUltimo method, of class LDL.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        LDL instance = new LDL();
        Node candidato = new Node(new Double(60));
        instance.insertar(candidato);
        Node result = instance.getUltimo();
        assertEquals(candidato, result);
    }
    
}
