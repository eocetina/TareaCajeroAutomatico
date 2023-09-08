package Banco;
/**
 * @author edcet 

 * @version 001
 */
	
/**
Condiciones inciales: $10,000.00 de saldo.

Opciones del cajero:
    1) Retirar dinero
    2) Hacer depósitos
    3) Consultar saldo
    4) Quejas
    5) Ver últimos movimientos
    9) Salir del cajero
    
   Dónde:

1) Retirar dinero:

   Mostrar la cantidad disponible a retirar.
   No se puede retirar más de $6,000.00
   Solo se puede retirar múltiplos de $50.00
   Una vez retirado el monto preguntar: ¿Desea donar $200 para la graduacón de ch30?

2) Hacer depósitos

   Mostrar un nuevo menú para depositar a:

       Cuenta de cheques

           Sumar la cantidad depositada al saldo disponible
           Solo depósitos múltiplos de $50
       Depósito a Tarjeta de Crédito

           Restar al saldo disponible
           Se puede incluir decimales (2 decimales, por ejemplo: $100.23)

3) Consultar saldo

   Mostrar el saldo disponible

4) Quejas

   Mostrar el mensaje: "No disponible por el momento, intente más tarde"

5) Ver últimos movimientos (Los 5 últimos)

   Mostrar los movimientos: depósitos y retiros
       Formato para mostrar
            YYYY/MM/DD hh:mm Retiro de $500
            YYYY/MM/DD hh:mm Depósito a TC de $300.12
            YYYY/MM/DD hh:mm Retiro de $300
            YYYY/MM/DD hh:mm Retiro de $100
            YYYY/MM/DD hh:mm Depósito a TC de $30.11

9) Salir del cajero

   Despide y sale del cajero.

Notas: 

   Si se pulsa una opción inválida (ej. 6, 7, 8), mostrar un mensaje similar a: "Opción inválida, por favor, vuelva a intentar".
   Si por 3 veces consecutivas se pulsa una opción inválida, se despide y se sale del sistema.
   En caso de que se pulse una opción inválida y luego se pulse una opción válida, esto no debe contar como parte de las veces consecutivas que se equivoca el usuario. 
*/

//Clase abstracta Banco 
public abstract class Banco {
 protected int ID;
 protected double balance;

 public Banco(int ID, double balance) {
     this.ID = ID;
     this.balance = balance;
 }
 
 

 public int getID() {
	return ID;
}



public void setID(int iD) {
	ID = iD;
}



public double getBalance() {
	return balance;
}



public void setBalance(double balance) {
	this.balance = balance;
}



public abstract void deposito(double cantidad);
 
 public abstract void retiro(double cantidad);
}
