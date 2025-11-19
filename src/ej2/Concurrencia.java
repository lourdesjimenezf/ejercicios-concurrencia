package ej2;



public class Concurrencia {

	public static void main(String[] args) {
		RecursoCompartido1 recurso1 = new RecursoCompartido1(30);
		RecursoCompartido2 recurso2 = new RecursoCompartido2(40);
		
		
		Lector[] lectores = new Lector[5];
		Escritor[] escritores = new Escritor[2];
		
		for (int i = 0; i<lectores.length; i++) {
			lectores[i] = new Lector(i, recurso1, recurso2);
		}
		for (int i = 0; i<escritores.length; i++) {
			escritores[i] = new Escritor(i, recurso1,recurso2);
		}
		for (int i = 0; i<lectores.length; i++) {
			lectores[i].start();
		}
		for (int i = 0; i<escritores.length; i++) {
			escritores[i].start();
		}

	}

	

}
