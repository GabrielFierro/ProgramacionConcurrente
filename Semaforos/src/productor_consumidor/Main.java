package productor_consumidor;

public class Main {

    public static void main(String[] args) {
        Buffer b = new Buffer(5);
        Productor p1 = new Productor(b, 10);
        Consumidor c1 = new Consumidor(b, 10);
        p1.start();
        c1.start();
    }
}
