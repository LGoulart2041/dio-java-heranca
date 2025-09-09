import cinema.IIngresso;
import cinema.IngressoFamilia;
import cinema.IngressoMeia;
import company.Attendant;
import company.IUser;
import company.Manager;
import company.Seller;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        /*  Utilização do package CINEMA */

        /*List<IIngresso> ingressos = List.of(
                new IngressoMeia(40, "Matrix", true),
                new IngressoFamilia(40, "Toy Story", false, 4)
        );

        for (IIngresso ingresso : ingressos) {
            System.out.println("🎬 " + ingresso.getNomeFilme());
            System.out.println("Valor: R$" + ingresso.getValorReal());
            System.out.println(ingresso.dubladoOuLegendado());
            System.out.println("---------------------");
        }*/

        IUser manager = new Manager("Anna", "anna@company.com", "1234");
        IUser seller = new Seller("Charles", "charles@company.com", "abcd");
        IUser attendant = new Attendant("Mary", "mary@company.com", "xyz");

        IUser[] users = { manager, seller, attendant };

        for(IUser user : users) {
            user.login();
        }

        // Métodos específicos de cada tipo
        ((Manager) manager).generateFinancialReport();
        ((Seller) seller).makeSale();
        ((Attendant) attendant).receivePayment(200);

        for(IUser user : users) {
            user.logoff();
        }
    }
}
