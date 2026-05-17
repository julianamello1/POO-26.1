package src;

import java.util.concurrent.TimeUnit;

public class LojaCripto extends Loja {

    public LojaCripto(Transportadora transportadora){
        super(transportadora);
    }

    @Override
    public void receberPagamento(double valor) {
        System.out.printf("\t\n[PAGAMENTO ENCRIPTADO] Processando transação no valor de %.2f.....%n", valor);
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("....\t");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\n\tPagamento aceito!");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            System.out.println("[PAGAMENTO ENCRIPTADO] Erro ao processar pagamento");
        }
    }
}

