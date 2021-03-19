package sample;

import javafx.scene.input.MouseEvent;

public class TelaInicialPresenterImpl {

    public void onPlayClicked(MouseEvent mouseEvent) throws Exception {
        Main.getInstance().goToTelaSelecao();
    }
}
