
public class Persona extends Thread {

    String nombre;
    int entraPiso,salirPiso;
    Ascensor ascensor;

    public Persona(String nombre, Ascensor ascensor) {
        this.nombre = nombre;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        for (;;){
            entraPiso = (int) ((Math.random() * 10) + 1);
            salirPiso = (int) ((Math.random() * 10) + 1);
            System.out.println(nombre + " esta piso " + entraPiso + " ir a piso " + salirPiso);
            if (ascensor != null) ascensor.entrar(entraPiso,nombre);
            if (ascensor != null) ascensor.salir(salirPiso,nombre);

            int tmp = (int) ((Math.random() * 2000) + 2000);
            try {
                Thread.sleep(tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
