import java.util.List;
// import java.util.Scanner;

public class Player {
    private String name;
    private Hand hand;
    private int balance;
    
    // private Scanner scanner;


    public Player (String name) {
        this.name = name;
        this.hand = new Hand();
        this.balance = getBalance(); //startsaldo
        
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue () {
        return hand.calculateValue();
    }

    // public void addBet(){
    //     System.out.println("Hvor mye vil du spille for?");
    //     int betAmount = scanner.nextInt();
    //     this.bet = betAmount;


    // }

    public void addBalance(int amount){
        this.balance+=amount;
    }
    public void removeBalance(int amount){
        this.balance-=amount;
    }

    public int getBalance(){
        return this.balance;
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
