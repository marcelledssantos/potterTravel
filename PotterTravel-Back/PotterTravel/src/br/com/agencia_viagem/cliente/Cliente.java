package cliente;

public class Cliente{

	private int id; 
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private String email;
	private String senha;
	private boolean ofertas;
	
	public Cliente() {}
	
	public Cliente(String email, boolean ofertas) {
		this.email = email;
		this.ofertas = ofertas;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean getOfertas() {
		return ofertas;
	}

	public void setOfertas(boolean ofertas) {
		this.ofertas = ofertas;

	}
	}


