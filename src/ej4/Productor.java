package ej4;

public class Productor extends Thread{
	private int id;
	private Buffer buffer;
	
	
	public Productor(int id, Buffer buffer) {
		this.id = id;
		this.buffer = buffer;
		
	}
	
	public void run() {
		while(true) {
			try {
				buffer.producir(id);
				sleep(1000);
				buffer.pararProducir(id);
			}catch(InterruptedException e) {return;}
		}
	}
}




