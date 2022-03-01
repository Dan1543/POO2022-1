import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int cont, no_control, calificacion, opcion;
        String materia;
        Estudiante[] estu = new Estudiante[10];
        estu[0] = new Estudiante(1,"Daniel","Matematicas", 70);
        estu[1] = new Estudiante(2,"Antonio","Matematicas", 59);
        estu[2] = new Estudiante(3,"Pepe","Matematicas", 30);
        estu[3] = new Estudiante(4,"Ana","Matematicas", 92);
        estu[4] = new Estudiante(5,"Alfredo","Matematicas", 80);
        /*Creamos todo con valores default para evitar errores al mostrar*/
        for (cont = 5; cont<10; cont++){
            estu[cont] = new Estudiante();
        }
        do{
            System.out.println("Ingresa la opcion a escoger: \n1.-Capturar alumnos\n2.-Mostrar alumnos\n3.-Salir");
            Scanner inOpcion = new Scanner(System.in);
            opcion = inOpcion.nextInt();
            if(opcion == 1){
                for (cont = 5; cont<10; cont++){
                    System.out.println("Ingresa el numero de control del alumno: ");
                    Scanner inNoControl = new Scanner(System.in);
                    no_control = inNoControl.nextInt();
                    System.out.println("Ingresa la materia: ");
                    Scanner inMateria = new Scanner(System.in);
                    materia = inMateria.next();
                    System.out.println("Ingresa la calificacion: ");
                    Scanner inCalificacion = new Scanner(System.in);
                    calificacion = inCalificacion.nextInt();
                    estu[cont].EditarEstudiante(no_control,materia,calificacion);
                 }
            }
            else if(opcion == 2){
                for (cont = 0; cont<10;cont++){
                    estu[cont].mostraralumno();
                }
            }
        }while(opcion!=3);
    }
}
