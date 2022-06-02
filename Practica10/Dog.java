public class Dog extends Animal{
    
    public Dog(String name, int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(name + " esta comiendo un hueso");
    }
    @Override
    public String getBreed(){
        return "Perro";
    }
    public void bark(){
        System.out.println(name + ": Woof");
    }
}
