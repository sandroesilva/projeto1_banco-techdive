package br.com.banco_techdive;

import java.util.ArrayList;

//lebrar de colocar abstract
public abstract class Conta {
    private String nome;
    private String cpf;
    private double rendaMensal;
    private int numConta = 0;
    private String agencia;
    protected double saldo = 0;
    protected ArrayList<String> extratoTrasacoes = new ArrayList<>();
    private static int total = 0;


    public Conta(String nome, String cpf, double rendaMensal, String agencia) {
        Conta.total++;
        this.nome = nome;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.numConta = total;
        this.agencia = agencia;
    }

    public boolean saque(double valor) {
        if (this.saldo > valor) {
            this.saldo -= valor;
            extratoTrasacoes.add("Saque: " + valor + " -------> Saldo atual: " + this.saldo);
            return true;
        } else {
            System.err.println("Valor é maior que o saldo disponivel");
            return false;
        }
    }

    public void deposita(double valor) {
        this.saldo += valor;
        extratoTrasacoes.add("Deposito: " + valor + " -----> Saldo atual: " + this.saldo);
//        trasacoes.adiciona("Deposito: " + valor + " -----> Saldo atual: " + this.saldo this);
    }

    public void extrato() {
        System.out.println("Titular da conta: " + this.nome + "\n" + "Numero da conta: " + this.numConta + " segue extrato: ");
        for (String model : extratoTrasacoes) {
            System.out.println(model);
        }
    }

    public void transferir(double valor, Conta destino) {
        this.saque(valor);
        destino.deposita(valor);
    }

    public void alteraDadosCadastrais(String nome, double rendaMensal, String agencia) {
        this.nome = nome;
        this.rendaMensal = rendaMensal;
        this.agencia = agencia;

    }


    public boolean validaCpf(String cpf) {
        cpf = cpf.trim().replace(".", "").replace("-", "");

        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaAgencia(String agencia) {
        if (agencia == "001" || agencia == "002")
            return true;
        return false;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", agencia='" + agencia + '\'' +
                '}';
    }

    public double getRendaMensal() {
        return this.rendaMensal;
    }

    public void getSimulador(int meses, double rentabilidade) {

    }


}
