import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.ObjectOutputStream;
//import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Random;
public class LecturaEscritura {
    public static void lectura(float[] calAlumno){
        FileReader fis = null;
        BufferedReader br;
        String[] calificaciones = null;
        Random rand = new Random();
        try{
            fis = new FileReader("datos.csv");
            br = new BufferedReader(fis);
            String lector;
            while((lector = br.readLine()) != null){
                calificaciones = lector.split(",");
            }
        }catch (IOException ioe){
            System.out.println("Error: " + ioe.toString());
        }finally{
            for(int cont = 0;cont<7;cont++){
                calAlumno[cont] = Float.parseFloat(calificaciones[rand.nextInt(21)]);//Ya que hay 21 calificaciones
            }
            try{
                if (fis != null) fis.close();
            }catch (IOException ioe){
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
    public static void escritura(Alumno al){
        FileWriter fos = null;
        BufferedWriter obs = null;
        File file;
        try{
            file = new File("Alumnos.txt");
            if(!file.exists()) file.createNewFile();
            fos = new FileWriter(file.getAbsoluteFile(), true);
            obs = new BufferedWriter(fos);
            obs.write(al.nombre);
            obs.write(al.matricula);
            for (int cont=0; cont<7; cont++){
                obs.write(Float.toString(al.calificaciones[cont]));
            }
            obs.write(Float.toString(al.promedio));
            System.out.println("El alumno ha sido ingresado a la base de datos con exito");
        }catch (IOException ioe){
            System.out.println("Error: " + ioe.toString());
        }finally{
            try{
                if (fos != null) fos.flush();
                if (obs != null) obs.close();
            }catch (IOException ioe){
                System.out.println("Error al cerrar" + ioe.toString());
            }
        }
    }
    /*public static void lecturatxt(){
        FileInputStream fis = null;
        ObjectInputStream obs = null;
        try{
            fis = new FileInputStream("Alumnos.txt");
            obs = new ObjectInputStream(fis);
            try{
                Alumno al = (Alumno) obs.readObject();
                al.imprimirAlumno();
            }catch (ClassNotFoundException e){
                System.out.println("Error: " + e.toString());
            }
        }catch (IOException ioe){
            System.out.println("Error: " + ioe.toString());
        }finally{
            try{
                if (fis != null) fis.close();
                if (obs != null) obs.close();
                System.out.println("El alumno ha sido ingresado a la base de datos con exito");
            }catch (IOException ioe){
                System.out.println("Error al cerrar el archivo");
            }
        }
    }*/
}
