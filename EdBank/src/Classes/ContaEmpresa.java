package Classes;

import java.util.Scanner;

public class ContaEmpresa extends Conta {
	double emprestimoEmpresa = 0;
	Scanner ler = new Scanner(System.in);

	public ContaEmpresa() {
		System.out.println("");
		System.out.println("        Informe os dados da sua conta \n");
		System.out.println("==========================================================\n");
		System.out.println("              Informe o numero da contas");
		System.out.print("                      (4 digitos):               \n");
		numero = ler.nextInt();
		System.out.println("              Informe o numero do CPF:           ");
		System.out.print("                      (11 digitos):               \n");
		cpf = ler.next();
		System.out.println("              Essa conta esta ativa?           \n");
		System.out.println("              [1]Ativa    [2]Inativa           \n");
		int a = ler.nextInt();
		System.out.println("==========================================================\n");
		if (a == 1)
			ativa = true;
		if (a == 2)
			ativa = false;
		if (ativa)
			OferecerEmprestimo();
	}

	public void OferecerEmprestimo() {
		System.out.println("Emprestimo disponivel, deseja solicitar?\n");
		System.out.println("Digite [1]SIM [2]N�O");
		char emp = ler.next().charAt(0);
		System.out.println("==========================================\n");
		if (emp == '1') {
			System.out.println("Digite o valor: (" + (10000 - emprestimoEmpresa) + " disponiveis.)");
			double novoEmprestimo = ler.nextDouble();
			System.out.println("========================================== \n");
			if (emprestimoEmpresa + novoEmprestimo <= 10000) {
				FazerEmprestimo(novoEmprestimo);
			} else {
				System.out.println("Valor indisponivel. O emprestimo n�o foi realizado.");
				System.out.println("=================================================== \n");
			}
		}
	}

	public void FazerEmprestimo(double valor) {
		emprestimoEmpresa = emprestimoEmpresa + valor;
		Credito(valor);
		System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
		System.out.println("\t\tTransa��o realizada com sucesso.");
		System.out.println("- N�mero da conta   \t\t\t " + numero);
		System.out.println("- Valor da transa��o\t\t\t R$ " + valor);
		System.out.println("- Opera��o          \t\t\t Deposito");
		System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void Debito(double valor) {
		if (valor <= getSaldo()) {
			Debito(valor);
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
			if (emprestimoEmpresa < 10000) {
				OferecerEmprestimo();
				Debito(valor);
			}
		}
	}
}