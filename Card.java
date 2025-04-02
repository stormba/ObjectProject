


public final class Card {
    char suit;
    int face;
    
    public Card(char suit, int face) {
        
        //suit er enten S, C, D, H
        if (suit != 'C' && suit != 'S' && suit != 'H' && suit!='D') {
            throw new IllegalArgumentException("Må enten være S, H, D eller C ");
        }
        this.suit = suit;
        //face mellom 1-13
        if (face <1 || face>13) {
            throw new IllegalArgumentException("Må være mellom 1 og 13");
        }
        this.face = face;

    }

    
    public char getSuit() {
        return this.suit;
    }

   
    public int getFace() {
        return this.face;
    }

    @Override
    public String toString() {
        return "" + suit + face + "";
    }

    public static void main(String[] args) {
        Card card = new Card('H', 13);
        System.out.println(card);
    }
}
