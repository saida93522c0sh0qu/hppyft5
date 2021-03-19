package sample.netgames;

import sample.entity.Jogada;

public class NetGames implements OuvidorProxy {

    //	protected sample.netgames.Proxy proxy;
    private NetGames instance;
    protected String servidor = "venus.inf.ufsc.br";

    public NetGames getInstance() {
        return this.instance;
    }

    public String getServidor() {
        return this.servidor;
    }

    public void conectar() {
        // TODO - implement NetGames.conectar
        throw new UnsupportedOperationException();
    }

    public void buscarPartida() {
        // TODO - implement NetGames.buscarPartida
        throw new UnsupportedOperationException();
    }

    public void receberSolicitacaoInicio() {
        // TODO - implement NetGames.receberSolicitacaoInicio
        throw new UnsupportedOperationException();
    }

    /**
     * @param jogada
     */
    public void enviaInfoInicial(Jogada jogada) {
        // TODO - implement NetGames.enviaInfoInicial
        throw new UnsupportedOperationException();
    }

    /**
     * @param jogada
     */
    public void enviaJogada(Jogada jogada) {
        // TODO - implement NetGames.enviaJogada
        throw new UnsupportedOperationException();
    }

    /**
     * @param jogada
     */
    public void recebeJogada(Jogada jogada) {
        // TODO - implement NetGames.recebeJogada
        throw new UnsupportedOperationException();
    }

    public void desconectar() {
        // TODO - implement NetGames.desconectar
        throw new UnsupportedOperationException();
    }

}