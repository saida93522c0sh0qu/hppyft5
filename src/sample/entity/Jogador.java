package sample.entity;

import sample.Main;

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
        Main.getInstance().atualizaVidaJogadores();
    }

    public void comprarCarta() {
        Integer idCarta = heroi.getBaralho().retiraCarta();
        if (idCarta > 0) {
            for (int i = 0; i < mao.length; i++) {
                if (mao[i] == null) {
                    mao[i] = Carta.getCartaById(idCarta);
                    return;
                }
            }
        } else {
            Efeito.aplicarEfeito(Efeito.DANO_HEROI_JOGADOR, idCarta);
        }
    }

    public void receberMoeda() {
        for (int i = 0; i < mao.length; i++) {
            if (mao[i] == null) {
                mao[i] = Carta.getCartaById(1);
                return;
            }
        }
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
        Main.getInstance().atualizaManaJogador();
    }

    public void removeCarta(int idPosicao) {
        this.mao[idPosicao] = null;
        Main.getInstance().atualizaMaoJogador();
    }

    public int getManaMaxima() {
        return this.manaMaxima;
    }

    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
        Main.getInstance().atualizaManaJogador();
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public Carta[] getMao() {
        return mao;
    }
}