public class Horse extends Animal{
    public Horse(String name, int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(name + " esta comiendo hierba");
    }
    @Override
    public String getBreed(){
        return "Caballo";
    }
    public void mount(){
        System.out.println(name + " esta siendo cuidadoso de no tirarte");
    }
}
