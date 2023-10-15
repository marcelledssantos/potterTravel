package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cia_aerea.Cia_aerea;
import factory.ConnectionFactory;

public class HotelDAO {

	public void salvarHotel(Hotel hotel) {
		String sql = "INSERT INTO hotel(nome, cidade)" + "VALUES(?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, hotel.getNome());
			pstm.setString(2, hotel.getCidade());
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

	public List<Hotel> exibirHotel() {
		String sql = "SELECT * FROM hotel";
		List<Hotel> hoteis = new ArrayList<Hotel>();
		
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Hotel hotel = new Hotel();
				hotel.setId(rset.getInt("id"));
				hotel.setNome(rset.getString("nome"));
				hotel.setCidade(rset.getString("cidade"));
				hoteis.add(hotel);
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
		return hoteis;
	}

	public void update(Hotel hotel) {
		String sql = "UPDATE hotel SET nome = ?, cidade =?" + "WHERE id = ?";

	Connection conn = null;
	PreparedStatement pstm = null;

	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, hotel.getNome());
		pstm.setString(2, hotel.getCidade());
		pstm.setInt(3, hotel.getId());
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
	public void removeByIdHotel(int id) {
		String sql = "DELETE FROM hotel WHERE id = ?";

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


