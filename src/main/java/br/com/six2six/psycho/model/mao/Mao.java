package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.ValorFace.As;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.Naipe;
import br.com.six2six.psycho.model.ValorFace;
import br.com.six2six.psycho.model.mao.util.AgrupadorHelper;

public class Mao {

	private List<Carta> cartas;
	private Agrupador agrupador;
	
	public Mao(List<Carta> cartas) {
		if (cartas.size() != 5) throw new IllegalArgumentException("A mão deve ter exatamente 5 cartas");
		this.cartas = cartas;
		Collections.sort(cartas);
		agrupador = new Agrupador();

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
		return As == this.cartas.get(4).getValorFace();
	}
	
	public Estatisticas possui(int quantidade) {
		return new Estatisticas(quantidade);
	}	
	
	public Agrupador cartas() {
		return agrupador;
	}
	
	public class Estatisticas {
		private int quantidade;

		private Estatisticas(int quantidade) {
			this.quantidade = quantidade;
		}
		
		public boolean cartasDistintas() {
			return agrupador.cartasAgrupadasPorValor.keySet().size() == quantidade;
		}
		
		public boolean cartasMesmoNaipe() {
			for (Naipe naipe : agrupador.cartasAgrupadasPorNaipe.keySet()) {
				if (agrupador.cartasAgrupadasPorNaipe.get(naipe).size() == quantidade) {
					return true;
				}
			}
			return false;
		}
		
		public boolean cartasEmAlgumGrupo() {
			for(ValorFace valor : agrupador.cartasAgrupadasPorValor.keySet()) {
				if (agrupador.cartasAgrupadasPorValor.get(valor).size() == quantidade) {
					return true;
				}
			}
			return false;
		}
	
		
		public boolean gruposDeValor() {
			return agrupador.cartasAgrupadasPorValor.keySet().size() == quantidade;
		}
		
	}
	
	public class Agrupador {
		private Map<ValorFace, List<Carta>> cartasAgrupadasPorValor = null;
		private Map<Naipe, List<Carta>> cartasAgrupadasPorNaipe = null;
		
		private Agrupador() {
			cartasAgrupadasPorValor = AgrupadorHelper.agruparPorValorFace(Mao.this.cartas);
			cartasAgrupadasPorNaipe = AgrupadorHelper.agruparPorNaipe(Mao.this.cartas);
		}
		
		public List<Carta> todas() {
			return Mao.this.cartas;
		}
		
		public List<Carta> doGrupo(int quantidade) {
			List<Carta> cartas = new ArrayList<Carta>();
			for (ValorFace valor : cartasAgrupadasPorValor.keySet()) {
				if (cartasAgrupadasPorValor.get(valor).size() == quantidade) {
					cartas.addAll(cartasAgrupadasPorValor.get(valor));
				}
			}
			return cartas;
		}

		public Carta maior() {
			return cartas.get(cartas.size() - 1);
		}

		public Carta menor() {
			return cartas.get(0);
		}
	
	}
	
	public static int comQuantidade(int quantidade) {
		return quantidade;
	}	
}
