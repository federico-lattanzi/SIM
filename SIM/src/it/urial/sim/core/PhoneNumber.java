package it.urial.sim.core;

public class PhoneNumber {
	
	private int prefix;
	private long number;
	
	/**
	 * 
	 * @param prefix Prefisso del telefono (in Italia +39)
	 * @param number Numero del telefono
	 */
	public PhoneNumber(int prefix, long number) {
		this.prefix = prefix;
		this.number = number;
	}
	
	/**
	 * 
	 * @return prefisso
	 */
	public int getPrefix() {
		return prefix;
	}
	
	/**
	 * 
	 * @return numero
	 */
	public long getNumber() {
		return number;
	}
	
}
