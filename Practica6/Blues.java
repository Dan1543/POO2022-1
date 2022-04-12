public class Blues extends Bird {
    public Blues(){
        this.setVelocidad(10);
        this.setPeso(5);
        this.setPoder("Cuando usas mi poder me divido en tres");
        this.setTamanio("Pequeño");
    }
    @Override
    public void ataque(){
        System.out.println(this.getPoder());
    }
}
