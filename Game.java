package br.com.softblue.jogoDaForca.Game;

import java.util.HashSet;
import java.util.Set;

import br.com.softblue.jogoDaForca.core.Config;
import br.com.softblue.jogoDaForca.core.Dictionary;
import br.com.softblue.jogoDaForca.core.InvalidCaracterException;
import br.com.softblue.jogoDaForca.core.Word;
import br.com.softblue.jogoDaForca.ui.UI;

public class Game {

	public void start() {

		UI.print("Bem Vindo ao Jogo da Forca!");

		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();

		UI.print("DICA: A palavra secreta possui " + word.size() + " letras!");

		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		int maxErrors = Integer.parseInt(Config.get("maxErrors"));
		UI.print("Voce pode errar mo máximo: "+ maxErrors + " vezes.");

		while (true) {
			UI.print(word);
			UI.printNewLine();

			char c;
			try {
				c = UI.readChar("Digite uma letra: ");

				if (usedChars.contains(c)) {
					throw new InvalidCaracterException("Essa letra já foi utilizada");
				}

				usedChars.add(c);

				if (word.hasChar(c)) {
					UI.print("Você acertou uma letra!");

				} else {
					errorCount++;

					if (errorCount < maxErrors) {
						UI.print("Você errou! Você pode errar " + (maxErrors - errorCount) + " vez(es).");
					}
				}
				UI.printNewLine();

				if (word.discovered()) {
					UI.print("Parabéns, você conseguiu acertar a palavra secreta!" + word.getOriginalWord());
					UI.print("Fim do Jogo!");
					break;
				}

				if (errorCount == maxErrors)
					UI.print("Você Perdeu! A palavra secreta era: " + word.getOriginalWord());
					UI.print("Fim do Jogo!");
					break;

			} catch (InvalidCaracterException e) {
				UI.print("ERRO:" + e.getMessage());
				UI.printNewLine();
			}

		}
	}
}
