/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.ldl.NodoDoble;
import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Jhonatan Orozco Blandón
 */
public class ArchivosExcelIO {
    

    private Sheet sheet;
    private Workbook workbook;
    private LDL lista;


    public Workbook getWorkbook() {
        return workbook;
    }

    public LDL convertirExcelALDL(String nombreArchivo) throws FileNotFoundException, 
        ValidacionPS0,IOException {
        File f = encontrarArchivo(nombreArchivo);
        Double numero;
        workbook= abrirLibroExcel(f);
        sheet = workbook.getSheetAt(0);     
        Row row=sheet.getRow(0);
        Cell cell=row.getCell(1);
        numero= cell.getNumericCellValue();
        lista=new LDL();
        NodoDoble nodo=new NodoDoble(numero);
        lista.insertar(nodo);
        return lista;
    }
    
    
    

    public File encontrarArchivo(String nombreArchivo) throws FileNotFoundException, 
            ValidacionPS0{
        File f;
        InputStream in;
        String extArchivo;
        Workbook w;
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

    
    public Workbook abrirLibroExcel(File f) throws FileNotFoundException, 
            IOException {
        InputStream in;
        in=new FileInputStream (f);
        Workbook w=new HSSFWorkbook(in);
        return w;
    }

}
