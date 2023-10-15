package cia_aerea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;

public class Cia_aereaDAO {

	public void salvarCia_Aerea(Cia_aerea cia_aerea) {
		String sql = "INSERT INTO cia_aerea(nome)" + "VALUES(?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cia_aerea.getNome());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {

					conn.close();

				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Cia_aerea> exibirCia_aerea() {
		String sql = "select * from cia_aerea";
		List<Cia_aerea> cias_aereas = new ArrayList<Cia_aerea>();
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cia_aerea cia_aerea = new Cia_aerea();
				cia_aerea.setId(rset.getInt("id"));
				cia_aerea.setNome(rset.getString("nome"));
				cias_aereas.add(cia_aerea);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cias_aereas;
	}

	public void update(Cia_aerea cia_aerea) {
		String sql = "UPDATE cia_aerea SET nome = ?" + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cia_aerea.getNome());
			pstm.setInt(2, cia_aerea.getId());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeByIdCia_Aerea(int id) {
		String sql = "DELETE FROM cia_aerea WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
