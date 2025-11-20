package ej6;


public class concurrencia {

	public static void main(String[] args) {
		int capacidad = 10;
		Marmita marmita = new Marmita(capacidad);
		Canibal[] canibales = new Canibal[5];
		Cocinero cocinero = new Cocinero(marmita);
		
		for (int i = 0; i<canibales.length; i++) {
			canibales[i] = new Canibal(i, marmita);
		}
		
		for (int i = 0; i<canibales.length; i++) {
			canibales[i].start();
		}
		cocinero.start();
		

	}

}
