package sample.entity;

public class Jogador {

    protected Heroi heroi;
    protected int manaMaxima;
    protected int manaAtual;
    protected int pontosDeVida;
    protected Carta[] mao;
    protected boolean phHabilitado;

    public Jogador() {
        this.phHabilitado = true;
        this.manaAtual = 0;
        this.manaMaxima = 0;
        this.pontosDeVida = 30;
        this.mao = new Carta[6];
    }

    public void setIdHeroi(int idHeroi) {
        heroi = Heroi.getHeroiById(idHeroi);
    }

    public int getIdHeroi() {
        return heroi.getId();
    }

    public int getPontosDeVida() {
        return this.pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void comprarCarta() {
        // TODO - implement Jogador.comprarCarta
        throw new UnsupportedOperationException();
    }

    public void receberMoeda() {
        // TODO - implement Jogador.receberMoeda
        throw new UnsupportedOperationException();
    }

    public boolean isPhHabilitado() {
        return this.phHabilitado;
    }

    public void setPhHabilitado(boolean phHabilitado) {
        this.phHabilitado = phHabilitado;
    }

    public int getManaAtual() {
        return this.manaAtual;
    }

    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    public int getIdCarta(int idPosicao) {
        // TODO - implement Jogador.getIdCarta
        throw new UnsupportedOperationException();
    }

    public void removeCarta(int idPosicao) {
        // TODO - implement Jogador.removeCarta
        throw new UnsupportedOperationException();
    }

    public int getManaMaxima() {
        return this.manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public Carta[] getMao() {
        return mao;
    }

    public void setMao(Carta[] mao) {
        this.mao = mao;
    }
}