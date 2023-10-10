package pacote_viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import factory.ConnectionFactory;

public class Pacote_viagemDAO {
	public void salvarPacote_viagem(Pacote_viagem pacote_viagem) {
		String sql = "INSERT INTO pacote_viagem(idPassagem, idHotel, preco, formaPagamento)" + "VALUES(?,?,?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pacote_viagem.getIdPassagem_aerea());
			pstm.setInt(2, pacote_viagem.getIdHotel());
			pstm.setString(3, pacote_viagem.getPreco());
			pstm.setString(4, pacote_viagem.getFormaPagamento());

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
