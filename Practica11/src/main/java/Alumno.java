import java.io.Serializable;
public class Alumno implements Serializable {
    public String nombre; 
    public int matricula;
    public float calificaciones[], promedio;
    public Alumno(String nom, int mat){
        calificaciones = new float[7];
        this.setNombre(nom);
        this.setMatricula(mat);
        LecturaEscritura.lectura(calificaciones);
        promediar(calificaciones);
    }
    private void promediar(float[] cal){
        int suma = 0;
        for (int cont = 0; cont < 7; cont++){
            suma += cal[cont];
        }
        this.promedio = suma/7;
    }
    private void setNombre(String a){
        this.nombre = a;
    }
    private String getNombre(){
        return this.nombre;
    }
    private void setMatricula(int a){
        this.matricula = a;
    }
    private int getMatricula(){
        return this.matricula;
    }
    private float getPromedio(){
        return this.promedio;
    }
    public void imprimirAlumno(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Promedio: " + getPromedio());
        System.out.println("Calificaciones: ");
        for (int cont = 0; cont<7;cont++){
            System.out.println(this.calificaciones[cont]);
        }
    }
}
