package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaJogoPresenterImpl {

    public void onPoderHeroicoClicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().usarPoderHeroico();
        }
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

    public void onCarta0Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(1);
        }
    }

    public void onCarta1Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(2);
        }
    }

    public void onCarta2Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(3);
        }
    }

    public void onCarta3Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(4);
        }
    }

    public void onCarta4Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(5);
        }
    }

    public void onCarta5Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(6);
        }
    }

    public void onDesistirClicked(MouseEvent mouseEvent) throws Exception {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().desistir();
        }
    }

    public void onFinalizarTurnoClicked(MouseEvent mouseEvent) throws Exception {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().finalizarTurno();
        }
    }

    public void onCancelarClicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesCartaDisponiveis) {
            Main.getInstance().cancelarCartaMostrada();
        }
    }

    public void onConfirmarClicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesCartaDisponiveis) {
            Main.getInstance().usarCartaMostrada();
        }
    }

}