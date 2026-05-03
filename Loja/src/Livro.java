package src;

public class Livro extends Produto {

    protected int numeroDePaginas;
    protected String autor; // nao precisava (seguindo o enunciado) mas quis adicionar

    public Livro (float preco, String descricao, String marca, String autor, int numeroDePaginas){
        super(preco, descricao, marca);
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
    }


    @Override
    public String toString(){
        return super.toString() + " Autor(a): " + this.autor;
    }

}
