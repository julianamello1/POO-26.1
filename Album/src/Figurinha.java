import java.awt.*;

public class Figurinha implements Colecionavel {

    private int posicao;

    private String texto;  // o melhor seria imagem

    TipoDeColecionavel tipo;

    public Figurinha(int posicao, String texto, TipoDeColecionavel tipo) {
        this.posicao = posicao;
        this.texto = texto;
        this.tipo = tipo;
    }

    @Override
    public int getPosicao() {
        return posicao;
    }

    @Override
    public TipoDeColecionavel getTipo() {
        return this.tipo;
    }

    @Override
    public String getTexto() {
        return texto;
    }
}
