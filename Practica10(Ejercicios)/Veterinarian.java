public class Veterinarian {
    String name;
    double salary;
    
    public Veterinarian (String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    public void vaccinate(Animal animal){
        animal.setVaccinated(true);
        System.out.println(animal.getName() + "fue vacunado");
    }
}
