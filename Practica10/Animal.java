public class Animal {
    String name;
    int age;
    boolean vaccinated;
    
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
        this.vaccinated = false;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public String getBreed(){
        return "Esta clase no distingue razas";
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
