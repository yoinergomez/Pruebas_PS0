/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0;

import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frank
 */
public class MainTest {
    
    public MainTest() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        String[] args = {"src\\main\\resources\\prueba.xls"};
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
