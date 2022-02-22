import java.util.Scanner;
public class Cama {
    private int codigo;
    private String marca;
    private String tamanio;
    private int existencias;
    private int precio;
    public void capturarAtributos(){
        System.out.println("Ingresa el codigo:");
        Scanner inCodigo = new Scanner(System.in);
        this.codigo = inCodigo.nextInt();
        System.out.println("Ingresa la marca:");
        Scanner inMarca = new Scanner(System.in);
        this.marca = inMarca.next();
        System.out.println("Ingresa el tamanio:");
        Scanner inTamanio = new Scanner(System.in);
        this.tamanio = inTamanio.next();
        System.out.println("Ingresa las existencias:");
        Scanner inExistencias = new Scanner(System.in);
        this.existencias = inExistencias.nextInt();
        System.out.println("Ingresa el precio:");
        Scanner inPrecio = new Scanner(System.in);
        this.precio = inPrecio.nextInt();
        System.out.println("Objeto capturado con existo \n");
    }
    public void imprimirObjetos(){
        System.out.println("\nId: " + this.codigo);
        System.out.println("Marca: " + this.marca);
        System.out.println("Tamanio: " + this.tamanio);
        System.out.println("Existencias: " + this.existencias);
        System.out.println("Precio: " + this.precio);
    }
}
