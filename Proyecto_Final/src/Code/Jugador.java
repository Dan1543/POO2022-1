package Code;

/**
 *
 * @author jesus
 */
public class Jugador {
    public int progreso, estrellas;
    public String nombre;
    public boolean enturno;
    public Jugador(int jug, String nombre){
        this.estrellas = 0;
        this.enturno = false;
        this.nombre = nombre;
    }
}
