package qeep.moving.backend.cidade;

import java.sql.*;
import java.util.*;

import qeep.moving.backend.cidade.dao.CidadeDAO;
import qeep.moving.backend.cidade.pojo.Cidade;


public class ExemploJDBC {

	public static void main(String[] args) throws SQLException {
		Scanner teclado = new Scanner(System.in);
		CidadeDAO  cidadeDAO = new CidadeDAO();
		
			int opcaoMenu = 0;

			do {
				System.out.println("\n------------------- MENU CADASTRO DE CIDADES -------------------\n");
				System.out.println("[1] - Cadastrar");
				System.out.println("[2] - Excluir");
				System.out.println("[3] - Listar todas as cidades cadastradas");
				System.out.println("[4] - Consultar cidade por DDD");
				System.out.println("[5] - Consultar cidade pela primeira Letra");
				System.out.println("[6] - Consultar todas as cidades por estado");
				System.out.println("[0] - Para encerrar");
				System.out.print("\nDigite a opção: ");
				opcaoMenu = teclado.nextInt();

				switch (opcaoMenu) {
				case 0:
				break;
				case 1:
					cidadeDAO.insereCidade(teclado);
					break;
				case 2:
					cidadeDAO.removeCidade(teclado);
					break;
				case 3:
					cidadeDAO.ListaTodasAsCidades(teclado);
					break;
				case 4:
					cidadeDAO.retornaCidadeDdd(teclado);
					break;
				case 5:
					cidadeDAO.retornaCidadePrimeiraLetra(teclado);
					break;
				//case 5:
					//cidadeDAO.retornaCidadePrimeiraLetra(teclado);
					//break;
				case 6:
					cidadeDAO.retornaCidadeEstado(teclado);
					break;
				default:
					System.out.println("Opção inválida!");
					break;
				}
			} while (opcaoMenu != 0);
			System.out.println("\nPrograma encerrado, Obrigado...");

		}
	}
	
	


