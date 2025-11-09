public class Cliente {
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.encolar(10);     cola.mostrarCola();
        cola.encolar(20);     cola.mostrarCola();
        cola.encolar(30);     cola.mostrarCola();
        cola.encolar(40);     cola.mostrarCola();
        cola.encolar(50);     cola.mostrarCola();
        cola.encolar(60);     cola.mostrarCola();

        cola.desencolar();    cola.mostrarCola();
        cola.desencolar();    cola.mostrarCola();
        cola.desencolar();    cola.mostrarCola();
        cola.desencolar();    cola.mostrarCola();
        cola.desencolar();    cola.mostrarCola();
        cola.desencolar();    cola.mostrarCola();
    }
}
