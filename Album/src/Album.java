import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Album<T extends Colecionavel> {

//    Figurinha[] itens; em vez de usar array, usa Map, que é Map<chave, valor>
    private Map<Integer, T> itemPorPosicao; // chave (Integer) = número da posição no álbum, valor (T) = objeto do item nessa posição
    private Map<Integer, Integer> contRepetidasPorPosicao; // chave (Integer) = número da posição, valor (Integer) = quantidade de repetidas daquela posição
    // se já tem a figurinha número n e recebe outra, o álbum deixa a n original no primeiro mapa e, na posição n desse segundo, coloca o valor 1
    private int tamanho;
    
    public Album(int tamanho) {
//        itens = new Figurinha[tamanho + 1];  // end direto, sem usar a posição 0
        itemPorPosicao = new HashMap<>();
        this.tamanho = tamanho;
    }

    public int getQuantasFaltamParaCompletar() {
        return tamanho - itemPorPosicao.size();
    }

    public void receberNovoItem(T item) {
        boolean ehRepetido = itemPorPosicao.containsKey(item.getPosicao());
    }

    public T getItemDaPosicao(int posicao) {
        return itemPorPosicao.get(posicao);
    }

    public float venderRepetidos(int posicao, int quantidade) {
        // verificação se item existe no álbum
        if (!itemPorPosicao.containsKey(posicao)) {
            throw new RuntimeException("Não existem itens nessa posição :(");
        }
        // verifica quantas repetidas existem para essa posição
        Integer repetidasDisponiveis = contRepetidasPorPosicao.get(posicao); // obs usar .get num Map dá o valor da chave que eu colocar de parâmetro
        if (repetidasDisponiveis == null) {
            repetidasDisponiveis = 0;
        }
        // validação de quantidade informada
        if (quantidade > repetidasDisponiveis) {
            throw new RuntimeException("A quantidade informada para venda é maior que a quantidade disponível!");
        }
        // recupera item pra saber as informções sobre ele
        T item = itemPorPosicao.get(posicao);
        TipoDeColecionavel tipo = item.getTipo();
        double precoUnidade = tipo.getPreco();

        // calcula valor total
        double valorTotal = precoUnidade * quantidade;

        // atualiza mapa de repetidos pra não contar com as que foram vendidas
        int novasRepetidas = repetidasDisponiveis - quantidade;
        if (novasRepetidas > 0) {
            contRepetidasPorPosicao.put(posicao, novasRepetidas);
        } else {
            // se zerar as repetidas da posição, remove a posição do mapa de repetidas
            contRepetidasPorPosicao.remove(posicao);
        }
        return (float) valorTotal;
    }

    // fazendo overload do metodo de vender repetidas:

    // não recebe parametro quantidade, deve retornar o valor total de TODOS os itens da posição
    public float venderRepetidos(int posicao){
        // repete verificações referentes a 1. se o item existe nesse map 2. quantas tem
        // verificação se item existe no álbum
        if (!itemPorPosicao.containsKey(posicao)) {
            throw new RuntimeException("Não existem itens nessa posição :(");
        }
        // verifica quantas repetidas existem para essa posição
        Integer repetidasDisponiveis = contRepetidasPorPosicao.get(posicao);
        if (repetidasDisponiveis == null) {
            repetidasDisponiveis = 0;
        }
        // recupera item pra saber as informções sobre ele
        T item = itemPorPosicao.get(posicao);
        TipoDeColecionavel tipo = item.getTipo();
        double precoUnidade = tipo.getPreco();
        int quantidade = repetidasDisponiveis;

        double valorTotalPosicao = precoUnidade * quantidade;

        // zera as repetidas da posição, então remove a posição do mapa de repetidas
        contRepetidasPorPosicao.remove(posicao);

        return (float) valorTotalPosicao;
    }

    // não recebe parâmetro nenhum, deve retornar o valor total de TODOS os itens repetidos
    public float venderRepetidos(){
        double valorTotalGeral = 0;
        // percorre todas as chaves (posições) das repetidas
        for(int posicao : contRepetidasPorPosicao.keySet()){
            int quantidade = contRepetidasPorPosicao.get(posicao);

            T item = itemPorPosicao.get(posicao);
            if (item != null){
                double precoUnidade = item.getTipo().getPreco();
                valorTotalGeral += (precoUnidade * quantidade);
            }
        }

        contRepetidasPorPosicao.clear(); // já que vende todas, remove tudo

        return (float) valorTotalGeral;
    }

    // recebe TipoDeColecionavel como parâmetro e retorna o valor de todos os itens repetidos do tipo informado
    public float venderRepetidos(TipoDeColecionavel tipo){
        double valorTotalTipo = 0;
        // lista que vai guardar as posições pra zerar no final
        java.util.ArrayList<Integer> posicoesVendidas = new ArrayList<>();

        // percorre todas as posições
        for (int posicao : contRepetidasPorPosicao.keySet()){
            T item = itemPorPosicao.get(posicao);

            // verifica se item existe e se o tipo é o tipo que quer vender
            if (item != null && item.getTipo() == tipo){
                int quantidade = contRepetidasPorPosicao.get(posicao);
                double precoUnitario = tipo.getPreco();

                valorTotalTipo += precoUnitario * quantidade;

                posicoesVendidas.add(posicao);

            }
        }

        for (int posicao : posicoesVendidas){
            posicoesVendidas.remove(posicao);
        }

        return (float) valorTotalTipo;
    }
}
