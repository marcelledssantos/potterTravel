package pacote_viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cia_aerea.Cia_aerea;
import factory.ConnectionFactory;

public class Pacote_viagemDAO {
	public void salvarPacote_viagem(Pacote_viagem pacote_viagem) {
		String sql = "INSERT INTO pacote_viagem(id_passagem_aerea, id_hotel, preco, forma_pagamento)"
				+ "VALUES(?,?,?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pacote_viagem.getId_Passagem_aerea());
			pstm.setInt(2, pacote_viagem.getId_Hotel());
			pstm.setString(3, pacote_viagem.getPreco());
			pstm.setString(4, pacote_viagem.getForma_Pagamento());

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

	public List<Pacote_viagem> exibirPacote_viagem() {
		String sql = "SELECT * FROM pacote_viagem";
		List<Pacote_viagem> pacotes_viagens = new ArrayList<Pacote_viagem>();
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Pacote_viagem pacote_viagem = new Pacote_viagem();
				pacote_viagem.setId(rset.getInt("id"));
				pacote_viagem.setId_Passagem_aerea(rset.getInt("id_passagem_aerea"));
				pacote_viagem.setId_Hotel(rset.getInt("id_hotel"));
				pacote_viagem.setPreco(rset.getString("preco"));
				pacote_viagem.setForma_Pagamento(rset.getString("forma_pagamento"));
				pacotes_viagens.add(pacote_viagem);
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
		return pacotes_viagens;
	}

	public void update(Pacote_viagem pacote_viagem) {
		String sql = "UPDATE pacote_viagem SET id_passagem_aerea = ?, id_hotel = ?, preco = ?, forma_pagamento = ? "
				+ "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pacote_viagem.getId_Passagem_aerea());
			pstm.setInt(2, pacote_viagem.getId_Hotel());
			pstm.setString(3, pacote_viagem.getPreco());
			pstm.setString(4, pacote_viagem.getForma_Pagamento());
			pstm.setInt(5, pacote_viagem.getId());
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

	public static  void removeById_Pacote_viagem(int id_pacote_viagem) {
		String sql = "DELETE FROM pacote_viagem WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_pacote_viagem);
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
