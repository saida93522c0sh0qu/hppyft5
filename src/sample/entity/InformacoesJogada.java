package sample.entity;

public class InformacoesJogada implements Jogada {

    protected int vidaJogador;
    protected int vidaAdversario;
    protected Integer[] idCartasNoCampoJogador;
    protected Integer[] idCartasNoCampoAdversario;
    protected Integer[] vidaLacaiosJogador;
    protected Integer[] vidaLacaiosAdversario;
    protected boolean jogoAcabou;

    public Integer[] getIdCartasNoCampoJogador() {
        return this.idCartasNoCampoJogador;
    }

    public void setIdCartasNoCampoJogador(Integer[] idCartasNoCampoJogador) {
        this.idCartasNoCampoJogador = idCartasNoCampoJogador;
    }

    public int getVidaJogador() {
        return this.vidaJogador;
    }

    public void setVidaJogador(int vidaJogador) {
        this.vidaJogador = vidaJogador;
    }

    public int getVidaAdversario() {
        return this.vidaAdversario;
    }

    public void setVidaAdversario(int vidaAdversario) {
        this.vidaAdversario = vidaAdversario;
    }

    public Integer[] getIdCartasNoCampoAdversario() {
        return this.idCartasNoCampoAdversario;
    }

    public void setIdCartasNoCampoAdversario(Integer[] idCartasNoCampoAdversario) {
        this.idCartasNoCampoAdversario = idCartasNoCampoAdversario;
    }

    public Integer[] getVidaLacaiosJogador() {
        return vidaLacaiosJogador;
    }

    public void setVidaLacaiosJogador(Integer[] vidaLacaiosJogador) {
        this.vidaLacaiosJogador = vidaLacaiosJogador;
    }

    public Integer[] getVidaLacaiosAdversario() {
        return vidaLacaiosAdversario;
    }

    public void setVidaLacaiosAdversario(Integer[] vidaLacaiosAdversario) {
        this.vidaLacaiosAdversario = vidaLacaiosAdversario;
    }

    public boolean isJogoAcabou() {
        return jogoAcabou;
    }

    public void setJogoAcabou(boolean jogoAcabou) {
        this.jogoAcabou = jogoAcabou;
    }
}