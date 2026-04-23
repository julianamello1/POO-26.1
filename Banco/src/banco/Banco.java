package banco;

import java.util.ArrayList;

public class Banco {

    public final static int TAMANHO_MAX_PRO_NOME = 10;

    private String nome;

    public static final float salarioBase = 1000;

    // criar e instanciar logo direto:
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>(); // aqui, vou criar uma lista dinâmica com elementos do tipo "Funcionario" e chamada "Funcionários"
    // arraylist é uma lista dinâmica! cresce e diminui conforme adicionae remove elementos (só pra objetos)

    private ArrayList<ContaCorrente> contasCorrentes;

    public void AddFuncionario(String cpf, String nome, String matricula, boolean ehGerente){
        // função de add funcionarios na lista dinâmica que recebe os parâmetros necessários p/ criar um "Funcionario"
        Funcionario novoFuncionario = null; // variável genérica, inicializa como null

        if (ehGerente){
            // se o funcionario for gerente (boolean ehGerente = true)
            novoFuncionario = new Gerente(cpf, nome, matricula, this);
            // cria um novo objeto do tipo gerente e coloca os parâmetros que ele recebe

        }
        else {
            // se o funcionário NÃO for gerente
            novoFuncionario = new Funcionario(cpf, nome, matricula, this);
            // tive que, na classe Funcionario, colocar a variável "bancoOndeTrabalha" como o objeto Banco. O "this" se refere a isso. É o próprio objeto Banco sendo recebido
        }
        this.listaFuncionarios.add(novoFuncionario); // adiciona na lista
    }


    public Funcionario localizarFuncionario(String matriculaBuscada) {
        // tem que percorrer a lista de funcionarios:
        for (Funcionario funcionario : this.listaFuncionarios) {
            if (funcionario.getMatricula().equals(matriculaBuscada)) {
                return funcionario; // se a matricula for igual à matricula procurada, retorna o objeto funcionario
            }
        }
        return null; // se não encontrar, retorna nada
    }


    public Gerente localizarGerente(String matriculaBuscada){
        for (Funcionario funcionario : this.listaFuncionarios){ // gerentes tbm estão na lista de funcionarios
            if (funcionario.getMatricula().equals(matriculaBuscada) && funcionario instanceof Gerente){
                // "instanceof" = verifica se o objeto é uma instância de uma classe específica
                // aqui, verifiquei se a matrícula era a mesma E se o funcionario era da classe gerente
                return (Gerente) funcionario;
                // aqui, fiz um typecast, ou seja, forço o java a ver o objeto funcionario como sendo da classe gerente (tendo todos os atributos da tal)
            }
        }
        return null;
    }

    /* obs: daria pra fazer esse localizarGerente com uma segunda lista separada pros gerentes:

    >> cria uma private ArrayList<Gerente> listaGerentes = new ArrayList<>();

    * public void AddFuncionario(String cpf, String nome, String matricula, boolean ehGerente){
        // função de add funcionarios na lista dinâmica que recebe os parâmetros necessários p/ criar um "Funcionario"
        Funcionario novoFuncionario = null; // variável genérica, inicializa como null

        if (ehGerente){
            // se o funcionario for gerente (boolean ehGerente = true)
            novoFuncionario = new Gerente(cpf, nome, matricula, this);
            this.listaFuncionarios.add(novoFuncionario);
            this.listaGerentes.add(novoFuncionario)
            // cria um novo objeto do tipo gerente e coloca os parâmetros que ele recebe
            >> adiciona na lista tanto dos funcionarios quanto dos gerentes!

        }
        else {
            // se o funcionário NÃO for gerente
            novoFuncionario = new Funcionario(cpf, nome, matricula, this);
            this.listaFuncionarios.add(novoFuncionario);
            // tive que, na classe Funcionario, colocar a variável "bancoOndeTrabalha" como o objeto Banco. O "this" se refere a isso. É o próprio objeto Banco sendo recebido
        }
    }

    >> aí, pra localizarGerente:

    public Gerente localizarGerente(String matricula) {
    // procura apenas na lista de gerentes (é mais rapido que com typecast e instanceof)
    for (Gerente g : listaGerentes) {
        if (g.getMatricula().equals(matricula)) {
            return g; // retorna direto, sem precisar de (Gerente) g
        }
    }
    return null;
}
*/

    public void promoverFuncionario(Funcionario funcionarioPromovido){
        System.out.println("O funcionário" + funcionarioPromovido.getNome() + "está promovido!!! PARABÉNS! ");
        // obs: getNome() sem "especificar" pega o nome de quem ta executando o código, nesse caso, classe Banco!!

        // cálculo do salário com a promoção:
        float novoSalario = (float) (1.3 * funcionarioPromovido.getSalario());

        // atualizar o valor do salário no objeto usando o setter (já que é private)
        funcionarioPromovido.setSalarioAtual(novoSalario);
            // no set salario, ele recebe um valor de salario atualizado e atualiza a gaveta de salario da classe (this.salario) pra esse valor recebido

        System.out.println("\nDados do funcionário atualizados:" + funcionarioPromovido.toString());
            // aqui ele utiliza o override do toString que já criei na classe Funcionário

    }

    public Banco(String nome) {
        setNome(nome);
        this.contasCorrentes = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        if (novoNome.length() >  TAMANHO_MAX_PRO_NOME) {
            return;  // o correto seria lançar uma exceção
        }
        this.nome = novoNome;
    }

    public int getNumeroDeContasCorrentes() {
        return contasCorrentes.size();
    }
}
