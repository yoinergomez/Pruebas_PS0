/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0_ldl;

/**
 * Clase que contiene la estructura de un nodo
 * @author Frank Castrillón - frank.castrillon@udea.edu.co
 * @date 2017/08/11
 * @version v1
 */
public class Node {
    private Double dato;
    private Node siguiente;
    private Node anterior;
    
    /**
     * Contructor de la clase Node
     * @param next nodo siguiente
     * @param previous nodo anterior
     * @param dato dato del nodo
     */
    Node(Node next, Node previous, Double dato) {
         this.siguiente = next;
         this.anterior = previous;
         this.dato = dato;
    }
    /**
     * Constructor de la clase node, se asigna null a los nodos next y previous
     * @param dato 
     */
    Node(Double dato) {
         this.siguiente = null;
         this.anterior = null;
         this.dato = dato;
    }
    /**
     * Constructor de la clase node vacio, se asigna null a todos los atributos
     */
    Node() {
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

    public Node getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }

    public Node getAnterior() {
        return anterior;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }
}
