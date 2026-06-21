//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Album<Figurinha> albumDaCopa = new Album(994);

        Figurinha fig = new Figurinha(15, "Fulano", TipoDeColecionavel.COMUM);
        albumDaCopa.receberNovoItem(fig);

        albumDaCopa.getItemDaPosicao(100);

        System.out.println(fig.getTexto());


        Album<Selo> albumDeSelos = new Album(220);

        Selo selo = new Selo("Brasil", 14, 60.0F);
        albumDeSelos.receberNovoItem(selo);

        albumDeSelos.getItemDaPosicao(100);

        System.out.println(selo.getTexto());


    }
}