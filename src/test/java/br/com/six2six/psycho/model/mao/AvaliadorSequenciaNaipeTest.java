package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.SEQUENCIA_NAIPE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorSequenciaNaipeTest {
	
	@Test
	public void deveIdentificarSequencia() {
		AvaliadorSequenciaNaipe sequencia = new AvaliadorSequenciaNaipe();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("3S", "8S", "5S", "JS", "QS")));
		assertEquals(SEQUENCIA_NAIPE, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(5, dadosAvaliacao.getCartasJogo().size());
	}
	
	@Test
	public void naoDeveIdentificarSequencia() {
		AvaliadorSequenciaNaipe sequencia = new AvaliadorSequenciaNaipe();
		DadosAvaliacaoJogo dadosAvaliacao = sequencia.getDadosAvaliacao(new Mao(Carta.from("3S", "8S", "5S", "JS", "QD")));
		assertEquals(SEQUENCIA_NAIPE, dadosAvaliacao.getJogo());
		assertFalse(dadosAvaliacao.fazJogo());
		assertEquals(0, dadosAvaliacao.getCartasJogo().size());
	}

}
