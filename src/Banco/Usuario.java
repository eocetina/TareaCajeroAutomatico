package Banco;

/**
 * @author edcet 

 * @version 001
 */ 

//Clase Usuario
public class Usuario extends Banco {
 public Usuario(int ID) {
     super(ID,0); // El usuario siempre tiene un saldo inicial de 0
 }
 
 

 @Override
 public void deposito(double cantidad) {
     if (cantidad > 0) {
         this.balance += cantidad;
         System.out.println("Depósito de $" + cantidad + " realizado. Nuevo saldo: $" + this.balance);
     } else {
         System.out.println("El monto del depósito debe ser mayor que 0.");
     }
 }

 @Override
 public void retiro(double cantidad) {
     if (cantidad > 0 && cantidad <= this.balance) {
         this.balance -= cantidad;
         System.out.println("Retiro de $" + cantidad + " realizado. Nuevo saldo: $" + this.balance);
     } else {
         System.out.println("El monto del retiro es inválido o insuficiente.");
     }
 }
 
 
}
