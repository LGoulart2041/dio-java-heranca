package cinema;

public class IngressoFamilia extends Ingresso {

    private int qtdPessoas;

    public IngressoFamilia(double valorBase, String nomeFilme, boolean dublado, int qtdPessoas) {
        super(valorBase, nomeFilme, dublado);
        this.qtdPessoas = qtdPessoas;
    }

    @Override
    public double getValorReal() {
        double total = getValorBase() * qtdPessoas;
        if(qtdPessoas > 3) {
            total *= 0.95;
        }
        return total;
    }
}
