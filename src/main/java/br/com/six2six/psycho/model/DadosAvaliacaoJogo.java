package br.com.six2six.psycho.model;

import java.util.List;

import lombok.Getter;
import br.com.six2six.psycho.model.mao.Jogo;

@Getter
public class DadosAvaliacaoJogo {
	
	private Jogo jogo;
	private boolean fazJogo;
	private List<Carta> cartasJogo;
	
	public DadosAvaliacaoJogo(Jogo jogo, boolean fazJogo, List<Carta> cartasJogo) {
		this.jogo = jogo;
		this.fazJogo = fazJogo;
		this.cartasJogo = cartasJogo;
	}
	
	public boolean fazJogo() {
		return isFazJogo();
	}
	
}
