package eg.edu.alexu.csd.datastructure.hangman;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		Hangman game = new Hangman ();
		String[] words = new String[10000] ;
		game.setDictionary(words);
		
		String s = game.selectRandomSecretWord();
		char c = 0 ;
		game.setMaxWrongGuesses(6);

		String finalSt;
		do {
			try {
				System.out.println("Guess a charachter : ");
				c = scan.next().charAt(0);
			}
			catch (Exception e) {
	            System.out.print(e.toString());
			}

			
			finalSt = game.guess(c);
			System.out.println(finalSt);
			
		}
		while ( finalSt != null );
			
        scan.close();
   
		System.out.println("The word is : "+ s);
	
		
		/*System.out.println(words[1]);
		System.out.println(words[9999]);
		System.out.println(words[3]);
		*/
	}

}
