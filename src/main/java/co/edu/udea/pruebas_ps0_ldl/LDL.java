package co.edu.udea.pruebas_ps0_ldl;

/**
 * Clase que contiene la estructura de una lista doblemente ligada con nodo 
 * cabeza, donde el dato del nodo cabeza alamacena la cantidad de nodos en la
 * lista
 * @author Frank Castrillón - frank.castrillon@udea.edu.co
 * @date 2017/08/11
 * @version v1
 */
public class LDL {
    
    private Node cabeza;
    private Node ultimo;

    public LDL() {
        cabeza = new Node(null, null, new Double(0));
        ultimo = cabeza;
    }
    /**
     * Inserta el nuevo nodo al final de la lista
     * @param nuevo 
     */
    public void insertar(Node nuevo) {
        if (nuevo != cabeza && nuevo != ultimo){
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
            cabeza.setDato(cabeza.getDato() + new Double(1));
        }
    }
    
    /**
     * Elimina el nodo que se pasa por referencia, si existe retorna true 
     * de lo contrario false
     * @param candidato
     * @return 
     */
    public boolean eliminar(Node candidato) {
        if (candidato == cabeza){
            return false;
        }
        if (candidato == ultimo){
            candidato.getAnterior().setSiguiente(null);
        }else{
            Node actual = cabeza;
            while (actual.getSiguiente() != candidato 
                    && actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            if (actual == ultimo){
                return false;
            }
            actual.setSiguiente(candidato.getSiguiente());
            candidato.getSiguiente().setAnterior(actual);
        }
        cabeza.setDato(cabeza.getDato() - new Double(1));   
        return true;
    }
    
    /**
     * Imprime los datos de la lista ligada
     */
    public void imprimirLista() {
        Node aux = cabeza;
        for (double i = 0; i <= cabeza.getDato(); i++) {
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
    }

    public Node getUltimo() {
        return ultimo;
    }

    public Node getCabeza() {
        return cabeza;
    }
}
