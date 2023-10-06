package viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;

public class ViagemDAO {
	
		public void salvarViagem( Viagem viagem) {
			String sql = "INSERT INTO viagem(horario, data,origem,destino,)" + "VALUES(?,?,?,?)";

			Connection conn = null;
			PreparedStatement pstm = null;
			try {

				conn = ConnectionFactory.createConnectionToMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setDate(1, viagem.getHorario());

				pstm.setDate(2, viagem.getData());

				pstm.setString(3, viagem.getOrigem());

				pstm.setString(4, viagem.getDestino());

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
