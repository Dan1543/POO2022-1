
class Cuenta extends Banco{
    private String titular;
    private long no_cuenta;
    private float saldo;
    private int pin;
    Cuenta(){}
    void setTitular(String titu){
        this.titular = titu;
    }
    String getTitular(){
        return this.titular;
    }
    void setNocuenta(long numero){
        this.no_cuenta = numero;
    }
    long getNocuenta(){
        return this.no_cuenta;
    }
    void setSaldo(float saldo){
        if(saldo>0){
            this.saldo = saldo;
        }
    }
    float getSaldo(){
        return this.saldo;
    }
    void setPin(int pin){
        this.pin = pin;
    }
    int getPin(){
        return this.pin;
    }
    boolean accesocuenta(long pin){
        return pin==this.pin;
    }
    void deposito(){
        float dinero;
        dinero = CapturaEntrada.capturaFloat("Ingrese la cantidad a depositar");
        CapturaEntrada.capturaString("Ingrese el dinero (Ingrese cualquier cosa cuando lo haga)"); //Simula que se esta depositando
        CapturaEntrada.capturaString("Puede retirar su tarjeta (Ingrese cualquier cosa cuando lo haga)"); //Simula que se esta sacando la tarjeta
        this.saldo+=dinero;
        System.out.println("El saldo actual es de: " + this.saldo);
    }
    void retiro(){
        float dinero;
        boolean paso=false;
        CapturaEntrada.capturaString("Puede retirar su tarjeta (Ingrese cualquier cosa cuando lo haga)"); //Simula que se esta sacando la tarjeta
        do{
            if(paso){System.out.println("Ingresa una cantidad valida");}
            dinero = CapturaEntrada.capturaFloat("Ingrese la cantidad a retirar: ");
            paso=true;
        }while (dinero>this.saldo);
        this.saldo-=dinero;
        System.out.println("Puede retirar su dinero\nEl saldo actual es de: " + this.saldo);
    }
}
