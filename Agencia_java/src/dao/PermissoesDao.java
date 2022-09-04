package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Permissoes;

public class PermissoesDao {
    Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Permissoes permissao) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO permissao(id_permissao, tipo)" + " VALUES(?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setInt(1, permissao.getId_permissao());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, permissao.getTipo());
			

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

	public void removeById(int id_permissao) {

		String sql = "DELETE FROM permissao WHERE id_permissao = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_permissao);
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

	public void update(Permissoes permissao) {
		String sql = "UPDATE permissao SET id_permissao = ?, tipo = ?";

		try {
			// cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// cria um preparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor de primeiro parametro do sql
			pstm.setInt(1, permissao.getId_permissao());
			// adiciona o segundo valor do parametro da sql
			pstm.setString(2, permissao.getTipo());
		
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

	public List<Permissoes> getContatos() {

		String sql = "SELECT * FROM permissao";
		List<Permissoes> permissao = new ArrayList<Permissoes>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Permissoes permissoes = new Permissoes();

				// Recupera o id do banco e atribui ele ao objeto
				permissoes.setId_permissao(rset.getInt("id_permissao"));

				// Recupera o tipo do banco e atribui ele ao objeto
				permissoes.setTipo(rset.getString("tipo"));

				

				

				// Adiciono o permissao recuperado, a lista de permissaos
				permissao.addAll(permissao);
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

		return permissao;
	}

	public Permissoes[] getTipo() {
		return null;
	}

}
