package Classes;

import java.util.Scanner;

public class ContaEstudantil extends Conta {

	double emprestimoEstudantil = 0;
	Scanner ler = new Scanner(System.in);

	public ContaEstudantil() {
		System.out.println("        Painel - Informe os dados da sua conta \n");
		System.out.println("    ========================================== \n");
		System.out.println("              Digite o numero da sua conta:    \n");
		numero = ler.nextInt();
		System.out.println("              Digite o seu CPF:                \n");
		cpf = ler.next();
		System.out.println("              Essa conta esta ativa?           \n");
		System.out.println("              [1]Ativa    [2]Inativa           \n");
		int a = ler.nextInt();
		System.out.println("    ========================================== \n");
		if (a == 1)
			ativa = true;
		if (a == 2)
			ativa = false;

		solicitarEmprestimo();
	}

	private void solicitarEmprestimo() {
		System.out.println("     Voc� gostaria de um empr�stimo ?          \n");
		System.out.println("                [1]Sim [2]N�o                  \n");
		System.out.println("    ========================================== \n");
		var emp = ler.nextInt();
		if (emp == 1) {

			System.out.println(" Digite o valor do empr�stimo: (" + (5000 - emprestimoEstudantil) + " dispon�vel)");
		}
		double novoEmprestimo = ler.nextDouble();
		System.out.println("========================================================================");
		if (emprestimoEstudantil + novoEmprestimo <= 5000) {
			fazerEmprestimo(novoEmprestimo);
		} else {
			System.out.println("Valor indispon�vel. N�o foi poss�vel realizar o empr�stimo.");
			System.out.println("");
			System.out.println("========================================================================");
		}
	}

	public void fazerEmprestimo(double valor) {
		emprestimoEstudantil = emprestimoEstudantil + valor;
		Credito(valor);
	}

	@Override
	public void Credito(double valor) {
		super.Credito(valor);
		System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
		System.out.println("\t\tTransa��o realizada com sucesso.");
		System.out.println("- N�mero da conta   \t\t\t " + numero);
		System.out.println("- Movimenta��o      \t\t\t R$ " + valor);
		System.out.println("- Opera��o          \t\t\t Saque");
		System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void Debito(double valor) {
		if (valor <= getSaldo()) {
			super.Debito(valor);
			System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
			System.out.println("\t\tTransa��o realizada com sucesso.");
			System.out.println("- N�mero da conta   \t\t\t " + numero);
			System.out.println("- Movimenta��o      \t\t\t R$ " + valor);
			System.out.println("- Opera��o          \t\t\t Saque");
			System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} else {
			System.out.println("O d�bito n�o foi realizado.\n\tValor insuficiente em conta.");
			System.out.println("     ===================================================== ");
			if (emprestimoEstudantil < 5000) {
				solicitarEmprestimo();
				super.Debito(valor);
			}
		}
	}

}