package Banco;
import java.util.ArrayList;
public class Atm {
	final double maxWithdraw= 6000.00;
	final double minWithdaw= 50.00;
    private double balance;
    private int serialNumber;
    private ArrayList<String> log = new ArrayList<>();
    
    public Atm(int serialNumber) {
        this.serialNumber = serialNumber;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
    
    public ArrayList<String> getLog() {
        return log;
    }


    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La cantidad del depósito no puede ser negativa");
        }
        balance += amount;
        log.add("Depósito: " + amount); // agregamos la transaccion al log
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La cantidad a retirar no puede ser negativa");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("No hay suficientes fondos para realizar el retiro");
        }

        balance -= amount;
    }

    public static void main(String[] args) {
        // Ejemplo de uso de la clase Atm
        Atm cajero = new Atm(12345);
        
        // Depositar 500
        cajero.deposit(500.0);
        
        // Intentar retirar 600 (debería lanzar una excepción)
        try {
            cajero.withdraw(600.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Retirar 200
        cajero.withdraw(200.0);
        
        // Verificar el saldo actual
        System.out.println("Saldo actual: " + cajero.getBalance());
    } // Main end
} //class End