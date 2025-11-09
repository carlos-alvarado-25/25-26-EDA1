public class Main {
    public static void main(String[] args) {
        Lista miLista = new Lista();
        miLista.agregar(30);  miLista.mostrarLista();
        miLista.agregar(40);  miLista.mostrarLista();
        miLista.agregar(50);  miLista.mostrarLista();

        System.out.println("Posicion 2 = " + miLista.obtener(2)); miLista.mostrarLista();
    }
}
