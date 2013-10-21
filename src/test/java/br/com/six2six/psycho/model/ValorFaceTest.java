package br.com.six2six.psycho.model;


import static br.com.six2six.psycho.model.ValorFace.As;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValorFaceTest {

	@Test
	public void criarValorFromString() {
		ValorFace as = ValorFace.from("A");
		assertEquals(As, as);
	}
	
}
