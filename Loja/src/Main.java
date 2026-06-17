package src;
import src.Produto;
import src.Loja;

public class Main {
    public static void main(String[] args) {

        Transportadora trasportadorinha = new Transportadora();
        LojaPix lojinha = new src.LojaPix(trasportadorinha);


        Produto notebookGamer = new Produto(1500, "notebook gamer", "GusBom");
        Produto oculos3D = new Produto(300, "oculos 3D", "HighBum");
        Produto bermuda = new Produto(40, "bermuda azul", "Lives");
        Livro LearnJava = new Livro(500, "livro POO em Java", "livraria", "Vinicius Gusmao", 1000);

        lojinha.cadastrarProduto(notebookGamer);
        lojinha.cadastrarProduto(oculos3D);
        lojinha.cadastrarProduto(bermuda);
        lojinha.cadastrarProduto(LearnJava);

        lojinha.imprimirEstoque();

        lojinha.venderProduto("livro POO em Java", "Av. Athos da Silveira Ramos, 274");



    }
}