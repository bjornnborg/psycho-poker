package br.com.six2six.psycho.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Monte {

	private List<Carta> cartas;
	private List<Carta> cartasTrocadas;
	
	public Monte(List<Carta> cartas) {
		if (cartas.size() != 5) {
			throw new IllegalArgumentException("O monte deve ter exatamente 5 cartas");
		}
		this.cartas = cartas;
		this.cartasTrocadas = new ArrayList<Carta>();
	}
	
	public List<Carta> trocar(List<Carta> cartas) {
		List<Carta> novasCartas = new ArrayList<Carta>();
		for (Carta carta : cartas) {
			novasCartas.add(trocar(carta));
		}
		return novasCartas;
	}
	
	public Carta trocar(Carta carta) {
		cartasTrocadas.add(carta);
		return cartas.remove(0);
	}

	public static Monte from(String... tuplas) {
		List<Carta> cartas = new ArrayList<Carta>();
		for (String tupla : tuplas) {
			cartas.add(Carta.from(tupla));
		}
		return new Monte(cartas);
	}
	
	
}
