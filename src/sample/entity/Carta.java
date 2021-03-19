package sample.entity;

public abstract class Carta {

	protected int custoMana;
	protected String nome;
	protected String caminhoImagem;

	/**
	 * 
	 * @param idCarta
	 */
	public Carta getCartaById(int idCarta) {
		// TODO - implement Carta.getCartaById
		throw new UnsupportedOperationException();
	}

	public int getCustoMana() {
		return this.custoMana;
	}

}