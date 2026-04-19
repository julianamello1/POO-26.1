package banco;

public class Funcionario extends Pessoa {
    /* "extends" significa que a classe "Funcionario" herda os atributos da classe Pessoa */
    private String matricula;
    private float salario;
    private String bancoOndeTrabalha;
    // então, além dessas duas variáveis que botei, "Funcionario" também tem todos os mesmo de Pessoa!


    public Funcionario(String cpf, String nome, String matricula, String bancoOndeTrabalha) {
        super(cpf, nome); // super tem que ser a primeira linha do construtor!
        /* como a classe Funcionario é uma extensão, um "filho" de Pessoa, o Java entende que todos os Funcionarios são Pessoa,
        * por isso, sempre que criar um, precisa estabelecer a parte Pessoa dele antes.
        * na classe Pessoa, defini que todas tem cpf e nome. Funcionario recebe permissão pra mexer nesses dois, pois vêm de seu pai.
        * é como se ele dissesse "ó, sou Funcionario mas sou primeiramente Pessoa. pega esses atributos que eu recebi e manda pro meu pai
        * pq é ele quem sabe como guardar isso corretamente! */
        this.matricula = matricula;
        this.salario = Banco.salarioBase; // ele pega o valor do salario base que foi definido e inicializado na classe Banco!
        this.bancoOndeTrabalha = bancoOndeTrabalha;
        // novamente, a gaveta da classe vai receber o valor dos parâmetros
    }

    public float imprimirContraCheque(){
        return salario; // pra alterar o salario, teria que usar um setter pq no construtor ele foi colocado com um valor ja, não como parâmetro!
    }

    public void setSalarioAtual(float salarioAtual){
        this.salario = salarioAtual;
    } // vai receber o salario atual e trocar (inicialmente, o salario se inicializa como o salario base, incializado em Banco e colocado no construtor de Funcionario!

    @Override
    public String toString(){
        return "Nome do funcionário:" + getNome() + "CPF:" + getCpf() + "Matrícula:" + matricula + "Salário:" + salario;
        // nome e cpf com getter pq são privados, então precisa de getter pra acessar
    }



}