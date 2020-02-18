public class Main {
    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor(5,10);
        Motor motor = new Motor(10, ascensor);


        Persona persona = new Persona("p1",ascensor);
        Persona persona1 = new Persona("p2",ascensor);
        Persona persona2 = new Persona("p3",ascensor);
        Persona persona3 = new Persona("p4",ascensor);
        Persona persona4 = new Persona("p5",ascensor);
        Persona persona5 = new Persona("p6",ascensor);
        Persona persona6 = new Persona("p7",ascensor);

        motor.start();
        persona.start();
        persona1.start();
        persona2.start();
        persona3.start();
        persona4.start();
        persona5.start();
        persona6.start();

    }
}
