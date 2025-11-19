package ej2;

public class RecursoCompartido2 {
	private int valor;
	private int numLectores = 0;
	private boolean hayEscritores = false;
	
	public RecursoCompartido2(int valor) {
		this.valor = valor;
		
	}
	
	public synchronized void leer(int id) {
		try {
			while(hayEscritores) {
				wait();
				
			}
			numLectores++;
			System.out.println("El lector " + id + " está leyendo el valor " + valor);
		}catch(InterruptedException e){ return;} 
	}
	
	public synchronized void pararLeer(int id) {
		numLectores--;
		System.out.println("El lector " + id + " ya no está leyendo");
		if (numLectores == 0) {
			notifyAll();
		}
	}

	//???
	public synchronized void escribir(int id, int valor) {
		try {
			while(hayEscritores || numLectores !=0) {
				wait();
			}
			hayEscritores = true;
			this.valor =(int)(Math.random() * 10000);
			System.out.println("El escritor " + id + " está escribiendo el valor " + this.valor);

		}catch(InterruptedException e){ return;} 
		
	}
	
	
	public synchronized void pararEscribir(int id) {
		hayEscritores = false;
		System.out.println("El escritor " + id + " ya no está escribiendo");
		notifyAll();
		
	}
}
