package it.urial.sim.home;

import java.util.concurrent.TimeUnit;

import it.urial.sim.core.CallManager;
import it.urial.sim.core.PhoneNumber;
import it.urial.sim.core.SIMCard;

public class SIM {
	
	/*
	 * 
	 * SAMPLE CLASS.
	 * 
	 * Esempio di utilizzo classe per quanto 
	 * riguarda il funzionamento delle classi contenute nel package: it.urial.sim.core
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		SIMCard sim = new SIMCard(new PhoneNumber(39, 3271296641l), 10);
		
		sim.Call(new PhoneNumber(39, 3271296641l));
		
		try {
			TimeUnit.SECONDS.sleep(1l);
			sim.getCall(0).endCallTimer();
			System.out.println(sim.getCall(0).getEndTime());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		CallManager.readCalls();
	}
	
}
