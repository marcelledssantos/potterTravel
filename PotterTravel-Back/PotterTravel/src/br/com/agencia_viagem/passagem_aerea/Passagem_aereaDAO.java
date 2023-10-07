package passagem_aerea;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}