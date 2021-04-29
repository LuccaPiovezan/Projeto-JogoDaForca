package br.com.softblue.jogoDaForca.ui;

import java.util.Scanner;

import br.com.softblue.jogoDaForca.core.InvalidCaracterException;

public class UI {

	public static void print(Object object) {
		System.out.println(object);
	}

	public static void printNewLine() {
		System.out.println();
	}

	@SuppressWarnings("resource")
	public static char readChar(String text)throws InvalidCaracterException {
		System.out.println(text + " ");

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		
		if(line.trim().isEmpty()) {
			throw new InvalidCaracterException("Você não digitou nenhuma letra!");
		}
		
		if(line.length() > 1) {
			throw new InvalidCaracterException("Digite apenas uma letra!");
		}
		
		char c = line.charAt(0);
		
		if(!Character.isLetter(c)) {
			throw new InvalidCaracterException("Digite apenas letras!");
		}
		
		return c;
	}
}
