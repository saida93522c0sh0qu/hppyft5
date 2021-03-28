package sample.bd;

import sample.entity.Carta;
import sample.entity.CartaFeitico;
import sample.entity.CartaLacaio;
import sample.entity.Efeito;

public abstract class CartaBD {

    public static <T extends Carta> T getCartaById(int id) {
        switch (id) {
            case 1:
                return (T) new CartaFeitico(id, 0, "carta_moeda.png", new Efeito(Efeito.GANHA_MANA, 1));
            case 2:
                return (T) new CartaLacaio(id, 2, "carta_crocolisco.png", 2, 3);
            case 3:
                //TODO AQUI TU SÓ DA-LHE, SEGUE O EXEMPLO DOS ANTERIORES, SALVA A IMAGEM COM AQUELE NOME, E SOH VAI
            default:
                return null;
        }
    }
}
