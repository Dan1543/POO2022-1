public class Cat extends Animal{
    
    public Cat(String name, int age){
        super(name,age);
    }
    @Override
    public void eat(){
        System.out.println(name + " esta comiendo un pescado");
    }
}
