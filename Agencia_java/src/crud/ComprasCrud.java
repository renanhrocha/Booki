package crud;

import java.util.Scanner;

import dao.ComprasDao;
import modelo.Compras;

public class ComprasCrud {

	public static  void main(String[] args) {
		ComprasDao compraDao = new ComprasDao() ;
		
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		int posicao = 0;
		int id_compra ;
		

		
		

		do {
			System.out.println("=== CRUD Compras ===");
			System.out.println("1 - Cadastrar compra");
			System.out.println("2 - Consultar compra");
			System.out.println("3 - Atualizar compra");
			System.out.println("4 - Deletar compra");
			System.out.println("0 - Sair");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				// CREATE
				System.out.println("Digite o id_compra : ");
				id_compra = s.nextInt();
				
				Compras c1 = new Compras(id_compra, null, null);
				
				compraDao.save(c1);
				
				System.out.println("\n***  Cadastrou  ***\n");

				break;
			case 2:
				// READ
				for (Compras a : compraDao.getCompra()) {
					System.out.println("Id: " + a.getId_compra() + " Valor: " + a.getValor_compra());
				}
				
				System.out.println("Consultou");
				break;
			case 3:
				// UPDATE
				
				s.nextLine();
				System.out.println("Digite o id da compra : ");
				id_compra = s.nextInt();
				
				Compras c2 = new Compras(id_compra);
			
				compraDao.update(c2);
	
				System.out.println("atualizou");
				break;
			case 4:
				// DELETE
				System.out.println("Digite o id da compra: ");
				posicao = s.nextInt();
				
				compraDao.removeById(1);
				
				break;
			case 5:
			default:
				System.out.println(opcao != 0 ? "opção invalida, digite novamente." : "");
				break;

			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();
	}
}