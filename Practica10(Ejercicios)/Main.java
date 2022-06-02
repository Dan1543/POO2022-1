public class Main {
    public static void main(String[] args) {
        //Ejercicio 1:
        Cat gatito = new Cat("Cato",5);
        gatito.eat();
        gatito.sleep();
        Dog perrito = new Dog("Roy", 3);
        perrito.eat();
        perrito.sleep();
        //Ejercicio 2:
        Animal Ej2 = new Dog("Firulais",4);
        Ej2.age();
        Ej2.eat();
        Ej2.sleep();
        //Ejercicio 3:
        Animal [] animalArray = new Animal[3];
        animalArray[0] = new Animal("Un animal",1);
        animalArray[1] = new Dog("Chispita",4);
        animalArray[2] = new Cat("Miau",2);
        for(Animal a: animalArray){
            a.eat();
            //Ejercicio 4:
            if (a instanceof Dog){
                ((Dog) a ).bark();
            }
        }        
    }
    
}
