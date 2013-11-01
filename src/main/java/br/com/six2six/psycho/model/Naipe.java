package br.com.six2six.psycho.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum Naipe {
	Copas("H", "\u2665"),
	Paus("C", "\u2663"),
	Espadas("S", "\u2660"),
	Ouros("D", "\u2666");
	
	private static Map<String, Naipe> naipes = new HashMap<String, Naipe>();
	
	private String sigla;
	private String simbolo;
	
	static {
		for(Naipe naipe : Naipe.values()) {
			naipes.put(naipe.getSigla(), naipe);
		}
	}
	
	private Naipe(String sigla, String simbolo) {
		this.sigla = sigla;
		this.simbolo = simbolo;
	}
	
	public static Naipe from(String sigla) {
		return naipes.get(sigla);
	}


}
