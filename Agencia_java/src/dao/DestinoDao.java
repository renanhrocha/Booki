package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Destino;

public class DestinoDao {
    Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO destino (local_destino, valor_destino, data_destino)" + " VALUES(?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, destino.getLocal_destino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setFloat(2, destino.getValor_destino());
			// Adicionar o valor do terceiro parâmetro da sql
			pstm.setDate(3, destino.getData_destino());
			
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

	public void removeById(int id_destino) {

		String sql = "DELETE FROM destino WHERE id_destino = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_destino);
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

	public void update(Destino destino) {
		String sql = "UPDATE destino SET local_destino = ?, valor_destino = ?, data_destino = ?" + "WHERE id_destino = ?";

		try {
			// cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// cria um preparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// adiciona o valor de primeiro parametro do sql
			pstm.setString(1, destino.getLocal_destino());
			// adiciona o segundo valor do parametro da sql
			pstm.setFloat(2, destino.getValor_destino());
			// adiciona o terceiro valor do parametro da sql
			pstm.setDate(3, destino.getData_destino());
			// adiciona o id
			pstm.setInt(4, destino.getId_destino());

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

	public List<Destino> getDestinos() {

		String sql = "SELECT * FROM destino";
		List<Destino> destinos = new ArrayList<Destino>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Destino destino = new Destino();

				// Recupera o id do banco e atribui ele ao objeto
				destino.setId_detino(rset.getInt("id_destino"));

				// Recupera o local do banco e atribui ele ao objeto
				destino.setLocal_destino(rset.getString("local_destino"));

				// Recupera o valor do banco e atribui ele ao objeto
				destino.setValor_destino(rset.getFloat("valor_destino"));

				// Recupera a data do banco e atribui ele ao objeto
				destino.setData_destino(rset.getDate("data_destino"));

				

				// Adiciono o destino recuperado, a lista de destinos
				destinos.add(destino);
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

		return destinos;
	}

}
