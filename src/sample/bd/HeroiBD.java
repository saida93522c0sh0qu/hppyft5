package sample.bd;

import sample.entity.Baralho;
import sample.entity.Efeito;
import sample.entity.Heroi;
import sample.entity.PoderHeroico;

import java.util.ArrayList;
import java.util.List;

public class HeroiBD {
    public static Heroi getHeroiById(int idHeroi) {
        switch (idHeroi) {
            case 1:
                PoderHeroico ph1 = new PoderHeroico("ph_bruxo.png", new Efeito(Efeito.COMPRA_CARTA, 1));
                List<Integer> list1 = new ArrayList<>();
                for (int i = 2; i <= 31; i++) {
                    list1.add(i);
                }
                Baralho bar1 = new Baralho(list1);
                return new Heroi(idHeroi, ph1, bar1, "bruxo_jogo.png");
            case 2:
                PoderHeroico ph2 = new PoderHeroico("ph_cacador.png", new Efeito(Efeito.DANO_HEROI_INIMIGO, 2));
                List<Integer> list2 = new ArrayList<>();
                for (int i = 32; i <= 61; i++) {
                    list2.add(i);
                }
                Baralho bar2 = new Baralho(list2);
                return new Heroi(idHeroi, ph2, bar2, "cacador_jogo.png");
            default:
                return null;
        }
    }
}
