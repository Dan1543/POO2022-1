public class Veterinarian {
    String name;
    double salary;
    double money;
    public Veterinarian (String name, double salary){
        this.name = name;
        this.salary = salary;
        this.money = 100; //Para que no inicie pobre:(
    }
    
    public void vaccinate(Animal animal){
        animal.setVaccinated(true);
        System.out.println(animal.getName() + "fue vacunado");
    }
    public void pagar(){
        money+=salary;
        System.out.println(name + " esta contento de que le pagaran");
    }
    public void comprarseunacocita(int cuantas){
        if((cuantas*15)>salary){
            System.out.println("No te puedes comprar tantas cocitas:(");
        }
        else{
            money-=cuantas*15;
            System.out.println("El veterinario es feliz:)");
        }
    }
}
