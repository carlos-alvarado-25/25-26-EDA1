public class Main {
    public static void main(String[] args) {
        Lista miLista = new Lista();
        System.out.println(miLista.estaVacia());
        miLista.agregar(10);  miLista.mostrarLista();
        miLista.agregar(20);  miLista.mostrarLista();
        miLista.agregar(30);  miLista.mostrarLista();
        miLista.agregar(40);  miLista.mostrarLista();
        miLista.agregar(50);  miLista.mostrarLista();
    }
}
