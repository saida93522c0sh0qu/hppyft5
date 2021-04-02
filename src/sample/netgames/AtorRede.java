package sample.netgames;

import br.ufsc.inf.leobr.cliente.*;
import br.ufsc.inf.leobr.cliente.exception.*;
import sample.Main;

public class AtorRede implements OuvidorProxy {

    protected br.ufsc.inf.leobr.cliente.Proxy proxy;
    private static AtorRede instance;
    protected final String servidor = "netgames.labsoft.ufsc.br";

    private AtorRede() {
        proxy = Proxy.getInstance();
        proxy.addOuvinte(this);
    }

    public static AtorRede getInstance() {
        if (instance == null) {
            instance = new AtorRede();
        }
        return instance;
    }

    public String getServidor() {
        return this.servidor;
    }

    public void conectar() {
        try {
            proxy.conectar(servidor, "NomeJogador");
        } catch (JahConectadoException e) {
            e.printStackTrace();
        } catch (NaoPossivelConectarException e) {
            e.printStackTrace();
        } catch (ArquivoMultiplayerException e) {
            e.printStackTrace();
        }
    }

    public void buscarPartida() {
        try {
            proxy.iniciarPartida(2);
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        }
    }

    public void enviaJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) {
        try {
            proxy.enviaJogada(jogada);
        } catch (NaoJogandoException e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
        Main.getInstance().receberSolicitacaoInicio();
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        Main.getInstance().finalizarComErro();
    }

    @Override
    public void receberMensagem(String msg) {
        //TODO
    }

    @Override
    public void receberJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) {
        try {
            Main.getInstance().receberJogada(jogada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tratarConexaoPerdida() {
        Main.getInstance().finalizarComErro();
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        Main.getInstance().finalizarComErro();
    }
}