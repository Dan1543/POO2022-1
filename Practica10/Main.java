public class Main {
    public static void main(String[] args) {
        Zoo zoologicoNewYork = new Zoo(CapturaEntrada.capturaFloat("Cuanto se le va a pagar al veterinario"), CapturaEntrada.capturaString("Como se llama"), CapturaEntrada.capturaEntero("Cuantos animales registraras"));
        zoologicoNewYork.addAnimal();
        zoologicoNewYork.showAnimals();
        zoologicoNewYork.removeAnimal(CapturaEntrada.capturaEntero("Que animal deseas eliminar de la lista"));
    }
    
}
