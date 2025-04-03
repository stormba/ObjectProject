import java.util.List;

public class Player {
    private String name;
    private Hand hand;
    private int balance;


    public Player (String name) {
        this.name = name;
        this.hand = new Hand();
        this.balance = 1000; //startsaldo
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue () {
        return hand.calculateValue();
    }

    public void addBalance(int amount){
        balance+=amount;
    }
    public void removeBalance(int amount){
        balance+=amount;
    }

    public boolean isBroke(){
        return balance<1;
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
