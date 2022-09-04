package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Compras;

public class ComprasDao {
    Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Compras compra) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO compras" + " compras SET id_compra = ?, valor_compra = ?, data_compra = ?";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, compra.getId_compra());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setDouble(2, compra.getValor_compra());
			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setDate(3, compra.getData_compra());
			
			
			

			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id_compra) {

		String sql = "DELETE FROM compras WHERE id_compra = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_compra);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		try {
			if (pstm != null) {

				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void update(Compras compra) {
		String sql = "UPDATE compras SET id_compra = ?, valor_compra = ?, data_compra = ?";

		try {
			// cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// cria um preparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor de primeiro parametro do sql
			pstm.setInt(1, compra.getId_compra());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setDouble(2, compra.getValor_compra());
			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setDate(3, compra.getData_compra());

			// executa a sql para a insercao dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		try {
			if (pstm != null) {

				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<Compras> getCompra() {

		String sql = "SELECT * FROM compras";
		List<Compras> compras = new ArrayList<Compras>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Compras compra = new Compras(0);

				// Recupera o id do banco e atribui ele ao objeto
				compra.setId_compra(rset.getInt("id_compra"));

				

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	
    

}
