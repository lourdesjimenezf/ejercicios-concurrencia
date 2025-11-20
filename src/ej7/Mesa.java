package ej7;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private List<Componente> componentes = new ArrayList<>(3);
	private boolean mesaVacia = true;
	private List<Componente> mesa;
	
	//la mesa empieza vacia
	public Mesa() {
		this.mesa = new ArrayList<>(2);
	}
	
	
	public boolean hayComponentes(Componente faltante) {
		if (!mesa.contains(faltante)) {
			return true;}
		return false;
	}
	
	public synchronized void ponerComponentes(Componente c1, Componente c2) {
		try {
			//si la mesa no está vacía hay que esperar
			while(!mesaVacia) {
				wait();
			} 
			//añado los dos componentes
			mesa.add(c1);
			mesa.add(c2);
			System.out.println("El estanquero pone " + c1 + " y " + c2);
			mesaVacia= false;
			//notifico a los fumadores
			notifyAll();
			
		}catch(InterruptedException e) {return;}
	}
	
	public synchronized void quitarComponentes(Componente faltante) {
		try {
			//si la mesa está vacía hay que esperar
			while(mesaVacia==true ||hayComponentes(faltante) ==false) {
				wait();
			} 
			//elimino los dos componentes
			mesa.clear();
			mesaVacia = true;
			System.out.println("El fumador " + faltante + " coge los componentes y fuma.");
			//notifico al estanquero
			notifyAll();
			
		}catch(InterruptedException e) {return;}
	}
	

}

