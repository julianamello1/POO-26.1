package banco;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        // criar o banco:
        Banco meuBanco = new Banco("Banculiana"); // "meuBanco" = nome da variével/objeto Banco

        System.out.println(
                "\nO banco " + meuBanco.getNome() + " possui " +
                        meuBanco.getNumeroDeContasCorrentes() +
                        " contas correntes.");

        Funcionario f1 = new Funcionario("1111", "Fulano", "F01", meuBanco);
        Funcionario f2 = new Funcionario("2222", "Beltrano", "F02", meuBanco);
        Funcionario f3 = new Funcionario("3333", "Ciclano", "F03", meuBanco);
        Funcionario f4 = new Funcionario("4444", "Sicrano", "F04", meuBanco);
        Funcionario f5 = new Funcionario("5555", "OutroFulano", "F05", meuBanco);

        Gerente g1 = new Gerente("111", "Gerente1", "G01", meuBanco);
        Gerente g2 = new Gerente("222", "Gerente2", "G02", meuBanco);

        meuBanco.AddFuncionario("1111","Fulano", "F01", false);
        meuBanco.AddFuncionario("2222","Beltrano", "F02", false);
        meuBanco.AddFuncionario("3333","Ciclano", "F03", false);
        meuBanco.AddFuncionario("4444","Sicrano", "F04", false);
        meuBanco.AddFuncionario("5555","OutroFulano", "F05", false);

        meuBanco.AddFuncionario("111","Gerente1", "G01", true);
        meuBanco.AddFuncionario("222","Gerente2", "G02", true);

        // Note que, pra usar as funções das classes, precisa utilizar o nome do objeto daquela classe!

        g1.AddSubordinado(f1);
        g1.AddSubordinado(f2);
        g2.AddSubordinado(f3);
        g2.AddSubordinado(f4);
        g2.AddSubordinado(f5);

        g1.imprimirEquipe();
        g2.imprimirEquipe();

        meuBanco.promoverFuncionario(f1);
        meuBanco.promoverFuncionario(g2);

    }
}