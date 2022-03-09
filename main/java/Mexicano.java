/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
public class Mexicano {
    private String nombres,apPaterno,apMaterno,CURP,RFC,edo_nacimiento;
    private int dia,mes,anio;
    private char genero;
    private boolean temporal;
    private String [][] edos; //Esto nos ayudara con la parte del curp de los estados
    
    public Mexicano(){
    }
    public void setInicial(String nombres,String apPaterno,String apMaterno,String edo, int dia, int mes, int anio, char genero){
        setEdos();
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.edo_nacimiento = obtenerEdo(edo.toUpperCase());
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.genero = genero;
        this.temporal = false;
    }
    public void setCurp(){
        this.CURP = obtenerCurp();
    }
    public void setRfc(){
        this.RFC = obtenerRfc();
    }
    private void setEdos() {
        this.edos = new String[33][2];
        this.edos[0][0] = "AGUASCALIENTES";
        this.edos[0][1] = "AS";
        this.edos[1][0] = "BAJA CALIFORNIA SUR";
        this.edos[1][1] = "BS";
        this.edos[2][0] = "BAJA CALIFORNIA";
        this.edos[2][1] = "BC";
        this.edos[3][0] = "CAMPECHE";
        this.edos[3][1] = "CC";
        this.edos[4][0] = "COAHUILA";
        this.edos[4][1] = "CL";
        this.edos[5][0] = "COLIMA";
        this.edos[5][1] = "CM";
        this.edos[6][0] = "CHIAPAS";
        this.edos[6][1] = "CS";
        this.edos[7][0] = "CHIHUAHUA";
        this.edos[7][1] = "CH";
        this.edos[8][0] = "DISTRITO FEDERAL";
        this.edos[8][1] = "DF";
        this.edos[9][0] = "DURANGO";
        this.edos[9][1] = "DG";
        this.edos[10][0] = "GUANAJUATO";
        this.edos[10][1] = "GT";
        this.edos[11][0] = "GUERRERO";
        this.edos[11][1] = "GR";
        this.edos[12][0] = "HIDALGO";
        this.edos[12][1] = "HG";
        this.edos[13][0] = "JALISCO";
        this.edos[13][1] = "JC";
        this.edos[14][0] = "MEXICO";
        this.edos[14][1] = "MC";
        this.edos[15][0] = "MICHOACAN";
        this.edos[15][1] = "MN";
        this.edos[16][0] = "MORELOS";
        this.edos[16][1] = "MS";
        this.edos[17][0] = "NAYARIT";
        this.edos[17][1] = "NT";
        this.edos[18][0] = "NUEVO LEON";
        this.edos[18][1] = "NL";
        this.edos[19][0] = "OAXACA";
        this.edos[19][1] = "OC";
        this.edos[20][0] = "PUEBLA";
        this.edos[20][1] = "PL";
        this.edos[21][0] = "QUERETARO";
        this.edos[21][1] = "QT";
        this.edos[22][0] = "QUINTANA ROO";
        this.edos[22][1] = "QR";
        this.edos[23][0] = "SAN LUIS POTOSI";
        this.edos[23][1] = "SP";
        this.edos[24][0] = "SONORA";
        this.edos[24][1] = "SR";
        this.edos[25][0] = "SINALOA";
        this.edos[25][1] = "SL";
        this.edos[26][0] = "TABASCO";
        this.edos[26][1] = "TC";
        this.edos[27][0] = "TAMAULIPAS";
        this.edos[27][1] = "TS";
        this.edos[28][0] = "TLAXCALA";
        this.edos[28][1] = "TL";
        this.edos[29][0] = "VERACRUZ";
        this.edos[29][1] = "VZ";
        this.edos[30][0] = "YUCATAN";
        this.edos[30][1] = "YN";
        this.edos[31][0] = "ZACATECAS";
        this.edos[31][1] = "ZS";
        this.edos[32][0] = "EXTRANJERO";
        this.edos[32][1] = "NE";
    }
    private String obtenerCurp(){
        String Curp ="";
        Curp += String.valueOf(this.apPaterno.charAt(0)).toUpperCase();
        Curp += obtenerVocal(1,this.apPaterno.toUpperCase());
        Curp += String.valueOf(this.apMaterno.charAt(0)).toUpperCase();
        Curp += String.valueOf(this.nombres.charAt(0)).toUpperCase();
        Curp = revisarPalabra(Curp);
        if(this.anio<10){Curp += "0" + String.valueOf(anio);}
        else{Curp += String.valueOf(anio);}
        if(this.mes<10){Curp += "0" + String.valueOf(mes);}
        else{Curp += String.valueOf(mes);}
        if(this.dia<10){Curp += "0" + String.valueOf(dia);}
        else{Curp += String.valueOf(dia);}
        Curp += String.valueOf(this.genero).toUpperCase();
        Curp += this.edo_nacimiento;//
        Curp += obtenerConsonante(2,this.apPaterno.toUpperCase());
        Curp += obtenerConsonante(2,this.apMaterno.toUpperCase());
        Curp += obtenerConsonante(2,this.nombres.toUpperCase());
        Curp += generarHomoclave(2);
        System.out.println("Para " + this.nombres + " " + this.apPaterno + " " + this.apMaterno);
        System.out.println("Curp: "+Curp);
        if(this.temporal)
        {
            System.out.println("Recuerda que tu CURP es de caracter temporal y tiene una vigencia de 180 dias naturales. \nFecha de vencimiento: " + LocalDate.now().plusDays(180));
        }
        return Curp;
    }
    private String obtenerRfc(){
        String Rfc ="";
        Rfc += String.valueOf(this.apPaterno.charAt(0)).toUpperCase();
        Rfc += obtenerVocal(1,this.apPaterno.toUpperCase());
        Rfc += String.valueOf(this.apMaterno.charAt(0)).toUpperCase();
        Rfc += String.valueOf(this.nombres.charAt(0)).toUpperCase();
        Rfc = revisarPalabra(Rfc);
        if(this.anio<10){Rfc += "0" + String.valueOf(anio);}
        else{Rfc += String.valueOf(anio);}
        if(this.mes<10){Rfc += "0" + String.valueOf(mes);}
        else{Rfc += String.valueOf(mes);}
        if(this.dia<10){Rfc += "0" + String.valueOf(dia);}
        else{Rfc += String.valueOf(dia);}
        Rfc += generarHomoclave(3); 
        System.out.println("Para " + this.nombres + " " + this.apPaterno + " " + this.apMaterno);
        System.out.println("RFC: "+Rfc);
        return Rfc;
    }
    private static String obtenerVocal(int cual, String busqueda){ //Cual nos ayudara a solo buscar la primera donde se necesita y la segunda donde se necesita sin repetir
        int pos = 0,encuentros=0;
        char actual = busqueda.charAt(pos);
        while(encuentros!=cual){
            do
            {
                pos++;
                actual = busqueda.charAt(pos);
            }while (!(actual=='A'||actual=='E'||actual=='I'||actual=='O'||actual=='U'));
            encuentros++;
        }
        return actual!='Ñ' ? String.valueOf(actual):"X";
    }
    private static String obtenerConsonante(int cual, String busqueda){ 
        int pos = 0,encuentros = 1;
        char actual = busqueda.charAt(pos);
        while(encuentros!=cual){
            do
            {
                pos++;
                actual = busqueda.charAt(pos);
            }while (actual=='A'||actual=='E'||actual=='I'||actual=='O'||actual=='U');
            encuentros++;
        }
        return actual!='Ñ' ? String.valueOf(actual):"X";
    }
    private String obtenerEdo(String edo)
    {
        int i=0;
        //while(i!=32){
            if(edo.equals(this.edos[32][0])){
                edo=Extranjero().toUpperCase();
                System.out.println(this.edo_nacimiento);
            }
            while(!(edo.equals(this.edos[i][0]))&&i<32){    
                i++;//Basicamente buscaremos hasta encontrar    
            }
            
        //}
        return this.edos[i][1];
    }
    private String Extranjero(){
        int nacionalidad;
        String Edo;
        Scanner Sc = new Scanner(System.in);
        System.out.println("Para " + this.nombres + " " + this.apPaterno + " " + this.apMaterno);
        System.out.println("Cuentas con residencia mexicana? 0 para no 1 para si");
        nacionalidad = Sc.nextInt();
        if(nacionalidad == 0){
            System.out.println("Lo siento pero no puedo generar sin tu residencia mexicana");
            System.exit(0);
        }
        else{
            System.out.println("Si cuentas con residencia mexicana puedes generar tu Rfc o una constancia temporal de CURP\nIngresa el estado donde se realiza el tramite: ");
            Edo = Sc.next();
            this.temporal = true;
            return Edo;                        
        }
    }
    private String generarHomoclave(int Cuantas)
    {
        int i;
        char randomchar;
        String retorno="";
        Random random = new Random();
        for (i=0;i<Cuantas;i++){
            if(random.nextInt(2)==0){
                randomchar = (char) (random.nextInt(26)+'A'); //https://www.delftstack.com/es/howto/java/java-random-character/
                retorno += String.valueOf(randomchar);
            }
            else{
                retorno += String.valueOf(random.nextInt(10));
            }
        }
        return retorno;
    }
    private String revisarPalabra(String palabra){
        int i=0;
        String [] palabrasProhibidas = new String[10];
        palabrasProhibidas[0] = "VACA";
        palabrasProhibidas[1] = "COLA";
        palabrasProhibidas[2] = "MOTA";
        palabrasProhibidas[3] = "CACA";
        palabrasProhibidas[4] = "RATA";
        palabrasProhibidas[5] = "LOCO";
        palabrasProhibidas[6] = "COCO";
        palabrasProhibidas[7] = "MOTO";
        palabrasProhibidas[8] = "RUCA";
        palabrasProhibidas[9] = "RUCO";//PALABRAS SOLO DE EJEMPLO 
        for(i=0;i<10;i++){
            if(palabra.equals(palabrasProhibidas[i])){
                palabra = palabra.substring(0,1)+"X"+palabra.substring(2);
            }
        }
        return palabra;
    }
}
