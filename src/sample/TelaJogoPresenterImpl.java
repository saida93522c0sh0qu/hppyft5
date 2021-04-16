package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TelaJogoPresenterImpl {

    public void onPoderHeroicoClicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().usarPoderHeroico();
        }
    }

    public void onCarta0Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(0);
        }
    }

    public void onCarta1Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(1);
        }
    }

    public void onCarta2Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(2);
        }
    }

    public void onCarta3Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(3);
        }
    }

    public void onCarta4Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(4);
        }
    }

    public void onCarta5Clicked(MouseEvent mouseEvent) {
        if (Main.getInstance().botoesGeraisDisponiveis) {
            Main.getInstance().abrirCarta(5);
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