public class Bomb extends Bird {
    public Bomb(){
        this.setVelocidad(10);
        this.setPeso(20);
        this.setPoder("Cuando usas mi poder exploto");
        this.setTamanio("Grande");
    }
    @Override
    public void ataque(){
        System.out.println(this.getPoder());
    }  
}
