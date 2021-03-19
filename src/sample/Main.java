package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.entity.Jogada;
import sample.entity.Tabuleiro;

public class Main extends Application {

    private static final String ID_BOTAO_CONFIRMAR = "#confirmar_button";
    private static final String ID_BOTAO_CANCELAR = "#cancelar_button";
    private static final String APP_TITLE = "HEARTHSTONE";
    protected Stage stage;
    private static Main instance;
    protected boolean procurou;
    protected Tabuleiro tabuleiro;
    protected boolean ganhou;
    protected int idCartaMostrada;
    protected int idPosicaoCartaMostrada;
    protected boolean acabou;
    protected boolean botoesCartaDisponiveis;
    protected boolean botoesGeraisDisponiveis;

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

    /**
     * @param tabuleiro
     */
    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getIdCartaMostrada() {
        return this.idCartaMostrada;
    }

    /**
     * @param idCartaMostrada
     */
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
    }

    public void hideBotoesCarta() {
        setImgGone(ID_BOTAO_CONFIRMAR);
        setImgGone(ID_BOTAO_CANCELAR);
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
        // TODO - implement Main3.receberSolicitacaoInicio
        throw new UnsupportedOperationException();
    }

    public void receberJogada(Jogada jogada) {
        // TODO - implement Main3.receberJogada
        throw new UnsupportedOperationException();
    }

    public void prepararMaosPrimeiroTurno() {
        // TODO - implement Main3.prepararMaosPrimeiroTurno
        throw new UnsupportedOperationException();
    }

    public void prepararInicioTurno() {
        // TODO - implement Main3.prepararInicioTurno
        throw new UnsupportedOperationException();
    }

    public void usarPoderHeroico() {
        // TODO - implement Main3.usarPoderHeroico
        throw new UnsupportedOperationException();
    }

    /**
     * @param idPosicaoMao
     */
    public void abrirCarta(int idPosicaoMao) {
        // TODO - implement Main3.abrirCarta
        throw new UnsupportedOperationException();
    }

    public void enviarJogada() {
        // TODO - implement Main3.enviarJogada
        throw new UnsupportedOperationException();
    }

    public void promoverAtaques() {
        // TODO - implement Main3.promoverAtaques
        throw new UnsupportedOperationException();
    }

    public void verificaFimJogo() {
        // TODO - implement Main3.verificaFimJogo
        throw new UnsupportedOperationException();
    }

    public void showResultadoJogo() {
        // TODO - implement Main3.showResultadoJogo
        throw new UnsupportedOperationException();
    }

}