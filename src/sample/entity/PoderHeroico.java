package sample.entity;

public class PoderHeroico {

    protected String caminhoImg;
    protected Efeito efeito;

    public PoderHeroico(String caminhoImg, Efeito efeito) {
        this.caminhoImg = Carta.CARTA_IMG_PATH + caminhoImg;
        this.efeito = efeito;
    }

    public String getCaminhoImg() {
        System.out.println(caminhoImg);
        return caminhoImg;
    }

    public Efeito getEfeito() {
        return efeito;
    }

}