package it.polito.tdp.corsi.model;

import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {

	private List<Corso> corsi;
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	
	public Model() {
		
		corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}
	
	public List<Corso> listaCorsiSemestre(int pd){
		// Utilizzo la classe 
		
		/*	A livello algoritimico, ho 2 opzioni:
		 *  
		 *  Opz.1 : Leggo tutto dal DB e poi filtro io
		 *  
		 *  Opz.2 : faccio fare il lavoro al DB
		 * 
		 */
		
		// OPZ.1
		
//		this.corsi = corsoDAO.listAll();
//		
//		List<Corso> risultato = new ArrayList<>();
//		
//		for(Corso c : this.corsi)
//		{
//			if(c.getPd() == pd )
//				risultato.add(c);
//			
//		}
//		return risultato;
		
		// OPZ.2
		
		List<Corso> risultato2 = corsoDAO.listByPD(pd);
		return risultato2;
//		
	}

	public String getStudenteByMatricola(int matricola) {
		Studente studente = studenteDAO.getStudenteByMatr(matricola);
		
		if(studente == null) {
			return "Studente non presente! ";
		}
		return studente.getNome() + " " + studente.getCognome();
	}

	public String getStaticheFromCorsi() {
		this.corsi = corsoDAO.listAll();
		
		StringBuilder sb = new StringBuilder();
		for(Corso c: this.corsi)
		{
			Statistiche stat = corsoDAO.getStatisticheByCodIns(c.getCodIns());
			
			sb.append("codins: " + c.getCodIns() + "\n");
			for(String cs : stat.getMappaCDS().keySet()) {
				
				sb.append(" - " + cs + " " + stat.getMappaCDS().get(cs) + "\n");
				
			}
			sb.append("\n");
			
		}
		return sb.toString();
	}
}
