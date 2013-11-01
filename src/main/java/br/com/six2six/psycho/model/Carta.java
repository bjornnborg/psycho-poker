package br.com.six2six.psycho.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of={"valorFace", "naipe"})
public class Carta implements Comparable<Carta> {
	
	private static final Pattern REGEX_TUPLA = Pattern.compile("([A2-9TJQK])([CDSH])");
	
	private ValorFace valorFace;
	private Naipe naipe;
	
	public Carta(ValorFace valorFace, Naipe naipe) {
		if (valorFace == null || naipe == null) {
			throw new IllegalArgumentException("Uma carta deve ter um valor e um naipe");
		}
		this.valorFace = valorFace;
		this.naipe = naipe;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", valorFace.getValor(), naipe.getSimbolo());
	}
	
	@Override
	public int compareTo(Carta carta) {
		return this.valorFace.getPeso() - carta.valorFace.getPeso();
	}
	public static Carta from(String tupla) {
		Matcher matcher = REGEX_TUPLA.matcher(tupla);
		if (matcher.matches()) {
			return new Carta(ValorFace.from(matcher.group(1)), Naipe.from(matcher.group(2)));
		}
		throw new IllegalArgumentException("Tupla inválida");
	}
	
	public static List<Carta> from(String... tupla) {
		List<Carta> cartas = new ArrayList<Carta>();
		for (String tuplaDaVez : tupla) {
			cartas.add(Carta.from(tuplaDaVez));
		}
		return cartas;
	}

}
