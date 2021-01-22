package br.com.livelo.solid.utils;

public class OperatorUtils {

	private OperatorUtils() {
		
	}
	
	public static <T extends Comparable<T>> boolean isGreatherThan(T compare, T compareTo) {
		return compareTo.compareTo(compare) > 1;
	}
}
