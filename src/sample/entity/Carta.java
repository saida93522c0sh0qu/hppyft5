package sample.entity;

import br.ufsc.inf.leobr.cliente.EstadoProxy;
import sample.bd.CartaBD;

public abstract class Carta {

    public static final String CARTA_IMG_PATH = "src\\sample\\images\\";

    protected int id;
    protected int custoMana;
    protected String caminhoImagem;

    public Carta(int id, int custoMana, String caminhoImagem) {
        this.id = id;
        this.custoMana = custoMana;
        this.caminhoImagem = CARTA_IMG_PATH + caminhoImagem;
    }

    public Carta() {
    }

    public static <T extends Carta> T getCartaById(int idCarta) {
        return CartaBD.getCartaById(idCarta);
    }

    public int getCustoMana() {
        return this.custoMana;
    }

    public void setCustoMana(int custoMana) {
        this.custoMana = custoMana;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = CARTA_IMG_PATH + caminhoImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}