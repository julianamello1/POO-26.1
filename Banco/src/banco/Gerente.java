package banco;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Gerente extends Funcionario{

    private ArrayList<Funcionario> Subordinados = new ArrayList<>();
    // lista dinâmica com os subordinados que respondem diretamente ao gerente

    private float salarioGerente;

    public Gerente(String cpf, String nome, String matricula, Banco bancoOndeTrabalha){
        super(cpf, nome, matricula, bancoOndeTrabalha);
        this.salarioGerente = (2 * Banco.salarioBase);
    }

    public void AddSubordinado(Funcionario funcionario){

        if (this.getBancoOndeTrabalha() != funcionario.getBancoOndeTrabalha()){
            throw new RuntimeException("ERRO! O funcionário trabalha em outro banco!");
        }

        this.Subordinados.add(funcionario); // se for do mesmo banco, só adiciona na lista
        /* aqui, não criei objeto new etc etc igual na lista de banco, pq a questão não pediu pra criar objeto kkkkkkk,
        * só pra adicionar na lista de subordinados mesmo! os objetos já foram criados e são passados como parâmetro */
    }

    public void imprimirEquipe(){
        System.out.println("\nEquipe do gerente " + this.getNome() + ":");
        // java vê que o avô dessa classe tem o getNome.
        for(Funcionario funcionario : Subordinados){ // enquanto o funcionario estiver dentro da lista de subordinados
            System.out.println(funcionario); // aparentemente java ja chama o toString automaticamente aqui
        }
    }

    @Override
    public String toString(){
        /* a classe Funcionario já tem um Override do toString que coloca cpf, nome, salário, matrícula tudo bonitinho!
        * então, ele aqui vai primeiramente pegar esse Override já feito (com ncpf, nome e matricula) e colocar aqui, adicionando as outras informações que eu
        * coloquei pros subordinados */
        return super.toString() + " | Tamanho da equipe: " + Subordinados.size();
    }

}
