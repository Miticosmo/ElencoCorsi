package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.Map;

public class Statistiche {
	
	Map <String, Integer> mappaCDS;
	
	public Statistiche() {
		this.mappaCDS = new HashMap<>();
	}

	public Map<String, Integer> getMappaCDS() {
		return mappaCDS;
	}

	public void setMappaCDS(Map<String, Integer> mappaCDS) {
		this.mappaCDS = mappaCDS;
	}
	
	@Override
	public String  toString() {
		return mappaCDS.toString();
	}
	
	

}
