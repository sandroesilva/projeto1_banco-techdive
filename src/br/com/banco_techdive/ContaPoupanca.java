package br.com.banco_techdive;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
    }
    public void getSimulador(int meses,double rentabilidade){
        double renta = rentabilidade / 12;
        renta *= meses;
        double calc = (super.saldo*renta)/100;
        System.out.println("Seu rendimento em " + meses + " meses sera de R$" + calc +" com seu atual saldo");
    }
}
