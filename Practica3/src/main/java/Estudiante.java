import java.util.Scanner;
public class Estudiante {
    private String nombre;
    private int numero_control;
    private String materia;
    private int calificacion;
    private String estado;
    
    public Estudiante() {
        this.numero_control = 0;
        this.nombre = null;
        this.materia = null;
        this.calificacion = 0;
        this. estado = null;
    }
    /*Este constructor es para los default*/
    public Estudiante(int id, String nombre, String materia, int calificacion){
        this.numero_control = id;
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
        this.estado = Estudiante.AsignarEstado(calificacion);
    }
    /*Este para los creados despues*/
    public void EditarEstudiante(int id, String materia, int calificacion){
        this.numero_control = id;
        this.nombre = Estudiante.AsignarNombre();
        this.materia = materia;
        this.calificacion = calificacion;
        this.estado = Estudiante.AsignarEstado(calificacion);
    }
    public static String AsignarNombre(){
        String nombres;
        System.out.println("Ingresa el nombre del alumno: ");
        Scanner inNombre = new Scanner(System.in);
        nombres = inNombre.next();
        return nombres;
    } 
    public static String AsignarEstado(int calificacion){
        String estado_regresado;
        if (calificacion<60){
            estado_regresado = "Reprobado";
        }
        else{
            estado_regresado = "Aprobado";
        }
        return estado_regresado;
    }
    public void mostraralumno(){
        System.out.println("Numero de control: " + this.numero_control);
        System.out.println("Nombre del alumno: " + this.nombre);
        System.out.println("Materia: " + this.materia);
        System.out.println("Calificacion: " + this.calificacion);
        System.out.println("Estado: " + this.estado);
    }
}
