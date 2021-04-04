package sample;

import br.ufsc.inf.leobr.cliente.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.entity.*;
import sample.netgames.AtorRede;

public class Main extends Application {

    private static final String APP_TITLE = "HEARTHSTONE";
    private static final String ID_BOTAO_CONFIRMAR = "#confirmar_button";
    private static final String ID_BOTAO_CANCELAR = "#cancelar_button";
    private static final String ID_CARTA_SELECIONADA = "#carta_mostrada";
    private static final String ID_VIDA_HEROI_JOGADOR = "#vida_heroi_jogador";
    private static final String ID_VIDA_HEROI_ADVERSARIO = "#vida_heroi_adversario";
    private static final String ID_VIDA_CARTA_JOGADOR_1 = "#vida_carta_jogador_1";
    private static final String ID_VIDA_CARTA_JOGADOR_2 = "#vida_carta_jogador_2";
    private static final String ID_VIDA_CARTA_JOGADOR_3 = "#vida_carta_jogador_3";
    private static final String ID_VIDA_CARTA_JOGADOR_4 = "#vida_carta_jogador_4";
    private static final String ID_VIDA_CARTA_JOGADOR_5 = "#vida_carta_jogador_5";
    private static final String ID_VIDA_CARTA_ADVERSARIO_1 = "#vida_carta_adversario_1";
    private static final String ID_VIDA_CARTA_ADVERSARIO_2 = "#vida_carta_adversario_2";
    private static final String ID_VIDA_CARTA_ADVERSARIO_3 = "#vida_carta_adversario_3";
    private static final String ID_VIDA_CARTA_ADVERSARIO_4 = "#vida_carta_adversario_4";
    private static final String ID_VIDA_CARTA_ADVERSARIO_5 = "#vida_carta_adversario_5";
    private static final String ID_CARTA_1 = "#carta_1";
    private static final String ID_CARTA_2 = "#carta_2";
    private static final String ID_CARTA_3 = "#carta_3";
    private static final String ID_CARTA_4 = "#carta_4";
    private static final String ID_CARTA_5 = "#carta_5";
    private static final String ID_CARTA_6 = "#carta_6";
    private static final String ID_CARTA_MESA_JOGADOR_1 = "#carta_mesa_jogador_1";
    private static final String ID_CARTA_MESA_JOGADOR_2 = "#carta_mesa_jogador_2";
    private static final String ID_CARTA_MESA_JOGADOR_3 = "#carta_mesa_jogador_3";
    private static final String ID_CARTA_MESA_JOGADOR_4 = "#carta_mesa_jogador_4";
    private static final String ID_CARTA_MESA_JOGADOR_5 = "#carta_mesa_jogador_5";
    private static final String ID_CARTA_MESA_ADVERSARIO_1 = "#carta_mesa_adversario_1";
    private static final String ID_CARTA_MESA_ADVERSARIO_2 = "#carta_mesa_adversario_2";
    private static final String ID_CARTA_MESA_ADVERSARIO_3 = "#carta_mesa_adversario_3";
    private static final String ID_CARTA_MESA_ADVERSARIO_4 = "#carta_mesa_adversario_4";
    private static final String ID_CARTA_MESA_ADVERSARIO_5 = "#carta_mesa_adversario_5";
    private static final String ID_HEROI_JOGADOR = "#heroi_jogador";
    private static final String ID_HEROI_ADVERSARIO = "#heroi_adversario";
    private static final String ID_PH_JOGADOR = "#ph_jogador";
    private static final String ID_PH_ADVERSARIO = "#ph_adversario";
    private static final String ID_MANA_JOGADOR = "#mana_jogador";

    protected Stage stage;
    private static Main instance;
    protected AtorRede atorRede;

    protected Tabuleiro tabuleiro;

    protected boolean procurou;
    protected boolean ganhou;
    protected boolean acabou;
    protected boolean botoesCartaDisponiveis = false;
    protected boolean botoesGeraisDisponiveis = false;

    protected int posicaoMaoCartaMostrada;
    protected Carta cartaMostrada;
    protected Integer mIdHeroijogador;

    public Main() {
        instance = this;
        atorRede = new AtorRede();
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

    public void hideCartaAndBotoesCarta() {
        this.botoesCartaDisponiveis = false;
        setImgGone(ID_BOTAO_CONFIRMAR);
        setImgGone(ID_BOTAO_CANCELAR);
        setImgGone(ID_CARTA_SELECIONADA);
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
        atorRede.buscarPartida();
    }

    public void receberSolicitacaoInicio() {
        tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador();
        jogador.setIdHeroi(mIdHeroijogador);
        tabuleiro.setJogador(jogador);
        if (procurou) {
            InformacoesIniciais informacoesIniciais = new InformacoesIniciais();
            informacoesIniciais.setIdHeroi(mIdHeroijogador);
            atorRede.enviaJogada(informacoesIniciais);
        }
    }

    public void receberJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) throws Exception {
        if (jogada instanceof InformacoesIniciais) {
            Jogador jogador2 = new Jogador();
            jogador2.setIdHeroi(((InformacoesIniciais) jogada).getIdHeroi());
            tabuleiro.setAdversario(jogador2);
            if (!procurou) {
                InformacoesIniciais informacoesIniciais = new InformacoesIniciais();
                informacoesIniciais.setIdHeroi(tabuleiro.getJogador().getIdHeroi());
                atorRede.enviaJogada(informacoesIniciais);
            }

            prepararMaosPrimeiroTurno();
        } else {
            InformacoesJogada informacoesJogada = (InformacoesJogada) jogada;
            tabuleiro.setIdCartaPosicoesJogador(JogadaUtils.IntToInteger(informacoesJogada.getIdCartasNoCampoAdversario()));
            tabuleiro.setIdCartaPosicoesAdversario(JogadaUtils.IntToInteger(informacoesJogada.getIdCartasNoCampoJogador()));
            tabuleiro.getJogador().setPontosDeVida(informacoesJogada.getVidaAdversario());
            tabuleiro.getAdversario().setPontosDeVida(informacoesJogada.getVidaJogador());
            tabuleiro.setVidaLacaiosJogador(JogadaUtils.IntToInteger(informacoesJogada.getVidaLacaiosAdversario()));
            tabuleiro.setVidaLacaiosAdversario(JogadaUtils.IntToInteger(informacoesJogada.getVidaLacaiosJogador()));
            if (acabou) {
                if (tabuleiro.getAdversario().getPontosDeVida() <= 0) {
                    ganhou = false;
                } else {
                    ganhou = true;
                }
                endGameIfNeeded();
            } else {
                prepararInicioTurno();
            }
        }
    }

    private void endGameIfNeeded() throws Exception {
        if (acabou) {
            showResultadoJogo();

            atorRede.finalizarPartida();
            atorRede.desconectar();
        }
    }

    public void prepararMaosPrimeiroTurno() throws Exception {
        goToTelaJogo();
        atualiarTelaJogoPrimeiraVez();
        for (int i = 0; i < 3; i++) {
            tabuleiro.getJogador().comprarCarta();
        }
        if (!procurou) {
            tabuleiro.getJogador().comprarCarta();
            tabuleiro.getJogador().receberMoeda();
        } else {
            prepararInicioTurno();
        }
    }

    private void atualiarTelaJogoPrimeiraVez() {
        Scene scene = stage.getScene();

        ImageView heroiJogador = (ImageView) scene.lookup(ID_HEROI_JOGADOR);
        ImageView heroiAdversario = (ImageView) scene.lookup(ID_HEROI_ADVERSARIO);
        ImageView phJogador = (ImageView) scene.lookup(ID_PH_JOGADOR);
        ImageView phAdversario = (ImageView) scene.lookup(ID_PH_ADVERSARIO);

        heroiJogador.setImage(new Image(getTabuleiro().getJogador().getHeroi().getCaminhoImg()));
        heroiAdversario.setImage(new Image(getTabuleiro().getAdversario().getHeroi().getCaminhoImg()));
        phJogador.setImage(new Image(getTabuleiro().getJogador().getHeroi().getPoderHeroico().getCaminhoImg()));
        phAdversario.setImage(new Image(getTabuleiro().getAdversario().getHeroi().getPoderHeroico().getCaminhoImg()));

        atualizaTelaJogo();
    }

    public void prepararInicioTurno() {
        Jogador jogador1 = getTabuleiro().getJogador();
        jogador1.comprarCarta();
        jogador1.setPhHabilitado(true);
        int manaMax = jogador1.getManaMaxima();
        if (manaMax < 10) {
            jogador1.setManaMaxima(++manaMax);
        }
        jogador1.setManaAtual(manaMax);
        atualizaManaJogador();
        habilitarBotoes();
    }

    public void usarPoderHeroico() {
        Jogador jogador = getTabuleiro().getJogador();
        if (jogador.isPhHabilitado()) {
            int manaAtual = jogador.getManaAtual();
            if (manaAtual >= 2) {
                jogador.setManaAtual(manaAtual - 2);
                Efeito.aplicarEfeito(jogador.getHeroi().getPoderHeroico().getEfeito());
                jogador.setPhHabilitado(false);
            }
        }
    }

    public void abrirCarta(int idPosicaoMao) {
        posicaoMaoCartaMostrada = idPosicaoMao;
        cartaMostrada = tabuleiro.getJogador().getMao()[posicaoMaoCartaMostrada];
        ImageView imageView = (ImageView) stage.getScene().lookup(ID_CARTA_SELECIONADA);
        Image img = new Image(cartaMostrada.getCaminhoImagem());
        imageView.setImage(img);
        showBotoesCarta();
    }

    public void enviarJogada() throws Exception {
        InformacoesJogada informacoesJogada = new InformacoesJogada();
        informacoesJogada.setIdCartasNoCampoJogador(JogadaUtils.IntegerToInt(tabuleiro.getIdCartaPosicoesJogador1()));
        informacoesJogada.setIdCartasNoCampoAdversario(JogadaUtils.IntegerToInt(tabuleiro.getIdCartaPosicoesJogador2()));
        informacoesJogada.setJogoAcabou(acabou);
        informacoesJogada.setVidaJogador(tabuleiro.getJogador().getPontosDeVida());
        informacoesJogada.setVidaAdversario(tabuleiro.getAdversario().getPontosDeVida());
        informacoesJogada.setVidaLacaiosJogador(JogadaUtils.IntegerToInt(tabuleiro.getVidaLacaiosJogador()));
        informacoesJogada.setVidaLacaiosAdversario(JogadaUtils.IntegerToInt(tabuleiro.getVidaLacaiosAdversario()));

        endGameIfNeeded();
    }

    public void promoverAtaques() throws Exception {
        getTabuleiro().promoverAtaques();
        verificaFimJogo();
    }

    public void verificaFimJogo() throws Exception {
        if (tabuleiro.getJogador().getPontosDeVida() <= 0 || tabuleiro.getAdversario().getPontosDeVida() <= 0) {
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
        atualizaVidaJogadores();
        atualizaManaJogador();
        atualizaMaoJogador();
        atualizaMesaJogador();
        atualizaMesaAdversario();
    }

    public void atualizaMesaJogador() {
        Scene scene = stage.getScene();
        ImageView cartaMesaJogador1 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_1);
        ImageView cartaMesaJogador2 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_2);
        ImageView cartaMesaJogador3 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_3);
        ImageView cartaMesaJogador4 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_4);
        ImageView cartaMesaJogador5 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_5);
        cartaMesaJogador1.setImage(tabuleiro.getCartaPosicoesJogador()[1] == null ? null : new Image(tabuleiro.getCartaPosicoesJogador()[1].getCaminhoImagem()));
        cartaMesaJogador2.setImage(tabuleiro.getCartaPosicoesJogador()[2] == null ? null : new Image(tabuleiro.getCartaPosicoesJogador()[2].getCaminhoImagem()));
        cartaMesaJogador3.setImage(tabuleiro.getCartaPosicoesJogador()[3] == null ? null : new Image(tabuleiro.getCartaPosicoesJogador()[3].getCaminhoImagem()));
        cartaMesaJogador4.setImage(tabuleiro.getCartaPosicoesJogador()[4] == null ? null : new Image(tabuleiro.getCartaPosicoesJogador()[4].getCaminhoImagem()));
        cartaMesaJogador5.setImage(tabuleiro.getCartaPosicoesJogador()[5] == null ? null : new Image(tabuleiro.getCartaPosicoesJogador()[5].getCaminhoImagem()));
        Label vidaCartaJogador1 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_1);
        Label vidaCartaJogador2 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_2);
        Label vidaCartaJogador3 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_3);
        Label vidaCartaJogador4 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_4);
        Label vidaCartaJogador5 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_5);
        vidaCartaJogador1.setText(tabuleiro.getCartaPosicoesJogador()[1] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[1].getVida())) : "");
        vidaCartaJogador2.setText(tabuleiro.getCartaPosicoesJogador()[2] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[2].getVida())) : "");
        vidaCartaJogador3.setText(tabuleiro.getCartaPosicoesJogador()[3] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[3].getVida())) : "");
        vidaCartaJogador4.setText(tabuleiro.getCartaPosicoesJogador()[4] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[4].getVida())) : "");
        vidaCartaJogador5.setText(tabuleiro.getCartaPosicoesJogador()[5] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[5].getVida())) : "");
    }

    public void atualizaMesaAdversario() {
        Scene scene = stage.getScene();
        ImageView cartaMesaAdversario1 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_1);
        ImageView cartaMesaAdversario2 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_2);
        ImageView cartaMesaAdversario3 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_3);
        ImageView cartaMesaAdversario4 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_4);
        ImageView cartaMesaAdversario5 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_5);
        cartaMesaAdversario1.setImage(tabuleiro.getCartaPosicoesAdversario()[1] == null ? null : new Image(tabuleiro.getCartaPosicoesAdversario()[1].getCaminhoImagem()));
        cartaMesaAdversario2.setImage(tabuleiro.getCartaPosicoesAdversario()[2] == null ? null : new Image(tabuleiro.getCartaPosicoesAdversario()[2].getCaminhoImagem()));
        cartaMesaAdversario3.setImage(tabuleiro.getCartaPosicoesAdversario()[3] == null ? null : new Image(tabuleiro.getCartaPosicoesAdversario()[3].getCaminhoImagem()));
        cartaMesaAdversario4.setImage(tabuleiro.getCartaPosicoesAdversario()[4] == null ? null : new Image(tabuleiro.getCartaPosicoesAdversario()[4].getCaminhoImagem()));
        cartaMesaAdversario5.setImage(tabuleiro.getCartaPosicoesAdversario()[5] == null ? null : new Image(tabuleiro.getCartaPosicoesAdversario()[5].getCaminhoImagem()));
        Label vidaCartaAdversario1 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_1);
        Label vidaCartaAdversario2 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_2);
        Label vidaCartaAdversario3 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_3);
        Label vidaCartaAdversario4 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_4);
        Label vidaCartaAdversario5 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_5);
        vidaCartaAdversario1.setText(tabuleiro.getCartaPosicoesAdversario()[1] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[1].getVida())) : "");
        vidaCartaAdversario2.setText(tabuleiro.getCartaPosicoesAdversario()[2] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[2].getVida())) : "");
        vidaCartaAdversario3.setText(tabuleiro.getCartaPosicoesAdversario()[3] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[3].getVida())) : "");
        vidaCartaAdversario4.setText(tabuleiro.getCartaPosicoesAdversario()[4] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[4].getVida())) : "");
        vidaCartaAdversario5.setText(tabuleiro.getCartaPosicoesAdversario()[5] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[5].getVida())) : "");
    }

    public void atualizaMaoJogador() {
        Scene scene = stage.getScene();
        ImageView carta1 = (ImageView) scene.lookup(ID_CARTA_1);
        ImageView carta2 = (ImageView) scene.lookup(ID_CARTA_2);
        ImageView carta3 = (ImageView) scene.lookup(ID_CARTA_3);
        ImageView carta4 = (ImageView) scene.lookup(ID_CARTA_4);
        ImageView carta5 = (ImageView) scene.lookup(ID_CARTA_5);
        ImageView carta6 = (ImageView) scene.lookup(ID_CARTA_6);
        carta1.setImage(tabuleiro.getJogador().getMao()[1] == null ? null : new Image(tabuleiro.getJogador().getMao()[1].getCaminhoImagem()));
        carta2.setImage(tabuleiro.getJogador().getMao()[2] == null ? null : new Image(tabuleiro.getJogador().getMao()[2].getCaminhoImagem()));
        carta3.setImage(tabuleiro.getJogador().getMao()[3] == null ? null : new Image(tabuleiro.getJogador().getMao()[3].getCaminhoImagem()));
        carta4.setImage(tabuleiro.getJogador().getMao()[4] == null ? null : new Image(tabuleiro.getJogador().getMao()[4].getCaminhoImagem()));
        carta5.setImage(tabuleiro.getJogador().getMao()[5] == null ? null : new Image(tabuleiro.getJogador().getMao()[5].getCaminhoImagem()));
        carta6.setImage(tabuleiro.getJogador().getMao()[6] == null ? null : new Image(tabuleiro.getJogador().getMao()[6].getCaminhoImagem()));
    }

    public void atualizaVidaJogadores() {
        Scene scene = stage.getScene();
        Label vidaHeroiJogador = (Label) scene.lookup(ID_VIDA_HEROI_JOGADOR);
        Label vidaHeroiAdversario = (Label) scene.lookup(ID_VIDA_HEROI_ADVERSARIO);
        vidaHeroiJogador.setText(Integer.toString(tabuleiro.getJogador().getPontosDeVida()));
        vidaHeroiAdversario.setText(Integer.toString(tabuleiro.getAdversario().getPontosDeVida()));
    }

    public void atualizaManaJogador() {
        Scene scene = stage.getScene();
        Label manaJogador = (Label) scene.lookup(ID_MANA_JOGADOR);
        manaJogador.setText(Integer.toString(tabuleiro.getJogador().getManaAtual()) + "/" + Integer.toString(tabuleiro.getJogador().getManaMaxima()));
    }

    public void finalizarTurno() throws Exception {
        desabilitarBotoes();
        promoverAtaques();
    }

    public void desistir() throws Exception {
        desabilitarBotoes();
        tabuleiro.getJogador().setPontosDeVida(0);
        enviarJogada();
    }

    public void cancelarCartaMostrada() {
        hideCartaAndBotoesCarta();
        posicaoMaoCartaMostrada = -1;
        cartaMostrada = null;
        ImageView imageView = (ImageView) stage.getScene().lookup(ID_CARTA_SELECIONADA);
        imageView.setImage(null);
    }

    public void usarCartaMostrada() {
        if (cartaMostrada instanceof CartaLacaio) {
            if (tabuleiro.adicionaLacaio((CartaLacaio) cartaMostrada)) {
                tabuleiro.getJogador().removeCarta(posicaoMaoCartaMostrada);
            }
        } else {
            Efeito.aplicarEfeito(((CartaFeitico) cartaMostrada).getEfeito());
            tabuleiro.getJogador().removeCarta(posicaoMaoCartaMostrada);
        }
        cancelarCartaMostrada();
    }

    public void finalizarComErro() {
        ganhou = true;
        try {
            showResultadoJogo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean conectar() {
        return atorRede.conectar();
    }
}