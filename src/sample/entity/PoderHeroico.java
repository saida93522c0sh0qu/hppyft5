package sample.entity;

public class PoderHeroico {

    protected String caminhoImg;
    protected Efeito efeito;

    public PoderHeroico(String caminhoImg, Efeito efeito) {
        this.caminhoImg = caminhoImg;
        this.efeito = efeito;
    }

    public String getCaminhoImg() {
        return caminhoImg;
    }

    public Efeito getEfeito() {
        return efeito;
    }

}