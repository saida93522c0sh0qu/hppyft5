package sample.entity;

import java.util.ArrayList;

public class Baralho {

    protected ArrayList<Integer> cartas;
    protected int cartasRestantes;

    public Baralho(ArrayList<Integer> cartas) {
        this.cartas = cartas;
        this.cartasRestantes = 30;
    }

    public Integer retiraCarta() {
        if (cartasRestantes > 0) {
            int index = (int) Math.round(Math.random() * 1000) % cartasRestantes;
            Integer cartaId = cartas.get(index);
            cartas.remove(index);
            cartasRestantes--;
            return cartaId;
        } else {
            return --cartasRestantes;
        }
    }
}