package ej7;

public class Concurrencia {

	public static void main(String[] args) {
		Mesa mesa = new Mesa();
		Fumador fumador1 = new Fumador(Componente.TABACO, mesa);
		Fumador fumador2 = new Fumador(Componente.PAPEL,mesa);
		Fumador fumador3 = new Fumador(Componente.CERILLA,mesa);
		
		Estanquero estanquero = new Estanquero(mesa);
		
		fumador1.start();
		fumador2.start();
		fumador3.start();
		estanquero.start();
		

	}

}
