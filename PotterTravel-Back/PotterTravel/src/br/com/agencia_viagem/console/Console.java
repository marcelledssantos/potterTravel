package console;

import java.util.Scanner;
import cia_aerea.Cia_aerea;
import cia_aerea.Cia_aereaDAO;
import cliente.Cliente;
import cliente.ClienteDAO;
import cliente_pacote.Cliente_pacote;
import cliente_pacote.Cliente_pacoteDAO;
import hotel.Hotel;
import hotel.HotelDAO;
import pacote_viagem.Pacote_viagem;
import pacote_viagem.Pacote_viagemDAO;
import passagem_aerea.Passagem_aerea;
import passagem_aerea.Passagem_aereaDAO;
import promocao.Promocao;
import promocao.PromocaoDAO;
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
		Cia_aereaDAO cia_aereaDAO = new Cia_aereaDAO();
		Cia_aerea cia_aerea = new Cia_aerea();
		Passagem_aereaDAO passagem_aereaDAO = new Passagem_aereaDAO();
		Passagem_aerea passagem_aerea = new Passagem_aerea();
		HotelDAO hotelDAO = new HotelDAO();
		Hotel hotel = new Hotel();
		Pacote_viagemDAO pacote_viagemDAO = new Pacote_viagemDAO();
		Pacote_viagem pacote_viagem = new Pacote_viagem();
		Cliente_pacoteDAO cliente_pacoteDAO = new Cliente_pacoteDAO();
		Cliente_pacote cliente_pacote = new Cliente_pacote();
		PromocaoDAO promocaoDAO = new PromocaoDAO();
		Promocao promocao = new Promocao();
		Scanner entrada = new Scanner(System.in);

		int menu = 1;

		while (menu != 0) { // Menu principal
			System.out.println("Bem vindo(a) a agência de viagens Potter Travel");
			System.out.println("Digite a opção desejada: ");
			System.out.println("1. Menu Usuário");
			System.out.println("2. Menu Viagem");
			System.out.println("3. Menu Cia Aérea");
			System.out.println("4. Menu Passagem Aérea");
			System.out.println("5. Menu Hotel");
			System.out.println("6. Menu Pacote viagem");
			System.out.println("7. Menu Cliente pacote");
			System.out.println("8. Menu Promoçao");
			System.out.println("0. Sair");
			menu = entrada.nextInt();
			entrada.nextLine();
			switch (menu) {

			case 1: { // Menu Cliente
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar usuário:");
				System.out.println("2. Exibir todos usuários:");
				System.out.println("3. Atualizar usuário:");
				System.out.println("4. Deletar usuário:");
				menu = entrada.nextInt();
			}
				switch (menu) {

				case 1: // Create Cliente
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

				case 2: // Read cliente
					for (Cliente c : clienteDAO.exibirUsuarios()) {
						System.out.println("NOME: " + c.getNome());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 3: // Upadate cliente
					Cliente clienteupdate = new Cliente();
					System.out.println("Digite qual ID deseja editar: ");
					int idUpdate = entrada.nextInt();
					clienteupdate.setId(idUpdate);
					System.out.println("Digite o novo nome: ");
					entrada.nextLine();
					String nomeUpdate = entrada.nextLine();
					clienteupdate.setNome(nomeUpdate);
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
					LocalDate dataConvertida = LocalDate.parse(data_Viagem, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

				case 3:// Update viagem
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
					System.out.println("Digite a nova data de partida: (aaaa-mm-dd)");
					String data_ViagemUpdate = entrada.nextLine();
					LocalDate dataUpdateConvertida = LocalDate.parse(data_ViagemUpdate,
							DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					viagemUpdate.setData_Viagem(dataUpdateConvertida);
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
				break;

			case 3:

				// Menu Cia_aerea
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar cia aérea:");
				System.out.println("2. Exibir todas cias aéreas:");
				System.out.println("3. Atualizar cia aérea:");
				System.out.println("4. Deletar cia aérea:");
				menu = entrada.nextInt();

				switch (menu) {

				case 1: // Create cia aérea {
					System.out.println("Digite o nome da cia aérea: ");
					entrada.nextLine();
					String nome = entrada.nextLine();
					cia_aerea.setNome(nome);
					cia_aereaDAO.salvarCia_Aerea(cia_aerea);
					System.out.println("Cia aérea cadastrada com sucesso!");
					System.out.println();
					break;

				case 2: // Read cia aerea
					for (Cia_aerea c : cia_aereaDAO.exibirCia_aerea()) {
						System.out.println("CIA AÉREA: " + c.getNome());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 3: // Update cia aerea
					Cia_aerea cia_aereaUpdate = new Cia_aerea();
					System.out.println("Digite qual ID deseja editar: ");
					int idUpdate = entrada.nextInt();
					cia_aereaUpdate.setId(idUpdate);
					System.out.println("Digite a nova cia aérea: ");
					entrada.nextLine();
					String nomeUpdate = entrada.nextLine();
					cia_aereaUpdate.setNome(nomeUpdate);
					cia_aereaDAO.update(cia_aereaUpdate);
					System.out.println("Cia aérea alterada com sucesso");
					System.out.println();
					break;

				case 4: // Delete cia aerea
					System.out.println("Digite qual ID deseja deletar: ");
					int idDelete = entrada.nextInt();
					cia_aereaDAO.removeByIdCia_Aerea(idDelete);
					System.out.println("Cia aérea deletada com sucesso!");
					break;
				}
				break;

			case 4:

				// Menu Passagem aerea
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar Passagem aérea:");
				System.out.println("2. Exibir todas as passagens aéreas:");
				System.out.println("3. Atualizar passagem aérea:");
				System.out.println("4. Deletar passagem aérea:");
				menu = entrada.nextInt();

				switch (menu) {

				case 1: // Create Passagem aérea {
					System.out.println("Digite o Id da viagem: ");
					entrada.nextLine();
					int id_viagem = entrada.nextInt();
					passagem_aerea.setId_viagem(id_viagem);
					System.out.println("Digite o Id da cia aérea: ");
					entrada.nextLine();
					int id_cia_aerea = entrada.nextInt();
					passagem_aerea.setId_cia_aerea(id_cia_aerea);
					passagem_aereaDAO.salvarPassagem_Aerea(passagem_aerea);
					System.out.println("Passagem aérea cadastrada com sucesso!");
					System.out.println();
					break;

				case 2: // Read Passagem_aerea
					for (Passagem_aerea c : passagem_aereaDAO.exibirPassagem_aerea()) {
						System.out.println("Viagem de id: " + c.getId_viagem());
						System.out.println("conjunta com a cia aérea : " + c.getId_cia_aerea());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 3: // Update Passagem aerea não está com conexão no banco
					Passagem_aerea passagem_aereaUpdate = new Passagem_aerea();
					System.out.println("Digite o novo Id da passagem aérea: ");
					int idUpdate = entrada.nextInt();
					passagem_aereaUpdate.setId(idUpdate);
					entrada.nextLine();
					System.out.println("Digite o novo Id da viagem: ");
					int id_viagemUpdate = entrada.nextInt();
					passagem_aereaUpdate.setId(id_viagemUpdate);
					System.out.println("Digite o novo Id da cia aérea: ");
					int id_cia_aereaUpdate = entrada.nextInt();
					passagem_aereaUpdate.setId(id_cia_aereaUpdate);
					passagem_aereaDAO.update(passagem_aereaUpdate);
					System.out.println("Passagem aérea alterada com sucesso");
					System.out.println();
					break;

				case 4: // Delete Passagem aerea
					System.out.println("Digite o ID da passagem aérea deseja deletar: ");
					int idDelete = entrada.nextInt();
					passagem_aereaDAO.removeByIdPassagem_Aerea(idDelete);
					System.out.println("Passagem aérea deletada com sucesso!");
					System.out.println();
					break;
				}
				break;

			case 5:

				// menu Hotel
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar hotel:");
				System.out.println("2. Exibir todos hotéis:");
				System.out.println("3. Atualizar hotel:");
				System.out.println("4. Deletar hotel:");
				menu = entrada.nextInt();

				switch (menu) {

				case 1: // Create hotel {
					System.out.println("Digite o nome do hotel: ");
					entrada.nextLine();
					String nome = entrada.nextLine();
					hotel.setNome(nome);
					System.out.println("Digite a cidade: ");
					String cidade = entrada.nextLine();
					hotel.setCidade(cidade);
					System.out.println("Hotel cadastrado com sucesso!");
					hotelDAO.salvarHotel(hotel);
					System.out.println();
					break;

				case 2: { // Read hotel
					for (Hotel c : hotelDAO.exibirHotel()) {
						System.out.println("Hotel " + c.getNome());
						System.out.println("Cidade: " + c.getCidade());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;
				}

				case 3: { // Update hotel
					Hotel hotelUpdate = new Hotel();
					System.out.println("Digite o nome do hotel: ");
					String NomeUpdate = entrada.nextLine();
					entrada.nextLine();
					hotelUpdate.setNome(NomeUpdate);
					System.out.println("Digite a cidade ");
					String cidadeUpdate = entrada.nextLine();
					hotelUpdate.setCidade(cidadeUpdate);
					hotelDAO.update(hotelUpdate);
					System.out.println("Hotel alterado com sucesso");
					System.out.println();
					break;
				}

				case 4: // Delete Passagem aerea
					System.out.println("Digite o ID do hotel que deseja deletar: ");
					int idDelete = entrada.nextInt();
					hotelDAO.removeByIdHotel(idDelete);
					System.out.println("Hotel deletado com sucesso!");
					System.out.println();
					break;
				}
				break;

			case 6:

				// Menu Pacote_viagem
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar pacote viagem:");
				System.out.println("2. Exibir todos pacotes de viagens:");
				System.out.println("3. Atualizar pacote viagem:");
				System.out.println("4. Deletar pacote viagem:");
				menu = entrada.nextInt();

				switch (menu) {

				case 1: // pacote viagem {

					System.out.println("Digite o Id da passagem aérea: ");
					int id_passagem_aerea = entrada.nextInt();
					pacote_viagem.setId_Passagem_aerea(id_passagem_aerea);
					System.out.println("Digite o Id do hotel: ");
					int id_hotel = entrada.nextInt();
					pacote_viagem.setId_Hotel(id_hotel);
					entrada.nextLine();
					System.out.println("Digite o valor do pacote");
					String preco = entrada.nextLine();
					pacote_viagem.setPreco(preco);
					System.out.println("Digite a forma de pagamento");
					String forma_pagamento = entrada.nextLine();
					pacote_viagem.setForma_Pagamento(forma_pagamento);
					pacote_viagemDAO.salvarPacote_viagem(pacote_viagem);
					System.out.println("Pacote viagem cadastrado com sucesso!");
					System.out.println();
					break;

				case 2: { // Read hotel
					for (Pacote_viagem c : pacote_viagemDAO.exibirPacote_viagem()) {
						System.out.println("Id da passagem aérea " + c.getId_Passagem_aerea());
						System.out.println("Id do hotel: " + c.getId_Hotel());
						System.out.println("Preço do pacote: " + c.getPreco());
						System.out.println("Forma de pagamento: " + c.getForma_Pagamento());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;
				}

				case 3: { // Update pacote_viagem
					Pacote_viagem pacote_viagemUpdate = new Pacote_viagem();
					System.out.println("Digite o id que deseja editar");
					int idUpdate = entrada.nextInt();
					pacote_viagemUpdate.setId(idUpdate);
					System.out.println("Digite o id da passagem aérea: ");
					int Id_passagem_aereaUpdate = entrada.nextInt();
					pacote_viagemUpdate.setId_Passagem_aerea(Id_passagem_aereaUpdate);
					System.out.println("Digite o id do hotel: ");
					int Id_hotelUpdate = entrada.nextInt();
					entrada.nextLine();
					pacote_viagemUpdate.setId_Hotel(Id_hotelUpdate);
					System.out.println("Digite o preço do pacote viagem: ");
					String precoUpdate = entrada.nextLine();
					pacote_viagemUpdate.setPreco(precoUpdate);
					System.out.println("Digite a forma de pagamento: ");
					String forma_pagamentoUpdate = entrada.nextLine();
					pacote_viagemUpdate.setForma_Pagamento(forma_pagamentoUpdate);
					pacote_viagemDAO.update(pacote_viagemUpdate);
					System.out.println("Pacote viagem  alterado com sucesso");
					System.out.println();
					break;
				}

				case 4: // Delete Passagem aerea
					System.out.println("Digite o ID do pacote que deseja deletar: ");
					int idDelete = entrada.nextInt();
					Pacote_viagemDAO.removeById_Pacote_viagem(idDelete);
					System.out.println("Pacote deletado com sucesso!");
					System.out.println();
					break;
				}
				break;

			case 7:

				// Menu Cliente_pacote
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar cliente e pacote:");
				System.out.println("2. Exibir todos clientes e pacotes:");
				System.out.println("3. Atualizar clientes e pacotes:");
				System.out.println("4. Deletar clientes e pacotes :");
				menu = entrada.nextInt();

				switch (menu) {

				case 1: // Create Cliente_pacote{
					System.out.println("Digite o Id do pacote viagem: ");
					int id_pacote_viagem = entrada.nextInt();
					cliente_pacote.setId_pacote_viagem(id_pacote_viagem);
					System.out.println("Digite o Id do cliente: ");
					entrada.nextLine();
					int id_cliente = entrada.nextInt();
					cliente_pacote.setId_Cliente(id_cliente);
					cliente_pacoteDAO.salvarCliente_pacote(cliente_pacote);
					System.out.println("Cliente e pacote cadastrados com sucesso!");
					System.out.println();
					break;

				case 2: // Read Cliente_pacote
					for (Cliente_pacote c : cliente_pacoteDAO.exibirCliente_pacote()) {
						System.out.println("Id do cliente: " + c.getId_Cliente());
						System.out.println("Id do pacote viagem : " + c.getId_pacote_viagem());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 3: { // Update cliente_pacote
					Cliente_pacote cliente_pacoteUpdate = new Cliente_pacote();
					System.out.println("Digite o id: ");
					int IdUpdate = entrada.nextInt();
					entrada.nextLine();
					cliente_pacoteUpdate.setId(IdUpdate);
					System.out.println("Digite o id do cliente: ");
					int Id_clienteUpdate = entrada.nextInt();
					entrada.nextLine();
					cliente_pacoteUpdate.setId_Cliente(Id_clienteUpdate);
					System.out.println("Digite o id do pacote viagem ");
					int id_pacote_viagemUpdate = entrada.nextInt();
					cliente_pacoteUpdate.setId_pacote_viagem(id_pacote_viagemUpdate);
					cliente_pacoteDAO.update(cliente_pacoteUpdate);
					System.out.println("Cliente e pacote viagem alterados com sucesso");
					System.out.println();
					break;
				}

				case 4: // Delete cliente pacote
					System.out.println("Digite o ID que deseja deletar: ");
					int idDelete = entrada.nextInt();
					cliente_pacoteDAO.removeById_Cliente_pacote(idDelete);
					System.out.println("Pacote deletado com sucesso!");
					System.out.println();
					break;
				}
				break;

			case 8: {
				// Menu Promocao
				System.out.println("Digite qual opção deseja:");
				System.out.println("1. Cadastrar promoção:");
				System.out.println("2. Exibir promoções:");
				System.out.println("3. Atualizar promoção:");
				System.out.println("4. Deletar promoção:");
				menu = entrada.nextInt();
			}
				switch (menu) {

				case 1: // Create Promocao
					System.out.println("Digite o Id da promoçao: ");
					int id_pacote_viagem = entrada.nextInt();
					promocao.setId_pacote_viagem(id_pacote_viagem);
					entrada.nextLine();
					System.out.println("Digite o novo valor:");
					Float novo_preco = entrada.nextFloat();
					promocao.setNovo_Preco(novo_preco);
					promocaoDAO.salvarPromocao(promocao);
					System.out.println("Novo valor cadastrado com sucesso!");
					System.out.println();
					break;

				case 2: // Read Promocao
					for (Promocao c : promocaoDAO.exibirPromocao()) {
						System.out.println("Id do pacote viagem: " + c.getId_pacote_viagem());
						System.out.println("Valor atualizado com desconto : " + c.getNovo_preco());
					}
					System.out.println("Digite enter para finalizar");
					entrada.nextLine();
					entrada.nextLine();
					break;

				case 3: { // Update promocao
					Promocao promocaoUpdate = new Promocao();
					System.out.println("Digite o id: ");
					int IdUpdate = entrada.nextInt();
					entrada.nextLine();
					promocaoUpdate.setId(IdUpdate);
					System.out.println("Digite o id do pacote viagem: ");
					int Id_pacote_viagemUpdate = entrada.nextInt();
					entrada.nextLine();
					promocaoUpdate.setId_pacote_viagem(Id_pacote_viagemUpdate);
					System.out.println("Digite o novo valor do pacote:");
					float Novo_precoUpdate = entrada.nextFloat();
					promocaoUpdate.setNovo_Preco(Novo_precoUpdate);
					promocaoDAO.update(promocaoUpdate);
					System.out.println("O valor foi alterado com sucesso!");
					System.out.println();
					break;
				}
				case 4: { // Delete promocao
					System.out.println("Digite o ID que deseja deletar: ");
					int idDelete = entrada.nextInt();
					promocaoDAO.removeById_Promocao(idDelete);
					System.out.println("Promocao deletada com sucesso!");
					System.out.println();
					break;
				}
				}	
			 case 0: {
					System.out.println("Agradecemos sua visita!");
					entrada.close();
				}
			 
				}
			}
		}
	}

