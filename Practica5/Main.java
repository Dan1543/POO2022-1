public class Main {
    public static void main(String[] args) {
        int cont,max=3;//max nos servira para hacer tres veces la operacion para la comprobacion de funcionamiento
        Banco banco = new Banco(1, "Banamex","CDMX"); //Supongamos que estamos trabajando solo con clientes de la sucursal 1 de CDMX de Banamex
        banco.Registro("Daniel", 1234,150000); //Registro de prueba para evitar no tener cuentas
        for(cont=0;cont<max;cont++){
            if(CapturaEntrada.capturaEntero("Ingresa 1 si quieres registrar una cuenta o 2 para acceder a una ya existente")==1){
                banco.Registro(CapturaEntrada.capturaString("Ingresa el nombre del titular"), CapturaEntrada.capturaEntero("Ingresa tu nip recuerda que este servira para acceder a tu cuenta"));
            }
            else{
                banco.Acceso(CapturaEntrada.capturaLong("Ingresa tu numero de cuenta"), CapturaEntrada.capturaEntero("Ingresa tu nip"));
            }
        }
    }
}
