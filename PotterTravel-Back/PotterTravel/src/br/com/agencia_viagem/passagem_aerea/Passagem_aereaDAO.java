package passagem_aerea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cia_aerea.Cia_aerea;
import factory.ConnectionFactory;

public class Passagem_aereaDAO {

	public void salvarPassagem_Aerea(Passagem_aerea passagem_aerea) {
		String sql = "INSERT INTO Passagem_aerea(id_viagem, id_cia_aerea)" + "VALUES(?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, passagem_aerea.getId_viagem());
			pstm.setInt(2, passagem_aerea.getId_cia_aerea());

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

	public List<Passagem_aerea> exibirPassagem_aerea() {
		List<Passagem_aerea> passagens_aereas = new ArrayList<Passagem_aerea>();
		Passagem_aerea passagem_aerea = new Passagem_aerea();

		String sql = "SELECT * FROM passagem_aerea";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				passagem_aerea.setId(rset.getInt("id"));
				passagem_aerea.setId_viagem(rset.getInt("id_viagem"));
				passagem_aerea.setId_cia_aerea(rset.getInt("id_cia_aerea"));
				passagens_aereas.add(passagem_aerea);
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
		return passagens_aereas;
	}
	
	public void update(Passagem_aerea passagem_aerea) {
		String sql = "UPDATE passagem_aerea SET id_viagem = ?, id_cia_aerea = ?" + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, passagem_aerea.getId());
			pstm.setInt(2, passagem_aerea.getId_viagem());
			pstm.setInt(3, passagem_aerea.getId_cia_aerea());
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

	public void removeByIdPassagem_Aerea(int id) {
		String sql = "DELETE FROM Passagem_aerea WHERE id = ?";

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

