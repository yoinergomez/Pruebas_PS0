/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0;

import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

/**
 *
 * @author Frank
 */
public class MainTest {

    public MainTest() {
    }

    public String corregirPath(String nombreRecurso) throws URISyntaxException {
        String path = this.getClass().getClassLoader().getResource(nombreRecurso)
                .toURI().toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            return path.substring(6);
        }
        return path.substring(5);
    }

    /**
     * Test of main method, of class Main.
     *
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testMain() throws URISyntaxException, IOException, ValidacionPS0 {
        String data = corregirPath("prueba.xls");
        String[] args = null;
        final InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Main.main(args);
        System.setIn(original);
    }

    @Test
    public void testMainClass() {
        Main m = new Main();
    }

//    @Test(expected = NoSuchElementException.class)
//    public void testMainVoidFile() {
//        String data = " ";
//        String[] args = null;
//        final InputStream original = System.in;
//        System.setIn(new ByteArrayInputStream(data.getBytes()));
//        Main.main(args);
//        System.setIn(original);
//    }
}
