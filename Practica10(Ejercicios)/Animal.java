public class Animal {
    String name;
    int age;
    boolean vaccinated;
    
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
        setVaccinated(false);
    }
    public String getName(){
        return this.name;
    }
    public void setVaccinated(boolean a){
        this.vaccinated = a;
    }
    public void eat(){
        System.out.println(name + " esta comiendo");
    }
    public void sleep(){
        System.out.println(name + " esta durmiendo");
    }
    public void age(){
        System.out.println(name + " actualmente tiene " + age + " años");
    }
}
