import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    private Album<Colecionavel> albumteste;

    @BeforeEach
// faz isso tudo antes de cada teste, pra não ter que ficar criando album dentro de cada teste
    void setAlbumteste() {

        albumteste = new Album<>(100);

        Figurinha f1 = new Figurinha(10, "Figurinha rosa", TipoDeColecionavel.RARO);
        Figurinha f2 = new Figurinha(12, "Figurinha preta", TipoDeColecionavel.COMUM);
        Figurinha fr2 = new Figurinha(12, "Figurinha preta", TipoDeColecionavel.COMUM);
        Figurinha frr2 = new Figurinha(12, "Figurinha preta", TipoDeColecionavel.COMUM);
        Figurinha fr1 = new Figurinha(10, "Figurinha rosa", TipoDeColecionavel.RARO);
        albumteste.receberNovoItem(f1);
        albumteste.receberNovoItem(f2);
        albumteste.receberNovoItem(fr2);
        albumteste.receberNovoItem(frr2);
        albumteste.receberNovoItem(fr1);
    }


    // teste venderRepetidos(int posicao, int quantidade)
    @Test
    void testVenderRepetidosComParametros() {
        float valor = albumteste.venderRepetidos(12, 1);
        assertEquals(10.0f, valor, 0.001f);

        // verifica se sobrou 1 repetida na posição 12, já que vendeu uma
        assertEquals(1, albumteste.getRepetidas(12));
    }

    // venderRepetidos (int posicao) = vender todas as repetidas da posição
    @Test
    void testVenderRepetidosPosicaoTotal() {
        float valor = albumteste.venderRepetidos(12); // 2 COMUM * 10 = 20.0
        assertEquals(20.0f, valor, 0.001f);

        // verifica se a posição foi removida do mapa de repetidas, já que vendeu todas
        assertEquals(0, albumteste.getRepetidas(12));
    }

    // venderRepetidos() = vender todas as repetidas
    @Test
    void testVenderTodasRepetidas() {
        // 2 comuns + 1 rara = 2 * 10 + 1 * 100 = 120
        float valorTotal = albumteste.venderRepetidos();
        assertEquals(120.0f, valorTotal, 0.001f);

        // Verifica se zerou tudo
        assertEquals(0, albumteste.getTotalRepetidas());
    }

    // vender todas as repetidas de um tipo de colecionavel
    @Test
    void testVenderRepetidasPorTipo() {
        float valor = albumteste.venderRepetidos(TipoDeColecionavel.COMUM);
        assertEquals(20.0f, valor, 0.001f);
    }
}