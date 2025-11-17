package ej1;

public class Escritor extends Thread{
	private RecursoCompartido recurso;
	private int id;
	
	public Escritor(RecursoCompartido recurso, int id) {
		this.recurso = recurso;
		this.id = id;
		
	}
	public void run() {
		while(true) {
			try {
				recurso.escribir(id);
				sleep(1000);
				//ESCRIBE LO QUE SEA
				recurso.pararEscribir(id);
				sleep(1000);
			}catch(InterruptedException e) { return;}
		}
	}

}
