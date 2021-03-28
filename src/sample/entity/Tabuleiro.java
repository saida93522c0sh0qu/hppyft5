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

    public void setIdCartaPosicoesJogador(Integer[] idCartas) {
        setIdCartas(idCartas, cartaPosicoesJogador);
        Main.getInstance().atualizaMesaJogador();
    }

    public void setIdCartaPosicoesAdversario(Integer[] idCartas) {
        setIdCartas(idCartas, cartaPosicoesAdversario);
        Main.getInstance().atualizaMesaAdversario();
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

    public boolean adicionaLacaio(CartaLacaio cartalacaio) {
        for (int i = 0; i < cartaPosicoesJogador.length; i++) {
            CartaLacaio cartaAtual = cartaPosicoesJogador[i];
            if (cartaAtual == null) {
                cartaPosicoesJogador[i] = cartalacaio;
                Main.getInstance().atualizaTelaJogo();
                return true;
            }
        }
        return false;
    }

    public void destruirLacaiosInimigos() {
        for (int i = 0; i < cartaPosicoesAdversario.length; i++) {
            cartaPosicoesAdversario[i] = null;
        }
        Main.getInstance().atualizaMesaAdversario();
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
                    }
                    if (cartaAdversario.getVida() <= 0) {
                        cartaPosicoesAdversario[i] = null;
                    }
                    Main.getInstance().atualizaMesaJogador();
                    Main.getInstance().atualizaMesaAdversario();
                } else {
                    Efeito.aplicarEfeito(Efeito.DANO_HEROI_INIMIGO, cartaJogador.getAtaque());

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
        Main.getInstance().atualizaMesaJogador();
    }

    public void setVidaLacaiosAdversario(Integer[] vidaLacaiosAdversario) {
        setVidaCartas(vidaLacaiosAdversario, cartaPosicoesAdversario);
        Main.getInstance().atualizaMesaAdversario();
    }

    private void setVidaCartas(Integer[] vidas, CartaLacaio[] cartas) {
        for (int i = 0; i < cartas.length; i++) {
            if (cartas[i] != null) {
                cartas[i].setVida(vidas[i]);
            }
        }
    }
}