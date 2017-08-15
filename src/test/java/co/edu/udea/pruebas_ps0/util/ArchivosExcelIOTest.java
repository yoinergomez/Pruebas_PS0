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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Pc1
 */
public class ArchivosExcelIOTest {

    private ArchivosExcelIO archivosExcelIO;

    public ArchivosExcelIOTest() {
    }

    public String corregirPath(String nombreRecurso) throws URISyntaxException {
        String path = this.getClass().getClassLoader().getResource(nombreRecurso)
                .toURI().toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            return path.substring(6);
        }
        return path.substring(5);
    }

    @Before
    public void inicializar() {
        archivosExcelIO = new ArchivosExcelIO();
    }

    /**
     *
     */
    @Test
    public void testExisteArchivosExcelIO() {
        assertNotNull(archivosExcelIO);

    }

    /**
     * Test of testAbrirArchivoInexistente method, of class ArchivosExcelIO.
     *
     * @throws java.io.FileNotFoundException
     * @throws co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0
     * @throws java.net.URISyntaxException
     */
    @Test(expected = FileNotFoundException.class)
    public void testAbrirArchivoInexistente() throws
            ValidacionPS0, URISyntaxException, FileNotFoundException {
        String path = "esteArchivoNoExiste.xls";
        archivosExcelIO.encontrarArchivo(path);
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
        String path = corregirPath("prueba.xls");
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
    public void testAbrirArchivosExcel() throws FileNotFoundException,
            ValidacionPS0, URISyntaxException {
        String path = corregirPath("prueba.xls");
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
    @Test(expected = ValidacionPS0.class)
    public void testAbrirArchivoDistintoExcel() throws FileNotFoundException,
            ValidacionPS0, URISyntaxException {
        String path = corregirPath("prueba.txt");
        archivosExcelIO.encontrarArchivo(path);
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
        String path = corregirPath("prueba.xls");
        File f = archivosExcelIO.encontrarArchivo(path);
        Workbook w = archivosExcelIO.abrirLibroExcel(f);
        assertNotNull(w);
    }

    @Test
    public void testLeerPrimeraCelda() throws URISyntaxException, ValidacionPS0,
            IOException {
        String path = corregirPath("prueba.xls");
        archivosExcelIO.convertirExcelALDL(path);
        LDL lista = archivosExcelIO.getListaColumnas().get(0);
        assertNotNull(lista.getPrimerNodo());
    }

    @Test
    public void testLeerPrimerCeldaVacia() throws URISyntaxException, ValidacionPS0,
            IOException {
        String path = corregirPath("pruebaVacio.xls");
        archivosExcelIO.convertirExcelALDL(path);
        LDL lista = archivosExcelIO.getListaColumnas().get(0);
        assertNull(lista.getPrimerNodo());
    }

    @Test
    public void testLeerPrimerColumna() throws URISyntaxException, ValidacionPS0,
            IOException {
        String path = corregirPath("prueba.xls");
        archivosExcelIO.convertirExcelALDL(path);
        LDL lista = archivosExcelIO.getListaColumnas().get(0);
        assertEquals(4, lista.length());
    }

    @Test(expected = ValidacionPS0.class)
    public void testLeerArchivoCorrupto() throws URISyntaxException, ValidacionPS0,
            IOException {
        String path = corregirPath("pruebaCaracter.xls");
        archivosExcelIO.convertirExcelALDL(path);
    }

    @Test
    public void testCopiarMediaAExcel() throws URISyntaxException, IOException {
        LDL lista = new LDL();
        NodoDoble nodo;
        for (int i = 1; i <= 10; i++) {
            nodo = new NodoDoble(new Double(Integer.toString(i)));
            lista.insertar(nodo);
        }
        ArrayList<LDL> variables = new ArrayList();
        variables.add(lista);
        File f = archivosExcelIO.generarResultados(variables);
        assertTrue(f.exists());

    }

    @Test
    public void testCopiarMediayDesviacionAExcel() throws URISyntaxException,
            IOException {
        LDL lista = new LDL();
        NodoDoble nodo;
        for (int i = 1; i <= 10; i++) {
            nodo = new NodoDoble(new Double(Integer.toString(i)));
            lista.insertar(nodo);
        }
        ArrayList<LDL> variables = new ArrayList();
        variables.add(lista);
        File f = archivosExcelIO.generarResultados(variables);
        assertTrue(f.exists());
    }

}
