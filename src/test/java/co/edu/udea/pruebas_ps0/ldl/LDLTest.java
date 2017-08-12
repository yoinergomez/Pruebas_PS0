/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.ldl;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author frank
 */
public class LDLTest {
    
    private LDL instance;
    
    public LDLTest() {
    }
    
    @Before
    public void setUp() {
        instance = new LDL();
        instance.insertar(new NodoDoble(new Double(20)));
        instance.insertar(new NodoDoble(new Double(10)));
        instance.insertar(new NodoDoble(new Double(50)));
    }
    

    /**
     * Test of insertar method, of class LDL.
     */
    @Test
    public void testInsertar() {
        NodoDoble nuevo = new NodoDoble();
        instance.insertar(nuevo);
        assertEquals(instance.getUltimo(), nuevo);
    }

    /**
     * Test of eliminar method, of class LDL.
     */
    @Test
    public void testEliminar() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        instance.insertar(candidato);
        instance.imprimirLista();
        System.out.println("\n");
        boolean result = instance.eliminar(candidato);
        instance.imprimirLista();
        assertEquals(Boolean.TRUE, result);
    }
    
    @Test
    public void testEliminarNodo() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        LDL instance = new LDL();
        instance.insertar(new NodoDoble(new Double(20)));
        instance.insertar(new NodoDoble(new Double(10)));
        instance.insertar(candidato);
        instance.insertar(new NodoDoble(new Double(50)));
        instance.imprimirLista();
        System.out.println("\n");
        boolean result = instance.eliminar(candidato);
        instance.imprimirLista();
        assertEquals(Boolean.TRUE, result);
    }
    
    @Test
    public void testEliminarNoExist() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        LDL instance = new LDL();
        instance.insertar(new NodoDoble(new Double(20)));
        instance.insertar(new NodoDoble(new Double(10)));
        instance.insertar(new NodoDoble(new Double(50)));
        boolean result = instance.eliminar(candidato);
        assertEquals(Boolean.FALSE, result);
    }
    
    @Test
    public void testEliminarCabeza() {
        instance.imprimirLista();
        System.out.println("\n");
        boolean result = instance.eliminar(instance.getCabeza());
        instance.imprimirLista();
        assertEquals(Boolean.FALSE, result);
    }

    @Test
    public void testEliminarUltimo() {
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
        NodoDoble candidato = new NodoDoble(new Double(60));
        instance.insertar(candidato);
        NodoDoble result = instance.getUltimo();
        assertEquals(candidato, result);
    }
    
    @Test
    public void testSumarElementosLista(){
        instance.imprimirLista();
        Double resultado = instance.sumar();
        instance.imprimirLista();
        assertEquals(new Double(80.0), resultado);
    }
    
    @Test
    public void testSumarElementosListaVacia(){
        LDL lista = new LDL();
        assertEquals(new Double(0), lista.sumar());
    }
    
    @Test
    public void testAgregarDatoGigante(){
        Double foo = Double.MAX_VALUE*Double.MAX_VALUE;
        instance.insertar(new NodoDoble(foo));
    }
}
