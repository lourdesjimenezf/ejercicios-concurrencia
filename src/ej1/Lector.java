package ej1;

public class Lector extends Thread{
	
	private RecursoCompartido recurso;
	private int id;
	
	public Lector(RecursoCompartido recurso, int id) {
		this.recurso = recurso;
		this.id = id;
		
	}
	public void run() {
		while(true) { //SE EJECUTA SIEMPRE
			try {
				recurso.leer(id);
				sleep(1000);
				//LEE EL RECURSO
				recurso.pararLeer(id);
				sleep(1000);
			}catch(InterruptedException e) { return;}
		}
	}

}
