package sample.entity;

import sample.Main;

public class Tabuleiro {

    protected Jogador jogador;
    protected Jogador adversario;
    protected CartaLacaio[] cartaPosicoesJogador;
    protected CartaLacaio[] cartaPosicoesAdversario;

    public Tabuleiro() {
        this.cartaPosicoesJogador = new CartaLacaio[5];
        this.cartaPosicoesAdversario = new CartaLacaio[5];
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Jogador getAdversario() {
        return this.adversario;
    }

    public void setAdversario(Jogador adversario) {
        this.adversario = adversario;
    }

    public CartaLacaio[] getCartaPosicoesJogador() {
        return cartaPosicoesJogador;
    }

    public void setCartaPosicoesJogador(CartaLacaio[] cartaPosicoesJogador) {
        this.cartaPosicoesJogador = cartaPosicoesJogador;
    }

    public CartaLacaio[] getCartaPosicoesAdversario() {
        return cartaPosicoesAdversario;
    }

    public void setCartaPosicoesAdversario(CartaLacaio[] cartaPosicoesAdversario) {
        this.cartaPosicoesAdversario = cartaPosicoesAdversario;
    }

    public Integer[] getIdCartaPosicoesJogador1() {
        return getIdCartas(cartaPosicoesJogador);
    }

    public Integer[] getIdCartaPosicoesJogador2() {
        return getIdCartas(cartaPosicoesAdversario);
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
        setIdCartas(idCartas, cartaPosicoesJogador);
    }

    public void setIdCartaPosicoesJogador2(Integer[] idCartas) {
        setIdCartas(idCartas, cartaPosicoesAdversario);
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
        for (int i = 0; i < cartaPosicoesJogador.length; i++) {
            Carta carta = cartaPosicoesJogador[i];
            if (carta == null) {
                cartaPosicoesJogador[i] = Carta.getCartaById(idCarta);
                Main.getInstance().atualizaTelaJogo();
                return true;
            }
        }
        return false;
    }

    public void limparLacaiosInimigos() {
        for (int i = 0; i < cartaPosicoesAdversario.length; i++) {
            cartaPosicoesAdversario[i] = null;
        }
    }

    public void promoverAtaques() {
        for (int i = 0; i < cartaPosicoesJogador.length; i++) {
            CartaLacaio cartaJogador = cartaPosicoesJogador[i];
            if (cartaJogador != null) {
                CartaLacaio cartaAdversario = cartaPosicoesAdversario[i];
                if (cartaAdversario != null) {
                    cartaJogador.setVida(cartaJogador.getVida() - cartaAdversario.getAtaque());
                    cartaAdversario.setVida(cartaAdversario.getVida() - cartaJogador.getAtaque());
                    if (cartaJogador.getVida() <= 0) {
                        cartaPosicoesJogador[i] = null;
//                        idCartaPosicoesJogador1[i] = null;
                    }
                    if (cartaAdversario.getVida() <= 0) {
                        cartaPosicoesAdversario[i] = null;
//                        idCartaPosicoesJogador2[i] = null;
                    }
                } else {
                    adversario.setPontosDeVida(adversario.getPontosDeVida() - cartaJogador.getAtaque());
                }
            }
        }
    }

    public Integer[] getVidaLacaiosJogador() {
        return getVidaCartas(cartaPosicoesJogador);
    }

    public Integer[] getVidaLacaiosAdversario() {
        return getVidaCartas(cartaPosicoesAdversario);
    }

    private Integer[] getVidaCartas(CartaLacaio[] cartas) {
        Integer[] vidas = new Integer[5];
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) {
                vidas[i] = cartas[i].getVida();
            }
        }
        return vidas;
    }

    public void setVidaLacaiosJogador(Integer[] vidaLacaiosJogador) {
        setVidaCartas(vidaLacaiosJogador, cartaPosicoesJogador);
    }

    public void setVidaLacaiosAdversario(Integer[] vidaLacaiosAdversario) {
        setVidaCartas(vidaLacaiosAdversario, cartaPosicoesAdversario);
    }

    private void setVidaCartas(Integer[] vidas, CartaLacaio[] cartas) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) {
                cartas[i].setVida(vidas[i]);
            }
        }
    }
}