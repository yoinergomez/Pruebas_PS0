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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pc1
 */
public class ArchivosExcelIOTest {
    
    public ArchivosExcelIOTest() {
    }
    
    @Test
    public void existeArchivosExcelIO(){
        ArchivosExcelIO archivosExcelIO=new ArchivosExcelIO();
        assertNotNull(archivosExcelIO);
    
    }

    /**
     * Test of convertirExcelALDL method, of class ArchivosExcelIO.
     * @throws java.io.FileNotFoundException
     */
    @Test(expected=FileNotFoundException.class)
    public void testAbrirArchivoExcel() throws FileNotFoundException {
        ArchivosExcelIO archivosExcelIO=new ArchivosExcelIO();
        String nombreArchivo="prueba.txt";
        File f= archivosExcelIO.abrirArchivoExcel(nombreArchivo);
    }

    /**
     * Test of escribirEnExcel method, of class ArchivosExcelIO.
     */
    @Test
    public void testEscribirEnExcel() {

    }
    
}
