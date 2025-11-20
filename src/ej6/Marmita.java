package ej6;

public class Marmita {
	private int raciones;
	private boolean hayMarmita = true; //Empezamos con marmita
	private boolean avisarCocinero = false;
	private int capacidad;
	
	public Marmita(int capacidad) {
		this.capacidad = capacidad;
		this.raciones = capacidad;
	}
	
	
	public synchronized void comer(int id) {
		try {
			//Si la marmita está vacia aviso al cocinero y espero
			while(!hayMarmita) {
				raciones = 0;
				//si no se ha avisado
				if(!avisarCocinero) {
					avisarCocinero = true;
					System.out.println("La marmita está vacía, avisa cocinero");
					//este notify solo despierta al cocinero
					notifyAll();
				}
				wait();
			}
			raciones--;
			System.out.println("El canibal " + id + " ha comido una ración.");
			if (raciones == 0) {
				hayMarmita = false;
			}
		}catch(InterruptedException e) {return;}
	}
	
	
	public synchronized void rellenar() {
		try {
			System.out.println("El cocinero ha rellenado la marmita");
			raciones = capacidad;
			hayMarmita = true;
			avisarCocinero = false;
			notifyAll();
			wait();
		}catch(InterruptedException e) {return;}
	}

}
