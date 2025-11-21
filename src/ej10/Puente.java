package ej10;


import java.util.LinkedList;
import java.util.Queue;

public class Puente{
	private int pesoTotal = 0;
	private int numVehiculos = 0;
	private Queue<Boolean> esperandoAmbulancias = new LinkedList<>();
	private Queue<Boolean> esperandoCoches = new LinkedList<>();
	
	
	public synchronized void entrarPuente(int peso, boolean ambulancia) {
		try {
			while(pesoTotal + peso > 15000 || numVehiculos >= 10) {
				if(ambulancia==true) {
					esperandoAmbulancias.add(ambulancia);
					System.out.println("Ambulancia con peso " + peso + " esperando a entrar");
					wait();
				}
				else {
					esperandoCoches.add(ambulancia);
					System.out.println("Coche con peso " + peso + " esperando a entrar");
					wait();
				}
			
				
			}
			numVehiculos++;
			pesoTotal = pesoTotal + peso;
			System.out.println("El vehículo con peso " + peso + " ha entrado");
			System.out.println("Numero de vehículos en el puente: " + numVehiculos);
			System.out.println("Peso total en el puente: " + pesoTotal);
			
			//solo se quitan de la cola si estan:
			if(!esperandoAmbulancias.isEmpty()) {
				esperandoAmbulancias.remove();
				
			}
			else if(!esperandoCoches.isEmpty()){
				esperandoCoches.remove();
				
			}
			
			
		
		}catch(InterruptedException e) {return;}
		
	}
	
	public synchronized void salirPuente(int peso) {
		//Sale vehículo
		pesoTotal = pesoTotal-peso;
		numVehiculos--;
		System.out.println("Vehiculo sale con peso " + peso+ " asi que peso total = " + pesoTotal);
		//Avisa a los que están esperando para entrar
		notifyAll();
	}
}
