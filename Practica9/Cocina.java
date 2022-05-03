public class Cocina{
        public Robot[] Bots = new Robot[6];
        public String[] listaacciones;
        public int accionactual,accioncorrecta,comidaactual,botactual;
        public int[] acciones;
        public boolean salida;
    public Cocina(){
        Bots[0] = new MiniRobotCuchillos();
        Bots[1] = new MiniRobotDesayunos();
        Bots[2] = new MiniRobotComidas();
        Bots[3] = new MiniRobotCenas();
        Bots[4] = new MiniRobotServido();
        Bots[5] = new MagnumOpus();
        setAccioncorrecta(1);
        setAccionactual(0);
        setComidaactual(0);
        botactual = 0;
        salida = true;
        acciones = new int[3];
        listaacciones = new String[3];
        listaacciones[0] = "Corto ingredientes";
        listaacciones[1] = "Cocino comida";
        listaacciones[2] = "Sirvio comida";
    }
    private void setAccioncorrecta(int a){
        this.accioncorrecta = a;
    }
    private void setAccionactual(int a){
        this.accionactual = a;
    }
    private void setComidaactual(int a){
        this.comidaactual = a;
    }
    public boolean revisarAccion(){
        return accioncorrecta==acciones[accioncorrecta-1];
    }
    public boolean revisarOrden(){
        return accionactual==accioncorrecta;
    }
    public boolean revisarComida(int revision){
        return revision ==comidaactual;
    }
    public int desplegarMenu(){
        System.out.println("Bienvenido al sistema de cocina del Magnum Opus");
        System.out.println("Lista de opciones:");
        System.out.println("1)Desayuno\n2)Comida\n3)Cena");
        return CapturaEntrada.capturaEntero("Selecciona la opcion adecuada segun lo que se preparara");
    }
    public void infoBots(){
        System.out.println("Estos son los Bots disponibles por el momento");
        for(int x=0;x<6;x++){
            Bots[x].imprimeBot();
        }
    }
    public void Cocinando(){
        comidaactual = desplegarMenu();
        infoBots();
        System.out.println("Debemos comenzar a cocinar recuerda que el orden es importante: ");
        System.out.println("1)Cortar los ingredientes");
        System.out.println("2)Cocinar la comida");
        System.out.println("3)Servir la comida");
        System.out.println("RECUERDA QUE ES IMPORTANTE QUE SE SELECCIONE EL ORDEN CORRECTO Y EL ROBOT CORRECTO PARA CADA ACCION");
        do{
            accionactual = CapturaEntrada.capturaEntero("Selecciona la accion que quieres realizar");
            botactual = CapturaEntrada.capturaEntero("Selecciona el identificador del robot que quieres que realice la tarea");
            acciones[accioncorrecta-1] = Bots[botactual].accion(listaacciones[accionactual-1]);
            Bots[botactual].restarBateria();
            if (accioncorrecta == 2){
                switch (botactual){//ESTO NO ES LO IDEAL
                    case 1 -> salida = revisarComida(1); 
                    case 2 -> salida = revisarComida(2);
                    case 3 -> salida = revisarComida(3);
                    case 5 -> salida = true; //OPUS PUEDE REALIZAR TODO POR LO QUE NO ES NECESARIO
                    default -> salida = false; //LOS OTROS BOTS NO TIENEN LA CAPACIDAD DE COCINAR
                }
                if(!salida){
                    System.out.println("El robot que usaste fue incapaz de cocinar lo que le pediste");
                }
            }       
            if(botactual!=5){
                if(!revisarAccion()){
                    salida = false;
                    System.out.println("El robot que usaste fue incapaz de realizar la accion que le pediste");
                }
                if(!revisarOrden()){
                    salida = false;
                    System.out.println("Realizaste alguna accion en el orden incorrecto");
                }
            }
            accioncorrecta++;
        }while(salida&&accioncorrecta<=3);
        if(salida){
            System.out.println("¡Hurra! El plato estaba delicioso");
        }
    }
}
