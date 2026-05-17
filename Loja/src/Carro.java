package src;

public class Carro extends Produto{
 // so de não colocar que implements Transportavel já que dizer que não é, né?
    public Carro(float preco, String descricao, String marca){
        super(preco, descricao, marca);
    }
}
