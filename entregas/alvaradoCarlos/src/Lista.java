public class Lista {

    private Elemento cabeza;
    private int tamaño;

    public Lista(){
        this.cabeza = null;
        tamaño = 0;
    }

    public void agregar(int valor) {
        Elemento nuevoElemento = new Elemento(valor);

        if (cabeza == null){
            this.cabeza = nuevoElemento;
            System.out.println(this.cabeza.valor());
        } else {
            Elemento actual = this.cabeza; // actual apunta a la referencia de la cabeza [ . . . 0 <--actual 1]
            while (actual.siguiente() != null) { // mientras que la referencia siguiente de actual no sea nula
                actual = actual.siguiente(); // actual apuntará a su referencia siguiente  [ . . . 0 actual--> 1]
            }
            actual.setSiguiente(nuevoElemento); // la referencia siguiente de actual apuntara al nuevo elemento 
            // [ . . . 0 actual--> 1] [ . . . 0 actual --> 1 actualSiguiente --> 2]
        }
        tamaño++;
    }

    public int tamaño(){
        return tamaño;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void mostrarLista() {
    if (cabeza == null) {
        System.out.println("La lista está vacía.");
        return;
    }

    Elemento actual = cabeza;
    System.out.print("Cabeza → ");
    while (actual != null) {
        System.out.print("[" + actual.valor() + "]");
        if (actual.siguiente() != null) {
            System.out.print(" → ");
        }
        actual = actual.siguiente();
    }
    System.out.println(" → null (Fin de la lista)");
}

    
}
