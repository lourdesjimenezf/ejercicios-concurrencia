package ej7;

public class Fumador extends Thread{
	private Componente faltante;
	private Mesa mesa;
	
	
	
	public Fumador(Componente faltante, Mesa mesa) {
		this.faltante = faltante;
		this.mesa = mesa;
	}
	
	public void run() {
		try {
			while(true) {
				mesa.quitarComponentes(faltante);
				sleep(1000); //fuma
			}
			
		}catch(InterruptedException e) {return;}
	}
	
	

}
