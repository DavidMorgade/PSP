/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo05;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aWa
 */
public class ProcesoPadre {
    
    private int ejecutarProceso(int a, int b) {
        int resultado = -1;
        String comando = "java";
        
        ProcessBuilder pb = new ProcessBuilder(comando);
        
        //Esblezco el directorio de trabajo
        pb.directory(new File("build\\classes"));
        
        //Añado comando
        pb.command().add("ejemplo05.ProcesoHijo");
        //pb.command().add("2");
        //pb.command().add("5");
        
        try {
            Process p = pb.start();
            
            resultado = p.waitFor();
            
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ProcesoPadre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
    public static void main(String[] args) {
        //Pedir dos números
        int a,b;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Dame un numero: ");
        a = teclado.nextInt();
        
        System.out.println("Dame otro numero: ");
        b = teclado.nextInt();
        
        
        ProcesoPadre lanzador = new ProcesoPadre();
        int resultado = lanzador.ejecutarProceso(a, b);
        if(resultado == 0) {
            System.out.println("--- Ejecutado correctamente ---");
        } else {
            System.out.println("Error en la ejecución del programa");
        }
    }
}