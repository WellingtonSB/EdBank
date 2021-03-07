package Application;

import java.util.Scanner;
import Classes.Conta;
import Classes.ContaPoupanca;
import Classes.ContaCorrente;
import Classes.ContaEspecial;
import Classes.ContaEmpresa;
import Classes.ContaEstudantil;

public class Main {
	public static void main(String[] args) {
		Conta conta = new Conta();
		int opcao = 0;
		int acao = 0;
		double valor;
		int mov = 0;
		String variedade = "";

		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Banco Edbank");
			System.out.println("*Slogan*");
			System.out.println();
			System.out.println("1 - CONTA POUPANÇA");
			System.out.println("2 - CONTA CORRENTE");
			System.out.println("3 - CONTA ESPECIAL");
			System.out.println("4 - CONTA EMPRESA");
			System.out.println("5 - CONTA ESTUDANTIL");
			System.out.println("6 - SAIR");
			System.out.println();
			System.out.print("DIGITE O CÓDIGO DA OPÇÃO SELECIONADA: ");
			opcao = s.nextInt();
			if (opcao == 1)////////////////////////////////////// CONTA/POUPANÇA///////////////////////////////////////////
			{
				conta = new ContaPoupanca();
				variedade = "POUPANÇA";
			} else if (opcao == 2)////////////////////////////////////// CONTA/CORRENTE///////////////////////////////////////////
			{
				conta = new ContaCorrente();
				variedade = "CORRENTE";
			} else if (opcao == 3)////////////////////////////////////// CONTA/ESPECIAL///////////////////////////////////////////
			{
				conta = new ContaEspecial();
				variedade = "ESPECIAL";
			} else if (opcao == 4)////////////////////////////////////// CONTA/EMPRESA////////////////////////////////////////////
			{
				conta = new ContaEmpresa();
				variedade = "EMPRESA";
			} else if (opcao == 5)////////////////////////////////////// CONTA/ESTUDANTIL/////////////////////////////////////////
			{
				conta = new ContaEstudantil();
				variedade = "ESTUDANTIL";
			} else {
				conta = new Conta();
			}
			do {
				mov = mov + 1;
				System.out.println("Banco Edbank");
				System.out.println("*Slogan*");
				System.out.println();
				System.out.println("CONTA " + variedade);
				System.out.println("Saldo Atual: " + conta.getSaldo());
				System.out.print("MOVIMENTO : 1-Debito ou 2-Credito: ");
				acao = s.nextInt();
				if (acao == 1 || acao == 2) {
					System.out.print("Valor do movimento: R$");
					valor = s.nextInt();
					if (acao == 1) {
						conta.Debito(valor);
					} else if (acao == 2) {
						conta.Credito(valor);
					}
				} else {
					System.out.println("Erro, entrada inválida.");
					mov = mov - 1;
				}
				System.out.print("Continuar S/N:");
				var mais = s.next().toUpperCase().charAt(0);
				if (mais == 'N') {
					mov = 10;
				}
			} while (mov < 10);
			if (opcao == 2) {
				((ContaCorrente) conta).pedirTalao();
			}
		} while (opcao != 6);
	}
}