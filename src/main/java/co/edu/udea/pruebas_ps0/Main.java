/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.util.ArchivosExcelIO;
import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Es la clase principal que se encarga de ejecutar el proyecto.
 *
 * @author Yoiner Gómez - yoiner.gomez22@gmail.com
 * @date 2017/08/11
 * @version v1
 */
public class Main {

    public static void main(String[] args) throws IOException, ValidacionPS0, URISyntaxException {
        ArchivosExcelIO archivo = new ArchivosExcelIO();

        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Introduce el path del archivo de excel.");
            System.out.println("ejemplo: C:\\Users\\Laptop\\Downloads\\archivo.xls: ");
            System.out.println("path: ");
            
            String path = br.readLine();
            archivo.convertirExcelALDL(path);
            ArrayList<LDL> variables = archivo.getListaColumnas();

            File f = archivo.generarResultados(variables);
            System.out.println("Revise los resultados en la ruta:" + f.getAbsolutePath());
            
            isr.close();
            br.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } 
    }

}
