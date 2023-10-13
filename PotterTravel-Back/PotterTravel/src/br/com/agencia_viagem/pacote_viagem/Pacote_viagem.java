package pacote_viagem;

public class Pacote_viagem {

	private int id;
	private int id_Passagem_aerea;
	private int id_hotel;
	private String preco;
	private String forma_pagamento;

	public Pacote_viagem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_Passagem_aerea() {
		return id_Passagem_aerea;
	}

	public void setId_Passagem_aerea(int id_Passagem_aerea) {
		this.id_Passagem_aerea = id_Passagem_aerea;
	}

	public int getId_Hotel() {
		return id_hotel;
	}

	public void setId_Hotel(int id_Hotel) {
		this.id_hotel = id_Hotel;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getForma_Pagamento() {
		return forma_pagamento;
	}

	public void setForma_Pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}
}
