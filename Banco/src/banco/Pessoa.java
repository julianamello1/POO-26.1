package banco;

public class Pessoa {

    // variáveis:
    private final String cpf; // final pq ele é uma constante após recevr seu valor, não pode ser alterado
    private String nome; // private pq só pode ser lido/alterado dentro da própria classe

/* classe:
* aqui, eu declaro todas as variáveis e métodos que vão ter nessa classe.
* defino que toda "Pessoa" terá nome e cpf.
*
* construtor:
* aqui, defino quais valores as variáveis vão receber logo de cara no objeto, coloco o conteúdo
* nas gavetas das variáveis pela primeira vez.
* ele recebe os parâmetros e joga eles pras variáveis da classe (com o "this.")
*  */

    // quando tem variável final, TEM QUE dar o valor no construtor
    public Pessoa (String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
        // aqui, diz que as variáveis nome e cpf vão receber o valor do parâmetro na main
        /* sem construtor, as variáveis iam ficar vazias e iria precisar usar um setter
        * pra botar o valor delas. Desse jeito aí, o objeto já nasce pronto pra receber os parâmetros
        * direto (ou seja, recebe os parâmetros logo dentro do () na main).   */
    }

    // métodos:
    public String getCpf() {
        return cpf;
    }
        /* usa um getter pq, como cpf é private, ninguém de fora da classe consegue olhar o que
        * tem dentro diretamente, então, utiliza os getters para que outras classes possam ver o valor,
        * mas não MEXER nele */

    public String getNome(){
        return nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }
        /* usa um setter! isso permite que o nome seja alterada depois que a
        * pessoa já foi criada. Não teve isso com cpf pq ele é final.
        * como fica pra usar um setter na main?
        * bom, nesse caso aí em específico, o setter é só pra se a pessoa quiser mudar o nome depois mesmo,
        * pq o nome já foi colocado como parâmetro recebido no construtor.
        *
        * mas, se não tivesse recebido no construtor, seria assim na main:
        * Pessoa p1 = new Pessoa("12345678900"); // isso considerando o cpf sendo um parâmetro
        * p1.setNome("Juliana"); */

    @Override
    public String toString(){
        return "Nome:" + nome + "CPF:" + cpf;
    }
        /* usa override pra, na hora de printar, o Java não colocar um código
        * feio, ele vai mostrar desse jeito aí bem bonitinho
        * métod "toString" transforma um objeto em uma frase String que humanos conseguem ler */




}