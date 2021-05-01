package sample.netgames;

import br.ufsc.inf.leobr.cliente.*;
import br.ufsc.inf.leobr.cliente.exception.*;
import sample.Main;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Properties;

public class AtorRede implements OuvidorProxy {

    protected br.ufsc.inf.leobr.cliente.Proxy proxy;
//    protected final String servidor = "netgames.labsoft.ufsc.br";
//    protected static final String servidor = "localhost";
    protected static final String servidor = AtorRede.getProp();

    private static String getProp() {
        String result = "localhost";
        Properties prop = new Properties();
        String propFileName = "config.properties";

        try {
            InputStream inputStream = new FileInputStream(new File(propFileName));
            prop.load(inputStream);
            result = prop.getProperty("servidor");
            inputStream.close();
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
    }

    public AtorRede() {
        proxy = Proxy.getInstance();
        proxy.addOuvinte(this);
    }

    public boolean conectar() {
        boolean retorno = true;
        try {
            proxy.conectar(servidor, "NomeJogador");
            JOptionPane.showMessageDialog(new Frame(),
                    "CONECTOU");
        } catch (JahConectadoException | NaoPossivelConectarException | ArquivoMultiplayerException ex) {
            JOptionPane.showMessageDialog(new Frame(),
                    ex.getMessage());
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public void buscarPartida() {
        try {
            proxy.iniciarPartida(2);
        } catch (NaoConectadoException e) {
            e.printStackTrace();
            System.out.println("NAO TAH CONECTADO");
        }
    }

    public void enviaJogada(br.ufsc.inf.leobr.cliente.Jogada jogada) {
        try {
            proxy.enviaJogada(jogada);
        } catch (NaoJogandoException e) {
            e.printStackTrace();
        }
    }

    public boolean desconectar() {
        boolean retorno = true;
        try {
            proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean finalizarPartida() {
        boolean retorno = true;
        try {
            proxy.finalizarPartida();
        } catch (NaoConectadoException | NaoJogandoException e) {
            e.printStackTrace();
            retorno = false;
        }
        return retorno;
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
        Main.getInstance().partidaNaoEncontrada();
    }
}