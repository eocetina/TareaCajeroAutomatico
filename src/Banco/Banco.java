package Banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Atm> cajeros;

	public Banco() {
		this.cajeros = new ArrayList<>();
	}

	public void agregarCajero(Atm cajero) {
		cajeros.add(cajero);
	}

	public List<Atm> getCajeros() {
		return cajeros;
	}

	public static void main(String[] args) {
		Banco miBanco = new Banco();

		Atm cajero1 = new Atm(12345);
		Atm cajero2 = new Atm(67890);

		miBanco.agregarCajero(cajero1);
		miBanco.agregarCajero(cajero2);

		// Acceder a la lista de cajeros del banco
		List<Atm> listaCajeros = miBanco.getCajeros();

		// Realizar operaciones en los cajeros
		for (Atm cajero : listaCajeros) {
			cajero.deposit(1000.0);
			cajero.deposit(500);
			cajero.deposit(60);
			//cajero.deposit(-1.1);
			cajero.deposit(3.45);
			System.out.println("Saldo en el cajero del banco (" + cajero.getSerialNumber() + "): " + cajero.getBalance());
		}
		
		// obtener los logs de cada cajero
				for (Atm cajero : listaCajeros) {
					atmTransactionLog(cajero);
					}
		
	}

	static void atmTransactionLog(Atm cajero ) {

		ArrayList<String> log = cajero.getLog();

		System.out.println("Registro de operaciones:");
		for (String entry : log) {
			System.out.println(entry);
		}
	}

}


