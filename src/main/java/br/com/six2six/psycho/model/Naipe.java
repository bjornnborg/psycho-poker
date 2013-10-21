package br.com.six2six.psycho.model;

import java.util.HashMap;
import java.util.Map;

public enum Naipe {
	Copas("H"),
	Paus("C"),
	Espadas("S"),
	Ouros("D");
	
	private static Map<String, Naipe> naipes = new HashMap<String, Naipe>();
	
	private String sigla;
	
	static {
		for(Naipe naipe : Naipe.values()) {
			naipes.put(naipe.getSigla(), naipe);
		}
	}
	
	private Naipe(String sigla) {
		this.sigla = sigla;
	}
	
	public static Naipe from(String sigla) {
		return naipes.get(sigla);
	}

	public String getSigla() {
		return sigla;
	}	
}
