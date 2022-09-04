package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Usuario;

public class UsuarioDAO {
    Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuario usuario) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO usuario(nome, senha, email, endereco)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();
			
			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, usuario.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			 pstm.setString(2, usuario.getSenha());
			 // Adicionar o valor do terceiro parâmetro da sql
			 pstm.setString(3, usuario.getEmail());
			 // Adicionar o valor do quarto parâmetro da sql
			 pstm.setString(4, usuario.getEndereco());

			

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

	public void removeById(int id) {

		String sql = "DELETE FROM usuario WHERE id = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
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

	public void update(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, email = ?, dataCadastro = ?" + "WHERE id = ?";

		try {
			// cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// cria um preparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor de primeiro parametro do sql
			pstm.setString(1, usuario.getNome());
			// adiciona o segundo valor do parametro da sql
			pstm.setString(2, usuario.getEmail());
			

			pstm.setInt(4, usuario.getId());

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

	public List<Usuario> getUsuarios() {

		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Usuario usuario = new Usuario();

				// Recupera o id do banco e atribui ele ao objeto
				usuario.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				usuario.setNome(rset.getString("nome"));

				// Recupera a idade do banco e atribui ele ao objeto
				usuario.setEmail(rset.getString("email"));

				

				// Adiciono o usuario recuperado, a lista de usuarios
				usuarios.add(usuario);
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

		return usuarios;
	}

	

}
