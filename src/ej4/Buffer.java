package ej4;


import java.util.LinkedList;
import java.util.Queue;


public class Buffer {
	//el primer dato que entra es el primer dato que sale
	Queue<Integer> miCola = new LinkedList<>();
	
	
	public Buffer(Queue<Integer> miCola) {
		this.miCola = miCola;
	}
	
	public synchronized void producir(int id) {
		try {
			//si el buffer esta lleno, esperar
			while(miCola.size() == 10) {
				wait();
			}
			//Introducen un entero generado aleatoriamente entre 0 y 10.000
			int valor = (int)(Math.random() * 10000);
			miCola.add(valor);
			System.out.println("El productor " + id + " ha producido " + valor);
			
		
		}catch(InterruptedException e) {return;}
	}
	
	public synchronized void pararProducir(int id) {
		System.out.println("El productor " + id + " ya no produce.");
		notifyAll();
		
	}
	
	
	public synchronized void consumir(int id) {
		try {
			//si el buffer esta vacio, esperar
			while(miCola.size() == 0) {
				wait();
			}
			int valor = miCola.remove();
			System.out.println("El consumidor " + id + " ha consumido " + valor);
			
		
		}catch(InterruptedException e) {return;}
	}
	
	public synchronized void pararConsumir(int id) {
		System.out.println("El consumidor " + id + " ya no consume.");
		notifyAll();
		
	}
	
	
	
	
}
