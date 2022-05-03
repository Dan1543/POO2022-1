
public abstract class Robot {

    public float bateria;
    public String nombre, ultimaaccion;
    public int identificador;
    
    public Robot(float bateria, String nombre, int identificador){
        setBateria(bateria);
        setNombre(nombre);
        setIdentificador(identificador);
        setUltimaaccion("Aun no ha realizado ninguna accion");
    }
    public void setBateria(float a) {
        this.bateria = a;
    }

    private float getBateria() {
        return this.bateria;
    }

    private void setNombre(String a) {
        this.nombre = a;
    }

    private String getNombre() {
        return this.nombre;
    }

    public void setUltimaaccion(String a) {
        this.ultimaaccion = a;
    }

    private String getUltimaaccion() {
        return this.ultimaaccion;
    }

    private void setIdentificador(int a) {
        this.identificador = a;
    }

    private int getIdentificador() {
        return this.identificador;
    }
    public void imprimeBot(){
        System.out.println("Identificador: " + getIdentificador());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Ultima accion realizada por el robot: " + getUltimaaccion());
        System.out.println("Bateria restante: " + getBateria());
    }
    //Para implementar el abstract hare que cada robot posea un distinto nivel de gasto de bateria
    public abstract void restarBateria();
    public abstract int accion(String a);    
}
