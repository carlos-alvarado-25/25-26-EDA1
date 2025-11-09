
public class Pila {

    private Nodo tope;

    public Pila(){
        this.tope = null;
    }

    public void apilar(int valor){
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.siguienteNodo = tope;
        tope = nuevoNodo;
    }

    public int desapilar(){
        assert !estaVacia() : "No se puede desapilar una pila vacia";
        int valor = tope.dato;
        tope = tope.siguienteNodo;
        return valor;
    }

    public int tope(){
        assert !estaVacia() : "No se puede consultar el tope de una pila vacia";
        return tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}
