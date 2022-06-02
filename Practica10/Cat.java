public class Cat extends Animal{
    
    public Cat(String name, int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(name + " esta comiendo un pescado");
    }
    @Override
    public String getBreed(){
        return "Gato";
    }
    public void ignore(){
        System.out.println(name + " esta ignorandote:(");
    }
}
