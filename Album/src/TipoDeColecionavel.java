public enum TipoDeColecionavel {

    // constantes
    COMUM(10.0),
    RARO(100.0),
    BRILHANTE(1500.0);

    // atributo que armazena o preço
    private final double preco;

    // construtor
    TipoDeColecionavel(double preco){
        this.preco = preco;
    }

    // getter publico pro preço
    public double getPreco(){
        return this.preco;
    }
}


