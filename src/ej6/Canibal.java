package ej6;

public class Canibal extends Thread{
	private int id;
	private Marmita marmita;

	public Canibal(int id, Marmita marmita) {
		this.id = id;
		this.marmita= marmita;
	}
	
	public void run() {
		try {
			while(true) {
				
				marmita.comer(id);
				int tiempo = (int)(Math.random() * 3000);
				sleep(tiempo);
				marmita.comer(id);
				int tiempo2 = (int)(Math.random() * 3500);
				sleep(tiempo2);
			}
		}catch(InterruptedException e) {return;}
	
	}
}
