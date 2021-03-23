package sample.entity;

import javafx.scene.image.ImageView;

public class Heroi {

    protected PoderHeroico poderHeroico;
    protected Baralho baralho;
    protected ImageView img;

    public PoderHeroico getPoderHeroico() {
        return poderHeroico;
    }

    public void setPoderHeroico(PoderHeroico poderHeroico) {
        this.poderHeroico = poderHeroico;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
}