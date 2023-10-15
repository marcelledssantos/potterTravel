package viagem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;

public class ViagemDAO {

	public void salvarViagem(Viagem viagem) {
		String sql = "INSERT INTO viagem(horario, data_viagem, origem, destino)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, viagem.getHorario());

			Date sqlDate = Date.valueOf(viagem.getData_Viagem());

			pstm.setDate(2, sqlDate);

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

	public List<Viagem> exibirDestinos() {
		String sql = "SELECT * FROM viagem";
		List<Viagem> viagens = new ArrayList<Viagem>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Viagem viagem = new Viagem();
				viagem.setId(rset.getInt("id"));
				viagem.setOrigem(rset.getString("origem"));
				viagem.setDestino(rset.getString("destino"));
				viagem.setData_Viagem(rset.getDate("data_viagem").toLocalDate());
				viagem.setHorario(rset.getString("horario"));
				viagens.add(viagem);
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
		return viagens;
	}

	public void update(Viagem novaViagem) {
		String sql = "UPDATE viagem SET origem = ?, destino = ?, data_viagem = ?, horario = ?" + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, novaViagem.getOrigem());
			pstm.setString(2, novaViagem.getDestino());
			pstm.setDate(3, Date.valueOf(novaViagem.getData_Viagem()));
			pstm.setString(4, novaViagem.getHorario());
			pstm.setInt(5, novaViagem.getId());

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

	public void removeByIdViagem(int id) {
		String sql = "DELETE FROM viagem WHERE id = ?";

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
