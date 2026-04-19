package banco;

public class ContaCorrente {

    //varáveis:
    private long numeroConta;
    private Pessoa correntista; // tem o objeto correntista que tem os atributos da classe pessoa
    private float saldoEmReais;
    private int limiteDoChequeEspecial;

    public ContaCorrente(long numeroConta, Pessoa correntista){ // o que objeto vai receber de parâmetro na main
    // nesse construtor que eu coloco que valores vão ser de cada variável
        this.numeroConta = numeroConta;
        this.correntista = correntista; /* o "private Pessoa correntista" vai
         receber o que o parâmetro "correntista" receber no main, ou seja, vai receber um objeto Pessoa

          pensar: é como se definisse la em cima o "int numero" e de parâmetro do construtor
          colocasse "int a", entao dentro colocaria this.numero = a >> a gaveta numero (da classe) recebe o valor que veio de a
          */
        this.saldoEmReais = 0; // opcional!

        /* Então, ContaCorrente vai receber um numero da conta e uma pessoa.
        * (ou seja, vai criar um objeto Pessoa na main (que recebe nome e cpf) e vai colocar o nome desse objeto como
        * parâmetro de ContaCorrente!!
        * ex: Pessoa cliente = new Pessoa("12345678900", "Juliana");
        * ContaCorrente conta = new ContaCorrente(1111, cliente);
        * o "cliente" que ele vai receber é um objeto do tipo Pessoa qye recebeu ja o nome e cpf!!!!*/
    }


    // métodos:
    public long getNumeroConta(){
            return numeroConta; // pra conseguir acessar os dados, ja que é private
    }

    public Pessoa getCorrentista(){
        return correntista;
    }

    public float getSaldoEmReais(){
        return saldoEmReais;
    }

    public int getLimiteDoChequeEspecial(){
        return limiteDoChequeEspecial;
    }

    // note que: pra usar os getters, precisa ser uma variável de mesmo tipo do retorno!!!!

}
