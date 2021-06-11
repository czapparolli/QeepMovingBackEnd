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
				default:
					System.out.println("Opção inválida!");
					break;
				}
			} while (opcaoMenu != 0);
			System.out.println("\nPrograma encerrado, Obrigado...");

		}
	}
	
	


