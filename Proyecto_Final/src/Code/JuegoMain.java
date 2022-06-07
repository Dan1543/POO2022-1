package Code;
import Visuals.*;
public class JuegoMain {
    public static void main(String[] args) {
        Jugador Jug1 = new Jugador(1,"Jugador 1");
        Jugador Jug2 = new Jugador(1,"Jugador 2");
        new frameMainpg(Jug1,Jug2).setVisible(true);
    }
}
