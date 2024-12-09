import java.util.Scanner;
import java.util.Random;

public class ContasBancarias {

    int id_conta;
    String cliente;
    double saldo_cliente;

    public ContasBancarias(String cliente, double saldo_cliente){
            this.cliente = cliente;
            this.saldo_cliente = saldo_cliente;

        Random numero_aleatorio = new Random();

        id_conta = numero_aleatorio.nextInt(1000);
    }

    public void Saldo(){
        System.out.println("Olá " + cliente +"! Seu saldo é de " + saldo_cliente);
    }

    public void Sacar(double valor_saque){
        if(saldo_cliente >= valor_saque){
            this.saldo_cliente = saldo_cliente - valor_saque;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Seu saldo é " + saldo_cliente);
        }else {
            System.out.println("Você não possui saldo para sacar esse valor");
        }
    }

    public void DepositarValor(double valorDoDeposito){
        if(valorDoDeposito <= 0){
            System.out.println("Seu valor esta incorreto para deposito");
        }else{
            this.saldo_cliente = saldo_cliente + valorDoDeposito;
            System.out.println("Deposito concluído! Seu saldo é de " + saldo_cliente);
        }
    }

    public void EmprestimoBancario(double emprestimoSolicitado){
        if (emprestimoSolicitado >= saldo_cliente){
            System.out.println("Não é possivel te oferecer um emprestimo. Seu saldo não foi suficiente");
        }else{
            saldo_cliente = saldo_cliente + emprestimoSolicitado;
            System.out.println("Emprestimo concluido");
            System.out.println("Seu novo saldo é " + this.saldo_cliente);
        }
    }

    public void PagarBoleto(double boleto){
        if(boleto > saldo_cliente){
            System.out.println("Seu saldo é insuficiente");
        }else{
            saldo_cliente = saldo_cliente - boleto;

            System.out.println("Boleto pago com sucesso");
            System.out.println("Seu saldo é " + this.saldo_cliente);
        }
    }

    public void Menu(){
        System.out.println("Olá " + cliente);
        System.out.println("Selecione o atendimento que deseja");
        System.out.println("1 - saldo");
        System.out.println("2 - sacar valor");
        System.out.println("3 - depositar uma grana");
        System.out.println("4 - pedir uma grana para o banco");
        System.out.println("5 - pagar um boleto");
        System.out.println("6 - Sair");
    }


    public void Acao(int escolhaUser){
        double valorsaque;
        double valordeposito;
        double valoremprestimo;
        double valorboleto;

        switch (escolhaUser){
            case 1:
                Saldo();
                break;
            case 2:
                System.out.println("Qual é o valor de saque?");
                valorsaque = entrada.nextDouble();
                Sacar(valorsaque);
                break;
            case 3:
                System.out.println("Qual é o valor do deposito?");
                valordeposito = entrada.nextDouble();
                DepositarValor(valordeposito);
                break;
            case 4:
                System.out.println("Qual é o valor do emprestimo?");
                valoremprestimo = entrada.nextDouble();
                EmprestimoBancario(valoremprestimo);
                break;
            case 5:
                System.out.println("Qual o valor do seu boleto?");
                valorboleto = entrada.nextDouble();
                PagarBoleto(valorboleto);
                break;
            case 6:
                System.out.println("Nós agradeçemos a preferência");
                break;
            default:
                System.out.println("Escolha incorreta");


        }
    }

    Scanner entrada = new Scanner(System.in);

    public void AtivarSistema() {
        int escolha;

        do {
            Menu();
            escolha = entrada.nextInt();
            Acao(escolha);
        } while (escolha != 6);
    }
}
