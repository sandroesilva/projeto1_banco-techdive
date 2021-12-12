package br.com.banco_techdive;

public class ContaInvestimento extends Conta {
    private int tipoInvestimeto;
    private double valorInvestido;
    public ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia,int tipoInvestimeto) {
        super(nome, cpf, rendaMensal, agencia);
        this.tipoInvestimeto = tipoInvestimeto;
    }



    @Override
    public void getSimulador(int meses, double rentabilidade){
        if(this.tipoInvestimeto == 1){
            double calc = (super.saldo*30)/100;
            System.out.println("Seu rendimento em um ano sera de R$" + calc +" com seu atual saldo");
        }else if(this.tipoInvestimeto == 2){
            double calc = (super.saldo*10)/100;
            System.out.println("Seu rendimento em um ano sera de R$" + calc +" com seu atual saldo");
        }else{
            System.err.println("Ainda nao escolheu um tipo de investimento");
        }
    }
}
