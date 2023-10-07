package console;

import java.util.Scanner;
import cliente.Cliente;
import cliente.ClienteDAO;
import viagem.Viagem;
import viagem.ViagemDAO;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Console {

	public static void main(String[] args) throws ParseException {
		ViagemDAO viagemDAO = new ViagemDAO();
		Viagem viagem = new Viagem();
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		Scanner entrada = new Scanner(System.in);
		
		
		int menu = 1;
		

		while (menu != 0) { //Menu principal
			System.out.println("Bem vindo(a) a agência de viagens Potter Travel");
			System.out.println("Digite a opção desejada: ");
			System.out.println("1. Menu Usuário");
			System.out.println("2. Menu Viagem");
			System.out.println("3. Menu Cia Aérea");
			System.out.println("0. Sair");
			menu = entrada.nextInt();
			entrada.nextLine();
			switch (menu) {

			case 1: // Menu Cliente
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar usuário:");
				System.out.println("2. Exibir todos usuários:");
				System.out.println("3. Atualizar usuário:");
				System.out.println("4. Deletar usuário:");
				menu = entrada.nextInt();

				switch (menu) {

				case 1: //Create Cliente
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
					System.out.println();
					break;

				case 2: //Read cliente
					for (Cliente c : clienteDAO.exibirUsuarios()) {
						System.out.println("NOME: " + c.getNome());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 3: //Upadate cliente
					Cliente clienteupdate = new Cliente();
					System.out.println("Digite qual ID deseja editar: ");
					int idUpdate = entrada.nextInt();
					clienteupdate.setId(idUpdate);
					System.out.println("Digite o novo nome: ");
					entrada.nextLine();
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
					System.out.println();
					break;

				case 4: // Delete cliente
					System.out.println("Digite qual ID deseja deletar: ");
					int idDelete = entrada.nextInt();
					clienteDAO.removeById(idDelete);
					System.out.println("Usuário deletado com sucesso!");
					System.out.println();
					break;
				}
				break;

			case 2: // Menu Viagem
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar viagem:");
				System.out.println("2. Exibir todas viagens:");
				System.out.println("3. Atualizar viagem:");
				System.out.println("4. Deletar viagem:");
				menu = entrada.nextInt();
				switch (menu) {

				case 1: // Create viagem
					System.out.println("Digite a origem: ");
					entrada.nextLine();
					String origem = entrada.nextLine();
					viagem.setOrigem(origem);
					System.out.println("Qual será o destino?");
					String destino = entrada.nextLine();
					viagem.setDestino(destino);
					System.out.println("Digite a data de partida: (aaaa-mm-dd)");
					String data_Viagem = entrada.nextLine();
					LocalDate dataConvertida = LocalDate.parse(data_Viagem,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					viagem.setData_Viagem(dataConvertida);
					System.out.println("Digite o Horário:");
					String horario = entrada.nextLine();
					viagem.setHorario(horario);
					viagemDAO.salvarViagem(viagem);
					System.out.println("Viagem cadastrada com sucesso!");
					System.out.println();
					break;

				case 2: // Read viagem
					for (Viagem c : viagemDAO.exibirDestinos()) {
						System.out.println("ORIGEM: " + c.getOrigem());
						System.out.println("DESTINO: " + c.getDestino());
						System.out.println("DATA: " + c.getData_Viagem());
						System.out.println("HORARIO: " + c.getHorario());
						System.out.println();	
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;
					
					
				case 3:// Update viagem BUG
					Viagem viagemUpdate = new Viagem();
					System.out.println("Digite qual ID deseja editar: ");
					int idUpdate = entrada.nextInt();
					viagemUpdate.setId(idUpdate);
					System.out.println("Digite a nova origem: ");
					entrada.nextLine();
					String origemUpdate = entrada.nextLine();
					viagemUpdate.setOrigem(origemUpdate);
					System.out.println("Digite o novo destino: ");
					String destinoUpdate = entrada.nextLine();
					viagemUpdate.setDestino(destinoUpdate);
					System.out.println("Digite a nova data: (aaaa-mm-dd)");
					String novaData_Viagem = entrada.nextLine();
					LocalDate novaDataConvertida = LocalDate.parse(novaData_Viagem,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					viagem.setData_Viagem(novaDataConvertida);
					System.out.println("Digite o novo horário: ");
					String horarioUpdate = entrada.nextLine();
					viagemUpdate.setHorario(horarioUpdate);
					viagemDAO.update(viagemUpdate);
					System.out.println("Viagem atualizada com sucesso!");
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 4: // Delete viagem
					System.out.println("Digite qual ID deseja deletar: ");
					int idDelete = entrada.nextInt();
					viagemDAO.removeByIdViagem(idDelete);
					System.out.println("Viagem deletada com sucesso!");
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;
				}
			
				}
			}
		}

	}
