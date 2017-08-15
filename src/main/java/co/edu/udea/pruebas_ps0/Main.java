/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.util.ArchivosExcelIO;
import co.edu.udea.pruebas_ps0.util.estadistica.MedidasEstadisticas;
import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Es la clase principal que se encarga de ejecutar el proyecto.
 * @author Yoiner Gómez - yoiner.gomez22@gmail.com
 * @date 2017/08/11
 * @version v1
 */
public class Main {
    
    public static void main(String[] args){
        
     ArchivosExcelIO archivo = new ArchivosExcelIO();
     MedidasEstadisticas medidas = new MedidasEstadisticas();
        try {
            archivo.convertirExcelALDL(args[0]);
            ArrayList<LDL> variables = archivo.getListaColumnas();
            
            /**for (int i = 0; i < tamano; i++) {
                System.out.println("Table 1: Column ["+i+"] \t\t Mean:"
                        +medidas.calcularMedia(objetos.get(i))+
                        "\t\t Std. Dev:"+
                        medidas.calcularDesviacionEstandar(objetos.get(i)));
            }**/
            File f=archivo.generarResultados(variables);
            System.out.println("Revise los resultados en la ruta:"+ f.getAbsolutePath());
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
             System.out.println(e.getMessage());
        } catch (ValidacionPS0 | URISyntaxException e) {
             System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException a){
            throw new ArrayIndexOutOfBoundsException("Debe ingresar la ruta del archivo.");
        }
    }
    
}
