package src;

public class Produto {

    protected float preco;
    protected String descricao;
    public String marca;

    public Produto(float preco, String descricao, String marca){
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
    }


    // getter com o nome do produto!
    public String getNome() {
        return this.descricao;
    }


    /* [obs] o Override funciona na função da classe em que eu coloco.
     no caso do toString, o sout tem a função toString dentro dele, então sempre que eu uso ele, vem o
     toString junto e, consequentemente, o Override tbm.
     Quando o sout é chamado, o Java checa se aquele objeto tem um Override pra toString e qual é.
     se não tiver, usa o do pai e assim vai. mas ele funciona assim, checando se a classe do objeto tem
     Override praquela função!
    */
    @Override
    public String toString(){
        return "Produto: " + this.getNome() + " | Preço: R$" + this.preco;
    }


}