import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int cont, opcion;
        do{
            System.out.println("Menu de clases: \n1-Celular\n2-Television\n3-Cama\n4-Empleados\n5-Tenis\n6-Salir\nIngresa tu seleccion: ");
            Scanner inOpcion = new Scanner(System.in);
            opcion = inOpcion.nextInt();
            switch(opcion){
                case 1 -> {
                    Celular[] cel = new Celular[3];
                    for(cont = 0; cont<3;cont++){
                        cel[cont] = new Celular();
                        cel[cont].capturarAtributos();
                    }
                    for(cont = 0; cont<3;cont++){
                        cel[cont].imprimirObjetos();
                    }
                }
                case 2 -> {
                    Television[] tv = new Television[3];
                    for(cont = 0; cont<3;cont++){
                        tv[cont] = new Television();
                        tv[cont].capturarAtributos();
                    }
                    for(cont = 0; cont<3;cont++){
                        tv[cont].imprimirObjetos();
                    }
                }
                case 3 -> {
                    Cama[] cama = new Cama[3];
                    for(cont = 0; cont<3;cont++){
                        cama[cont] = new Cama();
                        cama[cont].capturarAtributos();
                    }
                    for(cont = 0; cont<3;cont++){
                        cama[cont].imprimirObjetos();
                    }
                }
                case 4 -> {
                    Empleado[] emp = new Empleado[3];
                    for(cont = 0; cont<3;cont++){
                        emp[cont] = new Empleado();
                        emp[cont].capturarAtributos();
                    }
                    for(cont = 0; cont<3;cont++){
                        emp[cont].imprimirObjetos();
                    }
                }
                case 5 -> {
                    Tenis[] ten = new Tenis[3];
                    for(cont = 0; cont<3;cont++){
                        ten[cont] = new Tenis();
                        ten[cont].capturarAtributos();
                    }
                    for(cont = 0; cont<3;cont++){
                        ten[cont].imprimirObjetos();
                    }
                }
            }
        }while(opcion!=6);
        System.out.println("Hasta luego:)");
    }  
}
