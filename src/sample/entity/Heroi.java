package sample.entity;

public class Heroi {

    protected int id;
    protected PoderHeroico poderHeroico;
    protected Baralho baralho;
    protected String caminhoImg;

    public Heroi(PoderHeroico poderHeroico, Baralho baralho, String caminhoImg) {
        this.poderHeroico = poderHeroico;
        this.baralho = baralho;
        this.caminhoImg = Carta.CARTA_IMG_PATH + caminhoImg;
    }

    public Heroi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCaminhoImg() {
        return caminhoImg;
    }

    public void setCaminhoImg(String caminhoImg) {
        this.caminhoImg = Carta.CARTA_IMG_PATH + caminhoImg;
    }

    public static Heroi getHeroiById(int idHeroi) {
        //TODO FAZER SWITCH DOS HEROI AQUI
        return null;
    }
}