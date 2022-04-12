public class Chuck extends Bird{
    public Chuck(){
        this.setVelocidad(10);
        this.setPeso(10);
        this.setPoder("Cuando usas mi poder me vuelvo mas rapido");
        this.setTamanio("Normal");
    }

    @Override
    public void ataque(){
        System.out.println(this.getPoder());
    }
}
