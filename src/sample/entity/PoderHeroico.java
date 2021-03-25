package sample.entity;

import javafx.scene.image.ImageView;

public class PoderHeroico {

    protected String caminhoImg;
    protected Efeito efeito;

    public PoderHeroico(String caminhoImg, Efeito efeito) {
        this.caminhoImg = caminhoImg;
        this.efeito = efeito;
    }

    public PoderHeroico() {
    }

    public String getCaminhoImg() {
        return caminhoImg;
    }

    public void setCaminhoImg(String caminhoImg) {
        this.caminhoImg = caminhoImg;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }
}