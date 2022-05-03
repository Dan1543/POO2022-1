public class MiniRobotComidas extends Robot implements MiniRobots{
    public MiniRobotComidas(){
        super(100, "Robot para comidas", 2);
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
        return 2; //2 para comidas
    }
}
