package br.com.six2six.psycho.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum ValorFace {
	As("A", 14) {
		@Override
		public String toString() {
			return "Ás";
		}
	},
	Dois("2", 2),
	Tres("3", 3),
	Quatro("4", 4),
	Cinco("5", 5),
	Seis("6", 6),
	Sete("7", 7),
	Oito("8", 8),
	Nove("9", 9),
	Dez("10", 10),
	Valete("J", 11),
	Dama("Q", 12),
	Rei("K", 13);
	
	private static Map<String, ValorFace> valoresFace = new HashMap<String, ValorFace>();
	
	private String valorFace;
	private int peso;
	
	static {
		for(ValorFace carta : ValorFace.values()) {
			valoresFace.put(carta.getValorFace(), carta);
		}
	}
	
	private ValorFace(String valorFace, int peso) {
		this.valorFace = valorFace;
		this.peso = peso;
	}
	
	public static ValorFace from(String valorFace) {
		return valoresFace.get(valorFace);
	}

}
