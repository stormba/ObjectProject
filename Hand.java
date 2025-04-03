import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(){
        this.cards = new ArrayList<>(); //oppretter en tom liste for kortene på hånda

    }

    public void addCard(Card card) {
        cards.add(card);
    }


    public int calculateValue(){
        int value = 0;
        int aceCount = 0; //trenger ace-count for å ta høyde for 1/11 verdien

        for (Card card : cards) {
            int face = card.getFace(); //bruker getFace fra Card.java

            if (face > 10) {
                value += 10; //alle billedkort er verdt 10.
            } else if (face == 1) {
                aceCount++;
                value += 11;
            } else {
                value += face;
            }
        }

        //Må justere ess-veriden hvis totalveriden er >21
        //while-løkke hvis to ess er på hånda
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public void printHand(){
        //System.out.println("Hånden din: ");
        for (Card card : cards) {
            System.out.println("\n" + card + " "); //dette bruker toString-metoden til Card
        }
        System.out.println("Verdi: " + calculateValue() + "!");
    }
    
    public List<Card> getCards() {
        return cards;
    }

   



}
