package br.com.softblue.jogoDaForca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.softblue.jogoDaForca.Game.GameException;
import br.com.softblue.jogoDaForca.utils.RandomUtils;

public class FileDictionary extends Dictionary{

	private static final String FILE_NAME = "dicionario.txt";
	
	private List<String> words = new ArrayList<>();
	
	public FileDictionary() {
		load();
	}
	

	private void load() throws GameException {

		try (Scanner scanner = 
				new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {

			while (scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				words.add(word);
			}

			if (words.size() == 0) {
				throw new GameException("A lista de palavras n�o pode ser vazia");
			}
		}
	}
	@Override
	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(0, words.size());
		return new Word(words.get(pos));	
	}


	@Override
	public String getName() {
		return "Arquivo " + FILE_NAME;
	}
}
