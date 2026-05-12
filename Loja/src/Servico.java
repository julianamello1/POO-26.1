package src;

public class Servico implements Vendavel {

    protected float preco;
    protected String descricao;
    protected int tempoGarantia; // em meses


    public Servico(float preco, String descricao, int tempoGarantia){
        this.preco = preco;
        this.descricao = descricao;
        this.tempoGarantia = tempoGarantia;
    }

    @Override
    public float getPreco() {
        return this.preco;

    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }
}
