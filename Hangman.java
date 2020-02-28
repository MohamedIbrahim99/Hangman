package eg.edu.alexu.csd.datastructure.hangman;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Hangman implements IHangman{
	
	private String[] words = new String[10000] ;
	private String game ;
	private int maxGuess ;
	
	@Override
	public void setDictionary(String[] words) {
		try {
			FileInputStream file = new FileInputStream("W:\\CSED23\\1st year - 2nd term\\Projects\\Java\\10000 word\\google-10000-english-master\\google-10000-english-usa.txt");
			InputStreamReader reader = new InputStreamReader(file);
			BufferedReader input = new BufferedReader(reader);
	
			int i = 0 ;
			while (i < 10000) {
				words[i] = input.readLine();
				i++;
			} input.close();
		}
		catch (IOException e) {
			System.out.println("There is IOException!");
		}
	}

	@Override
	public String selectRandomSecretWord() {
		setDictionary(words);
		Random rand = new Random();
		int upperBound = 9999;
		int randomNum = rand.nextInt(upperBound);
		String secretWord = words[randomNum];
		if ( secretWord.matches("[a-zA-Z]+") ) {
			game = secretWord;
			return secretWord ;
		}
		else {
			return null;
		}

	}
	
	@Override
	public void setMaxWrongGuesses(Integer max) {
		if (max > 0) {
			maxGuess = max ;
		}
		else {
			maxGuess = 1;
		}
	}

	@Override
	public String guess(Character c) throws Exception {
		
		char constChar[] = game.toCharArray();
		char varChar[] = new char [game.length()];
		
		for (int i = 0 ; i < game.length() ; i++) {
			varChar[i] = '-';
		}
		
		boolean flag = false;
		for (int i = 0 ; i < game.length() ; i++) {
			if ( c == constChar[i]) {
				varChar[i] = c ;
				flag = true ;
			}
		}
		if (flag == false) {
			maxGuess--;
			if (maxGuess < 1) {
				return null;
			}
		}
		String varString = new String(varChar);
		return varString;
	}
}
