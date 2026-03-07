import java.util.Arrays;

public class Monitora {

    private String nombre;
    private int cantidadDeNiños;
    private Niño[] niños;

    public Monitora(String nombre, int maxNiños) {
        this.nombre = nombre;
        this.cantidadDeNiños = 0;
        this.niños = new Niño[maxNiños];
    }

    public void recibeNiño(Niño niño) {
        for (int i = 0; i < niños.length; i++) {
            if (niños[i] == null) {
                niños[i] = niño;
                System.out.println("Llega " + niño.nombre() + " (" + niño.edad() + " años)");
                System.out.println(niño.nombre() + " pasa a la cola de " + nombre);
                cantidadDeNiños++;
                return;
            }
        }
        System.out.println("No hay espacio para más niños.");
    }

    public Niño[] entregaNiños(Monitora monitora) {
        if (!haySuficientesNinos()) return new Niño[0];

        Niño[] grupoAEnviar = extraerGrupo(cantidadDeNiños);
        Niño[] grupoRecibido = monitora.recibeNiñosParaJugar(grupoAEnviar);

        reacomodarNiños(grupoRecibido.length);
        cantidadDeNiños -= grupoRecibido.length;

        System.out.println(nombre + " transfiere sus niños a " + monitora.nombre());
        mostrarGrupo(grupoRecibido);

        return grupoRecibido;
    }

    public Niño[] separarNiñosMenoresDe5(Monitora dalsy) {
        if (cantidadDeNiños == 0) {
            System.out.println("No hay niños en la cola de " + nombre + "\n");
            return new Niño[0];
        }

        Niño[] menoresDe5 = new Niño[cantidadDeNiños];
        Niño[] mayoresOIgual5 = new Niño[cantidadDeNiños];
        int idxMenores = 0;
        int idxMayores = 0;

        for (int i = 0; i < cantidadDeNiños; i++) {
            if (niños[i].edad() < 5) menoresDe5[idxMenores++] = niños[i];
            else mayoresOIgual5[idxMayores++] = niños[i];
        }

        System.out.println("Niños menores de 5 años pasan a " + dalsy.nombre() + ":");
        for (int i = 0; i < idxMenores; i++) {
            dalsy.recibeNiño(menoresDe5[i]);
            System.out.println("- " + menoresDe5[i].nombre() + " (" + menoresDe5[i].edad() + " años)");
        }

        reorganizarCola(mayoresOIgual5, idxMayores);
        System.out.println("Niños que se quedan con " + nombre + " para jugar:");
        mostrarGrupo(extraerGrupo(cantidadDeNiños));

        return Arrays.copyOf(menoresDe5, idxMenores);
    }

    public Niño[] entregaTodosNiñosA(Monitora otraMonitora) {
        if (cantidadDeNiños == 0) return new Niño[0];

        Niño[] grupo = extraerGrupo(cantidadDeNiños);
        for (int i = 0; i < cantidadDeNiños; i++) {
            otraMonitora.recibeNiño(niños[i]);
        }

        Arrays.fill(niños, null);
        cantidadDeNiños = 0;

        System.out.println(nombre + " transfiere TODOS sus niños a " + otraMonitora.nombre() + " INMEDIATAMENTE");
        return grupo;
    }

    public void presentarse() {
        System.out.println(nombre + ": Hola, soy " + nombre + ", monitora de esta ludoteca");
    }

    public void prepararCadenaPresentaciones() {
        for (int i = 0; i < cantidadDeNiños; i++) {
            niños[i].siguienteNiño(i < cantidadDeNiños - 1 ? niños[i + 1] : null);
        }
    }

    public void pideAlPrimerNiñoPresentarse() {
        if (cantidadDeNiños > 0) niños[0].presentarse();
        else System.out.println("No hay niños en la cola de " + nombre);
    }

    public void pedirCincoPrimerosPresentarse() {
        int limite = Math.min(5, cantidadDeNiños);
        for (int i = 0; i < limite; i++) niños[i].presentarse();
    }

    public void pedirCincoUltimosPresentarse() {
        int inicio = Math.max(0, cantidadDeNiños - 5);
        for (int i = inicio; i < cantidadDeNiños; i++) niños[i].presentarse();
    }

    public void pedirNiñosMayoresDe5Presentarse() {
        boolean hayNiños = false;
        for (int i = 0; i < cantidadDeNiños; i++) {
            if (niños[i].edad() > 5) {
                niños[i].presentarse();
                hayNiños = true;
            }
        }
        if (!hayNiños) System.out.println("No hay niños mayores de 5 años en la cola.\n");
    }

    public void pedirNiñosPorLetra(char letra) {
        boolean hayNiños = false;
        for (int i = 0; i < cantidadDeNiños; i++) {
            if (niños[i].nombre().toUpperCase().startsWith(String.valueOf(letra).toUpperCase())) {
                niños[i].presentarse();
                hayNiños = true;
            }
        }
        if (!hayNiños) System.out.println("No hay niños cuyos nombres empiecen con '" + letra + "'.\n");
    }

    public double decirEdadPromedio() {
        if (cantidadDeNiños == 0) return 0.0;
        int suma = 0;
        for (int i = 0; i < cantidadDeNiños; i++) suma += niños[i].edad();
        return (double) suma / cantidadDeNiños;
    }

    public void mostrarEstado() {
        System.out.println(nombre.toUpperCase() + ":");
        if (cantidadDeNiños == 0) System.out.println("  Cola vacía\n");
        else {
            System.out.println("  Niños en cola: " + cantidadDeNiños);
            mostrarGrupo(extraerGrupo(cantidadDeNiños));
        }
    }

    public Niño[] recibeNiñosParaJugar(Niño[] grupo) {
        int recibidos = 0;
        Niño[] grupoRecibido = new Niño[grupo.length];
        for (Niño n : grupo) {
            if (n != null && cantidadDeNiños < niños.length) {
                niños[cantidadDeNiños++] = n;
                grupoRecibido[recibidos++] = n;
                System.out.println(nombre + " recibió al niño " + n.nombre());
            }
        }
        return Arrays.copyOf(grupoRecibido, recibidos);
    }

    public void reorganizarCola(Niño[] nuevosNiños, int cantidad) {
        Arrays.fill(niños, null);
        System.arraycopy(nuevosNiños, 0, niños, 0, cantidad);
        cantidadDeNiños = cantidad;
    }

    private void reacomodarNiños(int tamaño) {
        for (int i = tamaño; i < cantidadDeNiños; i++) {
            niños[i - tamaño] = niños[i];
        }
        for (int i = cantidadDeNiños - tamaño; i < cantidadDeNiños; i++) {
            niños[i] = null;
        }
    }

    private Niño[] extraerGrupo(int tamaño) {
        return Arrays.copyOf(niños, tamaño);
    }

    private boolean haySuficientesNinos() {
        if (cantidadDeNiños < 5) {
            System.out.println("No hay suficientes niños para iniciar el juego (Mínimo 5).\n");
            return false;
        }
        return true;
    }

    private void mostrarGrupo(Niño[] grupo) {
        for (Niño n : grupo) {
            if (n != null) System.out.println("- " + n.nombre());
            else System.out.println("niño nulo");
        }
        System.out.println();
    }

    public String nombre() { return nombre; }
    public int cantidadDeNiños() { return cantidadDeNiños; }
}