public class MiniRobotDesayunos extends Robot implements MiniRobots {
    public MiniRobotDesayunos(){
        super(100, "Robot para los desayunos", 1);
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
        return 1; //1 para desayunos
    }
}
