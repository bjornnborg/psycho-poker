package br.com.six2six.psycho.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtil {
	
	public static <T> List<List<T>> combinar(List<T> lista, int posicoes) {
		List<List<T>> resultado = new ArrayList<List<T>>();
		
//		if (posicoes == lista.size()) {
//			resultado.add(lista);
//			return resultado;
//		}
//		
//		if (posicoes == 0) {
//			resultado.add(lista);
//			return resultado;
//		}
		
		for(int j = 0; j < lista.size(); j++) {
			
			if (posicoes == 1) {
				List<T> list = new ArrayList<T>();
				list.add(lista.get(j));
				
				resultado.add(list);
			}
			
//			cards.slice(i+1, cards.length)
			List<T> sublista = lista.subList(j+1, lista.size());
			List<List<T>> listaCombinada = combinar(sublista, posicoes-1);
			
			for(int i = 0; i < listaCombinada.size(); i++) {
				List<T> asList = new ArrayList<T>();
				asList.add(0,lista.get(j));
//				resultado.addAll(listaCombinada);	
				asList.addAll(listaCombinada.get(i));
				resultado.add(asList);
			}
			
			
		}
		
		return resultado;
	}
	
	private static <T> List<T> sublistaExluindoIndice(List<T> lista, int index) {
		List<T> resultado = new ArrayList<T>();
		for(int i=0; i<lista.size(); i++) {
			if (i != index) {
				resultado.add(lista.get(i));
			}
		}
		return resultado;
	}
	
	public static void mess(String... array) {
		List<List<String>> masterList = new ArrayList<List<String>>();
		for(int a=0; a < array.length; a++) {
			for(int b=0; b < array.length; b++) {
				for(int c=0; c < array.length; c++) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		mess("A", "B", "C", "D", "E");
		mess("A", "B", "C");
	}

}
