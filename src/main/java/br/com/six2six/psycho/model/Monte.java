package br.com.six2six.psycho.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Monte {

	private List<Carta> cartas;
	
	public Monte(List<Carta> cartas) {
		if (cartas.size() != 5) {
			throw new IllegalArgumentException("O monte deve ter exatamente 5 cartas");
		}
		this.cartas = cartas;
	}
	
	public List<Carta> trocar(int quantidadeCartas) {
		return cartas.subList(0, quantidadeCartas);
	}

	public static Monte from(String... tuplas) {
		List<Carta> cartas = new ArrayList<Carta>();
		for (String tupla : tuplas) {
			cartas.add(Carta.from(tupla));
		}
		return new Monte(cartas);
	}
	
	public static Monte from(String tuplasComEspacos) {
		return Monte.from(tuplasComEspacos.split("\\s"));
	}	
	
	@Override
	public String toString() {
		return cartas.toString();
	}
	
	
}
