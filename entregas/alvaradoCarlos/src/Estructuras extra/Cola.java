public class Cola {
    private Nodo nodoFrente;
    private Nodo nodoFinal;

    public Cola(){
        this.nodoFrente = null;
        this.nodoFinal = null;
    }

    public void encolar(int valor){
        Nodo nuevoNodo = new Nodo(valor);

        if(estaVacia()){
            this.nodoFrente = nuevoNodo;
            this.nodoFinal = nuevoNodo;
        } else {
            this.nodoFinal.siguienteNodo = nuevoNodo;
            this.nodoFinal = nuevoNodo;
        }
    }

    public int desencolar(){
        assert !estaVacia() : "No se puede desencolar una cola vacia";
        
        int valor = this.nodoFrente.dato;
        this.nodoFrente = this.nodoFrente.siguienteNodo;

        if (this.nodoFrente == null){
            this.nodoFinal = null;
        }
        return valor;

    }

    public int alFrente(){
        assert !estaVacia() : "No se puede obtener el frente de una cola vacia";

        return this.nodoFrente.dato;
    }

    public boolean estaVacia(){
        return this.nodoFrente == null;
    }

    public void mostrarCola() {
    if (estaVacia()) {
        System.out.println("La cola está vacía.");
        return;
    }

    Nodo actual = this.nodoFrente;
    System.out.print("Frente → ");
    while (actual != null) {
        System.out.print("[" + actual.dato + "]");
        if (actual.siguienteNodo != null) {
            System.out.print(" → ");
        }
        actual = actual.siguienteNodo;
    }
    System.out.println(" → null (Final)");
}

}
