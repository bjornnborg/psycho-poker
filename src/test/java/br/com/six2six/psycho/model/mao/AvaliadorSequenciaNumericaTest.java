package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NUMERICA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorSequenciaNumericaTest {
	
	@Test
	public void deveIdentificarSequencia() {
		AvaliadorSequenciaNumerica sequencia = new AvaliadorSequenciaNumerica();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("3S", "2H", "5D", "4D", "6S")));
		assertEquals(SEQUENCIA_NUMERICA, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(5, dadosAvaliacao.getCartasJogo().size());
	}

}
