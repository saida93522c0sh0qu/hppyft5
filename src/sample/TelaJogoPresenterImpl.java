package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaJogoPresenterImpl {

    public void onPoderHeroicoClicked(MouseEvent mouseEvent) {
    }

    public void onCartaMesa1Clicked(MouseEvent mouseEvent) {
        //TODO TIRAR ISSO AKI DEPOIS
        ImageView imgView = (ImageView) Main.getInstance().stage.getScene().lookup("#carta_mesa_jogador_1");
//        Image image1 = new Image("/src/sample/carta_teste2.png", 83.0, 118.0, false, false);
        Image image1 = new Image("C:\\Users\\Léo\\IdeaProjects\\Hearthstone_APS_Alpha\\src\\sample\\carta_teste2.png");
        imgView.setImage(null);
        imgView.setImage(image1);
        System.out.println("passou aki");
    }

    public void onCarta1Clicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCartaClicked
        throw new UnsupportedOperationException();
    }

    public void onCarta2Clicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCartaClicked
        throw new UnsupportedOperationException();
    }

    public void onCarta3Clicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCartaClicked
        throw new UnsupportedOperationException();
    }

    public void onCarta4Clicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCartaClicked
        throw new UnsupportedOperationException();
    }

    public void onCarta5Clicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCartaClicked
        throw new UnsupportedOperationException();
    }

    public void onCarta6Clicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCartaClicked
        throw new UnsupportedOperationException();
    }

    public void onDesistirClicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onDesistirClicked
        throw new UnsupportedOperationException();
    }

    public void onFinalizarTurnoClicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onFinalizarTurnoClicked
        throw new UnsupportedOperationException();
    }

    public void onCancelarClicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onCancelarClicked
        throw new UnsupportedOperationException();
    }

    public void onConfirmarClicked(MouseEvent mouseEvent) {
        // TODO - implement TelaJogoPresenterImpl.onConfirmarClicked
        throw new UnsupportedOperationException();
    }

}