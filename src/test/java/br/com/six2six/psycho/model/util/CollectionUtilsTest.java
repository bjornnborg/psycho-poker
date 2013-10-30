package br.com.six2six.psycho.model.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CollectionUtilsTest {

	@Test
	public void combinarSemFolga() {
		List<String> items = new ArrayList<String>();
		items.add("A");items.add("B");items.add("C");
		
		List<List<String>> listasCombinadas = CollectionUtil.combinar(items, 3);
		System.out.println(listasCombinadas);
		assertEquals(1, listasCombinadas.size());
		assertEquals("[A, B, C]", listasCombinadas.get(0).toString());
		
	}
	
	@Test
	public void combinarComZero() {
		List<String> items = new ArrayList<String>();
		items.add("A");items.add("B");items.add("C");
		
		List<List<String>> listasCombinadas = CollectionUtil.combinar(items, 0);
		System.out.println(listasCombinadas);
		assertEquals(0, listasCombinadas.size());
	}	
	
	@Test
	public void combinarComUmaFolga() {
		List<String> items = new ArrayList<String>();
		items.add("A");items.add("B");items.add("C");
		
		List<List<String>> listasCombinadas = CollectionUtil.combinar(items, 2);
		System.out.println(listasCombinadas);
		assertEquals(3, listasCombinadas.size());
		assertEquals("[A, B]", listasCombinadas.get(0).toString());
		
	}
	
	@Test
	public void combinarComUm() {
		List<String> items = new ArrayList<String>();
		items.add("A");items.add("B");items.add("C");
		
		List<List<String>> listasCombinadas = CollectionUtil.combinar(items, 1);
		System.out.println(listasCombinadas);
		assertEquals(3, listasCombinadas.size());
		assertEquals("[[A], [B], [C]]", listasCombinadas.toString());
		
	}
	
}
