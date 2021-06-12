package qeep.moving.backend.cidade.dao;

import java.sql.*;

import qeep.moving.backend.cidade.factory.*;
import qeep.moving.backend.cidade.pojo.Cidade;
import java.util.*;

public class CidadeDAO {

	private Connection conn;

	public CidadeDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}

	public void insereCidade(Scanner teclado) throws SQLException {

		int ddd = 0;
		String nome = "";
		float nro_habitantes = 0F;
		float renda_per_capita = 0F;
		String estado = "";
		int testeCapital = 0;
		boolean capital = false;
		String nome_prefeito = "";

		System.out.println("\nVamos cadastrar uma cidade...");

		while (ddd == 0 || ddd >= 100 || ddd < 0) {
			System.out.print("\nDigite o número do DDD ");
			ddd = teclado.nextInt();
			if (ddd == 0 || ddd >= 100 || ddd < 0) {
				System.out.println("\nDDD inválido, digite novamente...");
			}
		}
		teclado.nextLine();
		while (nome.equals(null) || nome.equals("")) {
			System.out.print("\nDigite o nome da cidade: ");
			nome = teclado.nextLine();

			if (nome.equals(null) || nome.equals("")) {
				System.out.println("\nNome da cidade em branco, digite novamente...");
			}

		}

		while (nro_habitantes == 0) {
			System.out.print("\nDigite o número aproximado de habitantes ");
			nro_habitantes = teclado.nextInt();
			if (nro_habitantes <= 0) {
				System.out.println("\nNúmero de habitantes inválido, digite novamente...");
			}
		}

		while (renda_per_capita == 0) {
			System.out.print("\nDigite o número da renda per capita ");
			renda_per_capita = teclado.nextInt();
			if (renda_per_capita <= 0) {
				System.out.println("\nNúmero de renda inválido, digite novamente...");
			}
		}

		while (testeCapital == 0) {
			System.out.print("\nA cidade digita é a Capital? Digite 2 para SIM e 1 para NÃO ");
			testeCapital = teclado.nextInt();
			if (testeCapital == 2) {
				capital = true;
			} else {
				capital = false;
			}
		}

		teclado.nextLine();

		while (estado.equals(null) || estado.equals("")) {
			System.out.print("\nDigite a sigla do estado:  ");
			estado = teclado.nextLine();

			if (estado.equals(null) || estado.equals("")) {
				System.out.println("\nNome da cidade em branco, digite novamente...");
			}

		}
		while (nome_prefeito.equals(null) || nome_prefeito.equals("")) {
			System.out.print("\nDigite o nome do prefeito da cidade: ");
			nome_prefeito = teclado.nextLine();

			if (nome_prefeito.equals(null) || nome_prefeito.equals("")) {
				System.out.println("\nNome do prefeito em branco, digite novamente...");
			}

		}

		String sql = "INSERT INTO public.cidade"
				+ "(ddd, nome, nro_habitantes, renda_per_capita, capital, estado, nome_prefeito)" + "VALUES" + "('"
				+ ddd + "','" + nome + "','" + nro_habitantes + "','" + renda_per_capita + "','" + capital + "','"
				+ estado + "','" + nome_prefeito + "')";

		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.execute();
		stmt.close();

	}

	public void removeCidade(Scanner teclado) throws SQLException {
		System.out.println("\nVamos excluir uma cidade...\n");
		System.out.print("Digite o DDD da cidade para excluir: ");
		int ddd = teclado.nextInt();

		String sql = "delete from public.cidade where ddd = " + ddd;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();
		int resultado = stmt.executeUpdate();
		stmt.close();

		if (resultado > 0) {
			System.out.println("\nDados atualizados na tabela");
			System.out.println("\nCidade excluida da tabela com sucesso !");

		} else {
			System.out.println("\nFalha ao excluir Cidade, DDD digitado não existe !");
		}

	}

	public void retornaCidadeDdd(Scanner teclado) throws SQLException {

		System.out.println("\nMENU DE CONSULTA DE CIDADE POR DDD");
		teclado.nextLine();
		System.out.print("\nDigite o número do DDD ");
		int ddd = teclado.nextInt();
		String sqlConsulta = "SELECT nome FROM public.cidade where ddd = '" + ddd + "'\n";
		PreparedStatement stmConsulta = conn.prepareStatement(sqlConsulta);
		ResultSet result = stmConsulta.executeQuery();
		System.out.println("\n--------------- CONSULTANDO DADOS DAS CIDADES ---------------");
		if (result.next()) {
			result = stmConsulta.executeQuery();
			while (result.next()) {

				System.out.printf("\n| Nome da cidade: %s | \n", result.getString("nome"));
			}
		} else {
			System.out.println("\n DDD da cidade não encontrado, tente novamente !");
		}

	}

	public void retornaCidadeEstado(Scanner teclado) throws SQLException {

		System.out.println("\nMENU DE CONSULTA DE CIDADEs POR ESTADO");
		teclado.nextLine();
		System.out.print("\nDigite a sigla do estado:  ");
		String estado = teclado.nextLine();
		String sqlConsulta = "SELECT nome FROM public.cidade where estado like '" + estado + "'\n";
		PreparedStatement stmConsulta = conn.prepareStatement(sqlConsulta);
		ResultSet result = stmConsulta.executeQuery();
		System.out.println("\n--------------- CONSULTANDO DADOS DAS CIDADES ---------------");
		if (result.next()) {
			result = stmConsulta.executeQuery();
			while (result.next()) {

				System.out.printf("\n| Nome da cidade: %s | \n", result.getString("nome"));
			}
		} else {
			System.out.println("\n Sigla do estado não encontrado, tente novamente !");
		}

	}
	
	public void retornaCidadePrimeiraLetra(Scanner teclado) throws SQLException {

		System.out.println("\nMENU DE CONSULTA DE CIDADES POR PRIMEIRA LETRA");
		teclado.nextLine();
		System.out.print("\nDigite a primeira letra da cidade:  ");
		String letra = teclado.nextLine();
		String sqlConsulta = "SELECT nome FROM public.cidade where estado ilike '" + letra + "%'\n";
		PreparedStatement stmConsulta = conn.prepareStatement(sqlConsulta);
		ResultSet result = stmConsulta.executeQuery();
		System.out.println("\n--------------- CONSULTANDO DADOS DAS CIDADES ---------------");
		if (result.next()) {
			result = stmConsulta.executeQuery();
			while (result.next()) {

				System.out.printf("\n| Nome da cidade: %s | \n", result.getString("nome"));
			}
		} else {
			System.out.println("\n Letra inicial da cidade não encontrada, tente novamente !");
		}

	}
	public void ListaTodasAsCidades(Scanner teclado) throws SQLException {

		String sqlConsulta = "SELECT *  FROM public.cidade order by ddd";
		PreparedStatement stmConsulta = conn.prepareStatement(sqlConsulta);
		ResultSet result = stmConsulta.executeQuery();
		System.out.println("\n--------------- LISTANDO TODOS OS DADOS DAS CIDADES ---------------");
		if (result.next()) {
			result = stmConsulta.executeQuery();
			while (result.next()) {
				String str = "";
				Boolean capital = result.getBoolean("capital");
				if(capital.equals(true)) {
					str = "Sim";
				}
				else {
					str = "Não";
				}
				System.out.printf("\n|DDD: %d | Nome da cidade: %s | Habitantes: %.0f | Renda per capita: %.0f | capital: '"+str+"' |Estado: %s | Nome do prefeito: %s | \n",
						result.getInt("ddd"), result.getString("nome"),result.getFloat("nro_habitantes"),result.getFloat("renda_per_capita"),result.getString("estado"), result.getString("nome_prefeito"));
			}
		} else {
			System.out.println("\n Letra inicial da cidade não encontrada, tente novamente !");
		}

	}

}
