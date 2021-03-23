package sample.entity;

public class CartaFeitico extends Carta {

    protected Efeito efeito;

    public CartaFeitico() {
    }

    public CartaFeitico(int id, int custoMana, String caminhoImagem, Efeito efeito) {
        super(id, custoMana, caminhoImagem);
        this.efeito = efeito;
    }
}