package br.com.six2six.psycho.model;

import static br.com.six2six.psycho.model.Naipe.Ouros;
import static br.com.six2six.psycho.model.ValorFace.As;
import static br.com.six2six.psycho.model.mao.Jogo.MAIOR_CARTA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.six2six.psycho.model.mao.Mao;

public class PsychoTest {
	
	@Test
	public void descobrirMelhorJogoComoMaiorCarta() {
		Mao mao = new Mao(Carta.from("3D", "5S", "2H", "QD", "TD")); 
		Monte monte = Monte.from("6S", "KH", "9H", "AD", "QH");
		
		DadosAvaliacaoJogo maiorJogo = new Psycho().descobrirMaiorJogo(mao, monte);
		assertEquals(MAIOR_CARTA, maiorJogo.getJogo());
		assertTrue(maiorJogo.fazJogo());
		assertEquals(As, maiorJogo.getCartasJogo().get(0).getValorFace());
		assertEquals(Ouros, maiorJogo.getCartasJogo().get(0).getNaipe());
	}

}
