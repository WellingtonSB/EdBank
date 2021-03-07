package Classes;

import java.util.Scanner;

public class ContaEmpresa extends Conta {
	double emprestimoEmpresa = 0;
	Scanner s = new Scanner(System.in);

	public ContaEmpresa() {
		System.out.println("Logue na sua conta.");
		System.out.println("Digite o numero da sua conta:");
		numero = s.nextInt();
		System.out.println("Digite o seu CPF: ");
		cpf = s.next();
		System.out.println("Essa conta esta ativa?");
		System.out.println();
		System.out.println("[1]Ativa[2]inativa");
		int a = s.nextInt();
		if (a == 1)
			ativa = true;
		if (a == 2)
			ativa = false;
		OferecerEmprestimo();
	}

	public void OferecerEmprestimo() {
		System.out.println("Você gostaria de um empréstimo ? ");
		var emp = s.next().toLowerCase().charAt(0);
		if (emp == 's') {
			System.out.println("...de quanto ? (" + (10000 - emprestimoEmpresa) + " disponível)");
			double novoEmprestimo = s.nextDouble();
			if (emprestimoEmpresa + novoEmprestimo <= 10000) {
				FazerEmprestimo(novoEmprestimo);
			} else {
				System.out.println("Valor indisponivel. O emprestimo não foi realizado.");
			}
		}
	}

	public void FazerEmprestimo(double valor) {
		emprestimoEmpresa = emprestimoEmpresa + valor;
		Credito(valor);
		System.out.println("Emprestimo de " + valor + " realizado.");
	}

	@Override
	public void Debito(double valor) {
		if (valor <= getSaldo()) {
			Debito(valor);
			System.out.println("Transação realizada com sucesso.");
		} else {
			System.out.println("O débito não foi realizado. Valor insuficiente em conta.");
			if (emprestimoEmpresa < 10000) {
				OferecerEmprestimo();
				Debito(valor);
			}
		}
	}
}