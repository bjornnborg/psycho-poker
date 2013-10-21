package br.com.six2six.psycho.model;

import lombok.Getter;

@Getter
public class Carta implements Comparable<Carta> {
	
	private ValorFace valorFace;
	private Naipe naipe;
	
	public Carta(ValorFace valorFace, Naipe naipe) {
		this.valorFace = valorFace;
		this.naipe = naipe;
	}
	
	@Override
	public String toString() {
		return String.format("%s de %s", valorFace, naipe);
	}
	
	@Override
	public int compareTo(Carta carta) {
		return this.valorFace.getPeso() - carta.valorFace.getPeso();
	}

}
