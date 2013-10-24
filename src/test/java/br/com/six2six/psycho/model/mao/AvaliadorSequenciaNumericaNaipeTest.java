package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA_NAIPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorSequenciaNumericaNaipeTest {
	
	@Test
	public void deveIdentificarSequencia() {
		AvaliadorSequenciaNumericaNaipe sequencia = new AvaliadorSequenciaNumericaNaipe();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("3S", "2S", "5S", "4S", "6S")));
		assertEquals(SEQUENCIA_NUMERICA_NAIPE, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(5, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void deveIdentificarSequenciaComecandoComAs() {
		AvaliadorSequenciaNumericaNaipe sequencia = new AvaliadorSequenciaNumericaNaipe();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("3S", "2S", "5S", "4S", "AS")));
		assertEquals(SEQUENCIA_NUMERICA_NAIPE, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(5, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void deveIdentificarSequenciaTerminandoComAs() {
		AvaliadorSequenciaNumericaNaipe sequencia = new AvaliadorSequenciaNumericaNaipe();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("TS", "KS", "AS", "QS", "JS")));
		assertEquals(SEQUENCIA_NUMERICA_NAIPE, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(5, dadosAvaliacao.getCartasJogo().size());
	}	
	
	@Test
	public void naoDeveDeixarAsConfundirSequencia() {
		AvaliadorSequenciaNumericaNaipe sequencia = new AvaliadorSequenciaNumericaNaipe();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("3S", "4S", "5S", "6S", "AS")));
		assertEquals(SEQUENCIA_NUMERICA_NAIPE, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}

}
