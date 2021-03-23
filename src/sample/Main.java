package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.entity.*;

import java.util.ArrayList;

public class Main extends Application {

    private static final String APP_TITLE = "HEARTHSTONE";
    private static final String ID_BOTAO_CONFIRMAR = "#confirmar_button";
    private static final String ID_BOTAO_CANCELAR = "#cancelar_button";
    private static final String ID_CARTA_SELECIONADA = "#carta_mostrada";

    protected Stage stage;
    private static Main instance;

    protected Tabuleiro tabuleiro;

    protected boolean procurou;
    protected boolean ganhou;
    protected boolean acabou;
    protected boolean botoesCartaDisponiveis = false;
    protected boolean botoesGeraisDisponiveis = false;

    protected int idCartaMostrada;
    protected int idPosicaoCartaMostrada;
    protected Integer mIdHeroijogador;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        if (null == instance) {
            instance = new Main();
        }
        return instance;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getIdCartaMostrada() {
        return this.idCartaMostrada;
    }

    public void setIdCartaMostrada(int idCartaMostrada) {
        this.idCartaMostrada = idCartaMostrada;
    }

    private void goToTelaInicial() throws Exception {
        replaceSceneContent("tela_inicial.fxml");
        stage.show();
    }

    public void goToTelaSelecao() throws Exception {
        replaceSceneContent("tela_selecao.fxml");
        stage.setWidth(1133.0);
        stage.setHeight(440.0);
        stage.show();
    }

    public void goToTelaJogo() throws Exception {
        replaceSceneContent("tela_jogo.fxml");
        stage.setWidth(982.0);
        stage.setHeight(620.0);
        stage.show();
    }

    public void habilitarBotoes() {
        this.botoesGeraisDisponiveis = true;
    }

    public void desabilitarBotoes() {
        this.botoesGeraisDisponiveis = false;
    }

    public void showBotoesCarta() {
        setImgVisible(ID_BOTAO_CONFIRMAR);
        setImgVisible(ID_BOTAO_CANCELAR);
        setImgVisible(ID_CARTA_SELECIONADA);
        this.botoesCartaDisponiveis = true;
    }

    public void hideBotoesCarta() {
        setImgGone(ID_BOTAO_CONFIRMAR);
        setImgGone(ID_BOTAO_CANCELAR);
        setImgGone(ID_CARTA_SELECIONADA);
        this.botoesCartaDisponiveis = false;
    }

    private void setImgVisible(String id) {
        ImageView view = (ImageView) stage.getScene().lookup(id);
        view.setVisible(true);
    }

    private void setImgGone(String id) {
        ImageView view = (ImageView) stage.getScene().lookup(id);
        view.setVisible(false);
    }

    private Parent replaceSceneContent(String fxml) throws Exception {
        Parent page = FXMLLoader.load(getClass().getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page, 993, 544);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        stage.sizeToScene();
        return page;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle(APP_TITLE);
        goToTelaInicial();
    }

    public void procurarPartida() {
        //TODO Chamar procurar partida do netgames
    }

    public void receberSolicitacaoInicio() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = initJogador();
        jogador.setIdHeroi(mIdHeroijogador);
        tabuleiro.setJogador1(jogador);
        if (procurou) {
            InformacoesIniciais informacoesIniciais = new InformacoesIniciais();
            informacoesIniciais.setIdHeroi(mIdHeroijogador);
            //TODO chamar enviarJogada do netgames
        }
    }

    private Jogador initJogador() {
        Jogador jogador = new Jogador();
        jogador.setPhHabilitado(true);
        jogador.setManaAtual(0);
        jogador.setManaMaxima(0);
        jogador.setPontosDeVida(30);
        return jogador;
    }

    public void receberJogada(Jogada jogada) throws Exception {
        if (jogada instanceof InformacoesIniciais) {
            Jogador jogador2 = initJogador();
            jogador2.setIdHeroi(((InformacoesIniciais) jogada).getIdHeroi());
            tabuleiro.setJogador2(jogador2);
            if (!procurou) {
                InformacoesIniciais informacoesIniciais = new InformacoesIniciais();
                informacoesIniciais.setIdHeroi(tabuleiro.getJogador1().getIdHeroi());
                //TODO chamar enviarJogada do netgames
            }

            prepararMaosPrimeiroTurno();
        } else {
            InformacoesJogada informacoesJogada = (InformacoesJogada) jogada;
            tabuleiro.setIdCartaPosicoesJogador1(informacoesJogada.getIdCartasNoCampo2());
            tabuleiro.setIdCartaPosicoesJogador2(informacoesJogada.getIdCartasNoCampo1());
            tabuleiro.getJogador1().setPontosDeVida(informacoesJogada.getVidaJogador2());
            tabuleiro.getJogador2().setPontosDeVida(informacoesJogada.getVidaJogador1());
            if (acabou) {
                if (tabuleiro.getJogador2().getPontosDeVida() <= 0) {
                    ganhou = false;
                } else {
                    ganhou = true;
                }
                endGameIfNeeded();
            }
        }
    }

    private void endGameIfNeeded() throws Exception {
        if (acabou) {
            showResultadoJogo();

            //TODO chamar netgames desconectar
        }
    }

    public void prepararMaosPrimeiroTurno() throws Exception {
        goToTelaJogo();
        for (int i = 0; i < 3; i++) {
            tabuleiro.getJogador1().comprarCarta();
        }
        if (!procurou) {
            tabuleiro.getJogador1().comprarCarta();
            tabuleiro.getJogador1().receberMoeda();
        } else {
            prepararInicioTurno();
        }
    }

    public void prepararInicioTurno() {
        Jogador jogador1 = getTabuleiro().getJogador1();
        jogador1.comprarCarta();
        habilitarBotoes();
        jogador1.setPhHabilitado(true);
        int manaMax = jogador1.getManaMaxima();
        if (manaMax < 10) {
            jogador1.setManaMaxima(++manaMax);
        }
        jogador1.setManaAtual(manaMax);
    }

    public void usarPoderHeroico() {
        Jogador jogador = getTabuleiro().getJogador1();
        if (jogador.getPhHabilitado()) {
            int manaAtual = jogador.getManaAtual();
            if (manaAtual >= 2) {
                jogador.setManaAtual(manaAtual - 2);
                Efeito.aplicarEfeito(jogador.getHeroi().getPoderHeroico().getEfeito().getEfeitoId());
                jogador.setPhHabilitado(false);
            }
        }
    }

    public void abrirCarta(int idPosicaoMao) {
        idCartaMostrada = idPosicaoMao;
        ImageView imageView = (ImageView) stage.getScene().lookup(ID_CARTA_SELECIONADA);
        Image img = new Image(Carta.getCartaById(getTabuleiro().getJogador1().getIdCarta(idCartaMostrada)).getCaminhoImagem());
        imageView.setImage(img);
        showBotoesCarta();
    }

    public void enviarJogada() throws Exception {
        InformacoesJogada informacoesJogada = new InformacoesJogada();
        informacoesJogada.setIdCartasNoCampo1(tabuleiro.getIdCartaPosicoesJogador1());
        informacoesJogada.setIdCartasNoCampo2(tabuleiro.getIdCartaPosicoesJogador2());
        informacoesJogada.setJogoAcabou(acabou);
        informacoesJogada.setVidaJogador1(tabuleiro.getJogador1().getPontosDeVida());
        informacoesJogada.setVidaJogador2(tabuleiro.getJogador2().getPontosDeVida());

        endGameIfNeeded();
    }

    public void promoverAtaques() throws Exception {
        getTabuleiro().promoverAtaques();
        verificaFimJogo();
    }

    public void verificaFimJogo() throws Exception {
        if (tabuleiro.getJogador1().getPontosDeVida() <= 0 || tabuleiro.getJogador2().getPontosDeVida() <= 0) {
            acabou = true;
            enviarJogada();
        }
    }

    public void showResultadoJogo() throws Exception {
        if (ganhou) {
            replaceSceneContent("ganhou.fxml");
        } else {
            replaceSceneContent("perdeu.fxml");
        }
    }

    public void recebeIdHeroi(Integer mIdHeroiSelecionado) {
        mIdHeroijogador = mIdHeroiSelecionado;
    }

    public void atualizaTelaJogo() {
        //TODO Atualizar tela de jogo
    }
}