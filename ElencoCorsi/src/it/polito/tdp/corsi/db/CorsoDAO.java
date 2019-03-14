package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Statistiche;

public class CorsoDAO {

	/**
	 * Restituisce tutti gli elementi della tabella CORSO
	 * 
	 * @return
	 */

	public List<Corso> listAll() {

		String sql = "SELECT codins, crediti, nome, pd " + "FROM corso";

		List<Corso> result = new ArrayList<Corso>();

		try {

			Connection conn = ConnectDB.getConnection();

			PreparedStatement st = conn.prepareStatement(sql);

			st.executeQuery();

			ResultSet res = st.executeQuery();

			while (res.next()) {
				Corso c = new Corso(res.getString("codins"), res.getInt("crediti"), res.getString("nome"),
						res.getInt("pd"));

				result.add(c);
			}

			conn.close();

		} catch (SQLException e) {
			return null;
		}

		return result;
	}

	/**
	 * Restituisce i corsi cha hanno questo periodo didattico{@code pd}
	 * 
	 * @param pd
	 * @return
	 */
	public List<Corso> listByPD(int pd)
	{
		
		String sql = "SELECT codins, crediti, nome, pd " + 
				"FROM iscritticorsi.corso WHERE pd = ?" ;
		
		List<Corso>	result = new ArrayList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
		
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, pd);
			
			ResultSet res = st.executeQuery();
			
			while(res.next())
			{
				Corso c = new Corso(res.getString("codins"), res.getInt("crediti"),res.getString("nome"),res.getInt("pd"));
				
				result.add(c);
			}
			
			conn.close();
			
			
		} 
		catch (SQLException e) 
		{
			
			return null;
		}
		return result;
	
	}

	public Statistiche getStatisticheByCodIns(String codIns) {
		String sql = "SELECT cds, COUNT(cds) as count\r\n" + 
				"FROM iscritticorsi.studente as s, iscritticorsi.iscrizione as i \r\n" + 
				"WHERE s.matricola = i.matricola AND i.codins = ? AND cds <> \"\" \r\n" + 
				"GROUP BY cds ";
		
		Statistiche stat = new Statistiche();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, codIns);
			
			ResultSet res = st.executeQuery();
			while(res.next()) {
				stat.getMappaCDS().put(res.getString("cds")	, res.getInt("count"));
			}
			
			conn.close();
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return stat;
	}

}
