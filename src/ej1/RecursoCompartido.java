package ej1;

public class RecursoCompartido {
	private int numLectores = 0;
	boolean hayEscritores = false;
	private int valor = 25;
	
	public RecursoCompartido(int valor) {
		this.valor = valor;
	}
	

	
	public synchronized void leer(int id) {
		try {
			//Si hay un escritor esperas, no puedes leer
			while(hayEscritores) {
				wait();
			}
			numLectores++;
			System.out.println("El lector " + id + " está leyendo el valor " + valor);
		}catch (InterruptedException e) { return;} //Cuando hay un wait tenemos que manejar la excepcion, si no da error
	}
	
	public synchronized void pararLeer(int id) {
		System.out.println("El lector " + id + " deja de leer el valor " + valor);
		numLectores--;
		//Si no hay lectores, notifico al escritor que este esperando (los lectores no esperan)
		if (numLectores == 0) {
			notifyAll();
		}
		
	}
	
	public synchronized void escribir(int id) {
		try {
			//Si hay un escritor o lector esperas, no puedes escribir ni leer
			while(hayEscritores || numLectores != 0) {
				wait();
			}
			hayEscritores = true;
			valor = (int)(Math.random() * 10000);
			System.out.println("El escritor " + id + " está escribiendo el valor " + valor);
		}catch (InterruptedException e) { return;} //Cuando hay un wait tenemos que manejar la excepcion, si no da error
	}
		
	public synchronized void pararEscribir(int id) {
		System.out.println("El escritor " + id + " deja de escribir");
		hayEscritores = false;
		//Cuando sale un escritor todo el mundo puede entrar
		notifyAll();
		
	}

}
