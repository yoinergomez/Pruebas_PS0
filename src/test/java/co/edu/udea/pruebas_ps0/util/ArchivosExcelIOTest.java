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
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Sheet;
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

    /**
     *
     */
    @Test
    public void testExisteArchivosExcelIO() {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        assertNotNull(archivosExcelIO);

    }

    /**
     * Test of testAbrirArchivoInexistente method, of class ArchivosExcelIO.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test(expected = FileNotFoundException.class)
    public void testAbrirArchivoInexistente() throws FileNotFoundException, Exception {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String nombreArchivo = "prueba2.txt";
        File f = archivosExcelIO.abrirArchivoExcel(nombreArchivo);
    }

    /**
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testAbrirArchivoExistente() throws FileNotFoundException, Exception {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.xls")
                .toURI().toString();

        path=path.substring(6);
        File f = archivosExcelIO.abrirArchivoExcel(path);
        assertTrue(f.exists());
    }

    /**
     * Test of escribirEnExcel method, of class ArchivosExcelIO.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testAbrirArchivosExcel() throws FileNotFoundException, Exception {
         ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.xls")
                .toURI().toString();

        path=path.substring(6);
        File f = archivosExcelIO.abrirArchivoExcel(path);
        String ext = FilenameUtils.getExtension(f.getName());
        assertArrayEquals("xls".toCharArray(), ext.toCharArray());
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testAbrirArchivoDistintoExcel() throws FileNotFoundException, Exception {
      ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.txt")
                .toURI().toString();

        path=path.substring(6);
        File f = archivosExcelIO.abrirArchivoExcel(path);
    }

    @Test
    public void testobtenerHojaExcel() throws FileNotFoundException, Exception {
//        ArchivosExcelIO archivosExcelIO=new ArchivosExcelIO();
//        String nombreArchivo="C:/Users/Pc1/Desktop1/prueba.xls";
//        archivosExcelIO.convertirExcelALDL(nombreArchivo);
//        Sheet sheet= archivosExcelIO.

    }

}
