package Banco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * @author edcet
 * 
 * @version 001
 */
//Clase ATM
public class ATM extends Banco {
	private List<String> registroTransacciones; // Registro de transacciones

	public ATM(int ID) {
		super(ID, 10000); // El ATM siempre tiene un saldo inicial de $10,000
		registroTransacciones = new ArrayList<>();
	}
	
	

	public List<String> getRegistroTransacciones() {
		return registroTransacciones;
	}



	public void setRegistroTransacciones(List<String> registroTransacciones) {
		this.registroTransacciones = registroTransacciones;
	}



	@Override
	public void deposito(double cantidad) {
		if (cantidad > 0) {
			this.balance += cantidad;
			registrarTransaccion("Depósito", cantidad);
			System.out.println("Depósito de $" + cantidad + " realizado. Nuevo saldo: $" + this.balance);
		} else {
			System.out.println("El monto del depósito debe ser mayor que 0.");
		}
	}

	@Override
	public void retiro(double cantidad) {
		if (cantidad > 0 && cantidad <= this.balance) {
			this.balance -= cantidad;
			registrarTransaccion("Retiro", cantidad);
			System.out.println("Retiro de $" + cantidad + " realizado. Nuevo saldo: $" + this.balance);
		} else {
			System.out.println("El monto del retiro es inválido o insuficiente.");
		}
	}

	public void registrarTransaccion(String tipoTransaccion, double cantidad) {
		Date fechaHoraActual = new Date();
		SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String registro = formatoFechaHora.format(fechaHoraActual) + " - " + tipoTransaccion + ": $" + cantidad;
		registroTransacciones.add(registro);
	}

	public void mostrarRegistroTransacciones() {
		System.out.println("Registro de Transacciones:");
		for (String transaccion : registroTransacciones) {
			System.out.println(transaccion);
		}
	}
}
