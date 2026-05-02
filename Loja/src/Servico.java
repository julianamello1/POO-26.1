package src;

public class Servico {

    protected float preco;
    protected String descricao;
    protected int tempoGarantia;


    public Servico(float preco, String descricao, int tempoGarantia){
        this.preco = preco;
        this.descricao = descricao;
        this.tempoGarantia = tempoGarantia;
    }
}
