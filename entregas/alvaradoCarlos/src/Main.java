public class Main {
    public static void main(String[] args) {
        // Lista miLista = new Lista();
        // miLista.agregar(30);  miLista.mostrarLista();
        // miLista.agregar(40);  miLista.mostrarLista();
        // miLista.agregar(50);  miLista.mostrarLista();

        // System.out.println("Posicion 2 = " + miLista.obtener(2)); miLista.mostrarLista();

        // miLista.modificar(2, 90); miLista.mostrarLista();

        // System.out.println("Posicion 2 = " + miLista.obtener(2)); miLista.mostrarLista();

        ArraySimulado array = new ArraySimulado(5);

        array.set(0, 5);
        System.out.println(array.get(0));
        System.out.println(array.get(1));
    }
}
