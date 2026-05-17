package src;

import java.util.concurrent.TimeUnit;

public class LojaPix extends Loja {

    public LojaPix(Transportadora transportadora){
        super(transportadora);
    }

    @Override
    public void receberPagamento(double valor) {
        System.out.println("[PAGAMENTO POR PIX] Gerando QR Code.....");
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.printf("[PAGAMENTO POR PIX] Pagamento no valor de R$%.2f sendo processado.....%n", valor);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("[PAGAMENTO POR PIX] Aguardando confirmação......");
            TimeUnit.SECONDS.sleep(2);

        } catch (InterruptedException e){
            System.out.println("[PAGAMENTO POR PIX] Erro ao processar o pagamento!");
        }
    }

}
