public class main {
    public static void main(String[] args) {
        int cont,cont2;
        Torneo Nba = new Torneo(CapturaEntrada.capturaString("Cual es el nombre del torneo?: "),
        CapturaEntrada.capturaString("Cual la region?: "),
        CapturaEntrada.capturaEntero("Cuantos equipos participaran?: "),
        CapturaEntrada.capturaEntero("Cuantos partidos se han jugado?: "),
        CapturaEntrada.capturaEntero("Cuantos partidso faltan por jugar?: "));
        System.out.println("El torneo se llama: " + Nba.getnombre());
        System.out.println("El torneo se juega en la region: " + Nba.getregion());
        System.out.println("Con este numero de participantes: " + Nba.getnum_part());
        System.out.println("Hasta el momento se han jugado: " + Nba.getpart_jug() + "partidos");
        System.out.println("Y faltan por jugar: " + Nba.getpart_pen() + "partidos");
        for(cont=0;cont<Nba.getnum_part();cont++){
            System.out.println("\n\nEl equipo: " + Nba.getnombre_equipo(cont));
            System.out.println("De la division: " + Nba.getdivision(cont));
            System.out.println("Este equipo ha anotado la cantidad de: " + Nba.getpuntos_equipos(cont) + "puntos");
            System.out.println("Tiene registrados a : " + Nba.getnumjugadores(cont) + "jugadores \n Los cuales son:");
            for(cont2=0;cont2<Nba.getnumjugadores(cont);cont2++){
                System.out.println("Con el numero: " + Nba.getnumuniforme(cont, cont2) + " " +  Nba.getnombre_jugador(cont, cont2) + "\n\n");
            }
        }
    }    
}
