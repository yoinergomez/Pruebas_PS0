/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0;


import java.net.URISyntaxException;
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
     * @throws java.net.URISyntaxException
     */
    @Test
    public void testMain() throws URISyntaxException {
        String path = 
                corregirPath("pruebaDatosPractica.xls");
        String[] args = {path};
        Main.main(args);
    }
    
    @Test
    public void testMainClass() {
        Main m = new Main();
    }
    
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testMainVoidFile() {
        String[] args = {};
        Main.main(args);
    }
    @Test
    public void testMainAlotString() {
        String[] args = {"asdasd","asdasd","asdasd", null};
        Main.main(args);
    }
    
}
