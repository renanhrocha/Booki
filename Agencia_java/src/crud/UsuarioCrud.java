package crud;

import java.util.ArrayList;
import java.util.Scanner;

import dao.UsuarioDAO;
import modelo.Usuario;



public class UsuarioCrud {

	public static void main(String[] args) {
		ArrayList<String> agenda = new ArrayList<>();
		int opcao = 0;
		
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		

		do {

			// Menu

			System.out.println("========== Usuarios ========== \n");
			System.out.println("Cadastrar usuario digite 1");
			System.out.println("Excluir usuario digite 2");
			System.out.println("Mostrar usuarios digite 3");
			System.out.println("Atualizar nome do usuario digite 4");
			System.out.println("Para sair digite 5 \n");

			Scanner inputOpcao = new Scanner(System.in);
			opcao = inputOpcao.nextInt();
			
			switch (opcao) {
			case 1:
				// Cadastrar
				Scanner inputEntrada = new Scanner(System.in);
				Usuario usuario = new Usuario();

				System.out.println("Digite o nome do usuario que deseja cadastrar \n");
				usuario.setNome(inputEntrada.next());

				System.out.println("Digite a senha do usuario que deseja cadastrar \n");
				usuario.setSenha(inputEntrada.next());

				System.out.println("Digite o email do usuario que deseja cadastrar \n");
				usuario.setEmail(inputEntrada.next());

				System.out.println("Digite o endereco do usuario que deseja cadastrar \n");
				usuario.setEndereco(inputEntrada.next());
				
				usuarioDao.save(usuario);

				break;

			case 2:
				// Excluir

				System.out.println("Digite o nome que deseja excluir \n");
				
				String nomeExcluir = "";
				Scanner inputExcluir = new Scanner(System.in);
				nomeExcluir = inputExcluir.next();

				if (agenda.contains(nomeExcluir)) {
					agenda.remove(nomeExcluir);
				} else {
					System.out.println("Erro, Nome não existe na agenda \n");
				}

				break;

			case 3:
				// Consultar todos nomes

				System.out.println("Contatos cadastrados \n");
                  
				for (Usuario c : usuarioDao.getUsuarios()) {

                    System.out.println("----------------------------------- ");

					System.out.println("NOME: " + c.getNome());

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
