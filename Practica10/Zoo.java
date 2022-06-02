import java.util.ArrayList;

public class Zoo {
    ArrayList <Animal> animales;
    Veterinarian veterinario;
    public Zoo(float sueldo, String nombre, int num_animales){
        this.animales = new ArrayList<Animal>();
        veterinario = new Veterinarian(nombre,sueldo);
        for(int cont=0;cont<num_animales;cont++){
            addAnimal();
        }
    }
    public void removeAnimal(int index){
        if(index<animales.size()){
            animales.remove(index);
        }else{
            System.out.println("No hay ningun animal registrado con ese indice"); 
        }
    }
    public void showAnimals(){
        for (Animal a:animales){
            System.out.println("Nombre: " + a.getName()+ "\nEdad: " + a.getAge()+ "\nRaza: " + a.getBreed());
        }
    }
    public void addAnimal(){
        String nombretemp;
        int edadtemp, tipo=0;
        do{
            tipo = CapturaEntrada.capturaEntero("""
                                                Que animal vas a agregar?
                                                1) Perro
                                                2) Gato
                                                3) Caballo
                                                4) Leon
                                                """);
        }while (tipo<=1 && tipo>=4);
        nombretemp = CapturaEntrada.capturaString("Como se llama");
        edadtemp = CapturaEntrada.capturaEntero("Cuantos años tiene");
        switch (tipo){
            case 1 -> {
                Animal Dogtemp = new Dog(nombretemp,edadtemp);
                animales.add(Dogtemp);
            }
            case 2 -> {
                Animal Cattemp = new Cat(nombretemp,edadtemp);
                animales.add(Cattemp);
            }
            case 3 -> {
                Animal Horsetemp = new Horse(nombretemp,edadtemp);
                animales.add(Horsetemp);
            }
            case 4 -> {
                Animal Liontemp = new Lion(nombretemp,edadtemp);
                animales.add(Liontemp);
            }  
        }
    }
}
