package Banco;
import java.util.Scanner;
public class ControladorATM {
	private ATM atm;

    public ControladorATM(ATM atm) {
        this.atm = atm;
    }

    public void menuInicial(Usuario user) {
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			    System.out.println("Opciones del cajero:");
			    System.out.println("1) Retirar dinero");
			    System.out.println("2) Hacer depósitos");
			    System.out.println("3) Consultar saldo");
			    System.out.println("4) Quejas");
			    System.out.println("5) Ver últimos movimientos");
			    System.out.println("9) Salir del cajero");

			    System.out.print("Por favor, seleccione una opción: ");
			    int opcion = scanner.nextInt();

			    switch (opcion) {
			        case 1:
			            realizarRetiro(user);
			            break;
			        case 2:
			            realizarDeposito(user);
			            break;
			        case 3:
			            consultarSaldo(user);
			            break;
			        case 4:
			            mostrarQuejas();
			            break;
			        case 5:
			            mostrarUltimosMovimientos();
			            break;
			        case 9:
			            System.out.println("Gracias por utilizar nuestro cajero. ¡Hasta luego!");
			            return;
			        default:
			            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			    }
			}
		}
    }

    private void realizarRetiro(Usuario user) {
        try (Scanner scanner = new Scanner(System.in)) {
			double disponibleATM = atm.getBalance();
			double disponibleUsuario = user.getBalance();

			System.out.println("Cantidad disponible a retirar del ATM: $" + disponibleATM);
			System.out.println("Cantidad disponible a retirar del Usuario: $" + disponibleUsuario);
			System.out.print("Ingrese la cantidad a retirar (múltiplos de $50.00, no más de $6,000.00): $");
			double cantidad = scanner.nextDouble();
			
			if(disponibleATM>0&&disponibleUsuario>0) { // validacion de tener saldo suficiente
				  if (cantidad <= 0 || cantidad > 6000 || cantidad % 50 != 0) { //validacion de terminaciones
			          System.out.println("Cantidad de retiro no válida.");
			          return;
			      }
				 

				  atm.registrarTransaccion("retiro",cantidad);
			      atm.retiro(cantidad);

			      System.out.print("¿Desea donar $200 para la graduación de ch30? (Sí/No): ");
			      String donacion = scanner.next();

			      if (donacion.equalsIgnoreCase("Si")) {
			          atm.deposito(200);
			          user.retiro(200); 
			          System.out.println("¡Gracias por su donación para la graduación de ch30!");
			      }
			}
		}
       
    }

    private void realizarDeposito(Usuario user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de cuenta para depositar:");
        System.out.println("1) Cuenta de cheques");
        System.out.println("2) Depósito a Tarjeta de Crédito");
        int tipoCuenta = scanner.nextInt();

        if (tipoCuenta != 1 && tipoCuenta != 2) {
            System.out.println("Opción no válida.");
            return;
        }

        System.out.print("Ingrese la cantidad a depositar: $");
        double cantidad = scanner.nextDouble();

        if (cantidad <= 0 || (tipoCuenta == 1 && cantidad % 50 != 0)) {
            System.out.println("Cantidad de depósito no válida.");
            return;
        }
        atm.deposito(cantidad);
        
        if (tipoCuenta == 1) {
            atm.registrarTransaccion("Deposito a cheque ", cantidad);
            user.deposito(cantidad);
            System.out.println("Depósito a cuenta de cheques realizado.");
        } else {
            System.out.println("Depósito a tarjeta de crédito realizado.");
            atm.registrarTransaccion("Deposito a TDC ", cantidad);
        }
    }

    private void consultarSaldo(Usuario user) {
        double saldo = user.getBalance();
        System.out.println("Saldo disponible del Usuario: $" + saldo);
    }

    private void mostrarQuejas() {
        System.out.println("No disponible por el momento, intente más tarde.");
    }

    private void mostrarUltimosMovimientos() {
        atm.mostrarRegistroTransacciones();
    }

    public Usuario nuevoUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de cuenta del nuevo usuario: ");
        int numeroCuenta = scanner.nextInt();

        // Crear una nueva instancia de Usuario con el número de cuenta
        Usuario nuevoUsuario = new Usuario(numeroCuenta);
        System.out.println("Nuevo usuario verificado con éxito.");
    return nuevoUsuario;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(12345); // Cambia el número de identificación (ID) según sea necesario
        ControladorATM controlador = new ControladorATM(atm);
      
        // Resto de la lógica del cajero
        controlador.menuInicial( controlador.nuevoUsuario());
    }
}