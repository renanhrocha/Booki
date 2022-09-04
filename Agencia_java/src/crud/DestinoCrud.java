package crud;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DestinoDao;
import modelo.Destino;

public class DestinoCrud {

	public static void main(String[] args) {
		ArrayList<String> agenda = new ArrayList<>();
		int opcao = 0;
		DestinoDao destinoDao = new DestinoDao();
		Destino destino = new Destino();

		do {

			// Menu

			System.out.println("========== Destino ========== \n");
			System.out.println("Cadastrar destino digite 1");
			System.out.println("Excluir destino digite 2");
			System.out.println("Mostrar destinos digite 3");
			System.out.println("Atualizar nome do destino digite 4");
			System.out.println("Para sair digite 5 \n");

			Scanner inputOpcao = new Scanner(System.in);
			opcao = inputOpcao.nextInt();

			switch (opcao) {
			case 1:
				// Cadastrar

				System.out.println("Digite o nome do destino que deseja cadastrar \n");
				
				Scanner inputNome = new Scanner(System.in);
				
				destino.setLocal_destino(inputNome.next());
				destinoDao.save(destino);

				break;

			case 2:
				// Excluir

				System.out.println("Digite o destino que deseja excluir \n");
				
				String nomeExcluir = "";
				Scanner inputExcluir = new Scanner(System.in);
				nomeExcluir = inputExcluir.next();

				if (destino.contains(nomeExcluir)) {
					destino.remove(nomeExcluir);
				} else {
					System.out.println("Erro, destino não existe  \n");
				}

				break;

			case 3:
				// Consultar todos nomes

				System.out.println("Contatos cadastrados \n");
                  
				for (Destino c : destinoDao.getDestinos()) {

                    System.out.println("----------------------------------- ");

					System.out.println("NOME: " + c.getLocal_destino());

					System.out.println("----------------------------------- ");
				}
				
				break;

			

			case 4:
				// Atualizar

				System.out.println("Digite o nome que deseja atualizar \n");
				
				String nomeAtualizar = "";
				Scanner inputAtualizar = new Scanner(System.in);
				nomeAtualizar = inputAtualizar.next();

				System.out.println("Digite o novo nome \n");
				
				String novoNome = "";
				Scanner inputNovoNome = new Scanner(System.in);
				novoNome = inputNovoNome.next();

				for (int i = 0; i < agenda.size(); i++) {

					if (agenda.get(i).equals(nomeAtualizar)) {

						agenda.set(i, novoNome);
					}
				}

				break;

			case 5:
				// Sair

				System.out.println("Você saiu da agenda!");
				break;

			default:
				System.out.println("Erro, digite uma opção valida \n");
				break;
			}

		} while (opcao != 6);

	}
}
