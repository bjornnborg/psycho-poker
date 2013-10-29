package br.com.six2six.psycho.model.mao;

import lombok.Getter;

@Getter
public enum Jogo {

	MAIOR_CARTA(1),
	PAR(2),
	DOIS_PARES(3),
	TRINCA(4),
	SEQUENCIA_NUMERICA(5),
	SEQUENCIA_NAIPE(6),
	FULL_HOUSE(7),
	FOUR(8),
	SEQUENCIA_NUMERICA_NAIPE(9);
	
	private int peso;

	private Jogo(int peso) {
		this.peso = peso;
	}
	
}
