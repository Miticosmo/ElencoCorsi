package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {

	public Studente getStudenteByMatr(int matricola) {
		String sql = "SELECT nome, cognome, cds from studente where matricola = ?";

		Studente result = null;

		try {

			Connection conn = ConnectDB.getConnection();

			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, matricola);

			ResultSet res = st.executeQuery();

			if (res.next()) {
				result = new Studente(matricola, res.getString("nome"), res.getString("cognome"), res.getString("cds"));
			}

			conn.close();

		} catch (SQLException e) {
			return null;
		}

		return result;
	}

}
