package br.com.six2six.psycho.model;

import static br.com.six2six.psycho.model.mao.Jogo.MAIOR_CARTA;
import static br.com.six2six.psycho.model.mao.Jogo.PAR;
import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DadosAvaliacaoJogoTest {

	@Test
	public void jogosDeMenorGrandezaDevemSerConsideradosMenores() {
		DadosAvaliacaoJogo jogo1 = new DadosAvaliacaoJogo(MAIOR_CARTA, true, null);
		DadosAvaliacaoJogo jogo2 = new DadosAvaliacaoJogo(PAR, true, null);
		assertTrue(jogo1.compareTo(jogo2) < 0);
		assertTrue(jogo2.compareTo(jogo1) > 0);
	}
	
	@Test
	public void jogosDeMemsaGrandezaQueNaoFizeramMatchDevemSerMenores() {
		DadosAvaliacaoJogo jogo1 = new DadosAvaliacaoJogo(MAIOR_CARTA, true, null);
		DadosAvaliacaoJogo jogo2 = new DadosAvaliacaoJogo(MAIOR_CARTA, false, null);
		assertTrue(jogo1.compareTo(jogo2) > 0);
		assertTrue(jogo2.compareTo(jogo1) < 0);
	}
	
	@Test
	public void jogosDeMemsaGrandezaQueFizeramMatchDevemResolvidosNasCartas() {
		DadosAvaliacaoJogo jogo1 = new DadosAvaliacaoJogo(MAIOR_CARTA, true, Carta.from("AS", "8D", "5D", "QC", "JH"));
		DadosAvaliacaoJogo jogo2 = new DadosAvaliacaoJogo(MAIOR_CARTA, true, Carta.from("TS", "8D", "5D", "QC", "JH"));
		assertTrue(jogo1.compareTo(jogo2) > 0);
		assertTrue(jogo2.compareTo(jogo1) < 0);
	}
	
	@Test
	public void jogosDeMemsaGrandezaQueFizeramMatchDevemResolvidosNasCartasSemSeConfundirComAs() {
		DadosAvaliacaoJogo jogo1 = new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA, true, Carta.from("AS", "2D", "3D", "4C", "5H"));
		DadosAvaliacaoJogo jogo2 = new DadosAvaliacaoJogo(SEQUENCIA_NUMERICA, true, Carta.from("2S", "3D", "4D", "5C", "6H"));
		assertTrue(jogo1.compareTo(jogo2) < 0);
		assertTrue(jogo2.compareTo(jogo1) > 0);
	}	


	
}
