/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.ldl;

/**
 * Clase que contiene la estructura de un nodo
 * @author Frank Castrillón - frank.castrillon@udea.edu.co
 * @date 2017/08/11
 * @version v1
 */
public class NodoDoble {
    private Double dato;
    private NodoDoble siguiente;
    private NodoDoble anterior;
    
    /**
     * Contructor de la clase Node
     * @param next nodo siguiente
     * @param previous nodo anterior
     * @param dato dato del nodo
     */
    public NodoDoble(NodoDoble next, NodoDoble previous, Double dato) {
         this.siguiente = next;
         this.anterior = previous;
         this.dato = dato;
    }
    /**
     * Constructor de la clase node, se asigna null a los nodos next y previous
     * @param dato 
     */
    public NodoDoble(Double dato) {
         this.siguiente = null;
         this.anterior = null;
         this.dato = dato;
    }
    /**
     * Constructor de la clase node vacio, se asigna null a todos los atributos
     */
    public NodoDoble() {
         this.siguiente = null;
         this.anterior = null;
         this.dato = null;
    }

    public Double getDato() {
        return dato;
    }

    public void setDato(Double dato) {
        this.dato = dato;
    }

    NodoDoble getSiguiente() {
        return siguiente;
    }

    void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    NodoDoble getAnterior() {
        return anterior;
    }

    void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
