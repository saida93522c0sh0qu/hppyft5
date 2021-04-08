package sample.entity;

public class CartaLacaio extends Carta {

    protected int ataque;
    protected int vida;

    public CartaLacaio(int id, int custoMana, String caminhoImagem, int ataque, int vida) {
        super(id, custoMana, caminhoImagem);
        this.ataque = ataque;
        this.vida = vida;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}