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
				if (diferencaPenultimaCartaPrimeiraIndicaSequencia(mao)) {
					int pesoProvisorioAs = 1;
					fazSequencia = (mao.getCartas().get(0).getValorFace().getPeso() - pesoProvisorioAs) == 1;
				}
			}
			
		}
		if (fazSequencia) {
			cartasJogo = mao.getCartas();
		}
		return new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA, fazSequencia, cartasJogo);
	}
	
	private boolean diferencaUltimaCartaPrimeiraIndicaSequencia(Mao mao) {
		return calcularGap(mao, mao.getCartas().size()-1) == (mao.getCartas().size() - 1);
	}
	
	private boolean diferencaPenultimaCartaPrimeiraIndicaSequencia(Mao mao) {
		return calcularGap(mao, mao.getCartas().size()-2) == (mao.getCartas().size() - 2);
	}	
	
	private int calcularGap(Mao mao, int indiceUltimaCarta) {
		return mao.getCartas().get(indiceUltimaCarta).getValorFace().getPeso() - mao.getCartas().get(0).getValorFace().getPeso();
	}
	

}
