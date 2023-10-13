package cliente_pacote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;

public class Cliente_pacoteDAO {

	public void salvarCliente_pacote(Cliente_pacote cliente_pacote) {
		String sql = "INSERT INTO Cliente_pacote (id_pacote_viagem, id_cliente)" + "VALUES(?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, cliente_pacote.getId_pacote_viagem());
			pstm.setInt(2, cliente_pacote.getId_Cliente());

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

	public List<Cliente_pacote> exibirCliente_pacote() {
		List<Cliente_pacote> clientes_pacotes = new ArrayList<Cliente_pacote>();
		Cliente_pacote cliente_pacote = new Cliente_pacote();

		String sql = "SELECT * FROM cliente_pacote";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				cliente_pacote.setId(rset.getInt("id"));
				cliente_pacote.setId_Cliente(rset.getInt("id_cliente"));
				cliente_pacote.setId_pacote_viagem(rset.getInt("id_pacote_viagem"));
				clientes_pacotes.add(cliente_pacote);
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
		return clientes_pacotes;
	}

	public void update(Cliente_pacote cliente_pacote) {
		String sql = "UPDATE cliente_pacote SET id_cliente = ?, id_pacote_viagem = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cliente_pacote.getId_Cliente());
			pstm.setInt(2, cliente_pacote.getId_pacote_viagem());
			pstm.setInt(3, cliente_pacote.getId());
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

	public void removeById_Cliente_pacote(int id) {
		String sql = "DELETE FROM cliente_pacote WHERE id = ?";

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
