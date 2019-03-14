package it.polito.tdp.corsi.model;

import java.util.List;

public class TestModel {
	
	
	

	public static void main(String[] args) {
	
		Model m = new Model();
		
		List<Corso> corsi = m.listaCorsiSemestre(2);
		
		for(Corso c : corsi)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(c);
		}
		System.out.println("Start");
		int matricola = 146601;
		String result = m.getStudenteByMatricola(matricola);
		System.out.println("Matricola: " + matricola + "\nNome Cognome:"+ result);
		
		result = m.getStaticheFromCorsi();
		System.out.println(result);

		
	}

}
