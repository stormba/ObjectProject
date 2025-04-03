import java.util.List;

public class Player {
    private String name;
    private Hand hand;


    public Player (String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue () {
        return hand.calculateValue();
    }

    public boolean isBusted() {
        //returnerer true hvis spilleren har busta.
        return getHandValue() > 21;
    }

    public String getName(){
        return name;
    }

    public void printHand() {
        System.out.print(name + "'s hånd: ");
        hand.printHand();
    }

    public List<Card> getHand(){
        return hand.getCards();
    }
    
}
