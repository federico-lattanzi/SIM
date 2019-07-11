package it.urial.sim.core;

public class Call {
	
	private int callId;
	
	private PhoneNumber sender;
	private PhoneNumber receiver;
	
	private long start;
	private long end;
	
	/**
	 * 
	 * @param callId ID della chiamata
	 * @param sender numero del mittente
	 * @param receiver numero del destinatario
	 */
	public Call(int callId, PhoneNumber sender, PhoneNumber receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
	/**
	 * 
	 * @return ID della chiamata
	 */
	public int getCallId() {
		return callId;
	}
	
	/**
	 * 
	 * @return Numero del mittente
	 */
	public PhoneNumber getSender() {
		return sender;
	}

	/**
	 * 
	 * @return Numero del destinatario
	 */
	public PhoneNumber getReceiver() {
		return receiver;
	}
	
	/**
	 * Salva i millisecondi di quel momento
	 */
	public void startCallTimer() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * Scrive su file il tempo complessivo della chiamata
	 */
	public void endCallTimer() {
		end = (System.currentTimeMillis() - start);
		CallManager.printCallTo(this);
	}
	
	public long getStartTime() {
		return start;
	}
	
	public long getEndTime() {
		return end;
	}
	
}
