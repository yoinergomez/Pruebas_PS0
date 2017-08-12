
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.ldl;

import co.edu.udea.pruebas_ps0.ldl.NodoDoble;
import co.edu.udea.pruebas_ps0.ldl.LDL;
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

    private LDL instance;

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
        instance = new LDL();
        instance.insertar(new NodoDoble(new Double(20)));
        instance.insertar(new NodoDoble(new Double(10)));
        instance.insertar(new NodoDoble(new Double(50)));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of insertar method, of class LDL.
     */
    @Test
    public void testInsertar() {
        NodoDoble nuevo = new NodoDoble();
        LDL instancia = new LDL();
        instancia.insertar(nuevo);
        assertEquals(instancia.getUltimo(), nuevo);
    }

    /**
     * Test of eliminar method, of class LDL.
     */
    @Test
    public void testEliminar() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        LDL instancia = new LDL();
        instancia.insertar(new NodoDoble(new Double(20)));
        instancia.insertar(new NodoDoble(new Double(10)));
        instancia.insertar(new NodoDoble(new Double(50)));
        instancia.insertar(candidato);
        instancia.imprimirLista();
        System.out.println("\n");
        boolean resultado = instancia.eliminar(candidato);
        instancia.imprimirLista();
        assertEquals(Boolean.TRUE, resultado);
    }

    @Test
    public void testEliminarNodo() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        LDL instancia = new LDL();
        instancia.insertar(new NodoDoble(new Double(20)));
        instancia.insertar(new NodoDoble(new Double(10)));
        instancia.insertar(candidato);
        instancia.insertar(new NodoDoble(new Double(50)));
        instancia.imprimirLista();
        System.out.println("\n");
        boolean result = instancia.eliminar(candidato);
        instancia.imprimirLista();
        assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testEliminarNoExist() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        LDL instancia = new LDL();
        instancia.insertar(new NodoDoble(new Double(20)));
        instancia.insertar(new NodoDoble(new Double(10)));
        instancia.insertar(new NodoDoble(new Double(50)));
        boolean result = instancia.eliminar(candidato);
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testEliminarCabeza() {
        LDL instancia = new LDL();
        instancia.insertar(new NodoDoble(new Double(20)));
        instancia.insertar(new NodoDoble(new Double(10)));
        instancia.insertar(new NodoDoble(new Double(50)));
        instancia.imprimirLista();
        System.out.println("\n");
        boolean result = instancia.eliminar(instancia.getCabeza());
        instancia.imprimirLista();
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testEliminarUltimo() {
        LDL instancia = new LDL();
        instancia.insertar(new NodoDoble(new Double(20)));
        instancia.insertar(new NodoDoble(new Double(10)));
        instancia.insertar(new NodoDoble(new Double(50)));
        instancia.imprimirLista();
        System.out.println("\n");
        boolean resultado = instancia.eliminar(instancia.getUltimo());
        instancia.imprimirLista();
        assertEquals(Boolean.TRUE, resultado);
    }

    /**
     * Test of getUltimo method, of class LDL.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        LDL instancia = new LDL();
        NodoDoble candidato = new NodoDoble(new Double(60));
        instancia.insertar(candidato);
        NodoDoble resultado = instancia.getUltimo();
        assertEquals(candidato, resultado);
    }

    @Test
    public void testSumarElementosLista() {
        instance.imprimirLista();
        Double resultado = instance.sumar();
        instance.imprimirLista();
        assertEquals(new Double(80.0), resultado);
    }

    @Test
    public void testSumarElementosListaVacia() {
        LDL lista = new LDL();
        assertEquals(new Double(0), lista.sumar());
    }

    @Test
    public void testAgregarDatoGigante() {
        Double foo = Double.MAX_VALUE * Double.MAX_VALUE;
        instance.insertar(new NodoDoble(foo));
    }
}
