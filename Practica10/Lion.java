public class Lion extends Animal{
    
    public Lion(String name, int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(name + " esta comiendo un gran pedazo de carne");
    }
    @Override
    public String getBreed(){
        return "Leon";
    }
    public void rawr(){
        System.out.println(name + ": Rawr jeje(:");
    }
    
}
