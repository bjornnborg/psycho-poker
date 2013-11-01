package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.ValorFace.As;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.Naipe;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

@Getter
public class Mao {

	private List<Carta> cartas;
	private Map<ValorFace, List<Carta>> cartasAgrupadasPorValor = null;
	private Map<Naipe, List<Carta>> cartasAgrupadasPorNaipe = null;
	
	public Mao(List<Carta> cartas) {
		if (cartas.size() != 5) {
			throw new IllegalArgumentException("A mão deve ter exatamente 5 cartas");
		}
		this.cartas = cartas;
		Collections.sort(cartas);
		cartasAgrupadasPorValor = AgrupadorHelper.agruparPorValorFace(this);
		cartasAgrupadasPorNaipe = AgrupadorHelper.agruparPorNaipe(this);
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
	
	public boolean temAsComoMaiorCarta() {
		return As == this.getCartas().get(4).getValorFace();
	}
	
	public boolean possuiCincoCartasDistintas() {
		return this.cartasAgrupadasPorValor.keySet().size() == 5;
	}
	
	
}
