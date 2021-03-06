package br.com.six2six.psycho.model;


import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.ValorFace.Dois;
import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA;
import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA_NAIPE;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import br.com.six2six.psycho.model.mao.Jogo;

@Getter
public class DadosAvaliacaoJogo implements Comparable<DadosAvaliacaoJogo> {
	
	private Jogo jogo;
	private boolean fazJogo;
	private List<Carta> cartasJogo;
	
	public DadosAvaliacaoJogo(Jogo jogo, boolean fazJogo, List<Carta> cartasJogo) {
		this.jogo = jogo;
		this.fazJogo = fazJogo;
		this.cartasJogo = cartasJogo;
		if (this.cartasJogo != null) {
			this.ordenarCartas(this.cartasJogo);
		}
	}
	
	private void ordenarCartas(List<Carta> cartasJogo) {
		Collections.sort(this.cartasJogo);
		if (algumaSequencia()) {
			if (Dois == cartasJogo.get(0).getValorFace() && As == cartasJogo.get(cartasJogo.size()-1).getValorFace()) {
				cartasJogo.add(0, cartasJogo.get(cartasJogo.size()-1));
				cartasJogo.remove(cartasJogo.size()-1);
			}
		}
		
	}
	private boolean algumaSequencia() {
		return (SEQUENCIA_NUMERICA == this.jogo || SEQUENCIA_NUMERICA_NAIPE == this.jogo) && this.fazJogo;
	}
	public boolean fazJogo() {
		return isFazJogo();
	}
	@Override
	public int compareTo(DadosAvaliacaoJogo outroJogo) {
		if (this.jogo.getPeso() != outroJogo.jogo.getPeso()) {
			return this.jogo.getPeso() - outroJogo.jogo.getPeso();
		}
		
		if (!this.fazJogo && outroJogo.fazJogo) {
			return outroJogo.jogo.getPeso() * -1;
		}
		
		if (this.fazJogo && !outroJogo.fazJogo) {
			return this.jogo.getPeso();
		}
		
		
		
		return somarCartas(this.cartasJogo) - somarCartas(outroJogo.cartasJogo);
	}
	
	private int somarCartas(List<Carta> cartas) {
		int total = 0;
		for (Carta carta : cartas) {
			total += carta.getValorFace().getPeso();
		}
		
		if (SEQUENCIA_NUMERICA == jogo || SEQUENCIA_NUMERICA_NAIPE == jogo) {
			total = ajustarPesoAs(cartas, total);
		}
		return total;
	}
	
	private int ajustarPesoAs(List<Carta> cartas, int total) {
		if (primeiraCartaAs(cartas)) {
			return total - 13;
		}
		return total;
	}
	
	private boolean primeiraCartaAs(List<Carta> cartas) {
		return As == cartas.get(0).getValorFace();
	}

	@Override
	public String toString() {
		return String.format("%s faz? %s cartas: %s", jogo, fazJogo, cartasJogo);
	}
	
	public boolean maiorQue(DadosAvaliacaoJogo outroJogo) {
		return this.compareTo(outroJogo) > 0;
	}
	
	public boolean menorQue(DadosAvaliacaoJogo outroJogo) {
		return this.compareTo(outroJogo) < 0;
	}	
	
}
