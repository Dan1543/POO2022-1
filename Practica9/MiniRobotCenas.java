public class MiniRobotCenas extends Robot implements MiniRobots{
    public MiniRobotCenas(){
        super(100, "Robot para cenas", 3);
    }
    @Override
    public void restarBateria(){
        setBateria(bateria-20);
    }
    @Override
    public int accion(String accionrealizada){
        setUltimaaccion(accionrealizada);
        return 2; //Este return es de la accion que el robot deberia de hacer
    }
    @Override
    public int especialidad(){
        return 3; //3 para cenas
    }
}
