package promocao;

public class Promocao {

	private int id;
	private int id_pacote_viagem;
	private float novo_preco;

	public Promocao() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_pacote_viagem() {
		return id_pacote_viagem;
	}

	public void setId_pacote_viagem(int id_pacote_viagem) {
		this.id_pacote_viagem = id_pacote_viagem;
	}

	public float getNovo_preco() {
		return novo_preco;
	}

	public void setNovo_Preco(float novo_preco) {
		this.novo_preco = novo_preco;
	}
}
