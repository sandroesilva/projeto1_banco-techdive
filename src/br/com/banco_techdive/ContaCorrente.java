package br.com.banco_techdive;

public class ContaCorrente extends Conta {
    private double limite;
    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia) {
        super(nome, cpf, rendaMensal, agencia);
        this.limite = (this.getRendaMensal()* 3.5)/100 ;
    }
    public double getLimite(){
        return this.limite;
    }

    @Override
    public boolean saque(double valor){
        if((super.saldo + this.limite) >= valor){
            super.saldo -= valor;
            super.extratoTrasacoes.add("Saque: " + valor + " ----> Saldo atual: " + super.saldo );
            return true;
        }else{
            System.err.println("Valor é maior que o saldo disponivel");
            return false;
        }
    }
}
