package sample.bd;

import sample.entity.Carta;
import sample.entity.CartaFeitico;
import sample.entity.CartaLacaio;
import sample.entity.Efeito;

public abstract class CartaBD {

    private static final String CARTA_ASSASSINAR = "carta_assassinar.png";
    private static final String CARTA_AVIVAR = "carta_avivar.png";
    private static final String VARTA_BOMBA_NEGRA = "carta_bomba_negra.png";
    private static final String CARTA_CROCOLISCO = "carta_crocolisco.png";
    private static final String CARTA_DISPARADA = "carta_disparada.png";
    private static final String CARTA_DISPARO_MORTAL = "carta_disparo_mortal.png";
    private static final String CARTA_ESTILHACAR = "carta_estilhacar.png";
    private static final String CARTA_FOGO_DALMA = "carta_fogo_dalma.png";
    private static final String CARTA_FOGO_LUNAR = "carta_fogo_lunar.png";
    private static final String CARTA_FURIANTE_MAGMA = "carta_furiante_magma.png";
    private static final String CARTA_GAIATO_MALIGNO = "carta_gaiato_maligno.png";
    private static final String CARTA_GOLEM_GUERRA = "carta_golem_guerra.png";
    private static final String CARTA_INTELECTO_ARCANO = "carta_intelecto_arcano.png";
    private static final String CARTA_JAVALI_PEDRATUSCO = "carta_javali_pedratusco.png";
    private static final String CARTA_LUTADORA_FOSSO = "carta_lutadora_fosso.png";
    private static final String CARTA_MOEDA = "carta_moeda.png";
    private static final String CARTA_MORDELISCA_OASIS = "carta_mordelisca_oasis.png";
    private static final String CARTA_MURLOC_SAQUEADOR = "carta_murloc_saqueador.png";
    private static final String CARTA_OGRO_PUNHO = "carta_ogro_punho.png";
    private static final String CARTA_PUNICAO_SAGRADA = "carta_punicao_sagrada.png";
    private static final String CARTA_RAPTO_DINO = "carta_rapto_dino.png";
    private static final String CARTA_TANQUE_ARANHA = "carta_tanque_aranha.png";
    private static final String CARTA_TIRO_ARCANO = "carta_tiro_arcano.png";
    private static final String CARTA_VERME_CARNICEIRO = "carta_verme_carniceiro.png";
    private static final String CARTA_YETI = "carta_yeti.png";

    public static <T extends Carta> T getCartaById(int id) {
        switch (id) {
            case 1:
                return (T) new CartaFeitico(id, 0, CARTA_MOEDA, new Efeito(Efeito.GANHA_MANA, 1));
            case 2:
                return (T) new CartaLacaio(id, 1, CARTA_JAVALI_PEDRATUSCO, 1, 1);
            case 3:
                return (T) new CartaLacaio(id, 1, CARTA_JAVALI_PEDRATUSCO, 1, 1);
            case 4:
                return (T) new CartaLacaio(id, 1, CARTA_MURLOC_SAQUEADOR, 2, 1);
            case 5:
                return (T) new CartaLacaio(id, 1, CARTA_MURLOC_SAQUEADOR, 2, 1);
            case 6:
                return (T) new CartaLacaio(id, 2, CARTA_CROCOLISCO, 2, 3);
            case 7:
                return (T) new CartaLacaio(id, 2, CARTA_RAPTO_DINO, 3, 2);
            case 8:
                return (T) new CartaLacaio(id, 2, CARTA_RAPTO_DINO, 3, 2);
            case 9:
                return (T) new CartaLacaio(id, 3, CARTA_FURIANTE_MAGMA, 5, 1);
            case 10:
                return (T) new CartaLacaio(id, 3, CARTA_TANQUE_ARANHA, 3, 4);
            case 11:
                return (T) new CartaLacaio(id, 3, CARTA_TANQUE_ARANHA, 3, 4);
            case 12:
                return (T) new CartaLacaio(id, 4, CARTA_MORDELISCA_OASIS, 2, 7);
            case 13:
                return (T) new CartaLacaio(id, 4, CARTA_MORDELISCA_OASIS, 2, 7);
            case 14:
                return (T) new CartaLacaio(id, 4, CARTA_GAIATO_MALIGNO, 5, 4);
            case 15:
                return (T) new CartaLacaio(id, 4, CARTA_GAIATO_MALIGNO, 5, 4);
            case 16:
                return (T) new CartaLacaio(id, 5, CARTA_LUTADORA_FOSSO, 5, 6);
            case 17:
                return (T) new CartaLacaio(id, 6, CARTA_OGRO_PUNHO, 6, 7);
            case 18:
                return (T) new CartaFeitico(id, 7, CARTA_DISPARADA, new Efeito(Efeito.COMPRA_CARTA, 4));
            case 19:
                return (T) new CartaFeitico(id, 1, CARTA_FOGO_DALMA, new Efeito(Efeito.COMPRA_CARTA, 1));
            case 20:
                return (T) new CartaFeitico(id, 1, CARTA_PUNICAO_SAGRADA, new Efeito(Efeito.DANO_HEROI_INIMIGO, 2));
            case 21:
                return (T) new CartaFeitico(id, 1, CARTA_PUNICAO_SAGRADA, new Efeito(Efeito.DANO_HEROI_INIMIGO, 2));
            case 22:
                return (T) new CartaFeitico(id, 0, CARTA_FOGO_LUNAR, new Efeito(Efeito.DANO_HEROI_INIMIGO, 1));
            case 23:
                return (T) new CartaFeitico(id, 0, CARTA_FOGO_LUNAR, new Efeito(Efeito.DANO_HEROI_INIMIGO, 1));
            case 24:
                return (T) new CartaFeitico(id, 2, VARTA_BOMBA_NEGRA, new Efeito(Efeito.DANO_HEROI_INIMIGO, 3));
            case 25:
                return (T) new CartaFeitico(id, 2, VARTA_BOMBA_NEGRA, new Efeito(Efeito.DANO_HEROI_INIMIGO, 3));
            case 26:
                return (T) new CartaFeitico(id, 0, CARTA_MOEDA, new Efeito(Efeito.GANHA_MANA, 1));
            case 27:
                return (T) new CartaFeitico(id, 0, CARTA_AVIVAR, new Efeito(Efeito.GANHA_MANA, 2));
            case 28:
                return (T) new CartaFeitico(id, 3, CARTA_DISPARO_MORTAL, new Efeito(Efeito.DANO_HEROI_INIMIGO, 5));
            case 29:
                return (T) new CartaFeitico(id, 3, CARTA_DISPARO_MORTAL, new Efeito(Efeito.DANO_HEROI_INIMIGO, 5));
            case 30:
                return (T) new CartaFeitico(id, 5, CARTA_ASSASSINAR, new Efeito(Efeito.DESTROI_INIMIGOS, 5));
            case 31:
                return (T) new CartaFeitico(id, 2, CARTA_ESTILHACAR, new Efeito(Efeito.GANHA_MANA, 5));
            case 32:
                return (T) new CartaLacaio(id, 1, CARTA_JAVALI_PEDRATUSCO, 1, 1);
            case 33:
                return (T) new CartaLacaio(id, 1, CARTA_JAVALI_PEDRATUSCO, 1, 1);
            case 34:
                return (T) new CartaLacaio(id, 1, CARTA_MURLOC_SAQUEADOR, 2, 1);
            case 35:
                return (T) new CartaLacaio(id, 1, CARTA_MURLOC_SAQUEADOR, 2, 1);
            case 36:
                return (T) new CartaLacaio(id, 2, CARTA_CROCOLISCO, 2, 3);
            case 37:
                return (T) new CartaLacaio(id, 2, CARTA_CROCOLISCO, 2, 3);
            case 38:
                return (T) new CartaLacaio(id, 2, CARTA_RAPTO_DINO, 3, 2);
            case 39:
                return (T) new CartaLacaio(id, 3, CARTA_FURIANTE_MAGMA, 5, 1);
            case 40:
                return (T) new CartaLacaio(id, 3, CARTA_VERME_CARNICEIRO, 2, 5);
            case 41:
                return (T) new CartaLacaio(id, 3, CARTA_VERME_CARNICEIRO, 2, 5);
            case 42:
                return (T) new CartaLacaio(id, 4, CARTA_MORDELISCA_OASIS, 2, 7);
            case 43:
                return (T) new CartaLacaio(id, 4, CARTA_MORDELISCA_OASIS, 2, 7);
            case 44:
                return (T) new CartaLacaio(id, 4, CARTA_YETI, 4, 5);
            case 45:
                return (T) new CartaLacaio(id, 4, CARTA_YETI, 4, 5);
            case 46:
                return (T) new CartaLacaio(id, 5, CARTA_LUTADORA_FOSSO, 5, 6);
            case 47:
                return (T) new CartaLacaio(id, 6, CARTA_OGRO_PUNHO, 6, 7);
            case 48:
                return (T) new CartaFeitico(id, 3, CARTA_INTELECTO_ARCANO, new Efeito(Efeito.COMPRA_CARTA, 2));
            case 49:
                return (T) new CartaFeitico(id, 3, CARTA_INTELECTO_ARCANO, new Efeito(Efeito.COMPRA_CARTA, 2));
            case 50:
                return (T) new CartaFeitico(id, 1, CARTA_FOGO_DALMA, new Efeito(Efeito.COMPRA_CARTA, 1));
            case 51:
                return (T) new CartaFeitico(id, 1, CARTA_FOGO_DALMA, new Efeito(Efeito.COMPRA_CARTA, 1));
            case 52:
                return (T) new CartaFeitico(id, 7, CARTA_DISPARADA, new Efeito(Efeito.COMPRA_CARTA, 4));
            case 53:
                return (T) new CartaFeitico(id, 1, CARTA_TIRO_ARCANO, new Efeito(Efeito.DANO_HEROI_INIMIGO, 2));
            case 54:
                return (T) new CartaFeitico(id, 1, CARTA_TIRO_ARCANO, new Efeito(Efeito.DANO_HEROI_INIMIGO, 2));
            case 55:
                return (T) new CartaFeitico(id, 0, CARTA_FOGO_LUNAR, new Efeito(Efeito.DANO_HEROI_INIMIGO, 1));
            case 56:
                return (T) new CartaFeitico(id, 0, CARTA_MOEDA, new Efeito(Efeito.GANHA_MANA, 1));
            case 57:
                return (T) new CartaFeitico(id, 0, CARTA_AVIVAR, new Efeito(Efeito.GANHA_MANA, 2));
            case 58:
                return (T) new CartaFeitico(id, 0, CARTA_AVIVAR, new Efeito(Efeito.GANHA_MANA, 2));
            case 59:
                return (T) new CartaFeitico(id, 3, CARTA_DISPARO_MORTAL, new Efeito(Efeito.DANO_HEROI_INIMIGO, 5));
            case 60:
                return (T) new CartaFeitico(id, 5, CARTA_ASSASSINAR, new Efeito(Efeito.DESTROI_INIMIGOS, 5));
            case 61:
                return (T) new CartaFeitico(id, 2, CARTA_ESTILHACAR, new Efeito(Efeito.GANHA_MANA, 5));
            default:
                return null;
        }
    }
}
