package Classes;

import java.util.Scanner;

public class ContaEspecial extends Conta {

      double LimiteEspecial = 1000;
    Scanner s = new Scanner(System.in);
    public ContaEspecial() {

    System.out.println("Logue na sua conta.");
    System.out.println("Digite o numero da sua conta:");
    numero = s.nextInt();
    System.out.println("Digite o seu CPF: ");
    cpf = s.next();
    System.out.println("Essa conta esta ativa?");
    System.out.println();
    System.out.println("[1]Ativa[2]inativa");
    char c = s.next().charAt(0);
    if(c == 1) ativa = true;
    if(c == 2) ativa = false;




     }
    @Override
    public void Debito(double valor) {
        if(getSaldo() - valor >=0) {

            super.Debito(valor);
        }
        else {

            if(getSaldo() + LimiteEspecial > valor) {
                System.out.println("Saldo insuficiente...");
                System.out.println("...usando limite");
                System.out.print(LimiteEspecial);

                UsarLimite(valor);
                System.out.println("==>"+LimiteEspecial);

                Debito(valor);
            }

            else {
                System.out.println(" Saldo e limete insuficiente ");
            }


        }
    }



        public void UsarLimite(double valor) {
            double restante = valor - getSaldo();
            super.Credito(restante);
            LimiteEspecial = LimiteEspecial - restante;

        }
}
