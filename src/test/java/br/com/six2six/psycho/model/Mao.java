package br.com.six2six.psycho.model;

import java.util.List;

import lombok.Getter;

@Getter
public class Mao {

	private List<Carta> cartas;
	
	public Mao(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	
	
}
