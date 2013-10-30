package br.com.six2six.psycho.model.mao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import br.com.six2six.psycho.model.Carta;

@Getter
public class Mao {

	private List<Carta> cartas;
	
	public Mao(List<Carta> cartas) {
		if (cartas.size() != 5) {
			throw new IllegalArgumentException("A mão deve ter exatamente 5 cartas");
		}
		this.cartas = cartas;
		Collections.sort(cartas);
	}
	
	public static Mao from(String... tuplas) {
		List<Carta> cartas = new ArrayList<Carta>();
		for (String tupla : tuplas) {
			cartas.add(Carta.from(tupla));
		}
		return new Mao(cartas);
	}
	
	public static Mao from(String tuplasComEspacos) {
		return Mao.from(tuplasComEspacos.split("\\s"));
	}	
	
	@Override
	public String toString() {
		return cartas.toString();
	}
	
	
	
}
