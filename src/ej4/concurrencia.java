package ej4;

import java.util.LinkedList;
import java.util.Queue;

public class concurrencia {
	public static void main(String[] args) {
		Queue<Integer> miCola = new LinkedList<>();
		for(int i =0; i<miCola.size();i++) {
			miCola.add(i);
			
		}
		Buffer recurso = new Buffer(miCola);
		
		
		Productor[] productores = new Productor[3];
		Consumidor[] consumidores = new Consumidor[5];
		
		for (int i = 0; i<productores.length; i++) {
			productores[i] = new Productor(i, recurso);
		}
		for (int i = 0; i<consumidores.length; i++) {
			consumidores[i] = new Consumidor(i, recurso);
		}
		for (int i = 0; i<productores.length; i++) {
			productores[i].start();
		}
		for (int i = 0; i<consumidores.length; i++) {
			consumidores[i].start();
		}

	}
}
