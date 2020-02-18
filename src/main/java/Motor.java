public class Motor extends Thread {

    int maxPiso;
    boolean estasubir;
    Ascensor ascensor;

    public Motor(int maxPiso, Ascensor ascensor) {
        this.maxPiso = maxPiso;
        this.estasubir = true;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        for (;;){

            if (ascensor.getActualPiso()==maxPiso){
                estasubir=false;
            }else if (ascensor.getActualPiso()==0){
                estasubir=true;
            }

            if (estasubir){
                ascensor.subir();
            }else {
                ascensor.bajar();
            }

            int tmp = (int) ((Math.random() * 2000) + 2000);
            try {
                Thread.sleep(tmp);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
