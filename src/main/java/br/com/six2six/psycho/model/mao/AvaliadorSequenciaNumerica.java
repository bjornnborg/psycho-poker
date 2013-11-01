package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA;

import java.util.ArrayList;
import java.util.List;

import br.com.six2six.psycho.model.AvaliadorMao;
import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorSequenciaNumerica implements AvaliadorMao {

	@Override
	public DadosAvaliacaoJogo getDadosAvaliacao(Mao mao) {
		boolean fazSequencia = false;
		List<Carta> cartasJogo = new ArrayList<Carta>();
		if (mao.possui(5).cartasDistintas()) {
			fazSequencia = diferencaUltimaCartaPrimeiraIndicaSequencia(mao);
			
			if (!fazSequencia && mao.temAsComoMaiorCarta()) {
				fazSequencia = diferencaPenultimaCartaPrimeiraIndicaSequencia(mao);
				 if (diferencaPenultimaCartaPrimeiraIndicaSequencia(mao)) {
					 int pesoProvisorioAs = 1;
					 fazSequencia = (mao.cartas().menor().getValorFace().getPeso() - pesoProvisorioAs) == 1;
				 }
			}
			
		}
		if (fazSequencia) {
			cartasJogo = mao.cartas().todas();
		}
		return new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA, fazSequencia, cartasJogo);
	}
	
	@Override
	public int getPeso() {
		return 5;
	}

	@Override
	public int compareTo(AvaliadorMao o) {
		return this.getPeso() - o.getPeso();
	}	
	
	private boolean diferencaUltimaCartaPrimeiraIndicaSequencia(Mao mao) {
		return calcularGap(mao, mao.cartas().todas().size()-1) == (mao.cartas().todas().size() - 1);
	}
	
	private boolean diferencaPenultimaCartaPrimeiraIndicaSequencia(Mao mao) {
		return calcularGap(mao, mao.cartas().todas().size()-2) == (mao.cartas().todas().size() - 2);
	}	
	
	private int calcularGap(Mao mao, int indiceUltimaCarta) {
		return mao.cartas().todas().get(indiceUltimaCarta).getValorFace().getPeso() - mao.cartas().todas().get(0).getValorFace().getPeso();
	}
	

}
