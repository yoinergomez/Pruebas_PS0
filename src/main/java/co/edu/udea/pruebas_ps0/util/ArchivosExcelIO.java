/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Jhonatan Orozco Blandón
 */
public class ArchivosExcelIO {
    

    private Sheet sheet;
    private Workbook workbook;

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }
    

    public File convertirExcelALDL(String nombreArchivo) throws FileNotFoundException, 
            ValidacionPS0, IOException {
        File f = abrirArchivoExcel(nombreArchivo);
        InputStream in = new FileInputStream(f);
        workbook = new HSSFWorkbook(in);
        sheet = workbook.getSheetAt(0);      
        return null;
    }
    
    

    public File abrirArchivoExcel(String nombreArchivo) throws FileNotFoundException, 
            ValidacionPS0 {
        File f = null;
        String extArchivo;
        f = new File(nombreArchivo);
        if (!f.exists()) {
            throw new FileNotFoundException("El archivo no existe");
        }
        extArchivo = FilenameUtils.getExtension(f.getName());
        if ("xls".compareTo(extArchivo) != 0) {
            throw new ValidacionPS0("La extensión es inválida");
        }
        return f;
    }

    public void escribirEnExcel() {

    }

}
