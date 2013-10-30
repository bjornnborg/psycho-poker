package br.com.six2six.psycho.model;

import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.ValorFace.Rei;
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
			Collections.sort(this.cartasJogo);
		}
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
		if (ultimaCartaAs(cartas) && !penultimaCartaRei(cartas)) {
			return total - 13;
		}
		return total;
	}
	
	private boolean ultimaCartaAs(List<Carta> cartas) {
		return As == cartas.get(cartas.size() - 1).getValorFace();
	}
	
	private boolean penultimaCartaRei(List<Carta> cartas) {
		return Rei == cartas.get(cartas.size() - 2).getValorFace();
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
