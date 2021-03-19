package sample.entity;

public class InformacoesJogada implements Jogada {

	protected int[] idCartasNoCampo1;
	protected int vidaJogador1;
	protected int vidaJogador2;
	protected int[] idCartasNoCampo2;
	protected boolean jogoAcabou;

	public int[] getIdCartasNoCampo1() {
		return this.idCartasNoCampo1;
	}

	/**
	 * 
	 * @param idCartasNoCampo1
	 */
	public void setIdCartasNoCampo1(int[] idCartasNoCampo1) {
		this.idCartasNoCampo1 = idCartasNoCampo1;
	}

	public int getVidaJogador1() {
		return this.vidaJogador1;
	}

	/**
	 * 
	 * @param vidaJogador1
	 */
	public void setVidaJogador1(int vidaJogador1) {
		this.vidaJogador1 = vidaJogador1;
	}

	public int getVidaJogador2() {
		return this.vidaJogador2;
	}

	/**
	 * 
	 * @param vidaJogador2
	 */
	public void setVidaJogador2(int vidaJogador2) {
		this.vidaJogador2 = vidaJogador2;
	}

	public int[] getIdCartasNoCampo2() {
		return this.idCartasNoCampo2;
	}

	/**
	 * 
	 * @param idCartasNoCampo2
	 */
	public void setIdCartasNoCampo2(int[] idCartasNoCampo2) {
		this.idCartasNoCampo2 = idCartasNoCampo2;
	}

	public boolean getJogoAcabou() {
		return this.jogoAcabou;
	}

	/**
	 * 
	 * @param jogoAcabou
	 */
	public void setJogoAcabou(boolean jogoAcabou) {
		this.jogoAcabou = jogoAcabou;
	}

}