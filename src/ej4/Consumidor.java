package ej4;

public class Consumidor extends Thread{
	private int id;
	private Buffer buffer;

	public Consumidor(int id, Buffer buffer) {
		this.id = id;
		this.buffer = buffer;
		
	}
	
	public  void run() {
		while(true) {
			try {
				buffer.consumir(id);
				sleep(1000);
				buffer.pararConsumir(id);
			}catch(InterruptedException e) {return;}
		}
	}
}
