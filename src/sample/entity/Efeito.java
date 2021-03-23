package sample.entity;

import sample.Main;

public class Efeito {

    public static final int DANO_HEROI = 1;
    public static final int COMPRA_CARTA = 2;
    public static final int DESTROI_INIMIGOS = 3;
    public static final int GANHA_MANA = 4;

    protected int efeitoId;

    public Efeito(int efeitoId) {
        this.efeitoId = efeitoId;
    }

    public int getEfeitoId() {
        return efeitoId;
    }

    public static void aplicarEfeito(int efeitoId) {
        // TODO - implement Efeito.aplicarEfeito
        Main.getInstance().atualizaTelaJogo();
    }

}