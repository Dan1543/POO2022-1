package Code;
import java.io.BufferedReader;
import java.io.FileReader;

//import java.io.File;
//import java.io.FileWriter;
//import java.io.BufferedWriter;
import java.io.IOException;

public class LecturaEscritura {
    public static String[][] lecturaPreguntas(String archivo,int cant_preg){
        FileReader fis = null;
        BufferedReader br;
        String[][] base;
        base = new String[cant_preg][6];
        try{
            fis = new FileReader(archivo);
            br = new BufferedReader(fis);
            String lector;
            int cont=0;
            while((lector = br.readLine()) != null){
                base[cont] = lector.split("\t");
                cont++;
            }
        }catch (IOException ioe){
            System.out.println("Error: " + ioe.toString());
        }finally{
            try{
                if (fis != null) fis.close();
            }catch (IOException ioe){
                System.out.println("Error al cerrar el archivo");
            }
        }
        return base;
    }
    /*public static void escritura(){
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
    }*/
}