package cinema;

public class IngressoMeia extends Ingresso  {

    public IngressoMeia(double valorBase, String nomeFilme, boolean dublado) {
        super(valorBase, nomeFilme, dublado);
    }

    @Override
    public double getValorReal() {
        return getValorBase() / 2;
    }
}
