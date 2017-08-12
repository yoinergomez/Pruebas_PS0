/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util.excepcion;

/**
 *
 * @author Jhonatan Orozco Blandón
 */
public class ValidacionPS0 extends Exception {
    
    public ValidacionPS0() {
		super();
		
	}

	public ValidacionPS0(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public ValidacionPS0(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ValidacionPS0(String arg0) {
		super(arg0);
		
	}

	public ValidacionPS0(Throwable arg0) {
		super(arg0);
		
	}

}
