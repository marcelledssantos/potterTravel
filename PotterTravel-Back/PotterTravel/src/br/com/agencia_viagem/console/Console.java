package console;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import cliente.Cliente;
import cliente.ClienteDAO;
import factory.ConnectionFactory;

public class Console {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		Scanner entrada = new Scanner(System.in);
		int menu = 1;

		while (menu != 0) {
			System.out.println("Bem vindo(a) a agência de viagens Potter Travel");
			System.out.println("Digite a opção desejada: ");
			System.out.println("1. menu Usuário");
			System.out.println("2. menu Viagem");
			System.out.println("3. menu Cia Aérea");
			System.out.println("0. Sair");
			menu = entrada.nextInt();
			entrada.nextLine();
			switch (menu) {

			case 1:
				System.out.println("digite qual opção deseja:");
				System.out.println("1. Cadastrar usuário:");
				System.out.println("2. Exibir todos usuários:");
				System.out.println("1. Atualizar usuário:");
				System.out.println("1. Deletar usuário:");
				menu = entrada.nextInt();

				switch (menu) {

				case 1:
					System.out.println("Digite seu nome: ");
					entrada.nextLine();
					String nome = entrada.nextLine();
					cliente.setNome(nome);
					System.out.println("Agora digite seu CPF: ");
					String cpf = entrada.nextLine();
					cliente.setCpf(cpf);
					System.out.println("Digite seu telefone: ");
					String telefone = entrada.nextLine();
					cliente.setTelefone(telefone);
					System.out.println("Digite endereço: ");
					String endereco = entrada.nextLine();
					cliente.setEndereco(endereco);
					System.out.println("Agora seu email: ");
					String email = entrada.nextLine();
					cliente.setEmail(email);
					System.out.println("Digite sua senha: ");
					String senha = entrada.nextLine();
					cliente.setSenha(senha);
					clienteDAO.salvarCliente(cliente);
					System.out.println("Usuário cadastrado com sucesso!");
					break;

				case 2:
					for (Cliente c : clienteDAO.exibirUsuarios()) {
						System.out.println("NOME: " + c.getNome());
					}
					break;

				case 3:
					Cliente clienteupdate = new Cliente();
					System.out.println("Digite qual ID deseja editar: ");
					int idUpdate = entrada.nextInt();
					clienteupdate.setId(idUpdate);
					System.out.println("Digite o novo nome: ");
					String nomeUpdate = entrada.nextLine();
					clienteupdate.setNome(nomeUpdate);
					//bug
					System.out.println("Digite o novo CPF: ");
					String cpfUpdate = entrada.nextLine();
					clienteupdate.setCpf(cpfUpdate);
					System.out.println("Digite o novo telefone: ");
					String telefoneUpdate = entrada.nextLine();
					clienteupdate.setTelefone(telefoneUpdate);
					System.out.println("Digite o novo endereço: ");
					String enderecoUpdate = entrada.nextLine();
					clienteupdate.setEndereco(enderecoUpdate);
					System.out.println("Digite o novo email: ");
					String emailUpdate = entrada.nextLine();
					clienteupdate.setEmail(emailUpdate);
					System.out.println("Digite a nova senha: ");
					String senhaUpdate = entrada.nextLine();
					clienteupdate.setSenha(senhaUpdate);
					clienteDAO.update(clienteupdate);
					System.out.println("Usuário editado com sucesso!");
					break;

				case 4:
					System.out.println("Digite qual ID deseja deletar: ");
					int idDelete = entrada.nextInt();
					clienteDAO.removeById(idDelete);
					System.out.println("Usuário deletado com sucesso!");
					break;
				}
				break;

			case 2:
				System.out.println("digite qual opção deseja:");
				System.out.println("1. Cadastrar viagem:");
				System.out.println("2. Exibir todas viagens:");
				System.out.println("1. Atualizar viagem:");
				System.out.println("1. Deletar viagem:");
				menu = entrada.nextInt();
				switch (menu) {

				case 1:
					System.out.println("cadastro de viagem");
					break;

				case 2:
					System.out.println("listar todas viagens");
					break;

				case 3:
					System.out.println("atualizar viagem");
					break;

				case 4:
					System.out.println("deletar viagem");
					break;
				}
			}
		}

	}
}