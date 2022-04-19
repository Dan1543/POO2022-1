public class Jugador {
    private int num_uniforme, puntos_anotados;
    private String nombre, posicion;
    private float estatura;
    public Jugador(){}
    public Jugador(int num, String nom, int punt, String pos, float est){
        this.setnum_uniforme(num);
        this.setnombre(nom);
        this.setpuntos_anotados(punt);
        this.setposicion(pos);
        this.setestatura(est);
    }
    private void setnum_uniforme(int a){
        this.num_uniforme = a;
    } 
    public int getnum_uniforme(){
        return this.num_uniforme;
    }
    private void setpuntos_anotados(int a){
        this.puntos_anotados = a;
    } 
    public int getpuntos_anotados(){
        return this.puntos_anotados;
    }
    private void setnombre(String a){
        this.nombre = a;
    } 
    public String getnombre(){
        return this.nombre;
    }
    private void setposicion(String a){
        this.posicion = a;
    } 
    public String getposicion(){
        return this.posicion;
    }
    private void setestatura(float a){
        this.estatura = a;
    } 
    public float getestatura(){
        return this.estatura;
    }
}
