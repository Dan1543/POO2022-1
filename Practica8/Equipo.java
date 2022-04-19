import java.util.HashMap;
import java.util.Map;
public class Equipo {
    public Map<Integer,Jugador> jugadores;
    private String nombre, division, entrenador;
    private int torn_part,torn_gan,torn_perd, num_jug,num_equ;
    public Equipo(){
    }
    public Equipo(String nom, String div, String ent, int torpar, int torgan, int torper, int numjug,int numequ){
        this.jugadores = new HashMap();
        this.setnombre(nom);
        this.setdivision(div);
        this.setentrenador(ent);
        this.settorn_part(torpar);
        this.settorn_gan(torgan);
        this.settorn_perd(torper);
        this.setnum_jug(numjug);
        this.setnum_equ(numequ);
        this.addjugador();
    }
    private void setnum_equ(int a){
        this.num_equ=a;
    }
    private void setnum_jug(int a){
        this.num_jug=a;
    }
    private void setnombre(String a){
        this.nombre=a;
    }
    private void setdivision(String a){
        this.division=a;
    }
    private void setentrenador(String a){
        this.entrenador=a;
    }
    private void settorn_part(int a){
        this.torn_part=a;
    }
    private void settorn_gan(int a){
        this.torn_gan=a;
    }
    private void settorn_perd(int a){
        this.torn_perd=a;
    }
    private int getnum_jug(){
        return this.num_jug;
    }
    public int getnum_uniforme(int con){
        return jugadores.get(con).getnum_uniforme();
    }
    public String getnombre_jug(int con){
        return jugadores.get(con).getnombre();
    }
    public void getnombre(String a){
        this.nombre = a;
    }
    public String getnombre(){
        return this.nombre;
    }
    public void getdivision(String a){
        this.division = a;
    }
    public String getdivision(){
        return this.division;
    }
    public void getentrenador(String a){
        this.entrenador = a;
    }
    public String getentrenador(){
        return this.entrenador;
    }
    public void gettorn_part(int a){
        this.torn_part = a;
    }
    public int gettorn_part(){
        return this.torn_part;
    }
    public void gettorn_gan(int a){
        this.torn_gan = a;
    }
    public int gettorn_gan(){
        return this.torn_gan;
    }
    public void gettorn_perd(int a){
        this.torn_perd = a;
    }
    public int gettorn_perd(){
        return this.torn_perd;
    }
    public int jugadores_registrados(){
        return jugadores.size();
    }
    private void addjugador(){
        int cont;
        for (cont=0;cont<this.getnum_jug();cont++){
            Jugador crearjug = new Jugador(this.revisar_num_uniforme(cont, CapturaEntrada.capturaEntero("Cual es el numero de uniforme?: ")),
            CapturaEntrada.capturaString("Cual es el nombre del jugador?: "),
            CapturaEntrada.capturaEntero("Cuantos puntos ha anotado?: "),
            CapturaEntrada.capturaString("Cual es su posicion?: "),
            CapturaEntrada.capturaFloat("Cual es su estatura?: "));
            this.jugadores.put(cont,crearjug);
        }
    }
    public int revisar_num_uniforme(int jug, int numuni){
        int contjug;
        if(this.jugadores.isEmpty()){
            return numuni;
        }
        else{
            for(contjug=0;contjug<this.jugadores_registrados();contjug++){
                if(numuni==this.jugadores.get(contjug).getnum_uniforme()){
                    numuni=CapturaEntrada.capturaEntero("El numero de uniforme que escogiste ya esta registrado en otro jugador: ");
                }
            }
        }
        return numuni;
    }
    public int puntos_anotados(){
        int cuenta = 0, cont, jug;
        jug = this.jugadores_registrados();
        for (cont = 0; cont<jug; cont++){
            cuenta += this.jugadores.get(cont).getpuntos_anotados();
        }
        return cuenta;
    }
}
