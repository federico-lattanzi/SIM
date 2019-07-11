package it.urial.sim.core;

import java.util.HashMap;

public class SIMCard {
	
	private PhoneNumber number;
	private long credit;
	private HashMap<Integer, Call> calls = new HashMap<Integer, Call>();
	
	/**
	 * 
	 * @param number Numero proprietario della SIM
	 * @param credit Credito disponibile nella SIM
	 */
	public SIMCard(PhoneNumber number, long credit) {
		this.number = number;
		this.credit = credit;
	}
	
	/**
	 * 
	 * @return Classe PhoneNumber (Prefisso + Numero)
	 */
	public PhoneNumber getPhoneNumber() {
		return this.number;
	}
	
	/**
	 * 
	 * @return Credito residuo
	 */
	public long getCredit() {
		return this.credit;
	}
	
	/**
	 * 
	 * @param receiver Numero di telefono del destinatario
	 */
	public void Call(PhoneNumber receiver) {
		int callId = calls.size() == 0 ? 0 : calls.size() +1;
		
		Call call = new Call(callId, getPhoneNumber(), receiver);
		call.startCallTimer();
		
		calls.put(callId, call);
	}
	
	/**
	 * 
	 * @param callId ID della chiamata
	 * @return La chiamata
	 */
	public Call getCall(int callId) {
		return calls.get(callId);
	}
	
}
