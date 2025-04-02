package oving3;

import java.util.Arrays;

public class CardDeck {
    public int n; // antall kort som skal legges til
    public String[] cardDeck;

    public CardDeck(int n) {

        // n må være mellom 1 og 13, alle andre verdier er ugydlig
        validateInput(n);
        this.n = n;

        this.cardDeck = new String[4 * n];

        // lager kortstokken

        // spar
        for (int i = 0; i < n; i++) {
            this.cardDeck[i] = "S" + (i + 1) + "";

        }
        // hjerter
        for (int i = 0; i < n; i++) {
            this.cardDeck[i + n] = "H" + (i + 1) + "";

        }
        // ruter
        for (int i = 0; i < n; i++) {
            this.cardDeck[i + 2 * n] = "D" + (i + 1) + "";

        }
        // kløver
        for (int i = 0; i < n; i++) {
            this.cardDeck[i + 3 * n] = "C" + (i + 1) + "";

        }
        shufflePerfectly();

    }


    // hjelpefunk validering av input n
    private void validateInput(int n) {
        if (n < 0 || n > 13) {
            throw new IllegalArgumentException("Må være mellom 1-13!");
        }
    }

    public int getCardCount() {
        return this.cardDeck.length;
    }

    public Card getCard(int n) {
        if (n < 0 || n > this.cardDeck.length) {
            throw new IllegalArgumentException("Du må oppgi en gydlig N-verdi!");
        }
        char suit;
        if (n < this.n) {
            suit = 'S'; // spar
        } else if (n < 2 * this.n) {
            suit = 'H'; // hjerter
        } else if (n < 3 * this.n) {
            suit = 'D'; // ruter
        } else {
            suit = 'C'; // kløver
        }
        int face = (n % this.n) + 1;

        return new Card(suit, face);
    }

    

    

public void shufflePerfectly() {
    String[] shuffledCardDeck = new String[4*n];
    int halfSize = this.cardDeck.length/2;
    String[] firstHalf = Arrays.copyOfRange(this.cardDeck, 0, halfSize);
    String[] secondHalf = Arrays.copyOfRange(this.cardDeck, halfSize, this.cardDeck.length);
    
    for (int i = 0; i < halfSize; i++) {
            shuffledCardDeck[2*i]=firstHalf[i];
        }
    for (int i = 1; i < halfSize+1; i++) {
        shuffledCardDeck[2*i-1]=secondHalf[i-1];
    }
    // int index = 0; 
    // for (int i = 0; i < halfSize; i++) {
    //     shuffledCardDeck[index++] = firstHalf[i]; 
    //     shuffledCardDeck[index++] = secondHalf[i];
    // }
    this.cardDeck = Arrays.copyOf(shuffledCardDeck, shuffledCardDeck.length);
   //this.cardDeck = shuffledCardDeck;
    
}


public static void main(String[] args) {
    CardDeck test = new CardDeck(2);
    System.out.println(Arrays.toString(test.cardDeck));
    


    
}


}
