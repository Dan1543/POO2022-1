public class MiniRobotCuchillos extends Robot{
    public MiniRobotCuchillos(){
        super(100, "Robot de cuchillos", 0);
    }
    @Override
    public void restarBateria(){
        setBateria(bateria-15);
    }
    @Override
    public int accion(String accionrealizada){
        setUltimaaccion(accionrealizada);
        return 1; //Este return es de la accion que el robot deberia de hacer
    }
}
