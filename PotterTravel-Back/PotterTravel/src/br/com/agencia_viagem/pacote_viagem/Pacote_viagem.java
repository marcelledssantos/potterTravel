package pacote_viagem;

public class Pacote_viagem {

	private int id;
	private int idPassagem_aerea;
	private int idHotel;
	private String preco;
	private String formaPagamento;

	public Pacote_viagem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPassagem_aerea() {
		return idPassagem_aerea;
	}

	public void setIdPassagem_aerea(int idPassagem_aerea) {
		this.idPassagem_aerea = idPassagem_aerea;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
