import java.util.ArrayList;

public class Banco {
    private int numero_banco;
    private String direccion, empresa;
    ArrayList<Cuenta> cuentasbanco = new ArrayList<>();
    public Banco(){}
    public Banco(int numero, String empresa, String direccion){
        this.numero_banco = numero;
        this.empresa = empresa;
        this.direccion = direccion;
    }
    public void Registro(String titular, int pin, float dinero){ //Registro de cuentas 
        Cuenta cuentanueva = new Cuenta();
        cuentanueva.setTitular(titular);
        cuentanueva.setNocuenta(crearnocuenta());
        cuentanueva.setPin(pin);
        cuentanueva.setSaldo(dinero);
        this.cuentasbanco.add(cuentanueva);
    }
    public void Registro(String titular, int pin){
        Cuenta cuentanueva = new Cuenta();
        cuentanueva.setTitular(titular);
        cuentanueva.setNocuenta(crearnocuenta());
        cuentanueva.setPin(pin);
        cuentanueva.setSaldo(CapturaEntrada.capturaFloat("Ingresa la cantidad de tu primer deposito"));
        this.cuentasbanco.add(cuentanueva);
        System.out.println("Cuenta registrada con exito con los datos: ");
        mostrarCuenta(this.cuentasbanco.size()-1);
    }
    private long crearnocuenta(){
        int cont;
        long num=1;
        for (cont=0;cont<this.cuentasbanco.size();cont++){
            num++;
        }
        return num;
    }
    private void mostrarCuenta(int index){
        System.out.println("Titular: " + this.cuentasbanco.get(index).getTitular());
        System.out.println("No cuenta: " + this.cuentasbanco.get(index).getNocuenta());
        System.out.println("Saldo actual: " + this.cuentasbanco.get(index).getSaldo());
    }
    public void Acceso(long no_cuenta,int pin){
        int indexCuenta;
        indexCuenta = buscarCuenta(no_cuenta);
        if(this.cuentasbanco.get(indexCuenta).accesocuenta(pin)){
            System.out.println("Acceso concedido");
            mostrarMenu(this.cuentasbanco.get(indexCuenta).getTitular(),indexCuenta);
        }
        else{
            System.out.println("Has ingresado un pin incorrecto");
            System.exit(0);
        }
    }
    private int buscarCuenta(long cuenta){
        int cont;
        for (cont=0;cont<this.cuentasbanco.size();cont++){
            if(this.cuentasbanco.get(cont).getNocuenta()==(cuenta)){
                return cont;
            }
        }
        System.out.println("No se encontro ninguna cuenta con ese numero de cuenta");
        System.exit(0);
        return 0;
    }
    private void mostrarMenu(String titular, int index){
        System.out.println("Bienvenido: " + titular);
        if(CapturaEntrada.capturaEntero("Si desea hacer un retiro ingrese 1, si desea hacer un deposito ingrese 2")==1){
            System.out.println("En este momento el saldo de la cuenta es de: " + this.cuentasbanco.get(index).getSaldo());
            this.cuentasbanco.get(index).retiro();
        }
        else{
            this.cuentasbanco.get(index).deposito();
        }
    }
}
