public class MiniRobotServido extends Robot{
    public MiniRobotServido(){
        super(100, "Robot para servir platos", 4);
    }
    @Override
    public void restarBateria(){
        setBateria(bateria-20);
    }
    @Override
    public int accion(String accionrealizada){
        setUltimaaccion(accionrealizada);
        return 3; //Este return es de la accion que el robot deberia de hacer
    }
}
