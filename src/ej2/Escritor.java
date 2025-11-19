package ej2;

public class Escritor extends Thread{
	private int id;
	private RecursoCompartido1 recurso1;
	private RecursoCompartido2 recurso2;
	
	public Escritor(int id, RecursoCompartido1 recurso1, RecursoCompartido2 recurso2) {
		this.id = id;
		this.recurso1 = recurso1;
		this.recurso2 = recurso2;
	}
	
	public void run() {
		try {
			double numAleatorio = Math.random();
			if(numAleatorio ==0.0) {
				recurso1.escribir(id, 30);
				sleep(1000);
				recurso1.pararEscribir(id);
			}
			else {
				recurso2.escribir(id, 40);
				sleep(1000);
				recurso2.pararEscribir(id);
			}
		}	catch(InterruptedException e) {return;}
	}
}
