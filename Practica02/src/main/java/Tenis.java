import java.util.Scanner;
public class Tenis {
    private int id;
    private String marca;
    private String modelo;
    private int precio;
    private int existencias;
    private int talla;
    public void capturarAtributos(){
        System.out.println("Ingresa el id:");
        Scanner inId = new Scanner(System.in);
        this.id = inId.nextInt();
        System.out.println("Ingresa la marca:");
        Scanner inMarca = new Scanner(System.in);
        this.marca = inMarca.next();
        System.out.println("Ingresa el modelo:");
        Scanner inModelo = new Scanner(System.in);
        this.modelo = inModelo.next();
        System.out.println("Ingresa las existencias:");
        Scanner inExistencias = new Scanner(System.in);
        this.existencias = inExistencias.nextInt();
        System.out.println("Ingresa el precio:");
        Scanner inPrecio = new Scanner(System.in);
        this.precio = inPrecio.nextInt();
        System.out.println("Ingresa la talla en cm:");
        Scanner inTalla = new Scanner(System.in);
        this.talla = inTalla.nextInt();
        System.out.println("Objeto capturado con existo \n");
    }
    public void imprimirObjetos(){
        System.out.println("\nId: " + this.id);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Existencias: " + this.existencias);
        System.out.println("Precio: " + this.precio);
        System.out.println("Talla: " + this.talla + "cm");
    }
}

