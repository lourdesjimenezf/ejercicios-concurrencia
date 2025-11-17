package ej1;

public class concurrencia {

	public static void main(String[] args) {
		int valor = 25;
		RecursoCompartido recurso = new RecursoCompartido(valor);
		
		
		Lector[] lectores = new Lector[3];
		Escritor[] escritores = new Escritor[2];
		
		for (int i = 0; i<lectores.length; i++) {
			lectores[i] = new Lector(recurso, i);
		}
		for (int i = 0; i<escritores.length; i++) {
			escritores[i] = new Escritor(recurso, i);
		}
		for (int i = 0; i<lectores.length; i++) {
			lectores[i].start();
		}
		for (int i = 0; i<escritores.length; i++) {
			escritores[i].start();
		}

	}

}
