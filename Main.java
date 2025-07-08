/**
 * Driver program that creates standard 52-card deck (as Card array)
 * and prints out each card in deck.
 *
 * @author ???
 * @version ???
 */

public class Main {

	
	public static void main(String[] args) {
		CardTester.main(null);
		Card[] deck = new Card[52];
	
		char[] suits = {'♥','♦','♣','♠'};
		System.out.println("PRINTING FULL %@-CARD DECK:\n");
		int index = 0;
		for (char suit: suits){
			for (int value = 1; value <= 13; value++){
				deck[index++] = new Card(value, suit);
			}
		}
		for(int i =0; i < deck.length;i++){
			System.out.print(deck[i] + "  ");
			if((i+1) % 13 == 0){
				System.out.println();
			}
		}

	
	}
}