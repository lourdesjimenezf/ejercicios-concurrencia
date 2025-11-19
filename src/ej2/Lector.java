package ej2;

public class Lector extends Thread{
	private int id;
	private RecursoCompartido1 recurso1;
	private RecursoCompartido2 recurso2;
	
	public Lector(int id, RecursoCompartido1 recurso1, RecursoCompartido2 recurso2) {
		this.id = id;
		this.recurso1 = recurso1;
		this.recurso2 = recurso2;
	}
	
	public void run() {
		
		try {
			double numAleatorio = Math.random();
			if(numAleatorio == 0.0) {
				recurso1.leer(id);
				sleep(1000);
				recurso1.pararLeer(id);
				
				recurso2.leer(id);
				sleep(1000);
				recurso2.pararLeer(id);
				
			}
			else {
				recurso2.leer(id);
				sleep(1000);
				recurso2.pararLeer(id);
				
				recurso1.leer(id);
				sleep(1000);
				recurso1.pararLeer(id);
				
			}
		}catch(InterruptedException e) {return;}
	}
		
	
}
