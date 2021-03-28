package sample.entity;

import java.util.List;

public class Baralho {

    protected List<Integer> cartas;
    protected int cartasRestantes;

    public Baralho(List<Integer> cartas) {
        this.cartas = cartas;
        this.cartasRestantes = 30;
    }

    public Integer retiraCarta() {
        if (cartasRestantes > 0) {
            Integer idCarta = (int) Math.round(Math.random() * cartasRestantes);
            cartas.remove(idCarta);
            cartasRestantes--;
            return idCarta;
        } else {
            return --cartasRestantes;
        }
    }
}