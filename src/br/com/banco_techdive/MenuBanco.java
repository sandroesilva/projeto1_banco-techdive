package br.com.banco_techdive;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuBanco {
    List<Conta> listaContas = new ArrayList<>();
    List<String> trasacoes = new ArrayList<>();
    List<Double> investimento = new ArrayList<>();
    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public boolean showCadastrasConta() {
        int opcao  ;
        boolean constOp = false;
        Scanner ler1 = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("===  Conta  tipo ===");
        System.out.println("Deseja cadastrar qual tipo de conta: ");
        System.out.println("1 - Conta Corrente" + "\n"+
                           "2 - Conta Poupança" + "\n"+
                           "3 - Conta Investimo");
        System.out.print("Digite a opcao desejada: ");
        opcao =(int) lerValor();


        if(opcao == 1){

            Scanner ler2 = new Scanner(System.in);
            Scanner ler3 = new Scanner(System.in);
            Scanner ler4 = new Scanner(System.in);
            Scanner ler5= new Scanner(System.in);
            String nome;
            String cpf;
            double rendaMensal;
            String agencia;
            int agenciaInt;
            System.out.println("\n");
            System.out.println("=== Conta Corrente===");
            System.out.println("Solicite os dados abaixo ao Cliente");
            System.out.print("Nome:");
            nome = lerString();
            Validador validador =new Validador();
            boolean validado ;
            do{
               System.out.print("CPF: ");
               cpf = lerString();
               validado = validador.validaCpf(cpf);
            }while(validado);
            System.out.print("Renda Mensal: ");
            rendaMensal = lerValor();
            do{
                System.out.print("Agencia: ");
                agencia = lerString();
                agenciaInt = Integer.parseInt(agencia);
                validado = validador.validaAgencia(agenciaInt);

            }while(validado);
            Conta conta = new ContaCorrente(nome,cpf,rendaMensal,agencia);

            listaContas.add(conta);

            System.out.println("Conta do Cliente " + nome + " criada com sucesso!!!");
//            controller.criaContaCorrente(nome,cpf,rendaMensal,agencia);
        }else if(opcao == 2){
            Scanner ler2 = new Scanner(System.in);
            Scanner ler3 = new Scanner(System.in);
            Scanner ler4 = new Scanner(System.in);
            Scanner ler5 = new Scanner(System.in);

            String nome;
            String cpf;
            double rendaMensal;
            String agencia;
            int agenciaInt;
            System.out.println("\n");
            System.out.println("=== Conta Poupança ===");
            System.out.println("Solicite os dados abaixo ao Cliente");
            System.out.print("Nome:");
            nome = lerString();
            Validador validador =new Validador();
            boolean validado ;
            do{
                System.out.print("CPF: ");
                cpf = lerString();
                validado = validador.validaCpf(cpf);
            }while(validado);
            System.out.print("Renda Mensal: ");
            rendaMensal = lerValor();
            do{
                System.out.print("Agencia: ");
                agencia = lerString();
                agenciaInt = Integer.parseInt(agencia);
                validado = validador.validaAgencia(agenciaInt);

            }while(validado);

            Conta conta = new ContaPoupanca(nome,cpf,rendaMensal,agencia);
            listaContas.add(conta);
            System.out.println("Conta do Cliente " + nome + " criada com sucesso!!! pounca");

        }else if(opcao == 3 ){
            String nome;
            String cpf;
            double rendaMensal;
            String agencia;
            int agenciaInt;
            int tipoInvestimento;
            System.out.println("\n");
            System.out.println("===  Conta ===");
            System.out.println("Solicite os dados abaixo ao Cliente");
            System.out.print("Nome:");
            nome = lerString();
            Validador validador =new Validador();
            boolean validado ;
            do{
                System.out.print("CPF: ");
                cpf = lerString();
                validado = validador.validaCpf(cpf);
            }while(validado);
            System.out.print("Renda Mensal: ");
            rendaMensal = lerValor();
            do{
                System.out.print("Agencia: ");
                agencia = lerString();
                agenciaInt = Integer.parseInt(agencia);
                validado = validador.validaAgencia(agenciaInt);

            }while(validado);
            System.out.print("Tipo de investimento: ");
            tipoInvestimento = (int) lerValor();
            System.out.print("Valor a investir: ");
            double valorInvestido = lerValor();
            switch (tipoInvestimento) {
                case 1: System.out.println("Rende 30% ao ano"); break;
                case 2: System.out.println("Rende 10% ao ano"); break;
            }
            Conta conta = new ContaInvestimento(nome,cpf,rendaMensal,agencia,tipoInvestimento);
            conta.setSaldo(valorInvestido);
            investimento.add(valorInvestido);
            listaContas.add(conta);
            System.out.println("Conta do Cliente " + nome + " criada com sucesso!!!");

        }





        return true;
    }

    public boolean showSaque(){
        int numConta;
        double valor;
        System.out.println("\n");
        System.out.println("=== Saque ===");
        System.out.print("Numero da conta:");
        numConta = (int)lerValor();
        System.out.print("Valor a sacar:" );
        valor = lerValor();
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta.saque(valor);

        }

        trasacoes.add("SAQUE ----> Numero da Conta: " + numConta + " Valor: " + valor + " Data " + dateTimeFormat.format(LocalDateTime.now()));
        System.out.println("Saque  efetuado com sucesso");
        System.out.println("\n");
        return  true;

    }
    public double lerValor(){
        Scanner ler1 =new Scanner(System.in);
        while(true) {
            try{
                return  Double.parseDouble(ler1.nextLine().replace(",", "."));

            }catch (Exception e){
                System.out.println("formato invalido");
                System.out.print(" digite novamente:");

            }
        }

    }
    public String lerString(){
        Scanner ler1 =new Scanner(System.in);

        while(true) {
            String  string = ler1.nextLine();
            if(string.isEmpty()){
                System.out.println("formato invalido");
                System.out.print(" digite novamente:");
            }else{
                return string;
            }

        }

    }

    public boolean showDeposito() {
        int numConta;
        double valor;
        System.out.println("\n");
        System.out.println("=== Deposito ===");
        System.out.print("Numero da conta:");
        numConta =(int) lerValor();
        System.out.print("Valor a depositar:" );
        valor = (int) lerValor();
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta.deposita(valor);

        }
        trasacoes.add("DEPOSITO ----> Numero da Conta: "+numConta+" Valor: "+ valor+ " Data " + dateTimeFormat.format(LocalDateTime.now()));
        System.out.println("Deposito efetuado com sucesso");

        return true;
    }
    public boolean showSaldo(){
        int numConta;
        System.out.println("\n");
        System.out.println("=== Saldo ===");
        System.out.print("Numero da conta:");
        numConta = (int)lerValor();
        System.out.print("O saldo da conta ---> ");
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                System.out.print(conta.getSaldo());

        }


        return true;
    }
    public boolean showExtrato(){
        int numConta;
        System.out.println("\n");
        System.out.println("=== Extrato ===");
        System.out.print("Numero da conta:");
        numConta = (int)lerValor();
        System.out.println("Segue extrato da conta abaixo: ");
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta.extrato();
        }


        return  true;
    }
    public boolean showTransferencia(){
        int numContaOrigem, numContaDestino;
        double valor;
        System.out.println("\n");
        System.out.println("=== Tranferencia===");
        System.out.print("Numero da conta de origem: ");
        numContaOrigem = (int)lerValor();
        System.out.print("Numero da conta de destino: ");
        numContaDestino = (int)lerValor();
        System.out.print("Valor a transfereir: " );
        valor = lerValor();
        Conta conta1 = null;
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numContaDestino)
                conta1 = conta;

        }
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numContaOrigem)
                conta.transferir(valor,conta1);
        }
        trasacoes.add("TRASFERENCIA ----> Numero da Conta Origem: " + numContaOrigem + " , Numero da Conta Destion: " +
                         numContaDestino + ", Valor:" + valor + " Data " + dateTimeFormat.format(LocalDateTime.now()));


        return  true;
    }
    public boolean showAlterarDadosCadastrais(){
        String nome;
        int numConta;
        double rendaMensal;
        String agencia;
        int agenciaInt;
        System.out.println("\n");
        System.out.println("=== Alterar dados cadastrais===");
        System.out.print("Numero da Conta: ");
        numConta = (int)lerValor();
        Conta conta1 = null;
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta1 = conta;

        }
        System.out.println("Solicite os novos dados abaixo ao Cliente");
        System.out.print("Nome:");
        conta1.setNome(lerString());
        System.out.print("Renda Mensal: ");
        conta1.setRendaMensal(lerValor());
        Validador validador =new Validador();
        boolean validado ;
        do{
            System.out.print("Agencia: ");
            agencia = lerString();
            agenciaInt = Integer.parseInt(agencia);
            validado = validador.validaAgencia(agenciaInt);

        }while(validado);
        conta1.setAgencia(agencia);
        System.out.println("Alteracao efetuado com sucesso");
        return  true;
    }
    public boolean showHistoricoTrasacoes(){
        System.out.println("\n");
        System.out.println("=== Historico de Trasações ===");
        System.out.println("Segue abaixo todas trasações efetuadas pelo banco");
//        imprime lista de trasacoes;
        for (String model : trasacoes){
            System.out.println(model);
        }

        return true;
    }
    public boolean showListaContas(){
        System.out.println("\n");
        System.out.println("=== Lista das Contas ===");
        System.out.println("Segue abaixo todas contas do banco");
//       chamr o metodo responsavel por listar as contas

        for (Conta conta : listaContas){
            System.out.println(conta);
        }
        return true;
    }
    public boolean showContasNegativadas(){
        System.out.println("\n");
        System.out.println("=== Lista das Contas Negativadas ===");
        System.out.println("Segue abaixo todas contas negatidas do banco");
        for (Conta conta : listaContas){
            if(conta.getSaldo() < 0)
                System.out.println("Numero Conta: "+ conta.getNumConta() + " ----> Saldo" + conta.getSaldo());
        }
        return true;
    }
    public boolean showTrasacoesCliente(){
        int numConta;
        System.out.println("\n");
        System.out.println("=== Trasaçoes de um cliente ===");
        System.out.print("Numero da conta:");
        numConta = (int)lerValor();
        System.out.println("Segue extrato da conta abaixo: ");
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta.extrato();
        }

        return  true;
    }
    public boolean showSimuladorPoupanca(){
        System.out.println("\n");
        System.out.println("=== Simulador de rendimento da Poupança ===");
        System.out.print("Numero Conta: ");
        int numConta = (int)lerValor();
        System.out.print("Quantos meses o cliente quer simular: ");
        int meses = (int)lerValor();
        System.out.print("Rentabalidade anual em %:");
        double rentabilidade = lerValor();
        System.out.println("Segue a simulação abaixo: ");
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta.getSimulador(meses,rentabilidade);
        }
        return  true;
    }
    public boolean showSimuladorInvestimento(){
        System.out.println("\n");
        System.out.println("=== Simulador de Investimento ===");
        System.out.print("Numero Conta: ");
        int numConta = (int)lerValor();
        for (Conta conta : listaContas){
            if(conta.getNumConta() == numConta)
                conta.getSimulador(2,12);
        }
        return true;
    }
    public boolean showTotalInvestido(){
        System.out.println("\n");
        System.out.println("=== Tota Investido ===");
        double soma= 0;
        for(Double model: investimento){
            soma += model;
        }
        System.out.print("Valor total Investido: "+ soma);

        return true;
    }





    public static void main(String[] args){
        boolean opcaoMenu = false;
        MenuBanco test =new MenuBanco();
        do{
            Scanner ler1 = new Scanner(System.in);
            int opcao ;
            System.out.println("\n");
            System.out.println("=== Bem Vindo ao Banco TECH DIVE ===");
            System.out.println(" Segue menu de operações");
            System.out.println("1 - Cadastrar nova conta" + "\n"+
                               "2 - Saque" +"\n"+
                               "3 - Deposito" +"\n"+
                               "4 - Saldo" +"\n"+
                               "5 - Extrato" +"\n"+
                               "6 - Tranferencia" +"\n"+
                               "7 - Alterar dados cadastrais" +"\n"+
                               "8 - Historicos de transações" +"\n"+
                               "9 - Listar todas as contas" +"\n"+
                               "10 - Contas com saldo negativado" +"\n"+
                               "11 - Trasações de um cliente" +"\n"+
                               "12 - Simular a rentabilidade da poupanca"+"\n"+
                               "13 - Simular investimento"+"\n"+
                               "14 - Total de investimeto"+"\n"+
                               "0 - Sair do banco");
            System.out.print("Digite a operacao desejada: ");
            opcao = (int)test.lerValor();
            switch(opcao){
                case 1: opcaoMenu = test.showCadastrasConta();break;
                case 2: opcaoMenu = test.showSaque(); break;
                case 3: opcaoMenu = test.showDeposito(); break;
                case 4: opcaoMenu = test.showSaldo(); break;
                case 5: opcaoMenu = test.showExtrato(); break;
                case 6: opcaoMenu = test.showTransferencia();;break;
                case 7: opcaoMenu = test.showAlterarDadosCadastrais();break;
                case 8: opcaoMenu = test.showHistoricoTrasacoes();break;
                case 9: opcaoMenu = test.showListaContas();break;
                case 10: opcaoMenu = test.showContasNegativadas();break;
                case 11: opcaoMenu = test.showTrasacoesCliente();break;
                case 12: opcaoMenu = test.showSimuladorPoupanca();break;
                case 13: opcaoMenu = test.showSimuladorInvestimento();break;
                case 14: opcaoMenu = test.showTotalInvestido();break;
                default: System.err.println("Opçao Invalida"); opcaoMenu =true; break;
                case 0: opcaoMenu =  false;break;
            }
        }while(opcaoMenu);



    }

}

