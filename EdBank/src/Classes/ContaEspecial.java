package Classes;

import java.util.Scanner;

public class ContaEspecial extends Conta {

	double limiteEspecial = 1000;
	Scanner ler = new Scanner(System.in);

	public ContaEspecial() {

		System.out.println("        Painel - Informe os dados da sua conta \n");
		System.out.println("    ========================================== \n");
		System.out.println("              Informe o numero da contas");
		System.out.print("                      (4 digitos):               \n");
		numero = ler.nextInt();
		System.out.println("              Informe o numero do CPF:           ");
		System.out.print("                      (11 digitos):               \n");
		cpf = ler.next();
		System.out.println("              Essa conta esta ativa?           \n");
		System.out.println("              [1]Ativa    [2]Inativa           \n");
		int a = ler.nextInt();
		System.out.println("    ========================================== \n");
		if (a == 1)
			ativa = true;
		if (a == 2)
			ativa = false;

	}

	@Override
	public void Credito(double valor) {
		super.Credito(valor);

		System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
		System.out.println("\t\tTransação realizada com sucesso.");
		System.out.println("- Número da conta   \t\t\t " + numero);
		System.out.println("- Movimentação      \t\t\t R$ " + valor);
		System.out.println("- Operação          \t\t\t Saque");
		System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	}

	@Override
	public void Debito(double valor) {
		double saldoAtual = getSaldo();

		if (valor <= saldoAtual) {
			super.Debito(valor);
		}

		if (valor > saldoAtual) {
			double limiteNecessario = valor - saldoAtual;
			if (limiteNecessario > limiteEspecial) {
				System.out.println("Transação não realizada.Saldo e limite insuficientes.");
				System.out.println("===================================================== \n");
				return;
			}

			if (saldoAtual > 0) {
				System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
				System.out.println("\t\tTransação realizada com sucesso.");
				System.out.println("- Número da conta   \t\t\t " + numero);
				System.out.println("- Movimentação      \t\t\t R$ " + saldoAtual);
				System.out.println("- Operação          \t\t\t Saque");
				System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				super.Debito(saldoAtual);
			}

			usarLimite(limiteNecessario);
		}
	}

	public void usarLimite(double valor) {
		System.out.println("Valor insuficiente em conta, o valor solicitado será retirado do limite especial.");
		System.out.println();
		System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
		System.out.println("\t\tTransação realizada com sucesso.");
		System.out.println("- Número da conta   \t\t\t " + numero);
		System.out.println("- Movimentação      \t\t\t R$ " + valor);
		System.out.println("- Limite Restante   \t\t\t R$:" + (limiteEspecial-valor));
		System.out.println("- Operação          \t\t\t Saque");
		System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		limiteEspecial = limiteEspecial - valor;
		
	}
}
