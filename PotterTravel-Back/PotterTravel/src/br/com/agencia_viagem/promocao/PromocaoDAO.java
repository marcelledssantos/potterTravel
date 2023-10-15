package promocao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;

public class PromocaoDAO {

	public void salvarPromocao(Promocao promocao) {
		String sql = "INSERT INTO Promocao (id_pacote_viagem, novo_preco)" + "VALUES(?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, promocao.getId_pacote_viagem());
			pstm.setFloat(2, promocao.getNovo_preco());

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

	public List<Promocao> exibirPromocao() {
		List<Promocao> promocoes = new ArrayList<Promocao>();
		

		String sql = "SELECT * FROM promocao";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Promocao promocao = new Promocao();
				promocao.setId(rset.getInt("id"));
				promocao.setId_pacote_viagem(rset.getInt("id_pacote_viagem"));
				promocao.setNovo_Preco(rset.getFloat("novo_preco"));
				promocoes.add(promocao);
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
		return promocoes;
	}

	public void update(Promocao promocao) {
		String sql = "UPDATE promocao SET id_pacote_viagem = ?, novo_preco = ?  WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, promocao.getId_pacote_viagem());
			pstm.setFloat(2, promocao.getNovo_preco());
			pstm.setInt(3, promocao.getId());
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



	public void removeById_Promocao(int id) {
		String sql = "DELETE FROM promocao WHERE id = ?";

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
