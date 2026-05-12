package src;

public class Livro extends Produto implements Transportavel {

    protected int numeroDePaginas;
    protected float peso;
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

    @Override
    public float getPeso() {
        return this.peso;
    }
}
