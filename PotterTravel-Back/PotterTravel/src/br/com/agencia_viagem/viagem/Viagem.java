package viagem;

import java.time.LocalDate;

public class Viagem {

	private int id;
	private String horario;
	private LocalDate data_viagem;
	private String origem;
	private String destino;

	public Viagem() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public LocalDate getData_Viagem() {
		return data_viagem;
	}

	public void setData_Viagem(LocalDate data_viagem) {
		this.data_viagem = data_viagem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}