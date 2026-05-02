import java.util.ArrayList;

public class Loja {

    ArrayList<Produto> produtos = new ArrayList<>();
    // em ArrayLista, é <tipo de variavel no array> nome do array = new ArrayLista<>();

  void  cadastrarProduto(Produto novoProduto){
      produtos.add(novoProduto); // nomedalista.add(nome do parametro);
  }


}
