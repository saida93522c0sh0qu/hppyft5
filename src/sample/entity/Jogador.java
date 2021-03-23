package sample.entity;

public class Jogador {

	protected Heroi heroi;
	protected int manaMaxima;
	protected int manaAtual;
	protected int pontosDeVida;
	protected Carta[] mao;
	protected boolean phHabilitado;

	/**
	 * 
	 * @param idHeroi
	 */
	public void setIdHeroi(int idHeroi) {
		// TODO - implement Jogador.setIdHeroi
		throw new UnsupportedOperationException();
	}

	public int getIdHeroi() {
		// TODO - implement Jogador.getIdHeroi
		throw new UnsupportedOperationException();
	}

	public int getPontosDeVida() {
		return this.pontosDeVida;
	}

	/**
	 * 
	 * @param pontosDeVida
	 */
	public void setPontosDeVida(int pontosDeVida) {
		this.pontosDeVida = pontosDeVida;
	}

	public void comprarCarta() {
		// TODO - implement Jogador.comprarCarta
		throw new UnsupportedOperationException();
	}

	public void receberMoeda() {
		// TODO - implement Jogador.receberMoeda
		throw new UnsupportedOperationException();
	}

	public boolean getPhHabilitado() {
		return this.phHabilitado;
	}

	/**
	 * 
	 * @param phHabilitado
	 */
	public void setPhHabilitado(boolean phHabilitado) {
		this.phHabilitado = phHabilitado;
	}

	public int getManaAtual() {
		return this.manaAtual;
	}

	/**
	 * 
	 * @param manaAtual
	 */
	public void setManaAtual(int manaAtual) {
		this.manaAtual = manaAtual;
	}

	/**
	 * 
	 * @param idPosicao
	 */
	public int getIdCarta(int idPosicao) {
		// TODO - implement Jogador.getIdCarta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idPosicao
	 */
	public void removeCarta(int idPosicao) {
		// TODO - implement Jogador.removeCarta
		throw new UnsupportedOperationException();
	}

	public int getManaMaxima() {
		return this.manaMaxima;
	}

	/**
	 * 
	 * @param manaMaxima
	 */
	public void setManaMaxima(int manaMaxima) {
		this.manaMaxima = manaMaxima;
	}

	public Heroi getHeroi() {
		return heroi;
	}
}