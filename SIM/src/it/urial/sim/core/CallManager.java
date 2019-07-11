package it.urial.sim.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CallManager {
	
	private static final File DIR = new File(System.getProperty("user.home") + File.separatorChar + "Desktop" + File.separatorChar + "SIM");
	
	/**
	 * 
	 * @return Lista delle righe del file
	 */
	public static List<String> readCalls() {
		List<String> list = new ArrayList<String>();
		
        FileReader fileReader;
		try {
			fileReader = new FileReader(new File(DIR.getPath(), "calls.log"));
			
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        
	        String line;
	        
	        while((line = bufferedReader.readLine()) != null) {
	        	list.add(line);
	        }
	        
	        bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		
		return list;
	}
	
	
	/**
	 * Scrive su file la chiamata che inseriamo nel parametro
	 * @param call La chiamata in questione
	 */
	@SuppressWarnings("deprecation")
	public static void printCallTo(Call call) {
		if(!DIR.exists()) {
			DIR.mkdirs();
		}
		
		File file = new File(DIR.getPath(), "calls.log");
		
		Date date = new Date();
		
		try {
			file.createNewFile();
			
			FileWriter fw = new FileWriter(file, true);
			
			fw.write("[" + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + "] [" + call.getCallId() + "] " + call.getSender().getPrefix() + call.getSender().getNumber() + " to "
					+ call.getReceiver().getPrefix() + call.getReceiver().getNumber() + " - " + (call.getEndTime() / 1000) + "\n");
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
