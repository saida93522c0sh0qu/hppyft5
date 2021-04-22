package sample;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.entity.Heroi;
import sample.netgames.AtorRede;

/**
 * Created by Léo on 25/06/2017.
 */
public class TelaSelecaoPresenterImpl {

    protected static final double OPACITY_NOT_SELECTABLE = 0.25;
    protected static final double OPACITY_SELECTABLE = 0.7;
    protected static final double OPACITY_SELECTED = 1;
    protected static final String VIEW_ID_BRUXO_SELECAO = "#bruxo_selecao";
    protected static final String VIEW_ID_ESCOLHA_BUTTON = "#escolha_button";
    protected static final String VIEW_ID_CACADOR_SELECAO = "#cacador_selecao";
    protected static final String VIEW_ID_PROCURAR_PARTIDA_BUTTON = "#procurar_partida_button";

    protected Integer mIdHeroiSelecionado = null;
    protected boolean mHeroiConfirmado = false;

    public void onProcurarPartidaClicked(MouseEvent mouseEvent) throws Exception {
        Main.getInstance().procurarPartida();
    }

    public void onBruxoSelecaoClicked(MouseEvent mouseEvent) {
        if (!mHeroiConfirmado) {
            selectHero(1, VIEW_ID_BRUXO_SELECAO);
        }
    }

    public void onCacadorSelecaoClicked(MouseEvent mouseEvent) {
        if (!mHeroiConfirmado) {
            selectHero(2, VIEW_ID_CACADOR_SELECAO);
        }
    }

    private void selectHero(Integer idHeroi, String idView) {
        deselectCurrentHero();
        mIdHeroiSelecionado = idHeroi;
        ImageView view = (ImageView) Main.getInstance().stage.getScene().lookup(idView);
        view.setOpacity(OPACITY_SELECTED);
    }

    private void deselectCurrentHero() {
        if (mIdHeroiSelecionado != null) {
            String idView = "";
            switch (mIdHeroiSelecionado) {
                case 1:
                    idView = VIEW_ID_BRUXO_SELECAO;
                    break;
                case 2:
                    idView = VIEW_ID_CACADOR_SELECAO;
                    break;
            }
            ImageView view = (ImageView) Main.getInstance().stage.getScene().lookup(idView);
            view.setOpacity(OPACITY_SELECTABLE);
            mIdHeroiSelecionado = null;
        }
    }

    public void onBotaoEscolhidoClicked(MouseEvent mouseEvent) {
        if (!mHeroiConfirmado && mIdHeroiSelecionado != null && Main.getInstance().conectar()) {
            changeEscolhidoOpacity();

            mHeroiConfirmado = true;

            Main.getInstance().recebeIdHeroi(mIdHeroiSelecionado);
        }

    }

    private void changeEscolhidoOpacity() {
        Scene scene = Main.getInstance().stage.getScene();
        ImageView escolhaButton = (ImageView) scene.lookup(VIEW_ID_ESCOLHA_BUTTON);
        ImageView bruxoSelecao = (ImageView) scene.lookup(VIEW_ID_BRUXO_SELECAO);
        ImageView cacadorSelecao = (ImageView) scene.lookup(VIEW_ID_CACADOR_SELECAO);
        ImageView procurarPartidaButton = (ImageView) scene.lookup(VIEW_ID_PROCURAR_PARTIDA_BUTTON);

        escolhaButton.setOpacity(OPACITY_NOT_SELECTABLE);
        bruxoSelecao.setOpacity(OPACITY_NOT_SELECTABLE);
        cacadorSelecao.setOpacity(OPACITY_NOT_SELECTABLE);
        procurarPartidaButton.setOpacity(OPACITY_SELECTED);
    }
}
