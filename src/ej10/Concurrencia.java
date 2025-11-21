package ej10;

public class Concurrencia {

	public static void main(String[] args) {
		Vehiculo[] vehiculos = new Vehiculo[15];
		Puente puente = new Puente();
		
		for(int i = 0; i<vehiculos.length;i++) {
			//genera un numero aleatorio entre 1000 y 5000
			//int valor = (int) (Math.random() * 4001) +1000;
			//entre 10 y 50
			int valor = (int) (Math.random()*41)+10;
			
			
			if(valor>=8000) {
				vehiculos[i] = new Vehiculo(valor, true, puente);
			}
			else {
				vehiculos[i] = new Vehiculo(valor, false, puente);
			}
			
		}
		
		for(int i = 0; i<vehiculos.length;i++) {
			vehiculos[i].start();
		}

	}

}
