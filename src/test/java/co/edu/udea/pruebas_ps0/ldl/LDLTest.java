/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.ldl;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author frank
 */
public class LDLTest {
    
    private LDL instancia;
    
    public LDLTest() {
    }
    
    @Before
    public void setUp() {
        instancia = new LDL();
        instancia.insertar(new NodoDoble(new Double(20)));
        instancia.insertar(new NodoDoble(new Double(10)));
        instancia.insertar(new NodoDoble(new Double(50)));
    }
    

    /**
     * Test of insertar method, of class LDL.
     */
    @Test
    public void testInsertar() {
        NodoDoble nuevo = new NodoDoble();
        instancia.insertar(nuevo);
        assertEquals(instancia.getUltimo(), nuevo);
    }

    /**
     * Test of eliminar method, of class LDL.
     */
    @Test
    public void testEliminar() {
        NodoDoble candidato = new NodoDoble(new Double(60));
        instancia.insertar(candidato);
        instancia.imprimirLista();
        System.out.println("\n");
        boolean result = instancia.eliminar(candidato);
        instancia.imprimirLista();
        assertEquals(Boolean.TRUE, result);
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
        instancia.imprimirLista();
        System.out.println("\n");
        boolean result = instancia.eliminar(instancia.getPrimerNodo().getAnterior());
        instancia.imprimirLista();
        assertEquals(Boolean.FALSE, result);
    }
    
    @Test
    public void testEliminarUltimo() {
        instancia.imprimirLista();
        System.out.println("\n");
        boolean result = instancia.eliminar(instancia.getUltimo());
        instancia.imprimirLista();
        assertEquals(Boolean.TRUE, result);
    }   
    /**
     * Test of getUltimo method, of class LDL.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        NodoDoble candidato = new NodoDoble(new Double(60));
        instancia.insertar(candidato);
        NodoDoble result = instancia.getUltimo();
        assertEquals(candidato, result);
    }
    
    @Test
    public void testSumarElementosLista(){
        Double resultado = instancia.sumar();
        assertEquals(new Double(80.0), resultado);
    }
    
    @Test
    public void testSumarNegativosDecimalLista(){
        instancia.insertar(new NodoDoble(new Double(1)));
        instancia.insertar(new NodoDoble(new Double("-80.5")));
        Double resultado = instancia.sumar();
        assertEquals(new Double(0.5), resultado);
    }
    
    @Test
    public void testSumarElementosListaVacia(){
        LDL lista = new LDL();
        assertEquals(new Double(0), lista.sumar());
    }
    
    @Test
    public void testAgregarDatoGigante(){
        Double foo = Double.MAX_VALUE*Double.MAX_VALUE;
        instancia.insertar(new NodoDoble(foo));
    }
    
    @Test
    public void testTamaño() {
        int tamaño = instancia.length();
        assertEquals(3, tamaño);
    }
    
    @Test
    public void testLength(){
        int numNodos = instancia.length();
        assertEquals(3, numNodos);
    }
}
