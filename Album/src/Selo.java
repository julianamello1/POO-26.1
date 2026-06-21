public class Selo implements Colecionavel {

    private float valorMonetario;

    private String pais;

    private int posicao;

    public Selo (String pais, int posicao, float valorMonetario){
        this.pais = pais;
        this.posicao = posicao;
        this.valorMonetario = valorMonetario;
    }

    @Override
    public int getPosicao() {
        return this.posicao;
        // faz-se uma conta envolvendo o país do selo, etc.
        // nao entendi isso ^ que o professor colocou
    }

    @Override
    public TipoDeColecionavel getTipo() {
        return TipoDeColecionavel.COMUM;
    }

    @Override
    public String getTexto() {
        return "Selo do país " + pais + " com valor de R$ " + valorMonetario;
    }

    public float getValorMonetario() {
        return this.valorMonetario;
    }
}
