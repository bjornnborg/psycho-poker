package br.com.six2six.psycho.model.mao;


import static br.com.six2six.psycho.model.mao.Jogo.MAIOR_CARTA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorMaiorCartaTest {
	
	@Test
	public void deveIdentificarMaiorCarta() {
		AvaliadorMaiorCarta maiorCarta = new AvaliadorMaiorCarta();
		DadosAvaliacaoJogo dadosAvaliacao = maiorCarta.getDadosAvaliacao(new Mao(Carta.from("3S", "4H", "5D", "JD", "AC")));
		assertEquals(MAIOR_CARTA, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(Carta.from("AC"), dadosAvaliacao.getCartasJogo().get(0));
		assertEquals(1, dadosAvaliacao.getCartasJogo().size());
	}
}
