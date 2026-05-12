package src;

import java.util.ArrayList;

public class Loja {

    private Transportadora transportadora;
    private ArrayList<Vendavel> listaProdutos = new ArrayList<>(); // lista aceita qualquer coisa que implemente Vendavel
    // em ArrayLista, é <tipo de variavel no array> nome do array = new ArrayLista<>();

    // criar um construtor que inicializa uma lista vazia (ou seja, não vai receber como parâmetro)
    // então, toda vez que fizer uma Loja, nasce pronta pra receber produtos e adioconar na lista com o metodo

    public Loja(Transportadora transportavel) {
        this.listaProdutos = new ArrayList<>();
        // inicializa ArrayLista toda vez que criar um objeto de Loja
        // se não fizesse, na hora de cadastrar e fazer o .add(), nao ia ter lista pra colocar!
    }


//    void cadastrarProduto(Produto novoProduto) {
//        listaProdutos.add(novoProduto); // nomedalista.add(nome do parametro);
//        System.out.println("\nProduto " + novoProduto.getNome() + " cadastrado!");
//    }

    public void cadastrarProduto(Vendavel item) { // "Eu aceito qualquer objeto, desde que a classe dele prometa (implemente) a interface Vendavel."
        listaProdutos.add(item);
        System.out.println("\nProduto " + item.getDescricao() + " cadastrado!"); // aqui pode add new Produto e new Servico
    }

//    public void venderProduto(String descricaoProduto) {
//        for (Produto p : listaProdutos) {
//            if (descricaoProduto.equals(p.descricao)) {
//                System.out.println("\n\tO produto " + descricaoProduto + " foi vendido com sucesso!");
//                return; // sai da funçao
//            }
//        }
//        System.out.println("\n\tO produto não está disponível na loja! :( ");
//    }

    public void venderProduto(String item, String endereco) {
        Vendavel itemComprado = null; // pra ficar + facil na main, essa funçao vai receber String

        for (Vendavel p : listaProdutos){
            if (p.getDescricao().equalsIgnoreCase(item)){
                if (p instanceof Vendavel){ // se o objeto for de uma classe que implementa Vendavel, vou criar um Vendavel = String
                    itemComprado = (Vendavel) p; // meio que garanto pro java que pode sim tratar ele como Vendavel
                    break;
                }
            }
            System.out.println("\n\tO produto " + itemComprado.getDescricao() + " foi vendido com sucesso!");
            System.out.println("\n\tValor: R$ " + itemComprado.getPreco());

            if (itemComprado instanceof Transportavel) {
                if (endereco == null || endereco.isEmpty()) { // se for transportavel, mas tiver s/ endereço, ele tem que pedir!
                    System.out.println("ERRO! Este item precisa de um endereço de destino!");
                } else {
                    transportadora.transportar((Transportavel) itemComprado, endereco); // como ja usou instanceof pra ver se era Transportavel, pode usar cast pra tratar como tal mesmo
                }
                listaProdutos.remove(item);
            } else {
                System.out.println("\n\tERRO! PRODUTO NÃO ESTÁ NO ESTOQUE!");
            }

        }
    }
//        public void imprimirEstoque () {
//            if (this.listaProdutos.isEmpty()) {
//                System.out.println("O estoque de tudo acabou! :o ");
//            } else { // fazer o print do ArrayList com um loop dos elementos
//                for (Produto p : this.listaProdutos) {
//                    System.out.println("\n\t" + p); // ja tem Override dos produtos e vai aparecer bonitinho
//                }
//            }
//        }
//    }

        public void imprimirEstoque() {
            System.out.println("\nInventário atual da loja: ");
            for (Vendavel item : listaProdutos) {
                System.out.println("\n\t . " + item.getDescricao() + "(R$ " + item.getPreco() + ")");
            }
        }
    }


