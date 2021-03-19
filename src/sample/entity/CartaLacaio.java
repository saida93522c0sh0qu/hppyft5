package sample.entity;

public class CartaLacaio extends Carta {

	protected int ataque;
	protected int vida;
	protected int vidaAtual;

	public int getAtaque() {
		return this.ataque;
	}

	/**
	 * 
	 * @param ataque
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getVida() {
		return this.vida;
	}

	/**
	 * 
	 * @param vida
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaAtual() {
		return this.vidaAtual;
	}

	/**
	 * 
	 * @param vidaAtual
	 */
	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}

}