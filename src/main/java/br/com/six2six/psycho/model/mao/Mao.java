package br.com.six2six.psycho.model.mao;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import br.com.six2six.psycho.model.Carta;

@Getter
public class Mao {

	private List<Carta> cartas;
	
	public Mao(List<Carta> cartas) {
		this.cartas = cartas;
		Collections.sort(cartas);
	}
	
	
	
}
