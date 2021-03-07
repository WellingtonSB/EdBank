package Classes;

import java.util.*;

public class ContaCorrente extends Conta {

	int contadorTalao = 0;
	Scanner ler = new Scanner(System.in);

	public ContaCorrente() {
		System.out.println("        Painel - Informe os dados da sua conta \n");
		System.out.println("    ========================================== \n");
		System.out.println("              Informe o numero da contas");
		System.out.print("                      (4 digitos):               \n");
		numero = ler.nextInt();
		System.out.println("              Informe o numero do CPF:           ");
		System.out.print("                      (8 digitos):               \n");
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

	public void pedirTalao() {
		System.out.println("          Deseja um talão de cheque ?          \n");
		System.out.println("                 [1]Sim[2]Não                  \n");
		System.out.println("    ========================================== \n");
		int r = ler.nextInt();

		if (r == 1) {
			if (this.contadorTalao < 3) {
				System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
				System.out.println("\t\tTransação realizada com sucesso. ");
				System.out.println("- Número da conta            " + numero);
				System.out.println("- Operação          \t\t\t       cheque");
				System.out.println("- Talões Restantes:          " + (3 - this.contadorTalao));
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				this.contadorTalao = this.contadorTalao + 1;
			} else {
				System.out.println("Limite de talão excedido!");
			}
		}
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
		if (valor <= getSaldo()) {
			super.Debito(valor);
			System.out.println("++++++++++++++++++++++++++ Extrato Conta +++++++++++++++++++++");
			System.out.println("\t\tTransação realizada com sucesso.");
			System.out.println("- Número da conta   \t\t\t " + numero);
			System.out.println("- Movimentação      \t\t\t R$ " + valor);
			System.out.println("- Operação          \t\t\t Saque");
			System.out.println("- Saldo Atual       \t\t\t R$" + getSaldo());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		} else {
			System.out.println("O débito não foi realizado.\n\tValor insuficiente em conta.");
			System.out.println("     ===================================================== ");
		}
	}
}