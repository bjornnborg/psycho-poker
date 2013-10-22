package br.com.six2six.psycho.model.mao;

import static br.com.six2six.psycho.model.mao.Jogo.DOIS_PARES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.six2six.psycho.model.Carta;
import br.com.six2six.psycho.model.DadosAvaliacaoJogo;

public class AvaliadorDoisParesTest {

	
	@Test
	public void deveIdentificarDoisPares() {
		AvaliadorDoisPares par = new AvaliadorDoisPares();
		DadosAvaliacaoJogo dadosAvaliacao = par.getDadosAvaliacao(new Mao(Carta.from("3S", "3H", "5D", "4D", "4S")));
		assertEquals(DOIS_PARES, dadosAvaliacao.getJogo());
		assertTrue(dadosAvaliacao.fazJogo());
		assertEquals(Carta.from("3S"), dadosAvaliacao.getCartasJogo().get(0));
		assertEquals(Carta.from("3H"), dadosAvaliacao.getCartasJogo().get(1));
		assertEquals(Carta.from("4D"), dadosAvaliacao.getCartasJogo().get(2));
		assertEquals(Carta.from("4S"), dadosAvaliacao.getCartasJogo().get(3));
	}	
}
