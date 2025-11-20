package ej7;

import java.util.Random;

public class Estanquero extends Thread{
	
	private Mesa mesa;
	
	public Estanquero(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public void run() {
		Componente[] todos = Componente.values(); //Creo un array con tabaco, papel y cerilla
		try {
			while(true) {
				//componente que falta
				Random random = new Random();
				int indice = random.nextInt(3);
				
				Componente c1 = todos[(indice +1)%3];
				Componente c2 = todos[(indice +2)%3];
				
				mesa.ponerComponentes(c1, c2);
				sleep(1000);
			}
		}catch(InterruptedException e) {return;}
		
	}
}
