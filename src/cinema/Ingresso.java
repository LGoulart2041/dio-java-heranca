package cinema;

public abstract class Ingresso implements IIngresso{

    private double valorBase;

    private String nomeFilme;

    private boolean dublado;

    public Ingresso(double valorBase, String nomeFilme, boolean dublado) {
        this.valorBase = valorBase;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }

    public boolean isDublado() {
        return dublado;
    }


    protected double getValorBase() {
        return valorBase;
    }

    @Override
    public String getNomeFilme() {
        return nomeFilme;
    }

    @Override
    public String dubladoOuLegendado() {
       return isDublado() ? "O filme é dublado" : "O filme é legendado";
    }

    public abstract double getValorReal();
}
