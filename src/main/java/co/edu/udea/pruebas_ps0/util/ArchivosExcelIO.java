/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jhonatan Orozco Blandón
 */
public class ArchivosExcelIO {
    
    public File convertirExcelALDL(String nombreArchivo){
        return null;
    }
    
    public File abrirArchivoExcel(String nombreArchivo) throws FileNotFoundException{
        File f=null;
        f =new File(nombreArchivo);
        if(!f.exists()){
            throw new  FileNotFoundException("El archivo no existe");
        }
        return f;
        
        
    }
    public void escribirEnExcel(){
        
    }
    
    
    
}
