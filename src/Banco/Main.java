/**
 * 
 */
package Banco;

/**
 * 
 */
public class Main {

	 public static void main(String[] args) {
	        ATM atm = new ATM(12345); // Cambia el número de identificación (ID) según sea necesario
	        ControladorATM controlador = new ControladorATM(atm);
	        
	        controlador.menuInicial( controlador.nuevoUsuario());
	        
	        
	   
	    }
}
