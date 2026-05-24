package model;

import exception.DevolucaoInvalidaException;
import exception.LimiteEmprestimosExcedidoException;
import exception.UsuarioNaoCadastradoException;

import java.util.Map;
import java.util.*;

public class Biblioteca {

    public static final int MIN_COPIAS_PARA_PODER_EMPRESTAR = 2;
    public static final int MAX_LIVROS_DEVIDOS_POR_USUARIO = 3;

    private Map<Long, Pessoa> usuarioByCpf;  // mapa para guardar todos os usuários cadastrados (por cpf)

    private int totalLivrosNasEstantes;  // contador para o total de livros nas estantes da biblioteca

    private int totalUsuariosCadastrados;

    private Map<Livro, Integer> qntdPorLivro; // map que controla a quantidade por livro

    private Map<Pessoa, Integer> qntdLivrosDevidos;

    public Biblioteca(){
        this.usuarioByCpf = new HashMap<>();
        this.qntdPorLivro = new HashMap<>();
        this.qntdLivrosDevidos = new HashMap<>();
    }

    /**
     * Cadastra um novo usuário, caso não exista;
     * se já existir, atualiza seus dados, sobrescrevendo nome e endereço no objeto
     * que já existia com aquele CPF.
     *
     * @param usuario A Pessoa a ser cadastrada/atualizada como usuária desta biblioteca.
     */
    public void cadastrarUsuario(Pessoa usuario) {
        long cpf = usuario.getCpf();
        Pessoa usuarioExistente = this.usuarioByCpf.get(cpf);

        if (usuarioExistente == null) {
            // o usuário informado é novo; vamos cadastrá-lo
            this.usuarioByCpf.put(cpf, usuario); // coloca as infos no hashmap
            totalUsuariosCadastrados ++;

        } else {
            // o usuário informado já existia; vamos atualizá-lo
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEndereco(usuario.getEndereco());
        }
    }

    public Pessoa getUsuario(long cpf){
        return this.usuarioByCpf.get(cpf);
    }

    public int getTotalDeUsuariosCadastrados(){
        return totalUsuariosCadastrados;
    }

    /**
     * Efetua a aquisição de certo número de cópias de um livro.
     *
     * @param livro O livro que desejamos adquirir.
     * @param quantidade A quantidade desejada, que será adquirida e acrescentada à quantidade já existente
     *                   daquele livro na biblioteca (se o livro já existir na biblioteca)
     */
    public void adquirirLivro(Livro livro, int quantidade) {
        if (quantidade <= 0){
            return;
        }
        int qtdAtual = this.qntdPorLivro.getOrDefault(livro, 0);
        this.qntdPorLivro.put(livro, qtdAtual + quantidade);
        this.totalLivrosNasEstantes += quantidade;
        // Dica: adicione um Map quantidadeByLivro como atributo de Biblioteca.
    }

    /**
     * Efetua o empréstimo de uma unidade do livro informado para o usuário informado, reduzindo em uma unidade
     * a quantidade daquele livro nas estantes da biblioteca.
     *
     * @param livro O livro que se deseja tomar emprestado
     * @param usuario O usuário que deseja pegar emprestado o livro
     *
     * @return true, se o empréstimo for bem sucedido; false, caso a biblioteca não tenha em suas estantes
     *         a quantidade mínima do livro desejado para que ele possa ser emprestado
     *         (vide model.Biblioteca.MIN_COPIAS_PARA_PODER_EMPRESTAR)
     *
     * @throws UsuarioNaoCadastradoException se o usuário não for cadastrado nesta biblioteca
     * @throws LimiteEmprestimosExcedidoException se o usuário já está ultrapassou o número máximo permitido de
     *                                            livros emprestados nesta biblioteca para cada usuário
     */
    public boolean emprestarLivro(Livro livro, Pessoa usuario)
            throws UsuarioNaoCadastradoException, LimiteEmprestimosExcedidoException {
            if(!this.usuarioByCpf.containsKey(usuario.getCpf())) { // se o usuario nao tiver cpf/nao for cadastrado
                throw new UsuarioNaoCadastradoException("Usuário não está cadastrado no sistema!!");
            }
            if(getQuantidadeDeLivrosDevidos(usuario) >= MAX_LIVROS_DEVIDOS_POR_USUARIO){ // usuario deve livros demais ja
                throw new LimiteEmprestimosExcedidoException("Usuário atingiu o limite de livros devidos!!");
            }
            int estoqueAtual = getQuantidadeDeLivrosNasEstantes(livro);
            if(estoqueAtual < MIN_COPIAS_PARA_PODER_EMPRESTAR){
                return false; // nao tem nenhum livro desse no estoque
            }

            this.qntdPorLivro.put(livro, estoqueAtual-1);
            this.totalLivrosNasEstantes--;
            int livrosJaTinha = this.qntdLivrosDevidos.getOrDefault(usuario, 0);
            this.qntdLivrosDevidos.put(usuario, livrosJaTinha+1);


        return true;

    }

    /**
     * Recebe de volta um livro que estava emprestado.
     *
     * @param livro O livro que o usuário está devolvendo
     * @param usuario O usuário que devolve o livro
     *
     * @throws DevolucaoInvalidaException caso o livro em questão não exista
     *                                    ou o livro não esteja emprestado para o usuário informado
     */
    public void receberDevolucaoLivro(Livro livro, Pessoa usuario) throws DevolucaoInvalidaException {

        int livrosJaTinha = this.qntdLivrosDevidos.getOrDefault(usuario, 0);
        if(livrosJaTinha <= 0){
            throw new DevolucaoInvalidaException();
        }

        this.qntdLivrosDevidos.put(usuario, livrosJaTinha -1);
        int estoqueAtualLivro = getQuantidadeDeLivrosNasEstantes(livro);
        this.qntdPorLivro.put(livro, estoqueAtualLivro+1);
        this.totalLivrosNasEstantes++;
    }

    public int getQuantidadeDeLivrosDevidos(Pessoa usuario) {
        return this.qntdLivrosDevidos.getOrDefault(usuario, 0);
    }

    public int getQuantidadeDeLivrosNasEstantes() { // se não colocar parâmetro, ele retorna o numero total de livros no geral
        // ****** NÃO MODIFIQUE ESSE MÉTODO! ******
        return totalLivrosNasEstantes;
    }

    public int getQuantidadeDeLivrosNasEstantes(Livro livro) { // se colocar parâmetro, ele retorna o total DAQUELE livro
        return this.qntdPorLivro.getOrDefault(livro, 0);
    }
}