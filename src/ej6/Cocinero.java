package ej6;

public class Cocinero extends Thread{
	private Marmita marmita;
	
	public Cocinero( Marmita marmita) {
		this.marmita= marmita;
	}
	
	public void run() {
		try {
			while(true) {
				
				marmita.rellenar();
				int tiempo = (int)(Math.random() * 3000);
				sleep(tiempo);
				marmita.rellenar();
				int tiempo2 = (int)(Math.random() * 2000);
				sleep(tiempo2);
			}
		}catch(InterruptedException e) {return;}
	}
}
