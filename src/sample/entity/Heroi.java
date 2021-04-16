package sample.entity;

import sample.bd.HeroiBD;

public class Heroi {

    protected int id;
    protected PoderHeroico poderHeroico;
    protected Baralho baralho;
    protected String caminhoImg;

    public Heroi(int id, PoderHeroico poderHeroico, Baralho baralho, String caminhoImg) {
        this.id = id;
        this.poderHeroico = poderHeroico;
        this.baralho = baralho;
        this.caminhoImg = Carta.CARTA_IMG_PATH + caminhoImg;
    }

    public int getId() {
        return id;
    }

    public PoderHeroico getPoderHeroico() {
        return poderHeroico;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public String getCaminhoImg() {
        System.out.println(caminhoImg);
        return caminhoImg;
    }


    public static Heroi getHeroiById(int idHeroi) {
        return HeroiBD.getHeroiById(idHeroi);
    }
}