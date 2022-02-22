import java.util.Scanner;
public class Celular {
    private int id;
    private String marca;
    private String modelo;
    private int memoria;
    private String color;
    public void capturarAtributos(){
        System.out.println("Ingresa el id del celular");
        Scanner inId = new Scanner(System.in);
        this.id = inId.nextInt();
        System.out.println("Ingresa la marca del celular");
        Scanner inMarca = new Scanner(System.in);
        this.marca = inMarca.next();
        System.out.println("Ingresa el modelo del celular");
        Scanner inModelo = new Scanner(System.in);
        this.modelo = inModelo.next();
        System.out.println("Ingresa la memoria del celular (en gb)");
        Scanner inMemoria = new Scanner(System.in);
        this.memoria = inMemoria.nextInt();
        System.out.println("Ingresa el color del celular");
        Scanner inColor = new Scanner(System.in);
        this.color = inColor.next();
        System.out.println("Objeto capturado con existo \n");
    }
    public void imprimirObjetos(){
        System.out.println("\nId: " + this.id);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Memoria: " + this.memoria + "gb");
        System.out.println("Color: " + this.color);
    }
}
