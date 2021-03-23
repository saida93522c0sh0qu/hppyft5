package sample.entity;

import sample.Main;

public class Tabuleiro {

    protected Jogador jogador1;
    protected Jogador jogador2;
    protected CartaLacaio[] cartaPosicoesJogador1;
    protected CartaLacaio[] cartaPosicoesJogador2;
//    protected Integer[] idCartaPosicoesJogador1;
//    protected Integer[] idCartaPosicoesJogador2;

    public Jogador getJogador1() {
        return this.jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return this.jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public CartaLacaio[] getCartaPosicoesJogador1() {
        return cartaPosicoesJogador1;
    }

    public void setCartaPosicoesJogador1(CartaLacaio[] cartaPosicoesJogador1) {
        this.cartaPosicoesJogador1 = cartaPosicoesJogador1;
    }

    public CartaLacaio[] getCartaPosicoesJogador2() {
        return cartaPosicoesJogador2;
    }

    public void setCartaPosicoesJogador2(CartaLacaio[] cartaPosicoesJogador2) {
        this.cartaPosicoesJogador2 = cartaPosicoesJogador2;
    }

    public Integer[] getIdCartaPosicoesJogador1() {
        return getIdCartas(cartaPosicoesJogador1);
    }

    public Integer[] getIdCartaPosicoesJogador2() {
        return getIdCartas(cartaPosicoesJogador2);
    }

    private Integer[] getIdCartas(CartaLacaio[] arrayLacaios) {
        Integer[] idCartas = new Integer[5];
        for (int i = 0; i < arrayLacaios.length; i++) {
            CartaLacaio carta = arrayLacaios[i];
            if (carta != null) {
                idCartas[i] = carta.getId();
            } else {
                idCartas[i] = null;
            }
        }
        return idCartas;
    }

    public void setIdCartaPosicoesJogador1(Integer[] idCartas) {
        setIdCartas(idCartas, cartaPosicoesJogador1);
    }

    public void setIdCartaPosicoesJogador2(Integer[] idCartas) {
        setIdCartas(idCartas, cartaPosicoesJogador2);
    }

    private void setIdCartas(Integer[] idCartas, CartaLacaio[] cartas) {
        for (int i = 0; i < idCartas.length; i++) {
            Integer idCarta = idCartas[i];
            if (idCarta != null) {
                cartas[i] = Carta.getCartaById(idCarta);
            } else {
                cartas[i] = null;
            }
        }
    }

    public boolean adicionaLacaio(int idCarta) {
        for (int i = 0; i < cartaPosicoesJogador1.length; i++) {
            Carta carta = cartaPosicoesJogador1[i];
            if (carta == null) {
                cartaPosicoesJogador1[i] = Carta.getCartaById(idCarta);
                Main.getInstance().atualizaTelaJogo();
                return true;
            }
        }
        return false;
    }

    public void limparLacaiosInimigos() {
        for (int i = 0; i < cartaPosicoesJogador2.length; i++) {
            cartaPosicoesJogador2[i] = null;
        }
    }

    public void promoverAtaques() {
        for (int i = 0; i < cartaPosicoesJogador1.length; i++) {
            CartaLacaio cartaJogador = cartaPosicoesJogador1[i];
            if (cartaJogador != null) {
                CartaLacaio cartaAdversario = cartaPosicoesJogador2[i];
                if (cartaAdversario != null) {
                    cartaJogador.setVida(cartaJogador.getVida() - cartaAdversario.getAtaque());
                    cartaAdversario.setVida(cartaAdversario.getVida() - cartaJogador.getAtaque());
                    if (cartaJogador.getVida() <= 0) {
                        cartaPosicoesJogador1[i] = null;
//                        idCartaPosicoesJogador1[i] = null;
                    }
                    if (cartaAdversario.getVida() <= 0) {
                        cartaPosicoesJogador2[i] = null;
//                        idCartaPosicoesJogador2[i] = null;
                    }
                } else {
                    jogador2.setPontosDeVida(jogador2.getPontosDeVida() - cartaJogador.getAtaque());
                }
            }
        }
    }
}