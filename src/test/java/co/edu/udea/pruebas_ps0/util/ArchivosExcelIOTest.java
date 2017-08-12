/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Workbook;
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
     * @throws co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0
     */
    @Test(expected = FileNotFoundException.class)
    public void testAbrirArchivoInexistente() throws FileNotFoundException, ValidacionPS0 {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String nombreArchivo = "prueba2.txt";
        File f = archivosExcelIO.encontrarArchivo(nombreArchivo);
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testAbrirArchivoExistente() throws FileNotFoundException,
            ValidacionPS0, URISyntaxException {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.xls")
                .toURI().toString();

        path = path.substring(5);
        File f = archivosExcelIO.encontrarArchivo(path);
        assertTrue(f.exists());
    }

    /**
     * Test of escribirEnExcel method, of class ArchivosExcelIO.
     *
     * @throws java.io.FileNotFoundException
     * @throws co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testAbrirArchivosExcel() throws FileNotFoundException, ValidacionPS0,
            URISyntaxException {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.xls")
                .toURI().toString();

        path = path.substring(5);
        File f = archivosExcelIO.encontrarArchivo(path);
        String ext = FilenameUtils.getExtension(f.getName());
        assertArrayEquals("xls".toCharArray(), ext.toCharArray());
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0
     * @throws java.net.URISyntaxException
     */
    @Test(expected = Exception.class)
    public void testAbrirArchivoDistintoExcel() throws FileNotFoundException,
            ValidacionPS0, URISyntaxException {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.txt")
                .toURI().toString();

        path = path.substring(5);
        File f = archivosExcelIO.encontrarArchivo(path);
    }

    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ValidacionPS0
     * @throws URISyntaxException
     */
    @Test
    public void testAbrirLibroExcel() throws FileNotFoundException, IOException,
            ValidacionPS0, URISyntaxException {
        ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.xls")
                .toURI().toString();
        path = path.substring(5);
        File f=archivosExcelIO.encontrarArchivo(path);
        Workbook w= archivosExcelIO.abrirLibroExcel(f);
        assertNotNull(w);

    }
    
    @Test
    public void testLeerPrimeraCelda() throws URISyntaxException, ValidacionPS0,
            IOException{
         ArchivosExcelIO archivosExcelIO = new ArchivosExcelIO();
        String path = this.getClass().getClassLoader().getResource("prueba.xls")
                .toURI().toString();
        path = path.substring(5);
        LDL lista=archivosExcelIO.convertirExcelALDL(path);
        assertNotNull(lista.getPrimerNodo());
        
    }

}
