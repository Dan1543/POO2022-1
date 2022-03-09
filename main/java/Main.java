/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class Main {
    public static void main(String[] args) {
        Mexicano persona1 = new Mexicano();
        persona1.setInicial("Jesus Daniel","Gonzalez","Rocha","Baja California", 5, 2, 02, 'H');
        persona1.setCurp();
        Mexicano persona2 = new Mexicano();
        persona2.setInicial("Marco Antonio","Rosales","Villegas","Veracruz", 15, 12, 96, 'H');
        persona2.setRfc();
        Mexicano persona3 = new Mexicano();
        persona3.setInicial("Mariah","Martins","Johnson","Extranjero", 5, 11, 03, 'M');
        persona3.setRfc();
        persona3.setCurp();
        
    }
    
}
