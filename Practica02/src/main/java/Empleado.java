import java.util.Scanner;
public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private String horario;
    private String genero;
    public void capturarAtributos(){
        System.out.println("Ingresa el id:");
        Scanner inId = new Scanner(System.in);
        this.id = inId.nextInt();
        System.out.println("Ingresa el nombre:");
        Scanner inNombre = new Scanner(System.in);
        this.nombre = inNombre.next();
        System.out.println("Ingresa el puesto:");
        Scanner inPuesto = new Scanner(System.in);
        this.puesto = inPuesto.next();
        System.out.println("Ingresa el horario (formato HH:MM-HH:MM):");
        Scanner inHorario = new Scanner(System.in);
        this.horario = inHorario.next();
        System.out.println("Ingresa el genero:");
        Scanner inPrecio = new Scanner(System.in);
        this.genero = inPrecio.next();
        System.out.println("Objeto capturado con existo \n");
    }
    public void imprimirObjetos(){
        System.out.println("\nId: " + this.id);
        System.out.println("Marca: " + this.nombre);
        System.out.println("Puesto: " + this.puesto);
        System.out.println("Horario: " + this.horario);
        System.out.println("Genero: " + this.genero);
    }
}

