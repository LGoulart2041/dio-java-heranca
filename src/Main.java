import cinema.IIngresso;
import cinema.IngressoFamilia;
import cinema.IngressoMeia;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        /*  Utilização do package CINEMA */
        List<IIngresso> ingressos = List.of(
                new IngressoMeia(40, "Matrix", true),
                new IngressoFamilia(40, "Toy Story", false, 4)
        );

        for (IIngresso ingresso : ingressos) {
            System.out.println("🎬 " + ingresso.getNomeFilme());
            System.out.println("Valor: R$" + ingresso.getValorReal());
            System.out.println(ingresso.dubladoOuLegendado());
            System.out.println("---------------------");
        }
    }
}
