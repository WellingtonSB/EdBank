package Classes;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
	// Atributos
	Scanner ler = new Scanner(System.in);

	int aniversarioConta = 30;
	boolean correcao = false;

	// Construtores
	public ContaPoupanca() {
		System.out.println("");
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
		System.out.println("              Informe o dia de hoje            \n");
		data = ler.nextInt();
		System.out.println("    ========================================== \n");
		if (a == 1)
			ativa = true;
		if (a == 2)
			ativa = false;
	}

	// Encapsulamento
	public int getAniversarioConta() {
		return aniversarioConta;
	}

	public void setAniversarioConta(int aniversarioConta) {
		this.aniversarioConta = aniversarioConta;
	}

	// Metodos

	@Override
	public void Credito(double valor) {
		// saldo = saldo + valor;
		super.Credito(valor);
		if (getSaldo() > 0) {
			if (data == aniversarioConta && correcao == false) {
				correcao = true;
				System.out.println("");
				System.out.println("\nSua conta acaba de completar mais um mês em nosso banco.");
				System.out.println("\tHaverá uma correção no seu saldo de +0,05%.\n");
				super.Credito((getSaldo() * 0.05));
				System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
				System.out.println("\t\tTransação realizada com sucesso.");
				System.out.println("- Número da conta   \t\t\t " + numero);
				System.out.println("- Valor da transação\t\t\t R$ " + valor);
				System.out.println("- Operação          \t\t\t Saque");
				System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}

		}
	}

	@Override
	public void Debito(double valor) {
		if (valor <= getSaldo()) {
			super.Debito(valor);
			System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
			System.out.println("\t\tTransação realizada com sucesso.");
			System.out.println("- Número da conta   \t\t\t " + numero);
			System.out.println("- Valor da transação\t\t\t R$ " + valor);
			System.out.println("- Operação          \t\t\t Saque");
			System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} else {
			System.out.println("O débito não foi realizado.\n\tValor insuficiente em conta.");
			System.out.println("       ===================================================== ");
		}
	}
}
