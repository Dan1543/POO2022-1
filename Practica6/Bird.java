public class Bird {
    private int velocidad, peso;
    private String poder,tamanio;
    public Bird(){
    }
    public void setVelocidad(int a){
        this.velocidad = a;
    }
    public void setPeso(int a){
        this.peso = a;
    }
    public void setPoder(String a){
        this.poder = a;
    }
    public void setTamanio(String a){
        this.tamanio = a;
    }
    public String getPoder(){
        return this.poder;
    }
    public void ataque(){
        System.out.println("Me lanzaste");
    }
    public void atributos(){
        System.out.println("Velocidad: " + this.velocidad);
        System.out.println("Peso: " + this.peso);
        System.out.println("Tamaños: " + this.tamanio);
        System.out.println("Poder: " + this.poder);
    }
}
