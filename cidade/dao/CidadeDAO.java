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
}
