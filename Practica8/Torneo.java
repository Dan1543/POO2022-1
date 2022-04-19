import java.util.HashMap;
import java.util.Map;
public class Torneo {
    private Map<Integer, Equipo> equipos;
    private String nombre, region;
    private int num_part, part_jug, part_pen;
    public Torneo(){
    }
    public Torneo(String nom, String reg, int par, int parj, int parp){
        this.equipos = new HashMap();
        this.setnombre(nom);
        this.setregion(reg);
        this.setnum_part(par);
        this.setpart_jug(parj);
        this.setpart_pen(parp);
        this.addequipos();
    }
    public void revisar_Nombres(String nombrearevisar){
        int contequ,contjug;
        if(!this.equipos.isEmpty()){
            for(contequ=0;contequ<this.num_part;contequ++){
                for(contjug=0;contjug<this.equipos.get(contequ).jugadores_registrados();contjug++){
                    if(nombrearevisar.equals(this.getnombre_jugador(contequ, contjug))){
                        Jugador crearjug = new Jugador(this.equipos.get(contequ).jugadores.get(contjug).getnum_uniforme(),
                                CapturaEntrada.capturaString("Se encontro que el jugador: " + this.equipos.get(contequ).jugadores.get(contjug).getnombre() + "Ya estaba registrado en otro equipo, ingresa un nombre valido: "),
                                this.equipos.get(contequ).jugadores.get(contjug).getpuntos_anotados(),
                                this.equipos.get(contequ).jugadores.get(contjug).getposicion(),
                                this.equipos.get(contequ).jugadores.get(contjug).getestatura());
                        this.equipos.get(contequ).jugadores.replace(contjug, crearjug);
                    }
                }
            }
        }
    }
    public int getnumjugadores(int con){
        return this.equipos.get(con).jugadores_registrados();
    }
    public int getnumuniforme(int con1,int con2){
        return this.equipos.get(con1).getnum_uniforme(con2);
    }
    public String getnombre_jugador(int con1, int con2){
        return this.equipos.get(con1).getnombre_jug(con2);
    }
    public int getpuntos_equipos(int con){
        return this.equipos.get(con).puntos_anotados();
    }
    public String getnombre_equipo(int con){
        return this.equipos.get(con).getnombre();
    }
    public String getdivision(int con){
        return this.equipos.get(con).getdivision();
    }
    public String getnombre(){
        return this.nombre;
    }
    private void setnombre(String a){
        this.nombre = a;
    }
    public String getregion(){
        return this.region;
    }
    private void setregion(String a){
        this.region = a;
    }
    public int getnum_part(){
        return this.num_part;
    }
    private void setnum_part(int a){
        this.num_part = a;
    }
    public int getpart_jug(){
        return this.part_jug;
    }
    private void setpart_jug(int a){
        this.part_jug = a;
    }
    public int getpart_pen(){
        return this.part_pen;
    }
    private void setpart_pen(int a){
        this.part_pen = a;
    }
    private void addequipos(){
        int cont;
        for (cont=0;cont<this.getnum_part();cont++){
            Equipo crearequipo = new Equipo(CapturaEntrada.capturaString("Cual es el nombre del equipo?: "),
            CapturaEntrada.capturaString("En que division se encuentra?: "),
            CapturaEntrada.capturaString("Cual es el nombre del entrenador?: "),
            CapturaEntrada.capturaEntero("En cuantos torneos ha participado?: "),
            CapturaEntrada.capturaEntero("Cuantos torneos ha ganado?: "),
            CapturaEntrada.capturaEntero("Cuantos torneos ha perdido?: "),
            CapturaEntrada.capturaEntero("Cuantos jugadores registraras en este equipo?: "),
            this.num_part);
            this.equipos.put(cont,crearequipo);
        }
    }
}
