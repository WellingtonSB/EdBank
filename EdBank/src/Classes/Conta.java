package Classes;

public class Conta {
	protected int numero;
	protected String cpf;
	private double saldo = 0;
	protected boolean ativa;
	protected int data;

	public Conta() {
		this.saldo = 0;
	}

	public Conta(int numero) {
		this.numero = numero;

		this.saldo = 0;
	}

	public Conta(int numero, String cpf) {
		this.numero = numero;
		this.cpf = cpf;

		this.saldo = 0;
	}

	public Conta(int numero, String cpf, boolean ativa) {
		this.numero = numero;
		this.cpf = cpf;
		this.ativa = ativa;

		this.saldo = 0;
	}

	public void Debito(double valor) {
		if (valor <= saldo) {
			saldo = saldo - valor;
			System.out.println("Transação realizada com sucesso.");
		} else {
			System.out.println("O débito não foi realizado. Valor insuficiente em conta.");
		}
	}

	public void Credito(double valor) {
		saldo = saldo + valor;
		System.out.println("Transação realizada com sucesso.");
	}

	// GetSet
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
}
