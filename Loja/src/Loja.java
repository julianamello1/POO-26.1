package src;

import java.util.ArrayList;

public class Loja {

    ArrayList<Produto> listaProdutos = new ArrayList<>();
    // em ArrayLista, é <tipo de variavel no array> nome do array = new ArrayLista<>();

    // criar um construtor que inicializa uma lista vazia (ou seja, não vai receber como parâmetro)
    // então, toda vez que fizer uma Loja, nasce pronta pra receber produtos e adioconar na lista com o metodo

    public Loja() {
        this.listaProdutos = new ArrayList<>();
        // inicializa ArrayLista toda vez que criar um objeto de Loja
        // se não fizesse, na hora de cadastrar e fazer o .add(), nao ia ter lista pra colocar!
    }


    void cadastrarProduto(Produto novoProduto) {
        listaProdutos.add(novoProduto); // nomedalista.add(nome do parametro);
        System.out.println("\nProduto " + novoProduto.getNome() + " cadastrado!");
    }

    public void venderProduto(String descricaoProduto) {
        for (Produto p : listaProdutos) {
            if (descricaoProduto.equals(p.descricao)) {
                System.out.println("\n\tO produto " + descricaoProduto + " foi vendido com sucesso!");
                return; // sai da funçao
            }
        }
        System.out.println("\n\tO produto não está disponível na loja! :( ");
    }
        public void imprimirEstoque () {
            if (this.listaProdutos.isEmpty()) {
                System.out.println("O estoque de tudo acabou! :o ");
            } else { // fazer o print do ArrayList com um loop dos elementos
                for (Produto p : this.listaProdutos) {
                    System.out.println("\n\t" + p); // ja tem Override dos produtos e vai aparecer bonitinho
                }
            }
        }

    }


