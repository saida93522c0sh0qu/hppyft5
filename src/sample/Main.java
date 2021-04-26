package sample;

import javafx.application.Application;
import javafx.application.Platform;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    private static final String APP_TITLE = "HEARTHSTONE";
    private static final String ID_BOTAO_CONFIRMAR = "#confirmar_button";
    private static final String ID_BOTAO_CANCELAR = "#cancelar_button";
    private static final String ID_CARTA_SELECIONADA = "#carta_mostrada";
    private static final String ID_VIDA_HEROI_JOGADOR = "#vida_heroi_jogador";
    private static final String ID_VIDA_HEROI_ADVERSARIO = "#vida_heroi_adversario";
    private static final String ID_VIDA_CARTA_JOGADOR_1 = "#vida_cgit rta_jogador_1";
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
    public static final String GANHOU_FXML = "ganhou.fxml";
    public static final String PERDEU_FXML = "perdeu.fxml";
    public static final String TELA_INICIAL_FXML = "tela_inicial.fxml";
    public static final String TELA_SELECAO_FXML = "tela_selecao.fxml";
    public static final String TELA_JOGO_FXML = "tela_jogo.fxml";

    protected Stage stage;
    private static Main instance;
    protected AtorRede atorRede;

    protected Tabuleiro tabuleiro;

    protected boolean procurou = false;
    protected boolean ganhou = false;
    protected boolean acabou = false;
    protected boolean botoesCartaDisponiveis = false;
    protected boolean botoesGeraisDisponiveis = false;
    protected boolean callbackFeito = false;

    protected int posicaoMaoCartaMostrada;
    protected Carta cartaMostrada;
    protected Integer mIdHeroijogador;
    private boolean desconectado = true;

    public Main() {
        instance = this;
        atorRede = new AtorRede();
    }

    public static Main getInstance() {
        return instance;
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

    private void goToTelaInicial() throws Exception {
        replaceSceneContent(TELA_INICIAL_FXML);
        stage.show();
    }

    public void goToTelaSelecao() throws Exception {
        replaceSceneContent(TELA_SELECAO_FXML);
        stage.setWidth(1133.0);
        stage.setHeight(440.0);
        stage.show();
    }

    public void goToTelaJogo() throws Exception {
        replaceSceneContent(TELA_JOGO_FXML);
        stage.setWidth(1000.0);
        stage.setHeight(665.0);
        stage.show();
    }


    private void goToTelaPerdeu() {
        try {
            replaceSceneContent(PERDEU_FXML);
            stage.setWidth(430.0);
            stage.setHeight(440.0);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goToTelaGanhou() {
        try {
            replaceSceneContent(GANHOU_FXML);
            stage.setWidth(600.0);
            stage.setHeight(200.0);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        procurou = true;
        atorRede.buscarPartida();
        try {
            goToTelaJogo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receberSolicitacaoInicio() {
        if (!procurou) {
            tabuleiro = new Tabuleiro();
            Jogador jogador = new Jogador();
            jogador.setIdHeroi(mIdHeroijogador);
            tabuleiro.setJogador(jogador);
            InformacoesIniciais informacoesIniciais = new InformacoesIniciais();
            informacoesIniciais.setIdHeroi(JogadaUtils.IntegerToInt(mIdHeroijogador));
            atorRede.enviaJogada(informacoesIniciais);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        goToTelaJogo();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void receberJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) throws Exception {
        if (jogada instanceof InformacoesIniciais) {
            if (procurou) {
                tabuleiro = new Tabuleiro();
                Jogador jogador = new Jogador();
                jogador.setIdHeroi(mIdHeroijogador);
                tabuleiro.setJogador(jogador);
            }
            Jogador jogador2 = new Jogador();
            InformacoesIniciais infosRecebidas = ((InformacoesIniciais) jogada);
            jogador2.setIdHeroi(infosRecebidas.getIdHeroi());
            tabuleiro.setAdversario(jogador2);
            if (procurou) {
                InformacoesIniciais informacoesIniciais = new InformacoesIniciais();
                informacoesIniciais.setIdHeroi(JogadaUtils.IntegerToInt(tabuleiro.getJogador().getIdHeroi()));
                atorRede.enviaJogada(informacoesIniciais);
                prepararMaosPrimeiroTurno();
            } else {
                prepararMaosPrimeiroTurno();
            }
        } else {
            InformacoesJogada informacoesJogada = (InformacoesJogada) jogada;
            tabuleiro.setIdCartaPosicoesJogador(JogadaUtils.IntArrayToInteger(informacoesJogada.getIdCartasNoCampoAdversario()));
            tabuleiro.setIdCartaPosicoesAdversario(JogadaUtils.IntArrayToInteger(informacoesJogada.getIdCartasNoCampoJogador()));
            tabuleiro.getJogador().setPontosDeVida(informacoesJogada.getVidaAdversario());
            tabuleiro.getAdversario().setPontosDeVida(informacoesJogada.getVidaJogador());
            tabuleiro.setVidaLacaiosJogador(JogadaUtils.IntArrayToInteger(informacoesJogada.getVidaLacaiosAdversario()));
            tabuleiro.setVidaLacaiosAdversario(JogadaUtils.IntArrayToInteger(informacoesJogada.getVidaLacaiosJogador()));
            acabou = informacoesJogada.isJogoAcabou();
            if (!acabou) {
                prepararInicioTurno();
            } else {
                showResultadoJogo();
                finalizaJogo();
            }
        }
    }

    private void finalizaJogo() {
        atorRede.finalizarPartida();
        atorRede.desconectar();
        desconectado = true;
    }

    private void showResultadoJogo() {
        if (tabuleiro.getJogador().getPontosDeVida() <= 0) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    goToTelaPerdeu();
                }
            });
        } else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    goToTelaGanhou();
                }
            });
        }
    }

    public void verificaFimJogo() {
        if (tabuleiro.getJogador().getPontosDeVida() <= 0 || tabuleiro.getAdversario().getPontosDeVida() <= 0) {
            acabou = true;
            showResultadoJogo();
            try {
                enviarJogada();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void prepararMaosPrimeiroTurno() throws Exception {
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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = stage.getScene();

                ImageView heroiJogador = (ImageView) scene.lookup(ID_HEROI_JOGADOR);
                ImageView heroiAdversario = (ImageView) scene.lookup(ID_HEROI_ADVERSARIO);
                ImageView phJogador = (ImageView) scene.lookup(ID_PH_JOGADOR);
                ImageView phAdversario = (ImageView) scene.lookup(ID_PH_ADVERSARIO);

                try {
                    heroiJogador.setImage(new Image(new FileInputStream(new File(getTabuleiro().getJogador().getHeroi().getCaminhoImg()))));
                    heroiAdversario.setImage(new Image(new FileInputStream(new File(getTabuleiro().getAdversario().getHeroi().getCaminhoImg()))));
                    phJogador.setImage(new Image(new FileInputStream(new File(getTabuleiro().getJogador().getHeroi().getPoderHeroico().getCaminhoImg()))));
                    phAdversario.setImage(new Image(new FileInputStream(new File(getTabuleiro().getAdversario().getHeroi().getPoderHeroico().getCaminhoImg()))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

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
        atualizaTelaJogo();
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
        Image img = null;
        try {
            img = new Image(new FileInputStream(new File(cartaMostrada.getCaminhoImagem())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageView.setImage(img);
        showBotoesCarta();
    }

    public void enviarJogada() throws Exception {
        InformacoesJogada informacoesJogada = new InformacoesJogada();
        informacoesJogada.setIdCartasNoCampoJogador(JogadaUtils.IntegerArrayToInt(tabuleiro.getIdCartaPosicoesJogador1()));
        informacoesJogada.setIdCartasNoCampoAdversario(JogadaUtils.IntegerArrayToInt(tabuleiro.getIdCartaPosicoesJogador2()));
        informacoesJogada.setJogoAcabou(acabou);
        informacoesJogada.setVidaJogador(tabuleiro.getJogador().getPontosDeVida());
        informacoesJogada.setVidaAdversario(tabuleiro.getAdversario().getPontosDeVida());
        informacoesJogada.setVidaLacaiosJogador(JogadaUtils.IntegerArrayToInt(tabuleiro.getVidaLacaiosJogador()));
        informacoesJogada.setVidaLacaiosAdversario(JogadaUtils.IntegerArrayToInt(tabuleiro.getVidaLacaiosAdversario()));

        atorRede.enviaJogada(informacoesJogada);
    }

    public void promoverAtaques() throws Exception {
        getTabuleiro().promoverAtaques();
        atualizaMesaAdversario();
        atualizaMesaJogador();
        verificaFimJogo();
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
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = stage.getScene();
                ImageView cartaMesaJogador1 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_1);
                ImageView cartaMesaJogador2 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_2);
                ImageView cartaMesaJogador3 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_3);
                ImageView cartaMesaJogador4 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_4);
                ImageView cartaMesaJogador5 = (ImageView) scene.lookup(ID_CARTA_MESA_JOGADOR_5);
                try {
                    cartaMesaJogador1.setImage(tabuleiro.getCartaPosicoesJogador()[0] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesJogador()[0].getCaminhoImagem()))));
                    cartaMesaJogador2.setImage(tabuleiro.getCartaPosicoesJogador()[1] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesJogador()[1].getCaminhoImagem()))));
                    cartaMesaJogador3.setImage(tabuleiro.getCartaPosicoesJogador()[2] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesJogador()[2].getCaminhoImagem()))));
                    cartaMesaJogador4.setImage(tabuleiro.getCartaPosicoesJogador()[3] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesJogador()[3].getCaminhoImagem()))));
                    cartaMesaJogador5.setImage(tabuleiro.getCartaPosicoesJogador()[4] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesJogador()[4].getCaminhoImagem()))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Label vidaCartaJogador1 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_1);
                Label vidaCartaJogador2 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_2);
                Label vidaCartaJogador3 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_3);
                Label vidaCartaJogador4 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_4);
                Label vidaCartaJogador5 = (Label) scene.lookup(ID_VIDA_CARTA_JOGADOR_5);
                vidaCartaJogador1.setText(tabuleiro.getCartaPosicoesJogador()[0] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[0].getVida())) : "");
                vidaCartaJogador2.setText(tabuleiro.getCartaPosicoesJogador()[1] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[1].getVida())) : "");
                vidaCartaJogador3.setText(tabuleiro.getCartaPosicoesJogador()[2] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[2].getVida())) : "");
                vidaCartaJogador4.setText(tabuleiro.getCartaPosicoesJogador()[3] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[3].getVida())) : "");
                vidaCartaJogador5.setText(tabuleiro.getCartaPosicoesJogador()[4] != null ? (Integer.toString(tabuleiro.getCartaPosicoesJogador()[4].getVida())) : "");
            }
        });
    }

    public void atualizaMesaAdversario() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = stage.getScene();
                ImageView cartaMesaAdversario1 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_1);
                ImageView cartaMesaAdversario2 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_2);
                ImageView cartaMesaAdversario3 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_3);
                ImageView cartaMesaAdversario4 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_4);
                ImageView cartaMesaAdversario5 = (ImageView) scene.lookup(ID_CARTA_MESA_ADVERSARIO_5);
                try {
                    cartaMesaAdversario1.setImage(tabuleiro.getCartaPosicoesAdversario()[0] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesAdversario()[0].getCaminhoImagem()))));
                    cartaMesaAdversario2.setImage(tabuleiro.getCartaPosicoesAdversario()[1] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesAdversario()[1].getCaminhoImagem()))));
                    cartaMesaAdversario3.setImage(tabuleiro.getCartaPosicoesAdversario()[2] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesAdversario()[2].getCaminhoImagem()))));
                    cartaMesaAdversario4.setImage(tabuleiro.getCartaPosicoesAdversario()[3] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesAdversario()[3].getCaminhoImagem()))));
                    cartaMesaAdversario5.setImage(tabuleiro.getCartaPosicoesAdversario()[4] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getCartaPosicoesAdversario()[4].getCaminhoImagem()))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Label vidaCartaAdversario1 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_1);
                Label vidaCartaAdversario2 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_2);
                Label vidaCartaAdversario3 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_3);
                Label vidaCartaAdversario4 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_4);
                Label vidaCartaAdversario5 = (Label) scene.lookup(ID_VIDA_CARTA_ADVERSARIO_5);
                vidaCartaAdversario1.setText(tabuleiro.getCartaPosicoesAdversario()[0] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[0].getVida())) : "");
                vidaCartaAdversario2.setText(tabuleiro.getCartaPosicoesAdversario()[1] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[1].getVida())) : "");
                vidaCartaAdversario3.setText(tabuleiro.getCartaPosicoesAdversario()[2] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[2].getVida())) : "");
                vidaCartaAdversario4.setText(tabuleiro.getCartaPosicoesAdversario()[3] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[3].getVida())) : "");
                vidaCartaAdversario5.setText(tabuleiro.getCartaPosicoesAdversario()[4] != null ? (Integer.toString(tabuleiro.getCartaPosicoesAdversario()[4].getVida())) : "");
            }
        });
    }

    public void atualizaMaoJogador() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = stage.getScene();
                ImageView carta1 = (ImageView) scene.lookup(ID_CARTA_1);
                ImageView carta2 = (ImageView) scene.lookup(ID_CARTA_2);
                ImageView carta3 = (ImageView) scene.lookup(ID_CARTA_3);
                ImageView carta4 = (ImageView) scene.lookup(ID_CARTA_4);
                ImageView carta5 = (ImageView) scene.lookup(ID_CARTA_5);
                ImageView carta6 = (ImageView) scene.lookup(ID_CARTA_6);
                try {
                    carta1.setImage(tabuleiro.getJogador().getMao()[0] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getJogador().getMao()[0].getCaminhoImagem()))));
                    carta2.setImage(tabuleiro.getJogador().getMao()[1] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getJogador().getMao()[1].getCaminhoImagem()))));
                    carta3.setImage(tabuleiro.getJogador().getMao()[2] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getJogador().getMao()[2].getCaminhoImagem()))));
                    carta4.setImage(tabuleiro.getJogador().getMao()[3] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getJogador().getMao()[3].getCaminhoImagem()))));
                    carta5.setImage(tabuleiro.getJogador().getMao()[4] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getJogador().getMao()[4].getCaminhoImagem()))));
                    carta6.setImage(tabuleiro.getJogador().getMao()[5] == null ? null : new Image(new FileInputStream(new File(tabuleiro.getJogador().getMao()[5].getCaminhoImagem()))));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void atualizaVidaJogadores() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = stage.getScene();
                Label vidaHeroiJogador = (Label) scene.lookup(ID_VIDA_HEROI_JOGADOR);
                Label vidaHeroiAdversario = (Label) scene.lookup(ID_VIDA_HEROI_ADVERSARIO);
                vidaHeroiJogador.setText(Integer.toString(tabuleiro.getJogador().getPontosDeVida()));
                vidaHeroiAdversario.setText(Integer.toString(tabuleiro.getAdversario().getPontosDeVida()));
            }
        });

    }

    public void atualizaManaJogador() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Scene scene = stage.getScene();
                Label manaJogador = (Label) scene.lookup(ID_MANA_JOGADOR);
                manaJogador.setText(Integer.toString(tabuleiro.getJogador().getManaAtual()) + "/" + Integer.toString(tabuleiro.getJogador().getManaMaxima()));
            }
        });

    }

    public void finalizarTurno() throws Exception {
        desabilitarBotoes();
        promoverAtaques();
        if (!acabou) {
            enviarJogada();
        }
    }

    public void cancelarCartaMostrada() {
        hideCartaAndBotoesCarta();
        posicaoMaoCartaMostrada = -1;
        cartaMostrada = null;
        ImageView imageView = (ImageView) stage.getScene().lookup(ID_CARTA_SELECIONADA);
        imageView.setImage(null);
    }

    public void usarCartaMostrada() {
        int custoMana = cartaMostrada.getCustoMana();
        int manaAtual = tabuleiro.getJogador().getManaAtual();
        if (custoMana <= manaAtual) {
            if (cartaMostrada instanceof CartaLacaio) {
                if (tabuleiro.adicionaLacaio((CartaLacaio) cartaMostrada)) {
                    tabuleiro.getJogador().removeCarta(posicaoMaoCartaMostrada);
                    int manaNova = manaAtual - custoMana;
                    tabuleiro.getJogador().setManaAtual(manaNova);
                }
            } else {
                Efeito efeitoCarta = ((CartaFeitico) cartaMostrada).getEfeito();
                tabuleiro.getJogador().removeCarta(posicaoMaoCartaMostrada);
                Efeito.aplicarEfeito(efeitoCarta);
                int manaNova = tabuleiro.getJogador().getManaAtual() - custoMana;
                tabuleiro.getJogador().setManaAtual(manaNova);
            }
        }
        cancelarCartaMostrada();
    }

    public void finalizarComErro() {
        if (acabou) {
            if (!desconectado) {
                atorRede.desconectar();
                desconectado = true;
            }
        } else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    goToTelaGanhou();
                }
            });
        }

    }

    public boolean conectar() {
        desconectado = false;
        return atorRede.conectar();
    }

    public void partidaNaoEncontrada() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    goToTelaSelecao();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        atorRede.desconectar();
        desconectado = true;
    }
}