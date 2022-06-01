
public class Main {
    public static void main(String[] args) {
        Alumno a1 = new Alumno("Daniel",1279926);
        a1.imprimirAlumno();
        LecturaEscritura.escritura(a1);
        Alumno a2 = new Alumno("Ingrid",1234879);
        a2.imprimirAlumno();
        LecturaEscritura.escritura(a2);
        Alumno a3 = new Alumno("Andres",786489);
        a3.imprimirAlumno();
        LecturaEscritura.escritura(a3);
        
        //LecturaEscritura.lecturatxt(); Si se desea revisar lo que esta escrito
    }
}
