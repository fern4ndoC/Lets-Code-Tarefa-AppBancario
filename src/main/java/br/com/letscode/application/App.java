package main.java.br.com.letscode.application;

import main.java.br.com.letscode.model.*;

import java.util.ArrayList;
import java.util.Locale;

public class App {
    public static void main(String[] args) {

        Locale ptbr = new Locale("pt", "BR");

        ArrayList<Conta> contas = new ArrayList<>();

        Cliente teste = new PessoaFisica("Fulano", "123456789");
        Cliente pj = new PessoaJuridica("Empresa X", "23654896");

        Conta cc = Conta.abrirConta(1, pj, 22, 22);
        cc.consultarSaldo(ptbr);
        cc.depositar(100);
        Conta cc2 = Conta.abrirConta(1, teste, 32, 32);
        cc.transferir(45, cc2);
        contas.add(cc2);
        contas.add(cc);
        Conta dest = new ContaCorrente();
        dest.setNumero(32);
        dest.setAgencia(32);

        System.out.print("conta 1:");
        cc.consultarSaldo(ptbr);
        System.out.print("conta 2:");
        cc2.consultarSaldo(ptbr);




    }
}
