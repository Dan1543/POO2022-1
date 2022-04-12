public class Main {
    public static void main(String[] args) {
        int cont;
        Bird Pajaros[] = new Bird[]{new Chuck(),new Bomb(),new Blues()};
        for (cont=0;cont<Pajaros.length;cont++){
            Pajaros[cont].ataque();
        }
    }
    
}
