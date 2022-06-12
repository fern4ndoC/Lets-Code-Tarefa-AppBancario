package main.java.br.com.letscode.application;

import main.java.br.com.letscode.model.*;

import java.util.ArrayList;
import java.util.Locale;

public class App {
    public static void main(String[] args) {

        Locale ptbr = new Locale("pt", "BR");
/*
        ArrayList<Conta> contas = new ArrayList<>();

        Cliente teste = new PessoaFisica("Fulano", "123456789");
        Cliente pj = new PessoaJuridica("Empresa X", "23654896");

        Conta cc = Conta.abrirConta(1, pj, 22, 22);
        Conta cc2 = Conta.abrirConta(1, teste, 32, 32);

        contas.add(cc2);
        contas.add(cc);

        int srcIndex = contas.indexOf(cc);
        Conta dest = new ContaCorrente();
        dest.setNumero(32);
        dest.setAgencia(32);
        int destIndex = contas.indexOf(dest);

        contas.get(srcIndex).consultarSaldo(ptbr);
        contas.get(srcIndex).depositar(100);


        System.out.print("conta 1:");
        contas.get(srcIndex).consultarSaldo(ptbr);
        System.out.print("conta 2:");
        contas.get(destIndex).consultarSaldo(ptbr);
*/
        PessoaFisica pf = new PessoaFisica("fulano","12548");
        pf.abrirConta(TipoConta.CONTA_CORRENTE, 22, 22);
        System.out.println(pf.toString());
    }
}
