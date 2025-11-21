package ej10;

public class Vehiculo extends Thread{
	private int peso;
	private boolean ambulancia;
	private Puente puente;
	
	public Vehiculo(int peso, boolean ambulancia, Puente puente) {
		this.peso = peso;
		this.ambulancia=ambulancia;
		this.puente = puente;
	}
	
	public void run() {
		try {
			puente.entrarPuente(peso, ambulancia);
			sleep(2000);
			puente.salirPuente(peso);
			
		}catch(InterruptedException e) {return;}
	}
}
