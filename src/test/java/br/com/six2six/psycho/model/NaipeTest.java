package br.com.six2six.psycho.model;

import static br.com.six2six.psycho.model.Naipe.Copas;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NaipeTest {
	
	@Test
	public void criarNaipeFromString() {
		Naipe copas = Naipe.from("H");
		assertEquals(Copas, copas);
	}
}
