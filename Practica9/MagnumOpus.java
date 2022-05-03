public class MagnumOpus extends Robot{
    public MagnumOpus(){
        super(100, "Magnum Opus", 5);
    }
    @Override
    public void restarBateria(){
        setBateria(bateria-25); 
    }
    @Override
    public int accion(String accionrealizada){
        setUltimaaccion(accionrealizada);
        return 10; //Ya que el magnus opus puede hacer todo tendra el codigo especial 10
    }
}
