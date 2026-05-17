package src;

public class Transportadora{

    public void transportar(Transportavel transportavel, String endereco){
        float peso = transportavel.getPeso();
        System.out.println("\t\nDestino do produto:" + endereco);
        System.out.println(("\t\tPeso: " + transportavel.getPeso() + "kg"));

    }
}
