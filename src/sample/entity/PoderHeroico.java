package sample.entity;

import javafx.scene.image.ImageView;

public class PoderHeroico {

    protected ImageView img;
    protected Efeito efeito;

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public Efeito getEfeito() {
        return efeito;
    }

    public void setEfeito(Efeito efeito) {
        this.efeito = efeito;
    }
}