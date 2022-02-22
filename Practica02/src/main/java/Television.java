import java.util.Scanner;
public class Television {
    private int codigo;
    private String marca;
    private String modelo;
    private int tamanio;
    private int precio;
    public void capturarAtributos(){
        System.out.println("Ingresa el codigo:");
        Scanner inCodigo = new Scanner(System.in);
        this.codigo = inCodigo.nextInt();
        System.out.println("Ingresa la marca:");
        Scanner inMarca = new Scanner(System.in);
        this.marca = inMarca.next();
        System.out.println("Ingresa el modelo:");
        Scanner inModelo = new Scanner(System.in);
        this.modelo = inModelo.next();
        System.out.println("Ingresa el tamanio:");
        Scanner inTamanio = new Scanner(System.in);
        this.tamanio = inTamanio.nextInt();
        System.out.println("Ingresa el precio:");
        Scanner inPrecio = new Scanner(System.in);
        this.precio = inPrecio.nextInt();
        System.out.println("Objeto capturado con existo \n");
    }
    public void imprimirObjetos(){
        System.out.println("\nId: " + this.codigo);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Tamanio: " + this.tamanio + "pulgadas");
        System.out.println("Precio: " + this.precio);
    }
}
