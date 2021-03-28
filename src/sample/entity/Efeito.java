package sample.entity;

import sample.Main;

public class Efeito {

    public static final int DANO_HEROI_INIMIGO = 1;
    public static final int COMPRA_CARTA = 2;
    public static final int DESTROI_INIMIGOS = 3;
    public static final int GANHA_MANA = 4;
    public static final int DANO_HEROI_JOGADOR = 5;

    protected int efeitoId;
    protected int qtdEfeito;

    public Efeito(int efeitoId, int qtdEfeito) {
        this.efeitoId = efeitoId;
        this.qtdEfeito = qtdEfeito;
    }

    public int getEfeitoId() {
        return efeitoId;
    }

    public static void aplicarEfeito(int efeitoId, int qtdEfeito) {
        switch (efeitoId) {
            case DANO_HEROI_INIMIGO:
                int ptsVidaInimigo = Main.getInstance().getTabuleiro().getAdversario().getPontosDeVida();
                Main.getInstance().getTabuleiro().getAdversario().setPontosDeVida(ptsVidaInimigo - qtdEfeito);
                break;
            case COMPRA_CARTA:
                for (int i = 0; i < qtdEfeito; i++) {
                    Main.getInstance().getTabuleiro().getJogador().comprarCarta();
                }
                break;
            case DESTROI_INIMIGOS:
                Main.getInstance().getTabuleiro().destruirLacaiosInimigos();
                break;
            case GANHA_MANA:
                int manaAtual = Main.getInstance().getTabuleiro().getJogador().getManaAtual();
                Main.getInstance().getTabuleiro().getJogador().setManaAtual(manaAtual + qtdEfeito);
                break;
            case DANO_HEROI_JOGADOR:
                int ptsVidaJogador = Main.getInstance().getTabuleiro().getJogador().getPontosDeVida();
                Main.getInstance().getTabuleiro().getJogador().setPontosDeVida(ptsVidaJogador - qtdEfeito);
                break;
        }
        Main.getInstance().atualizaTelaJogo();
    }

}