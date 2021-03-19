package sample.entity;

public class Tabuleiro {

	protected Jogador jogador1;
	protected Jogador jogador2;
	protected Jogador jogadorDoTurnoAtual;
	protected int[] idCartaPosicoesJogador1;
	protected int[] idCartaPosicoesJogador2;

	public Jogador getJogador1() {
		return this.jogador1;
	}

	/**
	 * 
	 * @param jogador1
	 */
	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return this.jogador2;
	}

	/**
	 * 
	 * @param jogador2
	 */
	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	/**
	 * 
	 * @param idCartasPosicao1
	 */
	public void setPosicoes1(int[] idCartasPosicao1) {
		// TODO - implement Tabuleiro.setPosicoes1
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCartasPosicao2
	 */
	public void setPosicoes2(int[] idCartasPosicao2) {
		// TODO - implement Tabuleiro.setPosicoes2
		throw new UnsupportedOperationException();
	}

	public int[] getIdCartasPosicao1() {
		// TODO - implement Tabuleiro.getIdCartasPosicao1
		throw new UnsupportedOperationException();
	}

	public int[] getIdCartasPosicao2() {
		// TODO - implement Tabuleiro.getIdCartasPosicao2
		throw new UnsupportedOperationException();
	}

	public boolean hasPosicaoLivre() {
		// TODO - implement Tabuleiro.hasPosicaoLivre
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCarta
	 */
	public void adicionaLacaio(int idCarta) {
		// TODO - implement Tabuleiro.adicionaLacaio
		throw new UnsupportedOperationException();
	}

	public void limparLacaiosInimigos() {
		// TODO - implement Tabuleiro.limparLacaiosInimigos
		throw new UnsupportedOperationException();
	}

}