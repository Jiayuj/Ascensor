public class Ascensor {

    int maxPersona, maxPiso, actualPersona,actualPiso;

    public Ascensor(int maxPersona, int maxPiso) {
        this.maxPersona = maxPersona;
        this.actualPiso=0;
        this.actualPersona=0;
        this.maxPiso=maxPiso;
    }

    public int getActualPiso() {
        return actualPiso;
    }

    public void setActualPiso(int actualPiso) {
        this.actualPiso = actualPiso;
    }

    public synchronized void entrar (int entraPiso, String nombre){
        try {
            while (actualPersona == maxPersona || actualPiso != entraPiso) wait();
            System.out.println(nombre + " entra piso " + actualPiso );
            actualPersona++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void salir (int salirPiso,String nombre){
        try {
            while (actualPiso != salirPiso) wait();
            System.out.println(nombre + " salir piso " + actualPiso );
            actualPersona--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void bajar(){
        actualPiso--;
        System.out.println("                    Ascensor bajar a "+actualPiso + " hay " + actualPersona+" personas");
        notifyAll();
    }

    public synchronized void subir(){
        actualPiso++;
        System.out.println("                    Ascensor subir a "+actualPiso + " hay " + actualPersona+" personas");
        notifyAll();
    }

}
